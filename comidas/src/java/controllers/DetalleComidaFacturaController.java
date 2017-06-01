/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.entidades.detalle_comida_factura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author strongher
 */
public class DetalleComidaFacturaController {
    
       public detalle_comida_factura _detalle = new detalle_comida_factura();
       
       public String consultarComidas() {
        
        
       List<detalle_comida_factura> dt = _detalle.Consultar(0);

        String html = "  <div class=\"col-xs-8\">\n"
                      + "  <select class=\"form-control\" id=\"cliente\" name=\"ncliente\">";
        html = html + "<option value='" + 0 + "'>" + "  " + "</option>";
        for (detalle_comida_factura detalle : dt) {
            
            html = html + "<option value='" + detalle.getIddetalle()+ "'>" + detalle.getCantidad()+ "</option>";

        }
        html = html + " </select>  \n"
                    + "</div> ";
        return html;
    }
}
