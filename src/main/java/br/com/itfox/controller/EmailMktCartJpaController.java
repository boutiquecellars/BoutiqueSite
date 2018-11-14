/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.NonexistentEntityException;
import br.com.itfox.controller.exceptions.PreexistingEntityException;
import br.com.itfox.entity.EmailMktCart;
import br.com.itfox.entity.EmailMktCartPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author belchiorpalma
 */
public class EmailMktCartJpaController implements Serializable {

    public EmailMktCartJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EmailMktCart emailMktCart) throws PreexistingEntityException, Exception {
        if (emailMktCart.getEmailMktCartPK() == null) {
            emailMktCart.setEmailMktCartPK(new EmailMktCartPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(emailMktCart);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmailMktCart(emailMktCart.getEmailMktCartPK()) != null) {
                throw new PreexistingEntityException("EmailMktCart " + emailMktCart + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EmailMktCart emailMktCart) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            emailMktCart = em.merge(emailMktCart);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                EmailMktCartPK id = emailMktCart.getEmailMktCartPK();
                if (findEmailMktCart(id) == null) {
                    throw new NonexistentEntityException("The emailMktCart with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(EmailMktCartPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmailMktCart emailMktCart;
            try {
                emailMktCart = em.getReference(EmailMktCart.class, id);
                emailMktCart.getEmailMktCartPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The emailMktCart with id " + id + " no longer exists.", enfe);
            }
            em.remove(emailMktCart);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EmailMktCart> findEmailMktCartEntities() {
        return findEmailMktCartEntities(true, -1, -1);
    }

    public List<EmailMktCart> findEmailMktCartEntities(int maxResults, int firstResult) {
        return findEmailMktCartEntities(false, maxResults, firstResult);
    }

    private List<EmailMktCart> findEmailMktCartEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EmailMktCart.class));
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

    public EmailMktCart findEmailMktCart(EmailMktCartPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmailMktCart.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmailMktCartCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EmailMktCart> rt = cq.from(EmailMktCart.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
