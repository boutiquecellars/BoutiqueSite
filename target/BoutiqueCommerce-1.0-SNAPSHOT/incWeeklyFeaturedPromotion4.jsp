<%-- 
    Document   : incWeeklyFeaturedPromotion4
    Created on : 23/05/2017, 10:44:44
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

<div class="row" data-gutter="15">
    <%
        int i=0;
            for(Product p:listProducts){
                if(i==4){
                    break;
                }
            %>
                <div class="col-md-3">
                    <div class="product ">
                        <ul class="product-labels">
                            <li>-60%</li>
                            <li>stuff pick</li>
                        </ul>
                        <div class="product-img-wrap">
                            <img class="product-img-primary" src="http://boutiquecellars.com/wine/imgs/boutique_cellars_<%=p.getNameReplaceAll(true)%>" alt="Image Alternative text" title="Image Title" />
                            <img class="product-img-alt" src="http://boutiquecellars.com/wine/imgs/boutique_cellars_<%=p.getNameReplaceAll(true)%>" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <a class="product-link" href="product.jsp?wine=<%=p.getNameReplaceAll(false)%>&product_id=<%=p.getProductId()%>"></a>
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
                            <h5 class="product-caption-title"><%=p.getName()%></h5>
                            <div class="product-caption-price"><!--<span class="product-caption-price-old">$75</span>--><span class="product-caption-price-new">AUD$<%=Utils.formatDecimal(p.getPrice())%></span>
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
                <div class="col-md-3">
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
                                <li class="rated"><i class="fa fa-star"></i>
                                </li>
                                <li><i class="fa fa-star"></i>
                                </li>
                            </ul>
                            <h5 class="product-caption-title">Hamilton Beach 49996 FlexBrew Single-Serve Coffeemaker with Removable Reservoir</h5>
                            <div class="product-caption-price"><span class="product-caption-price-new">$50</span>
                            </div>
                            <ul class="product-caption-feature-list">
                                <li>2 left</li>
                                
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="product ">
                        <ul class="product-labels">
                            <li>hot</li>
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
                                <li><i class="fa fa-star"></i>
                                </li>
                                <li><i class="fa fa-star"></i>
                                </li>
                            </ul>
                            <h5 class="product-caption-title">72 Sq Ft Black Foam Interlocking Exercise Protective Tile Flooring Gym Floor Mat</h5>
                            <div class="product-caption-price"><span class="product-caption-price-new">$62</span>
                            </div>
                            <ul class="product-caption-feature-list">
                                
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
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
                            <h5 class="product-caption-title">Barnett 78649 Recruit Youth 100# Crossbow Package With Red Dot Sight Pink</h5>
                            <div class="product-caption-price"><span class="product-caption-price-new">$55</span>
                            </div>
                            <ul class="product-caption-feature-list">
                                <li>3 left</li>
                                
                            </ul>
                        </div>
                    </div>
                </div>
            -->
            </div>