<%-- 
    Document   : carrito
    Created on : 23/04/2017, 10:07:01 AM
    Author     : sergio
--%>

<%@page import="java.util.List"%>
<%@page import="Models.entidades.detalle_comida_factura"%>
<%@page import="controllers.facturaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/stylecarrito.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Flat Cart Widget Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--google fonts-->
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<script src="js/jquery.min.js"></script>

<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.cake-top').fadeOut('slow', function(c){
	  		$('.cake-top').remove();
		});
	});	  
});
</script>

<script>$(document).ready(function(c) {
	$('.close-btm').on('click', function(c){
		$('.cake-bottom').fadeOut('slow', function(c){
	  		$('.cake-bottom').remove();
		});
	});	  
});
</script>
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String html =
                  "   	 		<div id=\"NOTIFICACION\">\n"
                + "                 \n"
                + "            </div>\n"
                + "   	 	</div>"
                + "                    <div class=\"dis-total\">\n"
                + "                        <h1>Total $</h1>\n"
                + "                        <center>\n"
                + "                            <div class=\"tot-btn\">\n"
                + "                                <a class=\"shop\" href=\"products.jsp\">Back to Shop</a>\n"
                + "                                <a id=\"BGUARDAR\"  class=\"check\"  >Continue to Checkout</a>\n"
                + "                            </div>\n"
                + "                        </center>\n"
                + "                        \n"
                + "                    </div>\n"
                + "                    <div class=\"clear\"> </div>\n"
                + "                </div>\n"
                + "            </div>";
            List<detalle_comida_factura> _carrito = null;
            if(session.getAttribute("_carrito")!= null){
                _carrito = (List<detalle_comida_factura>) session.getAttribute("_carrito");
            }
            
            facturaController cart =new facturaController();
        %>
        <script type="text/javascript" >
            $(document).ready(function () {
              
                $('#BGUARDAR').click(function (evt) {
                    $.post('CartServlet', {
                      action: 'RegistrarFactura'
                    }, function (responseText) {
                        if(responseText.trim() =='si'){
                           $('#NOTIFICACION').html("<label class='mensaje'>COMPRA REALIAZADA EXITOSAMENTE.REGRESE AL MENU</label>");
                        }
                        if(responseText.trim()=='nologeo'){
                            $('#NOTIFICACION').html("<label class='mensaje'>Por Favor inicie sesión</label>");
                        }if(responseText.trim() =='no'){                            
                           $('#NOTIFICACION').html("<label class='mensaje'>Error en la BD</label>");
                        }
                        
                    });
                });
               
           });
           
        </script>
        <div class="cart">
            <div class="cart-top">
                <div class="cart-experience">
                    <h4>Shopping Cart Experience</h4>
                </div>
                <div class="cart-login">
                    <div class="cart-login-img">
                        <img src="images/loggin_man.png">
                    </div> 
                    <div class="clear"> </div>
                </div>
                <div class="clear"> </div>
            </div>
            <div class="cart-bottom">
                 <%=_carrito!=null?cart.MostrarCarrito(_carrito):html %>               
            </div>             
            </div>
        </div>
    </body>
</html>
