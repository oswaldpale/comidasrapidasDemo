/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.entidades;

import Conections.Conection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author strongher
 */
public class detalle_comida_factura {
    
    private String iddetalle;
    private String comidas_idcomidas;
    private String nombreComida;
    private String factura_id;
    private int cantidad;
    private int precio;
    private int preciounitario;
    
    public Conection _conexion = new Conection();

    public List<detalle_comida_factura> Consultar(int idfactura)  {
        
        String sql ="";
        ArrayList dt = _conexion.GetData(sql);
        List<detalle_comida_factura> _detalle = new ArrayList<>();
        
        for (Object object : dt) {
             detalle_comida_factura registro = new detalle_comida_factura();
             HashMap item =(HashMap) object;
             registro.setIddetalle(item.get("idproducto").toString());
             registro.setCantidad(Integer.parseInt(item.get("cantidad").toString()));
             _detalle.add(registro);
        }
        return _detalle;

    }
    
    
       // <editor-fold defaultstate="collapsed" desc="Encapsulamiento get set"> 
    /**
     * @return the iddetalle
     */
    public String getIddetalle() {
        return iddetalle;
    }

    /**
     * @param iddetalle the iddetalle to set
     */
    public void setIddetalle(String iddetalle) {
        this.iddetalle = iddetalle;
    }

    /**
     * @return the comidas_idcomidas
     */
    public String getComidas_idcomidas() {
        return comidas_idcomidas;
    }

    /**
     * @param comidas_idcomidas the comidas_idcomidas to set
     */
    public void setComidas_idcomidas(String comidas_idcomidas) {
        this.comidas_idcomidas = comidas_idcomidas;
    }

    /**
     * @return the factura_id
     */
    public String getFactura_id() {
        return factura_id;
    }

    /**
     * @param factura_id the factura_id to set
     */
    public void setFactura_id(String factura_id) {
        this.factura_id = factura_id;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the preciounitario
     */
    public int getPreciounitario() {
        return preciounitario;
    }

    /**
     * @param preciounitario the preciounitario to set
     */
    public void setPreciounitario(int preciounitario) {
        this.preciounitario = preciounitario;
    }
       // </editor-fold>

    /**
     * @return the nombreComida
     */
    public String getNombreComida() {
        return nombreComida;
    }

    /**
     * @param nombreComida the nombreComida to set
     */
    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }
}
