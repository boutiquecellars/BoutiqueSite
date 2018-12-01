<%@page import="br.com.itfox.beans.OrderItem"%>
<%@page import="java.util.List"%>
<%@page import="br.com.itfox.beans.Order"%>
<!DOCTYPE HTML>
<html>

<head>
    <title>Shipping</title>
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
    <style>
        .eway-button{
            display:none;
        }
    </style>
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
                <h1 class="page-title">Shipping</h1>
            </header>
            <div class="row">
                <div class="col-md-9">
                    <p class="gap gap-small">
                        Boutique Cellars only ships within Australia. All orders are dispatched within 1 business day. A flat shipping fee of $15.00 AUD is charged for all orders under $300.00 AUD. 

                    </p>
                    <p class="gap gap-small">Orders are sent via standard freight. You will receive a confirmation email and tracking number from our freight partner once your order is dispatched. Please allow bt. 2-7 working days for your order to arrive.
</p>
                    <p class="gap gap-small">If your order is not received within this timeframe, please contact us on: bci.wines@gmail.com.
</p>
                </div>
            </div>
            <div class="gap gap-small"></div>
            
            
            
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
