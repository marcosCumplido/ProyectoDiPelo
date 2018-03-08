/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ManejadorBd;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Maria Jose
 */
@Named(value = "usuarios")
@RequestScoped
public class Usuarios implements Serializable{

   private String usuario;
   private String paswword;
   private String estado = "a";
 
   
   
   public Usuarios() {
    }

    public Usuarios(String usuario, String paswword) {
        this.usuario = usuario;
        this.paswword = paswword;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPaswword() {
        return paswword;
    }

    public void setPaswword(String paswword) {
        this.paswword = paswword;
    }
   

   public String login(){
        ManejadorBd mn= new ManejadorBd();
        boolean validado= false;
       try {
           validado=mn.validar(usuario, paswword);
          
           if (validado){
               return "success";
           }else{
               return "fail";
           }
//        if(usuario.equals("admin") && password.equals("admin")){
//	
//			return "success";
//		}
//		else{
//			return "fail";
//		}
//	}
       } catch (SQLException ex) {
           Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
       }
       return "fail";
    }
}