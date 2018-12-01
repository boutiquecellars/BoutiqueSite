<%@page import="br.com.itfox.utils.Utils"%>
<%@page import="br.com.itfox.beans.OrderItem"%>
<%@page import="java.util.List"%>
<%@page import="br.com.itfox.beans.Order"%>
<!DOCTYPE HTML>
<html>

<head>
    <title>BoutiqueCellars - Shopping cart</title>
    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <meta content="utf-8" http-equiv="encoding">
    <meta name="keywords" content="Template, html, premium, themeforest" />
    <meta name="description" content="TheBox - premium e-commerce template">
    <meta name="author" content="Tsoy">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href='https://fonts.googleapis.com/css?family=Roboto:500,300,700,400italic,400' rel='stylesheet' type='text/css'>
    <!-- <link href='https://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'> -->
    <!-- <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'> -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/mystyles.css">

</head>

<body>
    <div class="global-wrapper clearfix" id="global-wrapper">
        
        <!-- include Navbar Static Top -->
        <jsp:include page="incNavbarStaticTop.jsp">
            <jsp:param name="page" value="index" />
        </jsp:include>
        <!-- // include Navbar Static Top -->
        
        <!-- include Navbar Login Dialog -->
        <jsp:include page="incNavLoginDialog.jsp">
            <jsp:param name="page" value="index" />
        </jsp:include>
        <!-- //include Navbar Login Dialog -->
        
        <!-- include Navbar Account -->
        <jsp:include page="incNavAccount.jsp">
            <jsp:param name="page" value="index" />
        </jsp:include>
        <!-- //include Navbar Account -->
        
        
        
        <!-- include Navbar First -->
        <jsp:include page="incNavbarFirst.jsp">
            <jsp:param name="page" value="index" />
        </jsp:include>
        <!-- // include Navbar First -->
        
         <!-- include Navbar Default -->
        <jsp:include page="incNavbarDefault.jsp">
            <jsp:param name="page" value="index" />
        </jsp:include>
        <!-- // include Navbar Default -->
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
        <div class="container">
            <header class="page-header">
                <h1 class="page-title">My Shopping Bag </h1>
                <p><span class="small">All transactions are processed in Australian dollars</span></p>
            </header>
            <div class="row">
                <div class="col-md-10">
                    <table class="table table table-shopping-cart">
                        <thead>
                            <tr>
                                <th>Product</th>
                                <th>Title</th>
                                
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Remove</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            if(order!=null){
                                List<OrderItem> itens = order.getItems();
                                if(itens!=null && itens.size()>0){
                                    for(OrderItem i:itens){
                                 %>
                                 <tr>
                                <td class="table-shopping-cart-img">
                                    <a href="#">
                                        <img src="https://boutiquecellars.com/wine/imgs/boutique_cellars_<%=i.getProduct().getNameReplaceAll(true)%>" alt="Image Alternative text" title="Image Title" />
                                    </a>
                                </td>
                                <td class="table-shopping-cart-title"><a href="#"><% if(i.getProduct()!=null){out.print(i.getProduct().getName());} %></a>
                                </td>
                                
                                <td>AUD$<% out.print(i.getProductPrice()); %></td>
                                <td>
                                    <input class="form-control table-shopping-qty" type="text" value="<%=i.getProductQuantity() %>" />
                                </td>
                                <td>AUD$<%=i.getProductTotal() %></td>
                                <td>
                                    <a class="fa fa-close table-shopping-remove" href="ShoppingCart?product=<%=i.getProduct().getNameReplaceAll(true)%>&ref=<%=i.getProduct().getProductId() %>&itemId=<%=i.getOrderItemId() %>&operation=delete"></a>
                                </td>
                            </tr>
                                 <%
                                    }// fim for
                                }// fim if itens nulos
                            }// fim order nulo
                            %>
                            
                        </tbody>
                    </table>
                    <div class="gap gap-small"></div>
                </div>
                <div class="col-md-2">
                    <ul class="shopping-cart-total-list">
                        <li><span>Subtotal</span><span>AUD$<% if(order!=null){out.print(Utils.formatDecimal(order.getTotalSalesOrder()/1.1));} %></span>
                        </li>
                        <li><span>Shipping</span>
                            <span>
                                <%
                                 float shipping=0.0f;   
                                 if(order.getTotalSalesOrder()<=300){
                                     shipping=20;
                                     {out.print("AUD$ "+Utils.formatDecimal(shipping));}
                                 }else{
                                     out.print("Free");
                                 }
                                %>
                                </span>
                        </li>
                        <li><span>GST</span><span>AUD$<% if(order!=null){out.print(Utils.formatDecimal((order.getTotalSalesOrder()/1.1)*0.1));} %></span>
                        </li>
                        <li><span>Total</span><span>AUD$<% if(order!=null){out.print(Utils.formatDecimal(order.getTotalSalesOrder()+shipping));} %></span>
                        </li>
                    </ul><a class="btn btn-primary" href="checkout.jsp">Checkout</a>
                    
                </div>
            </div>
            <ul class="list-inline">
                <li><a class="btn btn-default" href="index.jsp">Continue Shopping</a>
                </li>
                <!--
                <li><a class="btn btn-default" href="#">Update Bag</a>
                </li>-->
            </ul>
        </div>
        <div class="gap"></div>
        
         <!-- include Footer -->
            <jsp:include page="incFooter.jsp">
                <jsp:param name="page" value="index" />
            </jsp:include>
        <!-- //include Footer -->  
        <!-- include Footer Copyright -->
            <jsp:include page="incFooterCopyright.jsp">
                <jsp:param name="page" value="index" />
            </jsp:include>
        <!-- //include Footer Copyright -->  

        
    </div>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/icheck.js"></script>
    <script src="js/ionrangeslider.js"></script>
    <script src="js/jqzoom.js"></script>
    <script src="js/card-payment.js"></script>
    <script src="js/owl-carousel.js"></script>
    <script src="js/magnific.js"></script>
    <script src="js/custom.js"></script>





</body>

</html>
