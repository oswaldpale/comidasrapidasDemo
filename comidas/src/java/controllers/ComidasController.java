/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.entidades.comidas;
import Models.entidades.detalle_comida_factura;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author strongher
 */
public class ComidasController {

    comidas _comidas = new comidas();

    public String MostrarComidas() {
        
        String html = "";
        ArrayList dt = _comidas.MostrarComidas();
        int cont = 0;
      
        for (Object object : dt) {
            HashMap item = (HashMap) object;
            if (cont!=2) {
                html = html +  "<div class=\"product-grid fade\" onclick=\"location.href='details.jsp?codigo=" + item.get("idcomidas") + "';\">\n"
                    + "							\n"
                    + "							<div class=\"product-pic\">\n"
                    + "								<a href=\"#\"><img src=\"images/platos/" + item.get("urlimagen").toString() + "\" height=\"200px\" title=\"product-name\" /></a>\n"
                    + "								<p>\n"
                    + "								<a href=\"#\">" + item.get("plato").toString() + "</a>\n"
                    + "								</p>\n"
                    + "							</div>\n"
                    + "							<div class=\"product-info\">\n"
                    + "								<div class=\"product-info-cust\">\n"
                    + "									<a href=\"details.jsp?codigo=" + item.get("idcomidas") + "\">detalles</a>\n"
                    + "								</div>\n"
                    + "								<div class=\"product-info-price\">\n"
                    + "									<a href=\"details.jsp?codigo=" + item.get("idcomidas") + "\">" + item.get("precio").toString() + "</a>\n"
                    + "								</div>\n"
                    + "								<div class=\"clear\"> </div>\n"
                    + "							</div>\n"
                    + "							<div class=\"more-product-info\">\n"
                    + "								<span> </span>\n"
                    + "							</div>\n"
                    + "</div>";
            }
            
            if (cont==2) {
                html = html + "<div class=\"product-grid fade last-grid\" onclick=\"location.href='details.jsp?codigo=" + item.get("idcomidas") + "';\">\n"
                        + "							\n"
                        + "							<div class=\"product-pic\">\n"
                        + "								<a href=\"#\"><img src=\"images/platos/" + item.get("urlimagen").toString() + "\" height=\"200px\" title=\"product-name\" /></a>\n"
                        + "								<p>\n"
                        + "								<a href=\"#\">" + item.get("plato").toString() + "</a>\n"
                        + "								</p>\n"
                        + "							</div>\n"
                        + "							<div class=\"product-info\">\n"
                        + "								<div class=\"product-info-cust\">\n"
                        + "									<a href=\"details.jsp?codigo="+  item.get("idcomidas") +"\">detalles</a>\n"
                        + "								</div>\n"
                        + "								<div class=\"product-info-price\">\n"
                        + "									<a href=\"details.jsp?codigo=" +  item.get("idcomidas") + "\">" + item.get("precio").toString() + "</a>\n"
                        + "								</div>\n"
                        + "								<div class=\"clear\"> </div>\n"
                        + "							</div>\n"
                        + "							<div class=\"more-product-info\">\n"
                        + "								<span> </span>\n"
                        + "							</div>\n"
                        + "						</div>\n"
                        + "						";
                cont = 0;
            }
            cont++;
        }
        html += "<div class=\"clear\"> </div>";
        return html;
    }
    
    public ArrayList ListarPlatos(){
       return _comidas.MostrarComidas();
    }
      public int CantidadPlatos(){
       return _comidas.MostrarComidas().size();
    }
}
