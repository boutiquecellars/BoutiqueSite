<%-- 
    Document   : incRelatedProducts
    Created on : 11/06/2017, 09:58:54
    Author     : belchiorpalma
--%>
<%@page import="br.com.itfox.utils.Utils"%>
<%@page import="br.com.itfox.beans.Product"%>
<%@page import="java.util.List"%>
<%@page import="br.com.itfox.business.BusinessDelegate"%>
<%
String categoryId = (String) request.getParameter("categoryId");
String limit = (String) request.getParameter("limit");
BusinessDelegate bd = new BusinessDelegate();
List<Product> listProducts = bd.selectProductsLight(Utils.parseInt(categoryId), Utils.parseInt(limit));
%>
<%
                    int i=1;
                    int cont=1;
                    int size = listProducts.size();
                    for(Product p:listProducts){
                    %>
                    <%
                      if(i==1){
                    %>
<div class="row" data-gutter="15">
     <%
                      }     
                    %>
                <div class="col-md-3">
                    <div class="product product-sm-left ">
                        <ul class="product-labels"></ul>
                        <div class="product-img-wrap">
                            <img class="product-img" src="https://boutiquecellars.com/wine/imgs/boutique_cellars_<%=p.getNameReplaceAll(true)%>" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <a class="product-link" href="product.jsp?wine=<%=p.getNameReplaceAll(false)%>&product_id=<%=p.getProductId() %>"></a>
                        <div class="product-caption">
                            <!--
                            <ul class="product-caption-rating">
                                <li class="rated"><i class="fa fa-star"></i>
                                </li>
                                <li class="rated"><i class="fa fa-star"></i>
                                </li>
                                <li class="rated"><i class="fa fa-star"></i>
                                </li>
                                <li class="rated"><i class="fa fa-star"></i>
                                </li>
                                <li class="rated"><i class="fa fa-star"></i>
                                </li>
                            </ul>-->
                            <h5 class="product-caption-title"><%=p.getName() %></h5>
                            <div class="product-caption-price"><span class="product-caption-price-new">AUD$<%=Utils.formatDecimal(p.getPrice())%></span>
                            </div>
                            <ul class="product-caption-feature-list">
                                
                            </ul>
                        </div>
                    </div>
                </div>
                
                <%if(i==4 || cont==size){%>
            </div>
<% 
                        i=0;
                        } 
                    %>
                    <%
                        i++;
                        cont++;
                        }
                    %>