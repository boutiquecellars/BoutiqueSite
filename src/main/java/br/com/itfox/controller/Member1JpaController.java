/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.itfox.entity.Areaoper;
import br.com.itfox.entity.Member1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author belchiorpalma
 */
public class Member1JpaController implements Serializable {

    public Member1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Member1 member1) {
        if (member1.getAreaoperCollection() == null) {
            member1.setAreaoperCollection(new ArrayList<Areaoper>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Areaoper> attachedAreaoperCollection = new ArrayList<Areaoper>();
            for (Areaoper areaoperCollectionAreaoperToAttach : member1.getAreaoperCollection()) {
                areaoperCollectionAreaoperToAttach = em.getReference(areaoperCollectionAreaoperToAttach.getClass(), areaoperCollectionAreaoperToAttach.getAreaOperacional());
                attachedAreaoperCollection.add(areaoperCollectionAreaoperToAttach);
            }
            member1.setAreaoperCollection(attachedAreaoperCollection);
            em.persist(member1);
            for (Areaoper areaoperCollectionAreaoper : member1.getAreaoperCollection()) {
                areaoperCollectionAreaoper.getMember1Collection().add(member1);
                areaoperCollectionAreaoper = em.merge(areaoperCollectionAreaoper);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Member1 member1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Member1 persistentMember1 = em.find(Member1.class, member1.getMemberId());
            Collection<Areaoper> areaoperCollectionOld = persistentMember1.getAreaoperCollection();
            Collection<Areaoper> areaoperCollectionNew = member1.getAreaoperCollection();
            Collection<Areaoper> attachedAreaoperCollectionNew = new ArrayList<Areaoper>();
            for (Areaoper areaoperCollectionNewAreaoperToAttach : areaoperCollectionNew) {
                areaoperCollectionNewAreaoperToAttach = em.getReference(areaoperCollectionNewAreaoperToAttach.getClass(), areaoperCollectionNewAreaoperToAttach.getAreaOperacional());
                attachedAreaoperCollectionNew.add(areaoperCollectionNewAreaoperToAttach);
            }
            areaoperCollectionNew = attachedAreaoperCollectionNew;
            member1.setAreaoperCollection(areaoperCollectionNew);
            member1 = em.merge(member1);
            for (Areaoper areaoperCollectionOldAreaoper : areaoperCollectionOld) {
                if (!areaoperCollectionNew.contains(areaoperCollectionOldAreaoper)) {
                    areaoperCollectionOldAreaoper.getMember1Collection().remove(member1);
                    areaoperCollectionOldAreaoper = em.merge(areaoperCollectionOldAreaoper);
                }
            }
            for (Areaoper areaoperCollectionNewAreaoper : areaoperCollectionNew) {
                if (!areaoperCollectionOld.contains(areaoperCollectionNewAreaoper)) {
                    areaoperCollectionNewAreaoper.getMember1Collection().add(member1);
                    areaoperCollectionNewAreaoper = em.merge(areaoperCollectionNewAreaoper);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = member1.getMemberId();
                if (findMember1(id) == null) {
                    throw new NonexistentEntityException("The member1 with id " + id + " no longer exists.");
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
            Member1 member1;
            try {
                member1 = em.getReference(Member1.class, id);
                member1.getMemberId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The member1 with id " + id + " no longer exists.", enfe);
            }
            Collection<Areaoper> areaoperCollection = member1.getAreaoperCollection();
            for (Areaoper areaoperCollectionAreaoper : areaoperCollection) {
                areaoperCollectionAreaoper.getMember1Collection().remove(member1);
                areaoperCollectionAreaoper = em.merge(areaoperCollectionAreaoper);
            }
            em.remove(member1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Member1> findMember1Entities() {
        return findMember1Entities(true, -1, -1);
    }

    public List<Member1> findMember1Entities(int maxResults, int firstResult) {
        return findMember1Entities(false, maxResults, firstResult);
    }

    private List<Member1> findMember1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Member1.class));
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

    public Member1 findMember1(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Member1.class, id);
        } finally {
            em.close();
        }
    }

    public int getMember1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Member1> rt = cq.from(Member1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
