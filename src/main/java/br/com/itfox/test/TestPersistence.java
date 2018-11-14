/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.test;

import br.com.itfox.controller.ClientJpaController;
import br.com.itfox.controller.TransactionJpaController;
import br.com.itfox.entity.Client;
import br.com.itfox.entity.Transaction;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author belchiorpalma
 */
public class TestPersistence {
    
    public static void main(String[] args){
         Transaction t = new Transaction();
                //SalesOrder salesOrder = new SalesOrder();
                 EntityManagerFactory emf = Persistence.createEntityManagerFactory("BoutiqueSitePU");
                EntityManager em = emf.createEntityManager();
                //EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
                ClientJpaController clientDAO = new ClientJpaController(emf);
                for(Client c: clientDAO.findClientEntities()){
                    System.out.println("Client:"+c.toString());
                }
    }
}
