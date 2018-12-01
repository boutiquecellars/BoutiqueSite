<%-- 
    Document   : incProducts
    Created on : 06/06/2017, 00:07:56
    Author     : belchiorpalma
--%>
<%@page import="br.com.itfox.utils.Utils"%>
<%@page import="br.com.itfox.beans.Product"%>
<%@page import="java.util.List"%>
<%@page import="br.com.itfox.business.BusinessDelegate"%>
<%
BusinessDelegate bd = new BusinessDelegate();
String categoryId = (String) request.getParameter("categoryId");
String limit = (String) request.getParameter("limit");



List<Product> listProducts = bd.selectProductsLight(Utils.parseInt(categoryId), Utils.parseInt(limit));
%>
<div class="col-md-9">
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
                        <div class="col-md-4">
                            <div class="product ">
                                <ul class="product-labels">
                                    <!-- <li>hot</li> -->
                                </ul>
                                <div class="product-img-wrap">
                                    <img class="product-img-primary" src="https://boutiquecellars.com/wine/imgs/boutique_cellars_<%=p.getNameReplaceAll(true)%>" alt="Image Alternative text" title="Image Title" />
                                    <img class="product-img-alt" src="https://boutiquecellars.com/wine/imgs/boutique_cellars_<%=p.getNameReplaceAll(true)%>" alt="Image Alternative text" title="Image Title" />
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
                                        <li><i class="fa fa-star"></i>
                                        </li>
                                        <li><i class="fa fa-star"></i>
                                        </li>
                                    </ul> -->
                                    <h5 class="product-caption-title"><%=p.getName() %></h5>
                                    <div class="product-caption-price"><span class="product-caption-price-new">AUD$<%=Utils.formatDecimal(p.getPrice()) %></span>
                                    </div>
                                    <ul class="product-caption-feature-list">
                                        
                                    </ul>
                                </div>
                            </div>
                        </div>
                    <%if(i==3 || cont==size){%>
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
                    
                    <div class="row">
                        <div class="col-md-6">
                            <p class="category-pagination-sign"><%=size%> items found in Wines. </p>
                        </div>
                        <!--
                        <div class="col-md-6">
                            <nav>
                                <ul class="pagination category-pagination pull-right">
                                    <li class="active"><a href="#">1</a>
                                    </li>
                                    <li><a href="#">2</a>
                                    </li>
                                    <li><a href="#">3</a>
                                    </li>
                                    <li><a href="#">4</a>
                                    </li>
                                    <li><a href="#">5</a>
                                    </li>
                                    <li class="last"><a href="#"><i class="fa fa-long-arrow-right"></i></a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        -->
                    </div>
                    
                </div>
