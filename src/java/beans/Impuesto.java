/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Alumno
 */
@Named(value = "impuesto")
@RequestScoped
public class Impuesto {

    private int codIva;
    private int valorIva;
    private String descripcion;
   
    public Impuesto() {
    }

    public Impuesto(int codIva, int valorIva, String descripcion) {
        this.codIva = codIva;
        this.valorIva = valorIva;
        this.descripcion = descripcion;
    }

    public int getCodIva() {
        return codIva;
    }

    public void setCodIva(int codIva) {
        this.codIva = codIva;
    }

    public int getValorIva() {
        return valorIva;
    }

    public void setValorIva(int valorIva) {
        this.valorIva = valorIva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
