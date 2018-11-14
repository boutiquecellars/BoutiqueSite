/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.IllegalOrphanException;
import br.com.itfox.controller.exceptions.NonexistentEntityException;
import br.com.itfox.controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.itfox.entity.Product;
import br.com.itfox.entity.ProductCarousel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author belchiorpalma
 */
public class ProductCarouselJpaController implements Serializable {

    public ProductCarouselJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductCarousel productCarousel) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Product productOrphanCheck = productCarousel.getProduct();
        if (productOrphanCheck != null) {
            ProductCarousel oldProductCarouselOfProduct = productOrphanCheck.getProductCarousel();
            if (oldProductCarouselOfProduct != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Product " + productOrphanCheck + " already has an item of type ProductCarousel whose product column cannot be null. Please make another selection for the product field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Product product = productCarousel.getProduct();
            if (product != null) {
                product = em.getReference(product.getClass(), product.getProductId());
                productCarousel.setProduct(product);
            }
            em.persist(productCarousel);
            if (product != null) {
                product.setProductCarousel(productCarousel);
                product = em.merge(product);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductCarousel(productCarousel.getProductId()) != null) {
                throw new PreexistingEntityException("ProductCarousel " + productCarousel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductCarousel productCarousel) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductCarousel persistentProductCarousel = em.find(ProductCarousel.class, productCarousel.getProductId());
            Product productOld = persistentProductCarousel.getProduct();
            Product productNew = productCarousel.getProduct();
            List<String> illegalOrphanMessages = null;
            if (productNew != null && !productNew.equals(productOld)) {
                ProductCarousel oldProductCarouselOfProduct = productNew.getProductCarousel();
                if (oldProductCarouselOfProduct != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Product " + productNew + " already has an item of type ProductCarousel whose product column cannot be null. Please make another selection for the product field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (productNew != null) {
                productNew = em.getReference(productNew.getClass(), productNew.getProductId());
                productCarousel.setProduct(productNew);
            }
            productCarousel = em.merge(productCarousel);
            if (productOld != null && !productOld.equals(productNew)) {
                productOld.setProductCarousel(null);
                productOld = em.merge(productOld);
            }
            if (productNew != null && !productNew.equals(productOld)) {
                productNew.setProductCarousel(productCarousel);
                productNew = em.merge(productNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = productCarousel.getProductId();
                if (findProductCarousel(id) == null) {
                    throw new NonexistentEntityException("The productCarousel with id " + id + " no longer exists.");
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
            ProductCarousel productCarousel;
            try {
                productCarousel = em.getReference(ProductCarousel.class, id);
                productCarousel.getProductId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productCarousel with id " + id + " no longer exists.", enfe);
            }
            Product product = productCarousel.getProduct();
            if (product != null) {
                product.setProductCarousel(null);
                product = em.merge(product);
            }
            em.remove(productCarousel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductCarousel> findProductCarouselEntities() {
        return findProductCarouselEntities(true, -1, -1);
    }

    public List<ProductCarousel> findProductCarouselEntities(int maxResults, int firstResult) {
        return findProductCarouselEntities(false, maxResults, firstResult);
    }

    private List<ProductCarousel> findProductCarouselEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductCarousel.class));
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

    public ProductCarousel findProductCarousel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductCarousel.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductCarouselCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductCarousel> rt = cq.from(ProductCarousel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
