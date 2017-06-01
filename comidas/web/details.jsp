<%@page import="controllers.ComidasController"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
    <head>
        <title>Restaurante Online Andrea</title>
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <meta   name="viewport" content="width=device-width, initial-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    </script>
    <!----webfonts---->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <!----//webfonts---->
    <script src="js/jquery.min.js"></script>
    <!----start-alert-scroller---->
    <script type="text/javascript" src="js/jquery.easy-ticker.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#demo').hide();
            $('.vticker').easyTicker();
        });
    </script>	
    <!----start-alert-scroller---->
    <!-- start menu -->
    <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/megamenu.js"></script>
    <script>$(document).ready(function () {
            $(".megamenu").megamenu();
        });</script>
    <script src="js/menu_jquery.js"></script>
    <!-- //End menu -->
    <!---move-top-top---->
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);
            });
            $("#salir").click(function (event) {
                console.log('salir');
            });

        });
    </script>
    <!---//move-top-top---->
    <!-- Owl Carousel Assets -->
    <link href="css/owl.carousel.css" rel="stylesheet">
    <script src="js/jquery-1.9.1.min.js"></script> 
    <!-- Owl Carousel Assets -->
    <!-- Prettify -->
    <script src="js/owl.carousel.js"></script>
    <script>
        $(document).ready(function () {

            $("#owl-demo").owlCarousel({
                items: 3,
                lazyLoad: true,
                autoPlay: true,
                navigation: true,
                navigationText: ["", ""],
                rewindNav: false,
                scrollPerPage: false,
                pagination: false,
                paginationNumbers: false,
            });

        });
    </script>
    <!-- //Owl Carousel Assets -->
</head>
<body>


    <%
        String _usuario = "antes de Ordenar tu comida registrate.";
        String _titulo = "PRODUCT NAME GOES HERE";
        String _detalle = "Lorem ipsum dolor sit amet,tempor incididunt ut labore et dolore magna aliqua.";
        String _disp = "LUNES";
        String _tipo = "CENA";

        int _precio = 14000;
        String _imagenURL = "sport.png";
        ComidasController con = new ComidasController();
        _usuario = (session.getAttribute("_usuario") != null) ? session.getAttribute("_usuario").toString().toUpperCase() : _usuario;

        String codcomida = (request.getParameter("codigo") != null) ? request.getParameter("codigo").toString() : "1";
        ArrayList _listaComidas = con.ListarPlatos();

        if (_listaComidas != null) {
            for (Object object : _listaComidas) {
                HashMap item = (HashMap) object;
                if (item.get("idcomidas").toString().equals(codcomida)) {
                    _titulo = item.get("plato").toString();
                    _detalle = item.get("ingredientes").toString();
                    _precio = Integer.parseInt(item.get("precio").toString());
                    _imagenURL = item.get("urlimagen").toString();
                    _tipo = item.get("nombre").toString();
                    _disp = item.get("dia").toString();

                }
            }
        }
    %>
    <!---start-wrap---->
    <!---start-header---->
    <div class="header">
        <div class="top-header">
            <div class="wrap">
                <div class="top-header-left">
                    <ul>
                        <!---cart-tonggle-script---->
                        <script type="text/javascript">
                            $(function () {
                                var $cart = $('#cart');
                                $('#clickme').click(function (e) {
                                    e.stopPropagation();
                                    if ($cart.is(":hidden")) {
                                        $cart.slideDown("slow");
                                    } else {
                                        $cart.slideUp("slow");
                                    }
                                });
                                $(document.body).click(function () {
                                    if ($cart.not(":hidden")) {
                                        $cart.slideUp("slow");
                                    }
                                });
                            });
                        </script>
                        <!---//cart-tonggle-script---->
                        <li><a class="cart" href="#"><span id="clickme"> </span></a></li>
                        <!---start-cart-bag---->
                        <div id="cart">Carrito <span><a href="carrito.jsp">Ir</a></span>

                        </div>

                        <!---start-cart-bag---->
                        <li><a class="info" href="#"><span> </span></a></li>
                    </ul>
                </div>
                <div class="top-header-center">
                    <div class="top-header-center-alert-left">
                        <h3>USUARIO</h3>
                    </div>
                    <div class="top-header-center-alert-right">
                        <div class="vticker">
                            <ul>
                                <li><label><%=_usuario%></label></li>
                            </ul>
                        </div>
                    </div>
                    <div class="clear"> </div>
                </div>
                <div class="top-header-right">
                    <ul>
                        <li><a href="login.jsp">Login</a><span> </span></li>
                        <li><a href="register.jsp">Join</a></li>
                    </ul>
                </div>
                <div class="clear"> </div>
            </div>
        </div>

    </div>
    <!----//End-bottom-header---->
    <!---//End-header---->
    <!--- start-content---->
    <div class="content details-page">
        <!---start-product-details--->
        <div class="product-details">
            <div class="wrap">
                <ul class="product-head">
                    <li><a href="products.jsp">Comidas</a> <span>::</span></li>
                    <li class="active-page"><a href="#">Product Page</a></li>
                    <div class="clear"> </div>
                </ul>
                <!----details-product-slider--->
                <!-- Include the Etalage files -->
                <link rel="stylesheet" href="css/etalage.css">
                <script src="js/jquery.etalage.min.js"></script>
                <!-- Include the Etalage files -->
                <script>
                            jQuery(document).ready(function ($) {

                                $('#etalage').etalage({
                                    thumb_image_width: 300,
                                    thumb_image_height: 400,
                                    source_image_width: 900,
                                    source_image_height: 1000,
                                    show_hint: true,
                                    click_callback: function (image_anchor, instance_id) {
                                        alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                                    }
                                });
                                // This is for the dropdown list example:
                                $('.dropdownlist').change(function () {
                                    etalage_show($(this).find('option:selected').attr('class'));
                                });

                            });
                </script>
                <!----//details-product-slider--->
                <div class="details-left">
                    <div class="details-left-slider">
                        <ul id="etalage">
                            <li>
                                <a href="#">
                                    <img class="etalage_thumb_image" src="images/platos/<%=_imagenURL%>" />
                                    <img class="etalage_source_image" src="images/platos/<%=_imagenURL%>"/>
                                </a>
                            </li>


                        </ul>
                    </div>
                    <div class="details-left-info">
                        <div class="details-right-head">
                            <h1><%= _titulo%></h1>
                            <p class="product-detail-info"><%=_detalle%></p>
                            <form method="POST" action="CartServlet">     

                                <div class="product-more-details">
                                    <ul class="price-avl">
                                        <li class="price"><label>$<%= _precio%></label></li>
                                        <li class="stock"><i>In stock</i></li>
                                        <div class="clear"> </div>
                                    </ul>
                                    <ul class="product-colors">
                                        <h3>DISP :
                                            <span><%= _disp%></span>
                                        </h3>
                                        <div class="clear"> </div>
                                        <h3>TIPO    :
                                            <span><%= _tipo%></span>
                                        </h3>
                                        <div class="clear"> </div>
                                    </ul>
                                    <ul class="prosuct-qty">
                                        <span >Cantidad</span>
                                        <select id="cantidad" name="cantidad">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                            <option>6</option>
                                        </select>
                                        <input id="action" name="action" type="hidden" value="AddCarrito" />
                                        <input id ="codcomida" name="codcomida" type="hidden" value="<%=codcomida%>"/>
                                        <input id ="precio" name="precio" type="hidden" value="<%=_precio%>"/>   
                                        <input id ="nombrecomida" name="nombrecomida" type="hidden" value="<%=_titulo%>"/>   
                                        <input id ="nombreusuario" name="nombreusuario" type="hidden" value="<%=_usuario%>"/>
                                    </ul>
                                    <input id="addcart" name="addcart" type="submit" value="agregar al carro" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
            <!----product-rewies---->
            <div class="product-reviwes">
                <div class="wrap">
                    <!--vertical Tabs-script-->
                    <!---responsive-tabs---->
                    <script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
                    <script type="text/javascript">
                            $(document).ready(function () {
                                $('#horizontalTab').easyResponsiveTabs({
                                    type: 'default', //Types: default, vertical, accordion           
                                    width: 'auto', //auto or any width like 600px
                                    fit: true, // 100% fit in a container
                                    closed: 'accordion', // Start closed if in accordion view
                                    activate: function (event) { // Callback function if tab is switched
                                        var $tab = $(this);
                                        var $info = $('#tabInfo');
                                        var $name = $('span', $info);
                                        $name.text($tab.text());
                                        $info.show();
                                    }
                                });

                                $('#verticalTab').easyResponsiveTabs({
                                    type: 'vertical',
                                    width: 'auto',
                                    fit: true
                                });
                            });
                    </script>




                </div>
            </div>
            <div class="clear"> </div>
            <!--//vertical Tabs-->
            <!----//product-rewies---->
            <!---//End-product-details--->
        </div>
    </div>

</body>
</html>

