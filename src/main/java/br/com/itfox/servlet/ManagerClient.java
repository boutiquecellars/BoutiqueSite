/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.servlet;

import br.com.itfox.beans.Client;
import br.com.itfox.beans.Product;
import br.com.itfox.utils.SendHtmlFormatedEmail;
import br.com.itfox.business.BusinessDelegate;
import br.com.itfox.controller.ClientJpaController;
import br.com.itfox.controller.SalesOrderJpaController;
import br.com.itfox.controller.TransactionJpaController;
import br.com.itfox.entity.SalesOrder;
import br.com.itfox.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author belchiorpalma
 */
public class ManagerClient extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("firstName");
        String email = request.getParameter("email");
        String lastName = request.getParameter("lastName");
        String telephone = request.getParameter("telephone");
        String orderDetails = request.getParameter("orderDetails");
        String orderNumber = request.getParameter("orderNumber");
        String dateBirth = request.getParameter("dateBirth");
        String companyName1 = request.getParameter("companyName1");
        String addStreet11 =  request.getParameter("addStreet11");
        String addStreet12 =  request.getParameter("addStreet12");
        String addSuburb1 =  request.getParameter("addSuburb1");
        String addPostal1 =  request.getParameter("addPostal1");
        String addState1 =  request.getParameter("addState1");
        String companyName2 = request.getParameter("companyName2");
        String addStreet21 =  request.getParameter("addStreet21");
        String addStreet22 =  request.getParameter("addStreet22");
        String addSuburb2 =  request.getParameter("addSuburb2");
        String addPostal2 = request.getParameter("addPostal2");
        String addState2=  request.getParameter("addState2");
        String sameAsDelivery = request.getParameter("sameAsDelivery");
        
       
        String clientId = request.getParameter("id");
        String operation = request.getParameter("operation");
        br.com.itfox.entity.Client  entityClient = new br.com.itfox.entity.Client();
        EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
        ClientJpaController clientDAO = new ClientJpaController(emf);
        SalesOrderJpaController salesDAO = new SalesOrderJpaController(emf);
        
        // inserindo os dados no bean
        entityClient.setName(name+" "+lastName);
        entityClient.setFirstName(name);
        entityClient.setLastName(lastName);
        entityClient.setEmail(email);
        entityClient.setTelephone(telephone);
        entityClient.setDateBirth(dateBirth);
        entityClient.setCompanyName1(companyName1);
        entityClient.setStreetAddress11(addStreet11);
        entityClient.setStreetAddress12(addStreet12);
        entityClient.setSuburb1(addSuburb1);
        entityClient.setPostal1(addPostal1);
        entityClient.setState1(addState1);
        entityClient.setCompanyName2(companyName2);
        entityClient.setStreetAddress21(addStreet21);
        entityClient.setStreetAddress22(addStreet22);
        entityClient.setSuburb2(addSuburb2);
        entityClient.setPostal2(addPostal2);
        entityClient.setState2(addState2);
        
        if(sameAsDelivery!=null && sameAsDelivery.equalsIgnoreCase("true")){
            sameAsDelivery="1";
        }else{
            sameAsDelivery="0";
        }
        entityClient.setSameAsDelivery(Utils.parseInt(sameAsDelivery));
        
                
        if(name!=null && !name.isEmpty() && name!="" ){
            Client c = new Client();
            c.setName(name);
            
            if(clientId !=null && !clientId.isEmpty() && clientId!=""){
                try{
                c.setClientId(Integer.parseInt(clientId));
                entityClient.setClientId(Integer.parseInt(clientId));
                }catch(Exception ex){
                    br.com.itfox.utils.Logger.getLogger(ex);
                }
            }
            
            c.setEmail(email);
           
            int result = 0;
            if(operation !=null && !operation.isEmpty() && operation!="" && operation.equalsIgnoreCase("insert")){
                result = clientDAO.create(entityClient);
                // result= new BusinessDelegate().insertClient(c);
                if(result >0){
                    SendHtmlFormatedEmail s = new SendHtmlFormatedEmail();
                    orderDetails="We received your order #"+orderNumber+" and we are working on it now.\n<br/>" +
                    "We will e-mail you an update as soon as your order is processed.\n<br/>" +
                    "\n<br/>" +
                    "Boutique Cellars team\n";
                    s.sendingHtml(orderDetails, orderNumber, name, email);
                    // atualizando o pedido com o nome do cliente
                    SalesOrder salesOrder = new SalesOrder();
                    
                    
                    try {
                        salesOrder = salesDAO.findSalesOrder(Utils.parseInt(orderNumber));
                        salesOrder.setClientId(String.valueOf(result));
                        salesOrder.setOrderId(Utils.parseInt(orderNumber));
                        salesDAO.edit(salesOrder);
                    } catch (Exception ex) {
                        Logger.getLogger(ManagerClient.class.getName()).log(Level.SEVERE, null, ex);
                        System.err.println("Erro ao atualizar o pedido: "+ ex.getLocalizedMessage());
                    }
                    
                }
            }else if(operation !=null && !operation.isEmpty() && operation!="" && operation.equalsIgnoreCase("update")){
                result = new BusinessDelegate().updateClient(c);
            }else if(operation !=null && !operation.isEmpty() && operation!="" && operation.equalsIgnoreCase("delete")){
                result = new BusinessDelegate().deleteClient(c);
            }
            
            if (result>0) {
                //session.setAttribute("userid", m.getEmail());
                //out.println("welcome " + userid);
                //out.println("<a href='logout.jsp'>Log out</a>");
               // response.sendRedirect("clients.jsp?msg=success");
               out.print("Sucesso");
            } else {
                //response.sendRedirect("clients.jsp?msg=error");
                out.print("Erro");
            }
        }else{
            out.print("nulo");
            response.sendRedirect("clients.jsp?msg=null");
        }
        try{
            out.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
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
