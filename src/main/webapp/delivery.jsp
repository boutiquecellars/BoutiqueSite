<%@page import="br.com.itfox.beans.OrderItem"%>
<%@page import="java.util.List"%>
<%@page import="br.com.itfox.beans.Order"%>
<!DOCTYPE HTML>
<html>

<head>
    <title>Delivery</title>
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
                <h1 class="page-title">Delivery</h1>
            </header>
            <div class="row">
                <div class="col-md-9">
                    <p class="lead">Aliquet fusce eget quisque posuere condimentum lectus molestie pulvinar placerat ac interdum maecenas mollis ad nostra rutrum ornare arcu taciti vitae lobortis eleifend iaculis turpis vitae cras tellus ultricies odio</p>
                </div>
            </div>
            <div class="gap gap-small"></div>
            <div class="row row-col-gap">
                <div class="col-md-8">
                    <img class="full-width" src="img/960x480.png" alt="Image Alternative text" title="Image Title" />
                </div>
                <div class="col-md-4">
                    <h3 class="widget-title">Our Story</h3>
                    <p>Suspendisse nascetur tellus lacinia volutpat dictumst blandit scelerisque nullam ut ipsum proin hac morbi donec porttitor facilisi elementum facilisis per accumsan pretium aliquet commodo non duis est vestibulum phasellus leo</p>
                    <p>Fringilla pulvinar fermentum nunc augue id conubia luctus sociosqu himenaeos dictum duis lobortis penatibus class nascetur fames pulvinar varius pulvinar</p>
                    <p>Dignissim nascetur fringilla ligula luctus nisl habitasse ut ac sociis nisi tristique consectetur potenti curae nascetur pellentesque duis odio ornare</p>
                    <p>Vestibulum sem consectetur iaculis torquent lobortis dis libero risus parturient</p>
                </div>
            </div>
            <div class="gap gap-small"></div>
            <div class="row row-col-gap">
                <div class="col-md-6">
                    <h3 class="widget-title">The Community</h3>
                    <p>Vestibulum congue litora fusce aenean at facilisi volutpat lorem mi consequat natoque tincidunt eget etiam nascetur iaculis iaculis non ultricies</p>
                    <p>Metus porta lobortis convallis lacinia integer platea cum pharetra duis nulla lectus himenaeos hac condimentum viverra condimentum morbi maecenas elit vestibulum vulputate nisl dignissim mus lacus sem euismod venenatis at</p>
                    <p>Varius mattis rutrum nostra habitant feugiat condimentum faucibus taciti porttitor</p>
                </div>
                <div class="col-md-6">
                    <img class="full-width" src="img/550x210.png" alt="Image Alternative text" title="Image Title" />
                </div>
            </div>
            <div class="gap gap-small"></div>
            <div class="row row-col-gap">
                <div class="col-md-9">
                    <div class="row row-sm-gap" data-gutter="10">
                        <div class="col-md-2">
                            <img class="full-width" src="img/300x300.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <div class="col-md-2">
                            <img class="full-width" src="img/300x300.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <div class="col-md-2">
                            <img class="full-width" src="img/300x300.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <div class="col-md-2">
                            <img class="full-width" src="img/300x300.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <div class="col-md-2">
                            <img class="full-width" src="img/300x300.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <div class="col-md-2">
                            <img class="full-width" src="img/300x300.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <div class="col-md-2">
                            <img class="full-width" src="img/300x300.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <div class="col-md-2">
                            <img class="full-width" src="img/300x300.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <div class="col-md-2">
                            <img class="full-width" src="img/300x300.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <div class="col-md-2">
                            <img class="full-width" src="img/300x300.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <div class="col-md-2">
                            <img class="full-width" src="img/300x300.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                        <div class="col-md-2">
                            <img class="full-width" src="img/300x300.png" alt="Image Alternative text" title="Image Title" />
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <h3 class="widget-title">Behind The Scenes</h3>
                    <p>Mi suspendisse sodales condimentum cum maecenas conubia massa morbi tristique ante iaculis sociosqu fusce lobortis phasellus nisi massa praesent torquent</p>
                    <p>Ultricies nullam ornare vitae justo ipsum nisi inceptos cursus blandit</p>
                    <p>Ipsum convallis quisque iaculis lectus orci facilisis maecenas mauris tristique</p>
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
