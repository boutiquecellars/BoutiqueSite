/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.utils;

import br.com.itfox.beans.Order;
import br.com.itfox.beans.OrderItem;
import br.com.itfox.entity.Transaction;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author belchiorpalma
 */
public class OrderDetailsHtml {
    public static StringBuilder getOrderDetails(Transaction t){
        StringBuilder s = new StringBuilder();
        
        
        Order order = new Order();
       // Transaction t = new Transaction();
        int orderId=0;
        int transactionStatus = 0;
        // Entity Client
        br.com.itfox.entity.Client c = new br.com.itfox.entity.Client();
        String firstName="";
        String lastName="";
        String email="";
        String telephone="";
        String dateBirth="";
        String companyName1="";
        String streetAddress11="";
        String streetAddress12="";
        String suburb1="";
        String postal1="";
        String state1="";
        String shipToDiffAddress="";
        String companyName2="";
        String streetAddress21="";
        String streetAddress22="";
        String suburb2="";
        String postal2="";
        String state2="";
        
        //if(session!=null){
            // pegando a transacao
           // t = (Transaction) session.getAttribute("transaction");
            // se a transacao não for nula
            s.append("<html><head>");
            s.append("<style type=\"text/css\" data-hse-inline-css=\"true\">\n" +
            "      table{background-color:#fcfcfc;}\n"+
            "      td {\n" +
            "         font-family: Arial, sans-serif; "
                    + "height:20px; display:block; float:left;\n" +
            "      }\n" +
            " </style>");
            s.append("</head><body>");
            
        try{   
            if(t!=null){
                
                orderId = t.getTransactionOrder();
                order = t.getSalesOrder();
                transactionStatus = t.getTransactionOrderStatus();
                s.append("  <h3 class=\"widget-title\">CONFIRMATION ORDER - "+order.getOrderDate()+"</h3><br/>");
                // se for ok
                if(t!=null && t.getTransactionOrderStatus()==1 ){
                    s.append("Transaction Status: Success!<br/>");
                    if(t.getTransactionOptions()!=null){
                    s.append("<br/>"+t.getTransactionOptions());
                    }
                }else{
                    if(t!=null && t.getCustomerNote()!=null){
                       s.append("Error:"+t.getCustomerNote());
                    }else{
                        s.append("Error ocurred.");
                    }
                }
                // criando a tabela com o pedido
                s.append("<div class=\"col-md-4\">");
                s.append("  <h3 class=\"widget-title\">ORDER INFO: "+t.getTransactionOrder()+"</h3><br/>");
                s.append("  <div class=\"box\">");
                s.append("      <table class=\"table\" style=\"width:422px;padding:0;margin:0\">");
                s.append("          <thead>");
                s.append("              <tr style=\"height:12px\">");
                s.append("                  <th style=\"width:312px\">Product</th>");
                s.append("                  <th style=\"width:55px\">QTY</th>");
                s.append("                  <th style=\"width:55px\">Price</th>");
                s.append("              </tr>");
                s.append("          </thead>");
                s.append("          <tbody>");
                if(order!=null){
                    //s.append("<input type=\"hidden\" id=\"order\" name=\"order\" value=\""+order.getOrderId()+"\"/>");
                    List<OrderItem> itens = order.getItems();
                    if(itens!=null && itens.size()>0){
                        for(OrderItem i:itens){
                            if(i.getProduct()!=null){
                            String name = i.getProduct().getName();
                            float qty = i.getProductQuantity();
                            float total = i.getProductTotal();
                            s.append("          <tr style=\"height:12px\" >");
                            s.append("              <td>"+ name +"</td>");
                            s.append("              <td>"+ qty +"</td>");
                            s.append("              <td>AUD$"+Utils.formatDecimal(total)+" </td>");
                            s.append("          </tr>");
                            }
                        }// fim for
                    }// fim if itens nulos
                }// fim order nulo
                       
                float totalSalesOrder =  order.getTotalSalesOrder();
                s.append("<tr style=\"height:12px\">");
                s.append("<td>Subtotal</td>");
                s.append("<td></td>");
                s.append("<td>AUD$"+ Utils.formatDecimal(order.getSubtotal())+"</td>");
                s.append("</tr>");
                s.append("<tr style=\"height:12px\">");
                s.append("<td>Shipping</td>");
                s.append("<td></td>");
                s.append("<td>AUD$"+Utils.formatDecimal(order.getShipping())+"</td>");
                s.append("</tr>");
                s.append("<tr style=\"height:12px\">");
                s.append("<td>GST</td>");
                s.append("<td></td>");
                s.append("<td>AUD$"+Utils.formatDecimal(order.getGst())+"</td>");
                s.append("</tr>");
                s.append("<tr style=\"height:12px\">");
                s.append("<td>Total</td>");
                s.append("<td></td>");
                s.append("<td>AUD$"+ Utils.formatDecimal(order.getTotal())+"</td>");
                s.append("</tr>");
                s.append("</tbody>");
                s.append("</table>");
               // s.append("<br/>Client: "+order.getClient().getClientId()+"<br/>");
               // s.append("First Name:"+order.getClient().getName());
                try{
                    c = order.getEntityClient();
                   firstName = c.getFirstName();
                   lastName = c.getLastName();
                   email = c.getEmail();
                   telephone=c.getTelephone();
                   dateBirth = c.getDateBirth();
                   companyName1 = c.getCompanyName1();
                   streetAddress11 = c.getStreetAddress11();
                   streetAddress12 = c.getStreetAddress12();
                   suburb1 = c.getSuburb1();
                   postal1 = c.getPostal1();
                   state1 = c.getState1();
                   shipToDiffAddress = c.getSameAsDelivery()+"";
                   companyName2 = c.getCompanyName2();
                   streetAddress21 = c.getStreetAddress21();
                   streetAddress22 = c.getStreetAddress22();
                   suburb2 = c.getSuburb2();
                   postal2 = c.getPostal2();
                   state2 = c.getState2();
                //s.append(c.toString());
                s.append("<h3 class=\"widget-title\">BILLING DETAILS </h3><br/><br/>");
                s.append("<table><thead><tr><th></th><th></th></tr></thead>");
                s.append("<tbody>");
                s.append("<tr><td>First Name:"+"</td>"+"<td>"+firstName+"</td>"+"</tr>");
                s.append("<tr><td>Last Name:"+"</td>"+"<td>"+lastName+"</td>"+"</tr>");
                s.append("<tr><td>Email:"+"</td>"+"<td>"+email+"</td>"+"</tr>");
                s.append("<tr><td>Phone Number:"+"</td>"+"<td>"+telephone+"</td>"+"</tr>");
                s.append("<tr><td>Date Birth:"+"</td>"+"<td>"+dateBirth+"</td>"+"</tr>");
                s.append("<tr><td>Company Name:"+"</td>"+"<td>"+companyName1+"</td>"+"</tr>");
                s.append("<tr><td>Street Address 1:"+"</td>"+"<td>"+streetAddress11+"</td>"+"</tr>");
                s.append("<tr><td>Street Address 2:"+"</td>"+"<td>"+streetAddress12+"</td>"+"</tr>");
                s.append("<tr><td>Suburb:"+"</td>"+"<td>"+suburb1+"</td>"+"</tr>");
                s.append("<tr><td>Postal:"+"</td>"+"<td>"+postal1+"</td>"+"</tr>");
                s.append("<tr><td>State:"+"</td>"+"<td>"+state1+"</td>"+"</tr>");
                s.append("<tr><td>Ship to a Different Address:"+"</td>"+"<td>"+shipToDiffAddress+"</td>"+"</tr>");
                s.append("<tr><td>Company Name:"+"</td>"+"<td>"+companyName2+"</td>"+"</tr>");
                s.append("<tr><td>Street Address 1:"+"</td>"+"<td>"+streetAddress21+"</td>"+"</tr>");
                s.append("<tr><td>Street Address 2:"+"</td>"+"<td>"+streetAddress22+"</td>"+"</tr>");
                s.append("<tr><td>Suburb:"+"</td>"+"<td>"+suburb2+"</td>"+"</tr>");
                s.append("<tr><td>Postal:"+"</td>"+"<td>"+postal2+"</td>"+"</tr>");
                s.append("<tr><td>State:"+"</td>"+"<td>"+state2+"</td>"+"</tr>");
                
                s.append("</tbody>");
                s.append("</table>");
                
                }catch(Exception ex){
                    System.err.println("Erro ao localizar Cliente");
                }
                s.append("</div>");
                s.append("</div>");
                s.append("</body>");
                s.append("</html>");
                
                  
                
                
            }else{
                System.out.println("Transaction is null");
            }// end if transaction
        }catch(Exception ex){
            System.err.println("Erro ao gerar o html para o email:" + ex.getMessage());
        }
            
            
            
        //}
        
        return s;
    }
}
