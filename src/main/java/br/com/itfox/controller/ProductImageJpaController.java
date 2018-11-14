/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.NonexistentEntityException;
import br.com.itfox.controller.exceptions.PreexistingEntityException;
import br.com.itfox.entity.ProductImage;
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
public class ProductImageJpaController implements Serializable {

    public ProductImageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductImage productImage) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productImage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductImage(productImage.getProductId()) != null) {
                throw new PreexistingEntityException("ProductImage " + productImage + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductImage productImage) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productImage = em.merge(productImage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = productImage.getProductId();
                if (findProductImage(id) == null) {
                    throw new NonexistentEntityException("The productImage with id " + id + " no longer exists.");
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
            ProductImage productImage;
            try {
                productImage = em.getReference(ProductImage.class, id);
                productImage.getProductId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productImage with id " + id + " no longer exists.", enfe);
            }
            em.remove(productImage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductImage> findProductImageEntities() {
        return findProductImageEntities(true, -1, -1);
    }

    public List<ProductImage> findProductImageEntities(int maxResults, int firstResult) {
        return findProductImageEntities(false, maxResults, firstResult);
    }

    private List<ProductImage> findProductImageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductImage.class));
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

    public ProductImage findProductImage(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductImage.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductImageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductImage> rt = cq.from(ProductImage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
