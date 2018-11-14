/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.NonexistentEntityException;
import br.com.itfox.entity.EmailMktProduct;
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
public class EmailMktProductJpaController implements Serializable {

    public EmailMktProductJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EmailMktProduct emailMktProduct) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(emailMktProduct);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EmailMktProduct emailMktProduct) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            emailMktProduct = em.merge(emailMktProduct);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = emailMktProduct.getEmailMktProductId();
                if (findEmailMktProduct(id) == null) {
                    throw new NonexistentEntityException("The emailMktProduct with id " + id + " no longer exists.");
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
            EmailMktProduct emailMktProduct;
            try {
                emailMktProduct = em.getReference(EmailMktProduct.class, id);
                emailMktProduct.getEmailMktProductId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The emailMktProduct with id " + id + " no longer exists.", enfe);
            }
            em.remove(emailMktProduct);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EmailMktProduct> findEmailMktProductEntities() {
        return findEmailMktProductEntities(true, -1, -1);
    }

    public List<EmailMktProduct> findEmailMktProductEntities(int maxResults, int firstResult) {
        return findEmailMktProductEntities(false, maxResults, firstResult);
    }

    private List<EmailMktProduct> findEmailMktProductEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EmailMktProduct.class));
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

    public EmailMktProduct findEmailMktProduct(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmailMktProduct.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmailMktProductCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EmailMktProduct> rt = cq.from(EmailMktProduct.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
