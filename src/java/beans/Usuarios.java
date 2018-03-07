/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Alumno
 */
@Named(value = "usuarios")
@RequestScoped
public class Usuarios implements Serializable{

    private String usuario;
    private String password;
    private boolean logeado=false;
            
    
   
    public boolean estaLogeado() {
    return logeado;
    } 
    public String getUsuario() {
    return usuario;
    }
    public void setUsuario(String usuario) {
    this.usuario = usuario;
    } 
    public String getPassword() {
    return password;
    }
    public void setPassword(String password) {
    this.password = password;
    }
//    public void login(ActionEvent actionEvent) {
//        RequestContext context = RequestContext.getCurrentInstance();
//        FacesMessage msg = null;
//        if (usuario != null && usuario.equals("admin") && password != null
//        && password.equals("admin")) {
//        logeado = true;
//        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuario);
//        } else {
//        logeado = false;
//        msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
//        "Credenciales no válidas");
//        }
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//        context.addCallbackParam("estaLogeado", logeado);
//        if (logeado){
//        context.addCallbackParam("view", "index.xhtml");
//        } 
//    }
//    public void logout() {
//    HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
//    .getExternalContext().getSession(false);
//    session.invalidate();
//    logeado = false;
//    } 

//    public String existeUsuario(){
//        ManejadorBd mn= new ManejadorBd();
//        int resultado= mn.guardar(Cliente.class, this);//hacemos un guardar generico
//        return""; //asi se llama a si mismo
//    }    
    
}
