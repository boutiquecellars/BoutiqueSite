/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.NonexistentEntityException;
import br.com.itfox.entity.SalesOrderItem;
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
public class SalesOrderItemJpaController implements Serializable {

    public SalesOrderItemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SalesOrderItem salesOrderItem) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(salesOrderItem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SalesOrderItem salesOrderItem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            salesOrderItem = em.merge(salesOrderItem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = salesOrderItem.getOrderItemId();
                if (findSalesOrderItem(id) == null) {
                    throw new NonexistentEntityException("The salesOrderItem with id " + id + " no longer exists.");
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
            SalesOrderItem salesOrderItem;
            try {
                salesOrderItem = em.getReference(SalesOrderItem.class, id);
                salesOrderItem.getOrderItemId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The salesOrderItem with id " + id + " no longer exists.", enfe);
            }
            em.remove(salesOrderItem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SalesOrderItem> findSalesOrderItemEntities() {
        return findSalesOrderItemEntities(true, -1, -1);
    }

    public List<SalesOrderItem> findSalesOrderItemEntities(int maxResults, int firstResult) {
        return findSalesOrderItemEntities(false, maxResults, firstResult);
    }

    private List<SalesOrderItem> findSalesOrderItemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SalesOrderItem.class));
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

    public SalesOrderItem findSalesOrderItem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SalesOrderItem.class, id);
        } finally {
            em.close();
        }
    }

    public int getSalesOrderItemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SalesOrderItem> rt = cq.from(SalesOrderItem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
