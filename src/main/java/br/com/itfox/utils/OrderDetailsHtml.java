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
        //if(session!=null){
            // pegando a transacao
           // t = (Transaction) session.getAttribute("transaction");
            // se a transacao não for nula
            s.append("<html><head>");
            s.append("<style type=\"text/css\" data-hse-inline-css=\"true\">\n" +
            "      table{background-color:#cccccc;}\n"+
            "      td {\n" +
            "         font-family: Arial, sans-serif; "
                    + "height:20px;\n" +
            "      }\n" +
            " </style>");
            s.append("</head><body>");
            
        try{   
            if(t!=null){
                orderId = t.getTransactionOrder();
                order = t.getSalesOrder();
                transactionStatus = t.getTransactionOrderStatus();
                
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
                s.append("  <h3 class=\"widget-title\">Order Info</h3>");
                s.append("  <div class=\"box\">");
                s.append("      <table class=\"table\" style=\"width:422px;height:100%;padding:0;margin:0\">");
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
                s.append("<td>AUD$"+ Utils.formatDecimal(totalSalesOrder/1.1)+"</td>");
                s.append("</tr>");
                s.append("<tr style=\"height:12px\">");
                s.append("<td>Shipping</td>");
                s.append("<td></td>");
                s.append("<td>AUD$0</td>");
                s.append("</tr>");
                s.append("<tr style=\"height:12px\">");
                s.append("<td>GST</td>");
                s.append("<td></td>");
                s.append("<td>AUD$"+Utils.formatDecimal((totalSalesOrder/1.1)*0.1)+"</td>");
                s.append("</tr>");
                s.append("<tr style=\"height:12px\">");
                s.append("<td>Total</td>");
                s.append("<td></td>");
                s.append("<td>AUD$"+ Utils.formatDecimal(totalSalesOrder)+"</td>");
                s.append("</tr>");
                s.append("</tbody>");
                s.append("</table>");
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
