<!DOCTYPE HTML>
<html>

<head>
    <title>Boutique Cellars.com</title>
    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <meta content="utf-8" http-equiv="encoding" >
    <meta name="keywords" content="Template, html, premium, themeforest" />
    <meta name="description" content="TheBox - premium e-commerce template">
    <meta name="author" content="Tsoy">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href='http://fonts.googleapis.com/css?family=Roboto:500,300,700,400italic,400' rel='stylesheet' type='text/css'>
    <!-- <link href='https://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'> -->
    <!-- <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'> -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/mystyles.css">
    <link rel="stylesheet" href="css/itfoxIndex.css">
    <style>
    
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

        <!-- include Header Carousel -->
        <jsp:include page="incHeaderCarousel.jsp">
            <jsp:param name="page" value="index" />
        </jsp:include>
        <!-- // include Header Carousel -->
        
        <div class="gap"></div>
        <div class="container">
            
            <!-- include wineries -->
            <jsp:include page="incHeaderWineries.jsp">
                <jsp:param name="page" value="index" />
            </jsp:include>
            <!-- // include wineries -->
            <div class="gap"></div>
            
           <!-- include Weekly Featured -->
            <jsp:include page="incWeeklyFeatured.jsp">
                <jsp:param name="page" value="index" />
            </jsp:include>
            <!-- // include Weekly Featured  -->
            <!-- include Weekly Featured - Promotion 4 -->
            <jsp:include page="incWeeklyFeaturedPromotion4.jsp">
                <jsp:param name="page" value="index" />
            </jsp:include>
            <!-- // include Weekly Featured - Promotion 4 -->
            <!-- include Weekly Featured - Promotion 8 
            <jsp:include page="incWeeklyFeaturedPromotion8.jsp">
                <jsp:param name="page" value="index" />
            </jsp:include>
            -->
            <!-- // include Weekly Featured - Promotion 8 -->
            <div class="gap"></div>
            <h3 class="widget-title-lg">&nbsp;</h3>
        </div>
        <div class="gap" ></div>
        <!-- include Slider -->
            <jsp:include page="incSlider.jsp">
                <jsp:param name="page" value="index" />
            </jsp:include>
        <!-- // include Slider -->   
        <!-- include Shop By Category -->
        <%--<jsp:include page="incShopByCategory.jsp">
                <jsp:param name="page" value="index" />
            </jsp:include> --%>
         <!-- //include Shop By Category -->  
 
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
<%--
<script>
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: -34.397, lng: 150.644},
          zoom: 8
        });
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDaoGWM7-5GpC7qEP2CwdkqIhu-WEKSCyI&callback=initMap" async defer></script>
--%>



</body>

</html>
 