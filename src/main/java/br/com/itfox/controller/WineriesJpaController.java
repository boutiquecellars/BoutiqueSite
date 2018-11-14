/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.NonexistentEntityException;
import br.com.itfox.entity.Wineries;
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
public class WineriesJpaController implements Serializable {

    public WineriesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Wineries wineries) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(wineries);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Wineries wineries) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            wineries = em.merge(wineries);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = wineries.getWineriesId();
                if (findWineries(id) == null) {
                    throw new NonexistentEntityException("The wineries with id " + id + " no longer exists.");
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
            Wineries wineries;
            try {
                wineries = em.getReference(Wineries.class, id);
                wineries.getWineriesId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The wineries with id " + id + " no longer exists.", enfe);
            }
            em.remove(wineries);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Wineries> findWineriesEntities() {
        return findWineriesEntities(true, -1, -1);
    }

    public List<Wineries> findWineriesEntities(int maxResults, int firstResult) {
        return findWineriesEntities(false, maxResults, firstResult);
    }

    private List<Wineries> findWineriesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Wineries.class));
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

    public Wineries findWineries(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Wineries.class, id);
        } finally {
            em.close();
        }
    }

    public int getWineriesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Wineries> rt = cq.from(Wineries.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
