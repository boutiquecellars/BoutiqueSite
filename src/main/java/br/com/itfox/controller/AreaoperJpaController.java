/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.controller;

import br.com.itfox.controller.exceptions.NonexistentEntityException;
import br.com.itfox.entity.Areaoper;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class AreaoperJpaController implements Serializable {

    public AreaoperJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Areaoper areaoper) {
        if (areaoper.getMember1Collection() == null) {
            areaoper.setMember1Collection(new ArrayList<Member1>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Member1> attachedMember1Collection = new ArrayList<Member1>();
            for (Member1 member1CollectionMember1ToAttach : areaoper.getMember1Collection()) {
                member1CollectionMember1ToAttach = em.getReference(member1CollectionMember1ToAttach.getClass(), member1CollectionMember1ToAttach.getMemberId());
                attachedMember1Collection.add(member1CollectionMember1ToAttach);
            }
            areaoper.setMember1Collection(attachedMember1Collection);
            em.persist(areaoper);
            for (Member1 member1CollectionMember1 : areaoper.getMember1Collection()) {
                member1CollectionMember1.getAreaoperCollection().add(areaoper);
                member1CollectionMember1 = em.merge(member1CollectionMember1);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Areaoper areaoper) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Areaoper persistentAreaoper = em.find(Areaoper.class, areaoper.getAreaOperacional());
            Collection<Member1> member1CollectionOld = persistentAreaoper.getMember1Collection();
            Collection<Member1> member1CollectionNew = areaoper.getMember1Collection();
            Collection<Member1> attachedMember1CollectionNew = new ArrayList<Member1>();
            for (Member1 member1CollectionNewMember1ToAttach : member1CollectionNew) {
                member1CollectionNewMember1ToAttach = em.getReference(member1CollectionNewMember1ToAttach.getClass(), member1CollectionNewMember1ToAttach.getMemberId());
                attachedMember1CollectionNew.add(member1CollectionNewMember1ToAttach);
            }
            member1CollectionNew = attachedMember1CollectionNew;
            areaoper.setMember1Collection(member1CollectionNew);
            areaoper = em.merge(areaoper);
            for (Member1 member1CollectionOldMember1 : member1CollectionOld) {
                if (!member1CollectionNew.contains(member1CollectionOldMember1)) {
                    member1CollectionOldMember1.getAreaoperCollection().remove(areaoper);
                    member1CollectionOldMember1 = em.merge(member1CollectionOldMember1);
                }
            }
            for (Member1 member1CollectionNewMember1 : member1CollectionNew) {
                if (!member1CollectionOld.contains(member1CollectionNewMember1)) {
                    member1CollectionNewMember1.getAreaoperCollection().add(areaoper);
                    member1CollectionNewMember1 = em.merge(member1CollectionNewMember1);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = areaoper.getAreaOperacional();
                if (findAreaoper(id) == null) {
                    throw new NonexistentEntityException("The areaoper with id " + id + " no longer exists.");
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
            Areaoper areaoper;
            try {
                areaoper = em.getReference(Areaoper.class, id);
                areaoper.getAreaOperacional();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The areaoper with id " + id + " no longer exists.", enfe);
            }
            Collection<Member1> member1Collection = areaoper.getMember1Collection();
            for (Member1 member1CollectionMember1 : member1Collection) {
                member1CollectionMember1.getAreaoperCollection().remove(areaoper);
                member1CollectionMember1 = em.merge(member1CollectionMember1);
            }
            em.remove(areaoper);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Areaoper> findAreaoperEntities() {
        return findAreaoperEntities(true, -1, -1);
    }

    public List<Areaoper> findAreaoperEntities(int maxResults, int firstResult) {
        return findAreaoperEntities(false, maxResults, firstResult);
    }

    private List<Areaoper> findAreaoperEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Areaoper.class));
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

    public Areaoper findAreaoper(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Areaoper.class, id);
        } finally {
            em.close();
        }
    }

    public int getAreaoperCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Areaoper> rt = cq.from(Areaoper.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
