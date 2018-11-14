/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.NonexistentEntityException;
import br.com.itfox.entity.Logupload;
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
public class LoguploadJpaController implements Serializable {

    public LoguploadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Logupload logupload) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(logupload);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Logupload logupload) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            logupload = em.merge(logupload);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = logupload.getLoguploadId();
                if (findLogupload(id) == null) {
                    throw new NonexistentEntityException("The logupload with id " + id + " no longer exists.");
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
            Logupload logupload;
            try {
                logupload = em.getReference(Logupload.class, id);
                logupload.getLoguploadId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The logupload with id " + id + " no longer exists.", enfe);
            }
            em.remove(logupload);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Logupload> findLoguploadEntities() {
        return findLoguploadEntities(true, -1, -1);
    }

    public List<Logupload> findLoguploadEntities(int maxResults, int firstResult) {
        return findLoguploadEntities(false, maxResults, firstResult);
    }

    private List<Logupload> findLoguploadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Logupload.class));
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

    public Logupload findLogupload(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Logupload.class, id);
        } finally {
            em.close();
        }
    }

    public int getLoguploadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Logupload> rt = cq.from(Logupload.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
