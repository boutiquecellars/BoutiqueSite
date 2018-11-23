/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.itfox.entity.Address;
import br.com.itfox.entity.Client;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author belchiorpalma
 */
public class ClientJpaController implements Serializable {

    public ClientJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public int create(Client client) {
        EntityManager em = null;
        int clientId=0;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Address billingAddress = client.getBillingAddress();
            if (billingAddress != null) {
                billingAddress = em.getReference(billingAddress.getClass(), billingAddress.getAddressId());
                client.setBillingAddress(billingAddress);
            }
            Address shippingAddress = client.getShippingAddress();
            if (shippingAddress != null) {
                shippingAddress = em.getReference(shippingAddress.getClass(), shippingAddress.getAddressId());
                client.setShippingAddress(shippingAddress);
            }
            em.persist(client);
            if (billingAddress != null) {
                billingAddress.getClientCollection().add(client);
                billingAddress = em.merge(billingAddress);
            }
            if (shippingAddress != null) {
                shippingAddress.getClientCollection().add(client);
                shippingAddress = em.merge(shippingAddress);
            }
            em.getTransaction().commit();
            clientId = client.getClientId();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return clientId;
    }

    public void edit(Client client) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Client persistentClient = em.find(Client.class, client.getClientId());
            Address billingAddressOld = persistentClient.getBillingAddress();
            Address billingAddressNew = client.getBillingAddress();
            Address shippingAddressOld = persistentClient.getShippingAddress();
            Address shippingAddressNew = client.getShippingAddress();
            if (billingAddressNew != null) {
                billingAddressNew = em.getReference(billingAddressNew.getClass(), billingAddressNew.getAddressId());
                client.setBillingAddress(billingAddressNew);
            }
            if (shippingAddressNew != null) {
                shippingAddressNew = em.getReference(shippingAddressNew.getClass(), shippingAddressNew.getAddressId());
                client.setShippingAddress(shippingAddressNew);
            }
            client = em.merge(client);
            if (billingAddressOld != null && !billingAddressOld.equals(billingAddressNew)) {
                billingAddressOld.getClientCollection().remove(client);
                billingAddressOld = em.merge(billingAddressOld);
            }
            if (billingAddressNew != null && !billingAddressNew.equals(billingAddressOld)) {
                billingAddressNew.getClientCollection().add(client);
                billingAddressNew = em.merge(billingAddressNew);
            }
            if (shippingAddressOld != null && !shippingAddressOld.equals(shippingAddressNew)) {
                shippingAddressOld.getClientCollection().remove(client);
                shippingAddressOld = em.merge(shippingAddressOld);
            }
            if (shippingAddressNew != null && !shippingAddressNew.equals(shippingAddressOld)) {
                shippingAddressNew.getClientCollection().add(client);
                shippingAddressNew = em.merge(shippingAddressNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = client.getClientId();
                if (findClient(id) == null) {
                    throw new NonexistentEntityException("The client with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Client client;
            try {
                client = em.getReference(Client.class, id);
                client.getClientId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The client with id " + id + " no longer exists.", enfe);
            }
            Address billingAddress = client.getBillingAddress();
            if (billingAddress != null) {
                billingAddress.getClientCollection().remove(client);
                billingAddress = em.merge(billingAddress);
            }
            Address shippingAddress = client.getShippingAddress();
            if (shippingAddress != null) {
                shippingAddress.getClientCollection().remove(client);
                shippingAddress = em.merge(shippingAddress);
            }
            em.remove(client);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Client> findClientEntities() {
        return findClientEntities(true, -1, -1);
    }

    public List<Client> findClientEntities(int maxResults, int firstResult) {
        return findClientEntities(false, maxResults, firstResult);
    }

    private List<Client> findClientEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Client.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Client findClient(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Client.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Client> rt = cq.from(Client.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
