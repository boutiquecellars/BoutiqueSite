<%@page import="br.com.itfox.beans.Product"%>
<%@page import="br.com.itfox.utils.Utils"%>
<%@page import="br.com.itfox.business.BusinessDelegate"%>
<%@page import="br.com.itfox.security.Security"%>
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

    <link href='https://fonts.googleapis.com/css?family=Roboto:500,300,700,400italic,400' rel='stylesheet' type='text/css'>
    <!-- <link href='https://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'> -->
    <!-- <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'> -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/mystyles.css">
    
    <!-- include Meta Header -->        
    <jsp:include page="incHeaderMeta.jsp" />    
    <!-- // include Meta Header -->
    

</head>

<body>
    <%
    String strProductId = Security.getParameter(request.getParameter("product_id"));
    BusinessDelegate bd = new BusinessDelegate();
    int productId = 0;
    productId = Utils.parseInt(strProductId);
    Product p = bd.selectProduct(productId);
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
        
        
       
        
        <div class="container">
            
            <header class="page-header">
                <ol class="breadcrumb page-breadcrumb">
                    <li><a href="#">Home</a>
                    </li>
                    <!--
                    <li><a href="#">Clothing, Shoes & Accessories</a>
                    </li>
                    <li><a href="#">Women's Handbags & Bags</a>
                    </li>-->
                    <li class="active"><%=p.getName()%></li>
                </ol>
            </header>
            <div class="row">
                <div class="col-md-6">
                    <div class="product-page-product-wrap jqzoom-stage jqzoom-stage-lg">
                        <div class="clearfix">
                            <a href="https://boutiquecellars.com/wine/imgs/boutique_cellars_<%=p.getNameReplaceAll(true)%>" id="jqzoom" data-rel="gal-1">
                                <img src="https://boutiquecellars.com/wine/imgs/boutique_cellars_<%=p.getNameReplaceAll(true)%>" alt="Image Alternative text" title="Image Title" />
                            </a>
                        </div>
                    </div>
                    <!--        
                    <ul class="jqzoom-list">
                        <li>
                            <a class="zoomThumbActive" href="javascript:void(0)" data-rel="{gallery:'gal-1', smallimage: 'img/500x500.png', largeimage: 'img/800x800.png'}">
                                <img src="img/100x100.png" alt="Image Alternative text" title="Image Title" />
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" data-rel="{gallery:'gal-1', smallimage: 'img/500x500.png', largeimage: 'img/800x800.png'}">
                                <img src="img/100x100.png" alt="Image Alternative text" title="Image Title" />
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" data-rel="{gallery:'gal-1', smallimage: 'img/500x500.png', largeimage: 'img/800x800.png'}">
                                <img src="img/100x100.png" alt="Image Alternative text" title="Image Title" />
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" data-rel="{gallery:'gal-1', smallimage: 'img/500x500.png', largeimage: 'img/800x800.png'}">
                                <img src="img/100x100.png" alt="Image Alternative text" title="Image Title" />
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" data-rel="{gallery:'gal-1', smallimage: 'img/500x500.png', largeimage: 'img/800x800.png'}">
                                <img src="img/100x100.png" alt="Image Alternative text" title="Image Title" />
                            </a>
                        </li>
                    </ul>
                    -->
                </div>
                <div class="col-md-6">
                    <div class="_box-highlight">
                        <!--
                        <ul class="product-page-product-rating">
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
                        
                        <p class="product-page-product-rating-sign"><a href="#">238 customer reviews</a>
                        </p>-->
                        <p><%=p.getB().getBrand() %></p>
                        <h1><%=p.getName()%></h1>
                        <!--<p><%=p.getC().getCategory() %></p>-->
                        <p class="product-page-price">AUD$<%=Utils.formatDecimal(p.getPrice())%></p>
                        
                        <p>Year:<%=p.getYear() %></p>
                        <p>Varietal:<%=p.getVarietal() %></p>
                        <p>Region:<%=p.getRegion() %></p>
                        <p>Alcohol:<%=p.getAlcohol() %></p>
                        <p>Type:<%=p.getMevushal() %></p>
                        <!--
                        <p class="product-page-desc-lg"><%=Utils.blobToString(p.getDescription()) %></p>
                        -->
                        <!--
                        <ul class="product-page-option-list">
                            <li class="clearfix">
                                <h5 class="product-page-option-title">Color</h5>
                                <select class="product-page-option-select">
                                    <option selected>Clementine</option>
                                    <option>Fanfare</option>
                                    <option>Flower Shower</option>
                                    <option>Flutterby</option>
                                    <option>Petal Paisley</option>
                                    <option>Ziggy Zinnia</option>
                                </select>
                            </li>
                            <li class="clearfix">
                                <h5 class="product-page-option-title">Size</h5>
                                <select class="product-page-option-select">
                                    <option selected>Normal</option>
                                    <option>Large</option>
                                    <option>Small</option>
                                </select>
                            </li>
                        </ul>-->
                        <ul class="product-page-actions-list">
                            <li class="product-page-qty-item">
                                <button class="product-page-qty product-page-qty-minus">-</button>
                                <input class="product-page-qty product-page-qty-input" type="number" value="1" id="quantity" />
                                <button class="product-page-qty product-page-qty-plus">+</button>
                            </li>
                            <li><a class="btn btn-lg btn-primary" onclick="addCart()" id="add-cart"><i class="fa fa-shopping-cart"></i>Add to Cart</a>
                            </li>
                            <!--
                            <li><a class="btn btn-lg btn-default" href="#"><i class="fa fa-star"></i>Wishlist</a>
                            
                            </li>-->
                        </ul>
                        <div class="gap gap-small"></div>
                    </div>
                </div>
            </div>
            <div class="gap"></div>
            <div class="tabbable product-tabs">
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active"><a href="#tab-1" data-toggle="tab">Description</a>
                    </li>
                    <!--
                    <li><a href="#tab-2" data-toggle="tab">Additional Information</a>
                    </li>
                    <li><a href="#tab-3" data-toggle="tab">Rating and Reviews</a>
                    </li>
                    -->
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade in active" id="tab-1">
                        <%=Utils.blobToString(p.getDescription()) %>
                    </div>
                    <div class="tab-pane fade" id="tab-2">
                        <table class="table">
                            <tbody>
                                <tr>
                                    <td>Weight:</td>
                                    <td>0.3 kg</td>
                                </tr>
                                <tr>
                                    <td>Dimensions:</td>
                                    <td>20 ½" W x 12" H x 10 ¾" D with 9" strap drop and 52" removable, adjustable strap</td>
                                </tr>
                                <tr>
                                    <td>Materials :</td>
                                    <td>100% Cotton</td>
                                </tr>
                                <tr>
                                    <td>Care Tips:</td>
                                    <td>Machine wash cold, gentle cycle, only non-chlorine bleach when needed; line dry</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane fade" id="tab-3">
                        <div class="row">
                            <div class="col-md-8">
                                <article class="product-review">
                                    <div class="product-review-author">
                                        <img class="product-review-author-img" src="img/70x70.png" alt="Image Alternative text" title="Image Title" />
                                    </div>
                                    <div class="product-review-content-full">
                                        <h5 class="product-review-title">Terrific Buy!</h5>
                                        <ul class="product-page-product-rating">
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
                                        <p class="product-review-meta">by Alison Mackenzie on 08/14/2015</p>
                                        <p class="product-review-body">Aliquam nam gravida hendrerit primis class egestas primis porta egestas non eleifend risus turpis commodo nisi felis nullam risus aliquam curae fusce elit est ornare</p>
                                        <p class="text-success"><strong><i class="fa fa-check"></i> I would recommend this to a friend!</strong>
                                        </p>
                                        <ul class="list-inline product-review-actions">
                                            <li><a href="#"><i class="fa fa-flag"></i> Flag this review</a>
                                            </li>
                                            <li><a href="#"><i class="fa fa-comment"></i> Comment review</a>
                                            </li>
                                        </ul>
                                    </div>
                                </article>
                                <article class="product-review">
                                    <div class="product-review-author">
                                        <img class="product-review-author-img" src="img/70x70.png" alt="Image Alternative text" title="Image Title" />
                                    </div>
                                    <div class="product-review-content-full">
                                        <h5 class="product-review-title">Too Big. Unusable.</h5>
                                        <ul class="product-page-product-rating">
                                            <li class="rated"><i class="fa fa-star"></i>
                                            </li>
                                            <li class="rated"><i class="fa fa-star"></i>
                                            </li>
                                            <li><i class="fa fa-star"></i>
                                            </li>
                                            <li><i class="fa fa-star"></i>
                                            </li>
                                            <li><i class="fa fa-star"></i>
                                            </li>
                                        </ul>
                                        <p class="product-review-meta">by Keith Churchill on 08/14/2015</p>
                                        <p class="product-review-body">Lacus molestie aptent elementum nascetur a blandit aenean fusce eleifend hendrerit ac fringilla vehicula eget odio orci hac mauris tincidunt tellus</p>
                                        <p class="text-danger"><strong><i class="fa fa-close"></i> No, I would not recommend this to a friend.</strong>
                                        </p>
                                        <ul class="list-inline product-review-actions">
                                            <li><a href="#"><i class="fa fa-flag"></i> Flag this review</a>
                                            </li>
                                            <li><a href="#"><i class="fa fa-comment"></i> Comment review</a>
                                            </li>
                                        </ul>
                                    </div>
                                </article>
                                <article class="product-review">
                                    <div class="product-review-author">
                                        <img class="product-review-author-img" src="img/70x70.png" alt="Image Alternative text" title="Image Title" />
                                    </div>
                                    <div class="product-review-content-full">
                                        <h5 class="product-review-title">Worth it</h5>
                                        <ul class="product-page-product-rating">
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
                                        <p class="product-review-meta">by Alison Mackenzie on 08/14/2015</p>
                                        <p class="product-review-body">Imperdiet maecenas suspendisse diam lorem nisi quis elit augue mus interdum porttitor ante</p>
                                        <p class="text-success"><strong><i class="fa fa-check"></i> I would recommend this to a friend!</strong>
                                        </p>
                                        <ul class="list-inline product-review-actions">
                                            <li><a href="#"><i class="fa fa-flag"></i> Flag this review</a>
                                            </li>
                                            <li><a href="#"><i class="fa fa-comment"></i> Comment review</a>
                                            </li>
                                        </ul>
                                    </div>
                                </article>
                            </div>
                            <div class="col-md-4">
                                <h3 class="product-tab-rating-title">Overall Customer Rating:</h3>
                                <ul class="product-page-product-rating product-rating-big">
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
                                    <li class="count">4.9</li>
                                </ul><small>238 customer reviews</small>
                                <p><strong>98%</strong> of reviewers would recommend this product</p><a class="btn btn-primary" href="#">Write a Review</a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <p class="category-pagination-sign">238 customer reviews found. Showing 1 - 5</p>
                            </div>
                            <div class="col-md-6">
                                <nav>
                                    <ul class="pagination category-pagination pull-right">
                                        <li class="active"><a href="#">1</a>
                                        </li>
                                        <li><a href="#">2</a>
                                        </li>
                                        <li><a href="#">3</a>
                                        </li>
                                        <li><a href="#">4</a>
                                        </li>
                                        <li><a href="#">5</a>
                                        </li>
                                        <li class="last"><a href="#"><i class="fa fa-long-arrow-right"></i></a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="gap"></div>
            <h3 class="widget-title">You Might Also Like</h3>
           
            <!-- include Related Products -->
            <jsp:include page="incRelatedProducts.jsp">
                <jsp:param name="page" value="index" />
                <jsp:param name="limit" value="16" />
                <jsp:param name="categoryId" value="<%=p.getCategoryId() %>" />
            </jsp:include>
            <!-- // include Related Products -->
            
            
            
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
        function addCart(){
            
            var url="ShoppingCart?product=<%=p.getNameReplaceAll(false)%>&ref=<%=p.getProductId()%>&quantity="+$("#quantity").val();
            window.location.replace(url);
        }
        </script>




</body>

</html>
