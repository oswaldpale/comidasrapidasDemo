/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.entidades;

import Conections.Conection;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import javax.json.Json;

/**
 *
 * @author strongher
 */
public class comidas {
    private String idcomidas;
    private String plato;
    private String urlimagen;
    private String ingredientes;
    private String jornada_idjornada;
    private String semana_idsemana;
    private String precio;
    public Conection _conexion = new Conection();
     
    public ArrayList MostrarComidas(){
        Json platos;
         String sql ="SELECT c.idcomidas,c.plato,c.urlimagen,c.ingredientes,c.jornada_idjornada,j.nombre,c.semana_idsemana,s.dia,c.precio FROM comidas c\n" +
                         "INNER JOIN jornada j ON c.jornada_idjornada= j.idjornada INNER JOIN semana s ON c.semana_idsemana = s.idsemana";
        ArrayList dt = _conexion.GetData(sql);
    
        return dt;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Encapsulamiento get set"> 
    /**
     * @return the idcomidas
     */
    public String getIdcomidas() {
        return idcomidas;
    }

    /**
     * @param idcomidas the idcomidas to set
     */
    public void setIdcomidas(String idcomidas) {
        this.idcomidas = idcomidas;
    }

    /**
     * @return the plato
     */
    public String getPlato() {
        return plato;
    }

    /**
     * @param plato the plato to set
     */
    public void setPlato(String plato) {
        this.plato = plato;
    }

    /**
     * @return the urlimagen
     */
    public String getUrlimagen() {
        return urlimagen;
    }

    /**
     * @param urlimagen the urlimagen to set
     */
    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    /**
     * @return the ingredientes
     */
    public String getIngredientes() {
        return ingredientes;
    }

    /**
     * @param ingredientes the ingredientes to set
     */
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * @return the jornada_idjornada
     */
    public String getJornada_idjornada() {
        return jornada_idjornada;
    }

    /**
     * @param jornada_idjornada the jornada_idjornada to set
     */
    public void setJornada_idjornada(String jornada_idjornada) {
        this.jornada_idjornada = jornada_idjornada;
    }

    /**
     * @return the semana_idsemana
     */
    public String getSemana_idsemana() {
        return semana_idsemana;
    }

    /**
     * @param semana_idsemana the semana_idsemana to set
     */
    public void setSemana_idsemana(String semana_idsemana) {
        this.semana_idsemana = semana_idsemana;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }
       // </editor-fold>
    
}
