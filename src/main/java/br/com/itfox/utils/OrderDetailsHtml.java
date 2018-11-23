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
    public static StringBuilder getOrderDetails(HttpSession session){
        StringBuilder s = new StringBuilder();
        
        Order order = new Order();
        Transaction t = new Transaction();
        int orderId=0;
        int transactionStatus = 0;
        if(session!=null){
            // pegando a transacao
            t = (Transaction) session.getAttribute("transaction");
            // se a transacao não for nula
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
                s.append("      <table class=\"table\" style=\"width:322px;height:100%\">");
                s.append("          <thead>");
                s.append("              <tr>");
                s.append("                  <th style=\"width:212px\">Product</th>");
                s.append("                  <th style=\"width:55px\">QTY</th>");
                s.append("                  <th style=\"width:55px\">Price</th>");
                s.append("              </tr>");
                s.append("          </thead>");
                s.append("          <tbody>");
                if(order!=null){
                    s.append("<input type=\"hidden\" id=\"order\" name=\"order\" value=\""+order.getOrderId()+"\"/>");
                    List<OrderItem> itens = order.getItems();
                    if(itens!=null && itens.size()>0){
                        for(OrderItem i:itens){
                            s.append("          <tr style=\"line-height:20px;\">");
                            s.append("              <td>"+ i.getProduct()!=null?i.getProduct().getName():"" +"</td>");
                            s.append("              <td>"+ i.getProductQuantity() +"</td>");
                            s.append("              <td>AUD$"+Utils.formatDecimal(i.getProductTotal())+" </td>");
                            s.append("          </tr>");
                        }// fim for
                    }// fim if itens nulos
                }// fim order nulo
                           
                s.append("<tr>");
                s.append("<td>Subtotal</td>");
                s.append("<td></td>");
                s.append("<td>AUD$"+ order!=null?Utils.formatDecimal(order.getTotalSalesOrder()/1.1):""+"</td>");
                s.append("</tr>");
                s.append("<tr>");
                s.append("<td>Shipping</td>");
                s.append("<td></td>");
                s.append("<td>AUD$0</td>");
                s.append("</tr>");
                s.append("<tr>");
                s.append("<td>GST</td>");
                s.append("<td></td>");
                s.append("<td>AUD$"+"order!=null?Utils.formatDecimal((order.getTotalSalesOrder()/1.1)*0.1):"+"</td>");
                s.append("</tr>");
                s.append("<tr>");
                s.append("<td>Total</td>");
                s.append("<td></td>");
                s.append("<td>AUD$"+"order!=null?Utils.formatDecimal(order.getTotalSalesOrder()):"+"</td>");
                s.append("</tr>");
                s.append("</tbody>");
                s.append("</table>");
                s.append("</div>");
                s.append("</div>");
                s.append("");
                
                  
                
                
            }// end if transaction
            
            
            
        }
        
        return s;
    }
}
