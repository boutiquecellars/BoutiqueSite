<%-- 
    Document   : incWeeklyFeatured
    Created on : 23/05/2017, 10:38:22
    Author     : belchiorpalma
--%>
<%@page import="br.com.itfox.utils.Utils"%>
<%@page import="java.util.List"%>
<%@page import="br.com.itfox.beans.Product"%>
<%@page import="br.com.itfox.business.BusinessDelegate"%>
<%
BusinessDelegate bd = new BusinessDelegate();
List<Product> listProducts = bd.selectProductsLight();
%>
<h3 class="widget-title-lg">Weekly Featured</h3>
 <div class="row" data-gutter="15">
            <%
            int i=0;
            for(Product p:listProducts){
                if(i==3){break;}
            %>
                <div class="col-md-4">
                    <div class="product ">
                        <ul class="product-labels"></ul>
                        <div class="product-img-wrap">
                            <img class="product-img-primary" src="http://boutiquecellars.com/wine/imgs/boutique_cellars_<%=p.getNameReplaceAll(true)%>" alt="Image Alternative text" title="Image Title" />
                            <img class="product-img-alt" src="http://boutiquecellars.com/wine/imgs/boutique_cellars_<%=p.getNameReplaceAll(true)%>" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <a class="product-link" href="product.jsp?wine=<%=p.getNameReplaceAll(false)%>&product_id=<%=p.getProductId()%>"><%=p.getName()%> </a>
                        <div class="product-caption">
                            <ul class="product-caption-rating">
                                <li class="rated"><i class="fa fa-star"></i>
                                </li>
                                <li class="rated"><i class="fa fa-star"></i>
                                </li>
                                <li class="rated"><i class="fa fa-star"></i>
                                </li>
                                <li class="rated"><i class="fa fa-star"></i>
                                </li>
                                <li><i class="fa fa-star"></i>
                                </li>
                            </ul>
                            <h5 class="product-caption-title"><%=p.getName()%></h5>
                            <div class="product-caption-price"><span class="product-caption-price-new">AUD$<%=Utils.formatDecimal(p.getPrice())%></span>
                            </div>
                            <ul class="product-caption-feature-list">
                                
                            </ul>
                        </div>
                              
                    </div>
                </div>
            <%
               i++; 
            }
            %>
            <!--
                <div class="col-md-4">
                    <div class="product ">
                        <ul class="product-labels">
                            <li>-20%</li>
                        </ul>
                        <div class="product-img-wrap">
                            <img class="product-img-primary" src="img/500x500.png" alt="Image Alternative text" title="Image Title" />
                            <img class="product-img-alt" src="img/500x500.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <a class="product-link" href="#"></a>
                        <div class="product-caption">
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
                            </ul>
                            <h5 class="product-caption-title">Military Shoulder Tactical Backpack Rucksacks Sport Travel Hiking Trekking Bag</h5>
                            <div class="product-caption-price"><span class="product-caption-price-old">$80</span><span class="product-caption-price-new">$64</span>
                            </div>
                            <ul class="product-caption-feature-list">
                                
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="product ">
                        <ul class="product-labels"></ul>
                        <div class="product-img-wrap">
                            <img class="product-img-primary" src="img/500x500.png" alt="Image Alternative text" title="Image Title" />
                            <img class="product-img-alt" src="img/500x500.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <a class="product-link" href="#"></a>
                        <div class="product-caption">
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
                            </ul>
                            <h5 class="product-caption-title">Apple iPhone 4S 16GB Factory Unlocked Black and White Smartphone</h5>
                            <div class="product-caption-price"><span class="product-caption-price-new">$125</span>
                            </div>
                            <ul class="product-caption-feature-list">
                                <li>2 left</li>
                                
                            </ul>
                        </div>
                    </div>
                </div>
                -->
            </div>
