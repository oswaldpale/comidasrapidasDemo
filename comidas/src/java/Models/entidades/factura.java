/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.entidades;

import Conections.Conection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author strongher
 */
public class factura {
   private String idfactura;
   private int subtotal;
   private int total;
   private String usuarios_idUsuarios;
   private String fecha_pedido;
   private String transporte;
   private int valor_transporte;
   private String direccion;
   private List<detalle_comida_factura> detalle;
   
    public Conection _conexion = new Conection();

    public String ConsultarCodigoFactura(){
          String sql="SELECT CONCAT(Prefijo,acumulador) AS codigo FROM acumulador";
           ArrayList dt =  _conexion.GetData(sql);
         for (Object object : dt) {
            HashMap item = (HashMap) object;
            return item.get("codigo").toString();
         }
         return "";
      }
   public boolean registrarFactura(factura fact){
       
      
       
       List<String> sentencias = new ArrayList<String>();
       
       String sql = "INSERT "
                        + "INTO "
                        + "    factura "
                        + "    ( "
                        + "        idfactura, "
                        + "        subtotal, "
                        + "        total, "
                        + "        usuarios_idUsuarios, "
                        + "        fecha_pedido, "
                        + "        transporte, "
                        + "        valor_transporte, "
                        + "        direccion "
                        + "    ) "
                        + "    VALUES "
                        + "    ( "
                        + "       '" + fact.getIdfactura() + "'  , "
                        + "       " + fact.getSubtotal() + "  , "
                        + "       " + fact.getTotal() + ", "
                        + "       " + fact.getUsuarios_idUsuarios() +", "
                        + "        '" + fact.getFecha_pedido() +"', "
                        + "        '" + fact.getTransporte() + "', "
                        + "        " + fact.getValor_transporte() + ", "
                        + "        '" + fact.getDireccion() + "' "
                        + "    )";
       sentencias.add(sql);
       
       for (detalle_comida_factura comida : fact.getDetalle()) {
           
          sql = "INSERT "
                    + "INTO "
                    + "    detalle_comida_factura "
                    + "    ( "
                    + "        comidas_idcomidas, "
                    + "        factura_id, "
                    + "        cantidad, "
                    + "        precio, "
                    + "        preciounitario "
                    + "    ) "
                    + "    VALUES "
                    + "    ( "
                    + "        " + comida.getComidas_idcomidas() + ", "
                    + "        '" + fact.getIdfactura() + "', "
                    + "        " + comida.getCantidad() + ", "
                    + "        "+ comida.getPrecio() + ", "
                    + "        " + comida.getPreciounitario() + " "
                    + "    )";    
          
          sentencias.add(sql);
       }
       String acumulador ="UPDATE acumulador SET acumulador = acumulador+1 WHERE id =1";
       sentencias.add(acumulador);
       return _conexion.Transaction(sentencias);
             
   }
   
     
   // <editor-fold defaultstate="collapsed" desc="Encapsulamiento get set"> 
    /**
     * @return the idfactura
     */
    public String getIdfactura() {
        return idfactura;
    }

    /**
     * @param idfactura the idfactura to set
     */
    public void setIdfactura(String idfactura) {
        this.idfactura = idfactura;
    }

    /**
     * @return the subtotal
     */
    public int getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the usuarios_idUsuarios
     */
    public String getUsuarios_idUsuarios() {
        return usuarios_idUsuarios;
    }

    /**
     * @param usuarios_idUsuarios the usuarios_idUsuarios to set
     */
    public void setUsuarios_idUsuarios(String usuarios_idUsuarios) {
        this.usuarios_idUsuarios = usuarios_idUsuarios;
    }

    /**
     * @return the fecha_pedido
     */
    public String getFecha_pedido() {
        return fecha_pedido;
    }

    /**
     * @param fecha_pedido the fecha_pedido to set
     */
    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    /**
     * @return the transporte
     */
    public String getTransporte() {
        return transporte;
    }

    /**
     * @param transporte the transporte to set
     */
    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    /**
     * @return the valor_transporte
     */
    public int getValor_transporte() {
        return valor_transporte;
    }

    /**
     * @param valor_transporte the valor_transporte to set
     */
    public void setValor_transporte(int valor_transporte) {
        this.valor_transporte = valor_transporte;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
           // </editor-fold>   

    /**
     * @return the detalle
     */
    public List<detalle_comida_factura> getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(List<detalle_comida_factura> detalle) {
        this.detalle = detalle;
    }
}
