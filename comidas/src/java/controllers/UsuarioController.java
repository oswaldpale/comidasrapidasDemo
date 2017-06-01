/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Models.entidades.usuarios;

/**
 *
 * @author strongher
 */
public class UsuarioController {
      private usuarios _usu = new usuarios();
      
      public String login(usuarios us){
          return _usu.login(us);
          
      }
}
