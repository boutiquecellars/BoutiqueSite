<%@page import="br.com.itfox.beans.Category"%>
<%@page import="br.com.itfox.security.Security"%>
<%@page import="java.util.List"%>
<%@page import="br.com.itfox.beans.Product"%>
<%@page import="br.com.itfox.business.BusinessDelegate"%>
<%

%>
<!DOCTYPE HTML>
<html>

<head>
    <title>Boutique Cellars</title>
    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <meta content="utf-8" http-equiv="encoding">
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

</head>

<body>
    <%
    String categoryTag = "";
    categoryTag = Security.getParameter(request.getParameter("category"));
    
    BusinessDelegate bd = new BusinessDelegate();
    Category c = bd.selectCategory(categoryTag);
    int categoryId = c.getCategoryId();
    %>
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
        
        
        

        <header class="page-header page-header-banner" style="background-image:url(<% if(c!=null){out.print(c.getImage1());}%>);">
            <div class="container">
                <div class="page-header-banner-inner">
                    <h1 class="page-title"><%=c.getCategory() %></h1>
                    <ol class="breadcrumb page-breadcrumb">
                        <li><a href="/index.jsp">Home</a>
                        </li>
                       <!-- <li><a href="#">Clothes &amp; Shoes</a>
                        </li>
                        <li><a href="#">Woman</a>
                        </li>-->
                        <li class="active"><%=c.getCategory() %></li>
                    </ol>
                    <ul class="category-selections clearfix">
                        <!--
                        <li>
                            <a class="fa fa-th-large category-selections-icon active" href="#"></a>
                        </li>
                        <li>
                            <a class="fa fa-th-list category-selections-icon" href="#"></a>
                        </li>
                        
                        <li><span class="category-selections-sign">Sort by :</span>
                            <select class="category-selections-select">
                                <option selected>Newest First</option>
                                <option>Best Sellers</option>
                                <option>Trending Now</option>
                                <option>Best Raited</option>
                                <option>Price : Lowest First</option>
                                <option>Price : Highest First</option>
                                <option>Title : A - Z</option>
                                <option>Title : Z - A</option>
                            </select>
                        </li>
                        -->
                        <!--
                        <li><span class="category-selections-sign">Items :</span>
                            <select class="category-selections-select">
                                <option>9 / page</option>
                                <option selected>12 / page</option>
                                <option>18 / page</option>
                                <option>All</option>
                            </select>
                        </li>-->
                    </ul>
                </div>
            </div>
        </header>
        <div class="container">
            <div class="row">
                <!-- Inc Aside Category -->
                <jsp:include page="incAsideCategory.jsp">
                    <jsp:param name="page" value="index" />
                </jsp:include>
                <!--// Inc Aide Category -->
                <!-- Inc Products -->
                <jsp:include page="incProducts.jsp">
                    <jsp:param name="page" value="index" />
                    <jsp:param name="categoryId" value="<%=categoryId%>" />
                    <jsp:param name="limit" value="50" />
                </jsp:include>
                <!--// Inc Products -->
            </div>
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
