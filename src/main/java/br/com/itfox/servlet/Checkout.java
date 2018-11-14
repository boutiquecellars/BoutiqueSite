/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.servlet;

import br.com.itfox.beans.Order;
import br.com.itfox.business.BusinessDelegate;
import br.com.itfox.controller.SalesOrderJpaController;
import br.com.itfox.controller.TransactionJpaController;
import br.com.itfox.entity.SalesOrder;
import br.com.itfox.entity.Transaction;
import br.com.itfox.utils.Utils;
import com.eway.payment.rapid.sdk.RapidClient;
import com.eway.payment.rapid.sdk.RapidSDK;
import com.eway.payment.rapid.sdk.output.QueryTransactionResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author belchiorpalma
 */
public class Checkout extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /**
             http://www.boutiquecellars.com/Checkout?AccessCode=C3AB9k1xvdgkguwwtWJ1KjmvjTCaDD7Fd5gl9PV5a__k5DOf3-fI_yW0Ek7gHaYgloPW4X7PN4II96fQkARxlD_e6yRtH_HfgiHH9DLVE7T9d3k0gFCWRPgwxgjHC__VJuF7TiDdsWaX1XNBxspM16NcwDQ==
             */
            // servlet for get information about order
            out.print(" checkout");
            try{
                String apiKey = "44DD7CfnAKlw1sNplZ8Ue/3imR3DcWfKokZOBerZ/ijRkuVRdfNQzNrQ05GYtW4ni6ACFB";
                String password = "zm3dRlSA";
                String rapidEndpoint = "Sandbox";
                String accessCode="F9802Af1q9L9fW_O3D2mwdZpJ_4nfZPIhbGu14mVYHtBB4CIR9fWUduVAtO1Gv4vJFmwGflc_9-wHsgIwP4k_dlE1lHoVMPgVHJ34p7QXLy_sVAVEt7ASXz9uZwC18Q6baYdZcnSDhEmQlgDXlXZEhuKhnQ==";
                accessCode="C3AB9k1xvdgkguwwtWJ1KjmvjTCaDD7Fd5gl9PV5a__k5DOf3-fI_yW0Ek7gHaYgloPW4X7PN4II96fQkARxlD_e6yRtH_HfgiHH9DLVE7T9d3k0gFCWRPgwxgjHC__VJuF7TiDdsWaX1XNBxspM16NcwDQ==";
                //accessCode = (String) request.getParameter("AccessCode");
                HttpSession session = request.getSession(true);
                String firstName="";
                String lastName="";
                String email="";
                String invNumber="";
                String invRef="";
                int totalAmount=0;
                int transactionID=0;
                String transDate="";
                String respCode="";
                String respMessage="";
                String autCode="";
                String note="";
                boolean status=false;
                Transaction t = new Transaction();
                //SalesOrder salesOrder = new SalesOrder();
                EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
                TransactionJpaController transactionDAO = new TransactionJpaController(emf);
                //SalesOrderJpaController salesOrderDAO = new SalesOrderJpaController(emf);
                Order order = new Order();
                BusinessDelegate bd = new BusinessDelegate();
               
                if(emf==null){
                    
                }
                
                if(accessCode!=null && emf!=null){
                
                    RapidClient client = RapidSDK.newRapidClient(apiKey, password, rapidEndpoint);

                    QueryTransactionResponse queryTransactionResponse = 
                    client.queryTransaction(accessCode);

                    if (queryTransactionResponse.getTransactionStatus().isStatus()) {
                        System.out.println("Payment successful! ID: " + queryTransactionResponse.getTransactionStatus().getTransactionID());
                        
                        firstName = queryTransactionResponse.getTransaction().getCustomer().getFirstName();
                        invNumber = queryTransactionResponse.getTransaction().getPaymentDetails().getInvoiceNumber();
                        invRef = queryTransactionResponse.getTransaction().getPaymentDetails().getInvoiceReference();
                        totalAmount = queryTransactionResponse.getTransaction().getPaymentDetails().getTotalAmount();
                        transactionID = queryTransactionResponse.getTransactionStatus().getTransactionID();
                        //transDate = queryTransactionResponse.getTransaction().getTransactionDateTime();
                        respCode = queryTransactionResponse.getTransactionStatus().getProcessingDetails().getResponseCode();
                        respMessage = queryTransactionResponse.getTransactionStatus().getProcessingDetails().getResponseMessage();
                        autCode = queryTransactionResponse.getTransactionStatus().getProcessingDetails().getAuthorisationCode();
                        status = queryTransactionResponse.getTransactionStatus().isStatus();
                        
                        t.setAccessCode(accessCode);
                        t.setCustomerFirstName(firstName);
                        t.setCustomerLastName(lastName);
                        t.setCustomerEmail(email);
                        t.setTransactionInvoiceNumber(invNumber);
                        t.setTransactionInvoiceReference(invRef);
                        t.setTransactionTotalAmount(String.valueOf(totalAmount));
                        t.setTransactiontransactionID(String.valueOf(transactionID));
                        t.setTransactionResponseCode(respCode);
                        t.setTransactionResponseMessage(respMessage);
                        t.setTransactionStatus(String.valueOf(status));
                        if(invRef!=null){
                            try{
                                String s[] = invRef.split("-");
                                if(s.length>0){
                                    t.setTransactionOrder(Utils.parseInt(s[1]));
                                }
                                // localizando a ordem
                                order =  bd.selectSalesOrder(t.getTransactionOrder());
                               // salesOrder = salesOrderDAO.findSalesOrder(t.getTransactionOrder());
                                t.setSalesOrder(order);
                            }catch(Exception ex){
                                ex.printStackTrace();
                            }
                        }
                        if(status){
                            t.setTransactionOrderStatus(1);
                            t.setTransactionOptions(RapidSDK.userDisplayMessage(respMessage, "en"));
                        }else{
                            t.setTransactionOrderStatus(0);
                        }
                        
                        
                        System.out.println("firstName:"+firstName);
                        System.out.println("invNumber:"+invNumber);
                        System.out.println("invRef:"+invRef);
                        System.out.println("totalAmount:"+totalAmount);
                        System.out.println("transactionID:"+transactionID);
                        System.out.println("transDate:"+transDate);
                        System.out.println("respCode:"+respCode);
                        System.out.println("respMessage:"+respMessage);
                        System.out.println("autCode:"+autCode);
                        System.out.println("status:"+ status);
                        
                        // verificando se existe erro
                        if (!queryTransactionResponse.getErrors().isEmpty()) {
                                for (String errorcode: queryTransactionResponse.getErrors()) {
                                    note+=("Error Message: " 
                                        + RapidSDK.userDisplayMessage(errorcode, "en"));
                                }
                                t.setCustomerNote(note);
                                System.out.println("Errors: " +note);
                        }
                        
                        // persistindo
                        try{
                            transactionDAO.create(t);
                        }catch(Exception ex){
                            ex.printStackTrace();
                        }finally{
                            // inserindo na sessao
                            if(session!=null){
                                session.setAttribute("transaction", t);
                            }
                        }
                        
                        
                    } else {
                        String[] errorcodes = queryTransactionResponse.getTransactionStatus().getProcessingDetails().getResponseMessage().split(", ");

                        for (String errorcode: errorcodes) {
                            System.out.println("Response Messages: " 
                                + RapidSDK.userDisplayMessage(errorcode, "en"));
                        }

                    }
                }
            }catch(Exception ex){
                System.err.println("Erro ao localizar a transacao "+ ex.getMessage());
            }finally{
               response.sendRedirect("confirmation.jsp");
            }
            
            
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
