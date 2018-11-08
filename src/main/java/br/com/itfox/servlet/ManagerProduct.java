/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.servlet;

import br.com.itfox.beans.Member;
import br.com.itfox.beans.Product;
import br.com.itfox.business.BusinessDelegate;
import br.com.itfox.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author belchiorpalma
 */
public class ManagerProduct extends HttpServlet {

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
        String name = request.getParameter("name");
        String sPrice = request.getParameter("price");
        String description = request.getParameter("description");
        String metaTitle = request.getParameter("meta_tag_title");
        String metaDescription = request.getParameter("meta_tag_description");
        String metKeywords = request.getParameter("meta_tag_keywords");
        String pic1 = request.getParameter("image_data");
        String pic2 = request.getParameter("pic2");
        String pic3 = request.getParameter("pic3");
        String pic4 = request.getParameter("pic4");
        String pic5 = request.getParameter("pic5");
        String productId = request.getParameter("id");
        String operation = request.getParameter("operation");
        if(name!=null && !name.isEmpty() && name!="" ){
            Product p = new Product();
            p.setName(name);
            
            if(productId !=null && !productId.isEmpty() && productId!=""){
                try{
                p.setProductId(Integer.parseInt(productId));
                }catch(Exception ex){
                    br.com.itfox.utils.Logger.getLogger(ex);
                }
            }
            if(sPrice !=null && !sPrice.isEmpty() && sPrice!=""){
                try{
                    p.setPrice(Float.parseFloat(sPrice));
                }catch(Exception ex){
                    br.com.itfox.utils.Logger.getLogger(ex);
                }
            }
            // convert blob to String
            p.setDescription(Utils.stringToBlob(description));
            p.setPic1(Utils.stringToBlob(pic1));
            p.setPic2(Utils.stringToBlob(pic2));
            p.setPic3(Utils.stringToBlob(pic3));
            p.setPic4(Utils.stringToBlob(pic4));
            p.setPic5(Utils.stringToBlob(pic5));
            p.setMetaTagDescription(metaDescription);
            p.setMetaTagTitle(metaTitle);
            p.setMetaTagKeywords(metKeywords);
            int result = 0;
            if(operation !=null && !operation.isEmpty() && operation!="" && operation.equalsIgnoreCase("insert")){
                result= new BusinessDelegate().insertProduct(p);
            }else if(operation !=null && !operation.isEmpty() && operation!="" && operation.equalsIgnoreCase("update")){
                result = new BusinessDelegate().updateProduct(p);
            }else if(operation !=null && !operation.isEmpty() && operation!="" && operation.equalsIgnoreCase("delete")){
                result = new BusinessDelegate().deleteProduct(p);
            }
            
            if (result>0) {
                //session.setAttribute("userid", m.getEmail());
                //out.println("welcome " + userid);
                //out.println("<a href='logout.jsp'>Log out</a>");
                response.sendRedirect("ecommerce_product.jsp?msg=success");
            } else {
                response.sendRedirect("ecommerce_product.jsp?msg=error");
            }
        }else{
            response.sendRedirect("ecommerce_product.jsp?msg=null");
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
