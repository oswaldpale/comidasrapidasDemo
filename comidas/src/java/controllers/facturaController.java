/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.entidades.detalle_comida_factura;
import Models.entidades.factura;
import java.util.List;

/**
 *
 * @author strongher
 */
public class facturaController {

    public factura _factura = new factura();
    int AcumTotalFinal = 0;

    public boolean registraFactura(factura fac) {
        return _factura.registrarFactura(fac);

    }

    public String ConsultarCodigoFactura() {
        return _factura.ConsultarCodigoFactura();
    }

    public String MostrarCarrito(List<detalle_comida_factura> _carrito) {
        String htmlencabezado = "<div class=\"table\">\n"
                + "                    <table>\n"
                + "                        <tbody>\n"
                + "                            <tr  class=\"main-heading\">	  	      	\n"
                + "                                <th>Imagen</th>\n"
                + "                                <th class=\"long-txt\">Comidas</th>\n"
                + "                                <th>Cantidad</th>\n"
                + "                                <th>Precio</th>\n"
                + "                                <th>Total</th> 		 			 	\n"
                + "                            </tr>\n"
                + "                            ";
        String htmlbody = "";
        int acum = 1;
        for (detalle_comida_factura item : _carrito) {
            htmlbody += "<tr class=\"cake-top\"><td class=\"cakes\">	 	     	  \n"
                    + "                                    <div class=\"product-img\">\n"
                    + "                                        <img src=\"images/platos/ensaladacesar.jpg\">\n"
                    + "                                    </div>\n"
                    + "                                </td>\n"
                    + "                                <td class=\"cake-text\">\n"
                    + "                                    <div class=\"product-text\">\n"
                    + "                                        <h3>" + item.getNombreComida() + "</h3>\n"
                    + "                                        <p> Codigo Referencia:" + item.getComidas_idcomidas() + "</p>\n"
                    + "                                    </div>\n"
                    + "                                </td>\n"
                    + "                                <td class=\"quantity\"> 	 	     	 \n"
                    + "                                    <div class=\"product-right\">\n"
                    + "                                        <input min=\"1\" type=\"number\" id=\"quantity\" name=\"quantity\" disabled=true value=\"" + item.getCantidad() + "\" class=\"form-control input-small\">				  \n"
                    + "                                    </div>\n"
                    + "                                </td>\n"
                    + "                                <td class=\"price\">\n"
                    + "                                    <h4>$" + item.getPreciounitario() + "</h4>	 	     		\n"
                    + "                                </td>\n"
                    + "                                <td class=\"top-remove\">\n"
                    + "                                    <h4>$" + item.getPrecio() + "</h4>\n"
                    + "                                    <div class=\"close\">\n"
                    + "                                        <h5>Remove</h5>\n"
                    + "                                    </div>\n"
                    + "                                </td></tr> ";
            AcumTotalFinal += item.getPrecio();
            if (acum > 1) {
                htmlbody += "<tr class=\"cake-bottom\"> <td class=\"cakes\">	 	     	  \n"
                        + "                                    <div class=\"product-img\">\n"
                        + "                                        <img src=\"images/platos/ensaladacesar.jpg\">\n"
                        + "                                    </div>\n"
                        + "                                </td>\n"
                        + "                                <td class=\"cake-text\">\n"
                        + "                                    <div class=\"product-text\">\n"
                        + "                                        <h3>" + item.getNombreComida() + "</h3>\n"
                        + "                                        <p>" + item.getComidas_idcomidas() + "</p>\n"
                        + "                                    </div>\n"
                        + "                                </td>\n"
                        + "                                <td class=\"quantity\"> 	 	     	 \n"
                        + "                                    <div class=\"product-right\">\n"
                        + "                                        <input min=\"1\" type=\"number\" id=\"quantity\" name=\"quantity\" disabled=true value=\"" + item.getCantidad() + "\" class=\"form-control input-small\">				  \n"
                        + "                                    </div>\n"
                        + "                                </td>\n"
                        + "                                <td class=\"price\">\n"
                        + "                                    <h4>$" + item.getPreciounitario() + "</h4>	 	     		\n"
                        + "                                </td>\n"
                        + "                                <td class=\"top-remove\">\n"
                        + "                                    <h4>$" + item.getPrecio() + "</h4>\n"
                        + "                                    <div class=\"close\">\n"
                        + "                                        <h5>Remove</h5>\n"
                        + "                                    </div>\n"
                        + "                                </td></tr>";
                AcumTotalFinal += item.getPrecio();
            }
        }
        return htmlencabezado + htmlbody + "                            \n"
                + "                        </tbody>\n"
                + "                    </table>" + "</div>\n"
                + "                <div class=\"vocher\">\n<div class=\"dis-card\">\n"
                + "   	 		<div id=\"NOTIFICACION\">\n"
                + "                 \n"
                + "            </div>\n"
                + "   	 	</div>"
                + "                    <div class=\"dis-total\">\n"
                + "                        <h1>Total $" + AcumTotalFinal + "</h1>\n"
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
    }

}
