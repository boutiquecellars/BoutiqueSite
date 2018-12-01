<%@page import="br.com.itfox.beans.OrderItem"%>
<%@page import="java.util.List"%>
<%@page import="br.com.itfox.beans.Order"%>
<!DOCTYPE HTML>
<html>

<head>
    <title>Privacy Policy</title>
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
                <h1 class="page-title">Privacy Policy</h1>
            </header>
            <div class="row">
                <div class="col-md-9">
                    <p class="gap gap-small">Boutique Cellar Imports Pty Ltd (ABN 69 607 265 618) and trading as Boutique Cellars is totally committed to ensuring your privacy is maintained at all times throughout your association with us. We adhere to strict privacy and security measures in order to ensure the safety and confidentiality of your information.<br/><br/>
                    Boutique Cellar Imports Pty Ltd is also subject to the National Privacy Principles (NPP) contained within the Privacy Act 1988.
                    </p>
                    <h2>What information do we collect and how is it used?</h2>
                    <p class="gap gap-small">
                        We only collect customer information that is necessary for us to do what we do. For example, when you order online, we need your name, email address, postal address, credit card number and expiration date. This enables us to process your order. We also require your telephone number to notify you of your orders status if required. We will also use this information to contact you, if you agree, to keep you abreast of special offers and promotions we have available.
                        <br/><br/>From time to time, we may also collect non-personal information from our customers. Sales history and purchase preference data, for example, that helps us in our ongoing efforts to improve our website and to make informed decisions when providing information on items you may wish to know about. 

                    </p>
                    <h2>How do we collect the information?</h2>
                    <p class="gap gap-small">More often than not the information will come directly from you. If, however, someone purchases you a gift for example, your information may become available to us from a third party. We will always ensure that the source of your information is indicated clearly in our customer list so you can confirm how we collected it if required. If your information is collected in this fashion we will confirm with you whether you want to receive any additional information from us, promotional or otherwise.
</p>
                <h2>Disclosure of personal information.</h2>
                    <p class="gap gap-small">We only use or disclose information about our customers in ways they would reasonably expect. This means we only use information to process your order or to improve our website and offers. At this time we do not partner with or have special relationships with any ad server companies or third parties and therefore do not pass off your particulars to any ad server companies or to third parties.
</p>
<h2>Security Policy.</h2>
                    <p class="gap gap-small">When purchasing from Boutique Cellars, card details are transmitted through a secure server using eWay?s electronic payment gateway. Card data is not hosted or stored in any way by Boutique Cellars after processing.
</p>
<h2>Accessing personal information & complaints.</h2>
<p class="gap gap-small">
    Boutique Cellars understands that it is important that our customers be able to access their personal information. Access requests can be made by emailing us at bci.wines@gmail.com.
    <br/><br/>If you require clarification on specific topics regarding your information, have a concern, a complaint or a suggestion on how we can improve this area of our service, please contact us as soon as possible by phoning emailing us at bci.wines@gmail.com.

</p>
                </div>
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
    <script>
        $( document ).ready(function() {
            $(".eway-button").hide();
        });
        function proceedPayment(){
            var name = $("#name").val();
            var email = $("#email").val();
            var tel = $("#tel").val();
            
            var error=0;
            
            if(name==null || name.length<3){
                alert("Please, Fill Name");
                $("#name").focus();
                error++;
            }else if(email==null || email.length<3){
                alert("Please, Fill Correct Email");
                $("#email").focus();
                error++;
            }else if(tel==null || tel.length<3){
                alert("Please, Fill Phone");
                $("#phone").focus();
                error++;
            }
            
            if(error==0){
                $("#eway-paynow-button").attr("data-email",email);
                $("#eway-paynow-button").attr("data-phone",tel);
                $("#eway-paynow-button").attr("data-cardname","12345678");


                $(".eway-button").show();
                $(".eway-button").click();
                $(".proceed-payment").hide();
            }
        }
    </script>




</body>

</html>
