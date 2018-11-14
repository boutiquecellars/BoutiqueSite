/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.IllegalOrphanException;
import br.com.itfox.controller.exceptions.NonexistentEntityException;
import br.com.itfox.entity.Product;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.itfox.entity.ProductCarousel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author belchiorpalma
 */
public class ProductJpaController implements Serializable {

    public ProductJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Product product) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductCarousel productCarousel = product.getProductCarousel();
            if (productCarousel != null) {
                productCarousel = em.getReference(productCarousel.getClass(), productCarousel.getProductId());
                product.setProductCarousel(productCarousel);
            }
            em.persist(product);
            if (productCarousel != null) {
                Product oldProductOfProductCarousel = productCarousel.getProduct();
                if (oldProductOfProductCarousel != null) {
                    oldProductOfProductCarousel.setProductCarousel(null);
                    oldProductOfProductCarousel = em.merge(oldProductOfProductCarousel);
                }
                productCarousel.setProduct(product);
                productCarousel = em.merge(productCarousel);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Product product) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Product persistentProduct = em.find(Product.class, product.getProductId());
            ProductCarousel productCarouselOld = persistentProduct.getProductCarousel();
            ProductCarousel productCarouselNew = product.getProductCarousel();
            List<String> illegalOrphanMessages = null;
            if (productCarouselOld != null && !productCarouselOld.equals(productCarouselNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain ProductCarousel " + productCarouselOld + " since its product field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (productCarouselNew != null) {
                productCarouselNew = em.getReference(productCarouselNew.getClass(), productCarouselNew.getProductId());
                product.setProductCarousel(productCarouselNew);
            }
            product = em.merge(product);
            if (productCarouselNew != null && !productCarouselNew.equals(productCarouselOld)) {
                Product oldProductOfProductCarousel = productCarouselNew.getProduct();
                if (oldProductOfProductCarousel != null) {
                    oldProductOfProductCarousel.setProductCarousel(null);
                    oldProductOfProductCarousel = em.merge(oldProductOfProductCarousel);
                }
                productCarouselNew.setProduct(product);
                productCarouselNew = em.merge(productCarouselNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = product.getProductId();
                if (findProduct(id) == null) {
                    throw new NonexistentEntityException("The product with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Product product;
            try {
                product = em.getReference(Product.class, id);
                product.getProductId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The product with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            ProductCarousel productCarouselOrphanCheck = product.getProductCarousel();
            if (productCarouselOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Product (" + product + ") cannot be destroyed since the ProductCarousel " + productCarouselOrphanCheck + " in its productCarousel field has a non-nullable product field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(product);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Product> findProductEntities() {
        return findProductEntities(true, -1, -1);
    }

    public List<Product> findProductEntities(int maxResults, int firstResult) {
        return findProductEntities(false, maxResults, firstResult);
    }

    private List<Product> findProductEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Product.class));
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

    public Product findProduct(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Product> rt = cq.from(Product.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
