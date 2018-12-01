<%-- 
    Document   : incNavbarFirst
    Created on : 21/05/2017, 22:40:24
    Author     : belchiorpalma
--%>
<%@page import="br.com.itfox.beans.OrderItem"%>
<%@page import="java.util.List"%>
<%@page import="br.com.itfox.beans.Order"%>
<%
        Order order = new Order();
        String sessionId="";
        if(session!=null){
            order = (Order) session.getAttribute("order");
            if(order!=null){
                sessionId=order.getOrderId()+"";
            }
        }
        %>
<nav class="navbar navbar-default navbar-main-white navbar-pad-top navbar-first">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp">
                        <img src="img/logo-boutiquecellars.svg" alt="Boutique Cellars" title="Boutique Cellars" />
                    </a>
                </div><!--
                <form class="navbar-form navbar-left navbar-main-search navbar-main-search-category" role="search">
                    <select class="navbar-main-search-category-select">
                        <option>All Departmens</option>
                        <option>Appilances</option>
                        <option>Apps & Games</option>
                        <option>Arts, Crafts & Sewing</option>
                        <option>Automotive</option>
                        <option>Baby</option>
                        <option>Books</option>
                        <option>CDs & Vinyl</option>
                        <option>Cell Phones & Accessories</option>
                        <option>Clothing, Shoes & Jewelry</option>
                        <option>&nbsp;&nbsp;&nbsp;Woman</option>
                        <option>&nbsp;&nbsp;&nbsp;Men</option>
                        <option>&nbsp;&nbsp;&nbsp;Girls</option>
                        <option>&nbsp;&nbsp;&nbsp;Baby</option>
                        <option>Collectibles & Fine Art</option>
                        <option>Computers</option>
                        <option>Credit and Payment Cards</option>
                        <option>Digital Music</option>
                        <option>Electronics</option>
                        <option>Gift Cards</option>
                        <option>Grocery & Gourmet</option>
                        <option>Health & Personal Care</option>
                        <option>Home & Kitchen</option>
                        <option>Industrial & Scientific</option>
                        <option>Luggage & Travel</option>
                        <option>Luxury Beauty</option>
                        <option>Magazine Subscribtions</option>
                        <option>Movies & TV</option>
                        <option>Musical Instuments</option>
                        <option>Office Products</option>
                        <option>Patio, Lawn & Garden</option>
                        <option>Pet Supplies</option>
                        <option>Software</option>
                        <option>Sports & Outdoors</option>
                        <option>Tools & Home Improvement</option>
                        <option>Toys & Games</option>
                        <option>Video Games</option>
                        <option>Wine</option>
                    </select>
                    <div class="form-group">
                        <input class="form-control" type="text" placeholder="Search the Entire Store..." />
                    </div>
                    <a class="fa fa-search navbar-main-search-submit" href="#"></a>
                </form>-->
                <ul class="nav navbar-nav navbar-right navbar-mob-item-left">
                    <!--
                    <li><a href="#nav-login-dialog" data-effect="mfp-move-from-top" class="popup-text"><span >Hello, Sign in</span>Your Account</a>
                    </li>
                    -->
                    <%
                         if(order!=null){
                                List<OrderItem> itens = order.getItems();
                                if(itens!=null && itens.size()>0){
                    %>
                    <li class="dropdown"><a href="shopping-cart.jsp"><span >Your Cart</span><i class="fa fa-shopping-cart"></i> <%=itens.size()%> Items</a>
                        <ul class="dropdown-menu dropdown-menu-shipping-cart">
                            <%
                           
                                
                                    for(OrderItem i:itens){
                                 %>
                            <li>
                                <a class="dropdown-menu-shipping-cart-img" href="#">
                                    <img src="https://boutiquecellars.com/wine/imgs/boutique_cellars_<%=i.getProduct().getNameReplaceAll(true)%>" alt="Image Alternative text" title="Image Title" />
                                </a>
                                <div class="dropdown-menu-shipping-cart-inner">
                                    <p class="dropdown-menu-shipping-cart-price">AUD$<%=i.getProductTotal() %></p>
                                    <p class="dropdown-menu-shipping-cart-item"><a href="#"><% if(i.getProduct()!=null){out.print(i.getProduct().getName());} %></a>
                                    </p>
                                </div>
                            </li>
                            <%
                                    }// fim for
                                
                            %>
                            <li>
                                <p class="dropdown-menu-shipping-cart-total">Total: AUD$<% if(order!=null){out.print(order.getTotalSalesOrder());} %></p>
                                <button class="dropdown-menu-shipping-cart-checkout btn btn-primary" onclick="checkout()">Checkout</button>
                            </li>
                        </ul>
                    </li>
                    <%
                        }// fim if itens nulos
                    }// fim order nulo
                    %>
                    <div class="navbar-header">
                        <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#main-nav-collapse" area_expanded="false"><span class="sr-only">Main Menu</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                        </button>
                    </div>
                </ul>
            </div>
        </nav>
                    <script>
                        function checkout(){
                            window.location.replace("checkout.jsp");
                        }
                        </script>