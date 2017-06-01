/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.entidades;

import Conections.Conection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author strongher
 */
public class usuarios {
    private String usuario;
    private String contrasena;
    private String idUsuarios;
    public Conection _conexion = new Conection();
    
    public String login(usuarios usu){
        String sql ="SELECT idUsuarios FROM usuarios WHERE nombre ='" + usu.usuario + "' AND contrasena = '" + usu.contrasena + "'";
        ArrayList dt = _conexion.GetData(sql);
         for (Object object : dt) {
             HashMap item =(HashMap) object;
             String idusuario = item.get("idUsuarios").toString();
             return idusuario;
        }
        return null;
    }
    
   // <editor-fold defaultstate="collapsed" desc="Encapsulamiento get set"> 
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the idUsuarios
     */
    public String getIdUsuarios() {
        return idUsuarios;
    }

    /**
     * @param idUsuarios the idUsuarios to set
     */
    public void setIdUsuarios(String idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
       // </editor-fold>
}
