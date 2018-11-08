/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.servlet;

import br.com.itfox.beans.Order;
import br.com.itfox.beans.OrderItem;
import br.com.itfox.beans.Product;
import br.com.itfox.business.BusinessDelegate;
import br.com.itfox.security.Security;
import br.com.itfox.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author belchiorpalma
 */
public class ShoppingCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void insertItemOrder(BusinessDelegate bd, Order order, String strProductId, float productQuantity){
        Product p = new Product();
                OrderItem o = new OrderItem();
                p = bd.selectProduct(Utils.parseInt(strProductId)); // localizando o produto
                o.setOrder(order);
                o.setProduct(p);
                o.setProductDescount(0);
                o.setProductPrice(p.getPrice());
                o.setProductQuantity(productQuantity);
                o.setProductTotal(productQuantity*p.getPrice());
                o.setOrderItemStatus("1");//new
                // inserindo o item no banco de dados
                int r = bd.insertSalesOrderItem(o);
                if(r==1){
                    System.out.println("Inserido com sucesso");
                }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //variaveis
        String strProductId = (String) Security.getParameter(request.getParameter("ref"));
        String strProductQuantity = (String) Security.getParameter(request.getParameter("quantity"));
        String strOperation = (String) Security.getParameter(request.getParameter("operation"));
        String strOrderItemId = (String) Security.getParameter(request.getParameter("itemId"));
        int productQuantity = 1;
        int orderItemId=0;
        if(strProductQuantity!=null){
            try{
            productQuantity = Utils.parseInt(strProductQuantity);
            }catch(Exception ex){
                productQuantity=1;
            }
        }
        if(strOrderItemId!=null){
            try{
                orderItemId= Utils.parseInt(strOrderItemId);
            }catch(Exception ex){
                orderItemId=0;
            }
        }
        
        Order order = new Order();
        BusinessDelegate bd = new BusinessDelegate();
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res =  (HttpServletResponse) response;
        HttpSession session = request.getSession(false);
         
        //Get the IP address of client machine.
        String ipAddress = req.getRemoteAddr();
        String url = req.getRequestURI();
        
        
        if(session!=null && !session.isNew()){
            System.out.println("session started..");
            order = (Order) session.getAttribute("order");
            if(order==null){
                order = bd.insertOrder(session.getId(), ipAddress);
                
                // inserindo os itens no pedido
                this.insertItemOrder(bd, order, strProductId, productQuantity);
                // colocando na sessao os itens do pedido
                order = bd.selectSalesOrder(order.getOrderId());
                session.setAttribute("order", order);
            }else{
                // ja tenho um pedido cadastrado
                if(strOperation==null){
                    strOperation="insert";
                }
                switch(strOperation){
                    case "insert":
                        // inserindo os itens no pedido
                        this.insertItemOrder(bd, order, strProductId, productQuantity);
                        break;
                    case "update":
                        break;
                    case "delete":
                        bd.deleteSalesOrderItem(orderItemId);
                        break;
                    default:
                        this.insertItemOrder(bd, order, strProductId, productQuantity);
                        break;
                                
                }
                
                // colocando na sessao os itens do pedido
                order = bd.selectSalesOrder(order.getOrderId());
                session.setAttribute("order", order);
            }
        }else{
            // criando a sessao pela primeira vez
            System.out.println("first session");
            session = req.getSession(true);
            order = bd.insertOrder(session.getId(), ipAddress);
            //session.setAttribute("order", order);
            this.insertItemOrder(bd, order, strProductId, productQuantity);
            // colocando na sessao os itens do pedido
            order = bd.selectSalesOrder(order.getOrderId());
            session.setAttribute("order", order);
        }
        int productId=0;
        try{
            productId = Utils.parseInt(strProductId);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        /*** Criando um pedido
          para o cliente
          * 
         ***/
        
        
        
        
        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
        /*
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShoppingCart</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShoppingCart at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
