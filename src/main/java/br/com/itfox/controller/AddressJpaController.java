/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.NonexistentEntityException;
import br.com.itfox.entity.Address;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.itfox.entity.Client;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author belchiorpalma
 */
public class AddressJpaController implements Serializable {

    public AddressJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Address address) {
        if (address.getClientCollection() == null) {
            address.setClientCollection(new ArrayList<Client>());
        }
        if (address.getClientCollection1() == null) {
            address.setClientCollection1(new ArrayList<Client>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Client> attachedClientCollection = new ArrayList<Client>();
            for (Client clientCollectionClientToAttach : address.getClientCollection()) {
                clientCollectionClientToAttach = em.getReference(clientCollectionClientToAttach.getClass(), clientCollectionClientToAttach.getClientId());
                attachedClientCollection.add(clientCollectionClientToAttach);
            }
            address.setClientCollection(attachedClientCollection);
            Collection<Client> attachedClientCollection1 = new ArrayList<Client>();
            for (Client clientCollection1ClientToAttach : address.getClientCollection1()) {
                clientCollection1ClientToAttach = em.getReference(clientCollection1ClientToAttach.getClass(), clientCollection1ClientToAttach.getClientId());
                attachedClientCollection1.add(clientCollection1ClientToAttach);
            }
            address.setClientCollection1(attachedClientCollection1);
            em.persist(address);
            for (Client clientCollectionClient : address.getClientCollection()) {
                Address oldBillingAddressOfClientCollectionClient = clientCollectionClient.getBillingAddress();
                clientCollectionClient.setBillingAddress(address);
                clientCollectionClient = em.merge(clientCollectionClient);
                if (oldBillingAddressOfClientCollectionClient != null) {
                    oldBillingAddressOfClientCollectionClient.getClientCollection().remove(clientCollectionClient);
                    oldBillingAddressOfClientCollectionClient = em.merge(oldBillingAddressOfClientCollectionClient);
                }
            }
            for (Client clientCollection1Client : address.getClientCollection1()) {
                Address oldShippingAddressOfClientCollection1Client = clientCollection1Client.getShippingAddress();
                clientCollection1Client.setShippingAddress(address);
                clientCollection1Client = em.merge(clientCollection1Client);
                if (oldShippingAddressOfClientCollection1Client != null) {
                    oldShippingAddressOfClientCollection1Client.getClientCollection1().remove(clientCollection1Client);
                    oldShippingAddressOfClientCollection1Client = em.merge(oldShippingAddressOfClientCollection1Client);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Address address) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Address persistentAddress = em.find(Address.class, address.getAddressId());
            Collection<Client> clientCollectionOld = persistentAddress.getClientCollection();
            Collection<Client> clientCollectionNew = address.getClientCollection();
            Collection<Client> clientCollection1Old = persistentAddress.getClientCollection1();
            Collection<Client> clientCollection1New = address.getClientCollection1();
            Collection<Client> attachedClientCollectionNew = new ArrayList<Client>();
            for (Client clientCollectionNewClientToAttach : clientCollectionNew) {
                clientCollectionNewClientToAttach = em.getReference(clientCollectionNewClientToAttach.getClass(), clientCollectionNewClientToAttach.getClientId());
                attachedClientCollectionNew.add(clientCollectionNewClientToAttach);
            }
            clientCollectionNew = attachedClientCollectionNew;
            address.setClientCollection(clientCollectionNew);
            Collection<Client> attachedClientCollection1New = new ArrayList<Client>();
            for (Client clientCollection1NewClientToAttach : clientCollection1New) {
                clientCollection1NewClientToAttach = em.getReference(clientCollection1NewClientToAttach.getClass(), clientCollection1NewClientToAttach.getClientId());
                attachedClientCollection1New.add(clientCollection1NewClientToAttach);
            }
            clientCollection1New = attachedClientCollection1New;
            address.setClientCollection1(clientCollection1New);
            address = em.merge(address);
            for (Client clientCollectionOldClient : clientCollectionOld) {
                if (!clientCollectionNew.contains(clientCollectionOldClient)) {
                    clientCollectionOldClient.setBillingAddress(null);
                    clientCollectionOldClient = em.merge(clientCollectionOldClient);
                }
            }
            for (Client clientCollectionNewClient : clientCollectionNew) {
                if (!clientCollectionOld.contains(clientCollectionNewClient)) {
                    Address oldBillingAddressOfClientCollectionNewClient = clientCollectionNewClient.getBillingAddress();
                    clientCollectionNewClient.setBillingAddress(address);
                    clientCollectionNewClient = em.merge(clientCollectionNewClient);
                    if (oldBillingAddressOfClientCollectionNewClient != null && !oldBillingAddressOfClientCollectionNewClient.equals(address)) {
                        oldBillingAddressOfClientCollectionNewClient.getClientCollection().remove(clientCollectionNewClient);
                        oldBillingAddressOfClientCollectionNewClient = em.merge(oldBillingAddressOfClientCollectionNewClient);
                    }
                }
            }
            for (Client clientCollection1OldClient : clientCollection1Old) {
                if (!clientCollection1New.contains(clientCollection1OldClient)) {
                    clientCollection1OldClient.setShippingAddress(null);
                    clientCollection1OldClient = em.merge(clientCollection1OldClient);
                }
            }
            for (Client clientCollection1NewClient : clientCollection1New) {
                if (!clientCollection1Old.contains(clientCollection1NewClient)) {
                    Address oldShippingAddressOfClientCollection1NewClient = clientCollection1NewClient.getShippingAddress();
                    clientCollection1NewClient.setShippingAddress(address);
                    clientCollection1NewClient = em.merge(clientCollection1NewClient);
                    if (oldShippingAddressOfClientCollection1NewClient != null && !oldShippingAddressOfClientCollection1NewClient.equals(address)) {
                        oldShippingAddressOfClientCollection1NewClient.getClientCollection1().remove(clientCollection1NewClient);
                        oldShippingAddressOfClientCollection1NewClient = em.merge(oldShippingAddressOfClientCollection1NewClient);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = address.getAddressId();
                if (findAddress(id) == null) {
                    throw new NonexistentEntityException("The address with id " + id + " no longer exists.");
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
            Address address;
            try {
                address = em.getReference(Address.class, id);
                address.getAddressId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The address with id " + id + " no longer exists.", enfe);
            }
            Collection<Client> clientCollection = address.getClientCollection();
            for (Client clientCollectionClient : clientCollection) {
                clientCollectionClient.setBillingAddress(null);
                clientCollectionClient = em.merge(clientCollectionClient);
            }
            Collection<Client> clientCollection1 = address.getClientCollection1();
            for (Client clientCollection1Client : clientCollection1) {
                clientCollection1Client.setShippingAddress(null);
                clientCollection1Client = em.merge(clientCollection1Client);
            }
            em.remove(address);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Address> findAddressEntities() {
        return findAddressEntities(true, -1, -1);
    }

    public List<Address> findAddressEntities(int maxResults, int firstResult) {
        return findAddressEntities(false, maxResults, firstResult);
    }

    private List<Address> findAddressEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Address.class));
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

    public Address findAddress(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Address.class, id);
        } finally {
            em.close();
        }
    }

    public int getAddressCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Address> rt = cq.from(Address.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
