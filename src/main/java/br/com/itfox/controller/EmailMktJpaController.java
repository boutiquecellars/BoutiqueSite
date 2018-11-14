/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.NonexistentEntityException;
import br.com.itfox.entity.EmailMkt;
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
public class EmailMktJpaController implements Serializable {

    public EmailMktJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EmailMkt emailMkt) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(emailMkt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EmailMkt emailMkt) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            emailMkt = em.merge(emailMkt);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = emailMkt.getEmailMktId();
                if (findEmailMkt(id) == null) {
                    throw new NonexistentEntityException("The emailMkt with id " + id + " no longer exists.");
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
            EmailMkt emailMkt;
            try {
                emailMkt = em.getReference(EmailMkt.class, id);
                emailMkt.getEmailMktId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The emailMkt with id " + id + " no longer exists.", enfe);
            }
            em.remove(emailMkt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EmailMkt> findEmailMktEntities() {
        return findEmailMktEntities(true, -1, -1);
    }

    public List<EmailMkt> findEmailMktEntities(int maxResults, int firstResult) {
        return findEmailMktEntities(false, maxResults, firstResult);
    }

    private List<EmailMkt> findEmailMktEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EmailMkt.class));
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

    public EmailMkt findEmailMkt(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmailMkt.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmailMktCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EmailMkt> rt = cq.from(EmailMkt.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
