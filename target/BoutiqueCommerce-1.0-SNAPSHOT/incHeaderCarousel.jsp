<%-- 
    Document   : incHeaderCarousel
    Created on : 23/05/2017, 10:09:14
    Author     : belchiorpalma
--%>
<%@page import="java.util.List"%>
<%@page import="br.com.itfox.beans.Product"%>
<%@page import="br.com.itfox.business.BusinessDelegate"%>
<%
BusinessDelegate bd = new BusinessDelegate();
List<Product> listProducts = bd.selectProductsCarousel();
%>
<div class="owl-carousel owl-loaded owl-nav-dots-inner" data-options='{"items":1,"loop":true}'>
            <%
            for(Product p:listProducts){
            %>
            <div class="owl-item">
                <div class="slider-item">
                    <div class="container">
                        <div class="slider-item-inner">
                            <div class="slider-item-caption-left slider-item-caption-white">
                                <h4 class="slider-item-caption-title"><%=p.getName()%></h4>
                                <p class="slider-item-caption-desc"><%=p.getMetaTagTitle()%></p><a class="btn btn-lg btn-ghost btn-white" href="product.jsp?wine=<%=p.getNameReplaceAll(false)%>&product_id=<%=p.getProductId()%>">Shop Now</a>
                            </div>
                            <img class="slider-item-img-right" src="http://boutiquecellars.com/wine/imgs/boutique_cellars_<%=p.getNameReplaceAll(true)%>" alt="<%=p.getName()%> title="<%=p.getMetaTagTitle()%>" style="top: 60%; width: 17%; margin-right: 200px" />
                        </div>
                    </div>
                </div>
            </div>
            <%
            }
            %> 
            <!--
            <div class="owl-item">
                <div class="slider-item">
                    <div class="container">
                        <div class="slider-item-inner">
                            <div class="slider-item-caption-right slider-item-caption-white">
                                <h4 class="slider-item-caption-title">World Top Guitars from $350</h4>
                                <p class="slider-item-caption-desc">Fill It To The Rim With Guitar.</p><a class="btn btn-lg btn-ghost btn-white" href="#">Shop Now</a>
                            </div>
                            <img class="slider-item-img-left" src="img/Reserve_merlot2014.png" alt="Image Alternative text" title="Image Title" style="transform:translateY(-50%) rotate(14deg); width: 25%; margin-left: 150PX" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="owl-item">
                <div class="slider-item">
                    <div class="container">
                        <div class="slider-item-inner">
                            <div class="slider-item-caption-left slider-item-caption-white">
                                <h4 class="slider-item-caption-title">Run! Run! Run!</h4>
                                <p class="slider-item-caption-desc">Your Running Shoes, Right Away.</p><a class="btn btn-lg btn-ghost btn-white" href="#">Shop Now</a>
                            </div>
                            <img class="slider-item-img-right" src="img/Reserve_merlot2014.png" alt="Image Alternative text" title="Image Title" style="top: 60%; width: 22%; margin-left: 200px" />
                        </div>
                    </div>
                </div>
            </div>
            -->
        </div>
