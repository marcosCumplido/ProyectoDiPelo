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
@Named(value = "conceptos")
@RequestScoped
public class Conceptos {

    private int codConcepto;
    private String descripcion;
    private Double importe;
    private int descuento;
    private int codIva;
    private String estado;
    
    public Conceptos() {
    }

    public Conceptos(int codConcepto, String descripcion, Double importe, int descuento, int codIva, String estado) {
        this.codConcepto = codConcepto;
        this.descripcion = descripcion;
        this.importe = importe;
        this.descuento = descuento;
        this.codIva = codIva;
        this.estado = estado;
    }

    public int getCodConcepto() {
        return codConcepto;
    }

    public void setCodConcepto(int codConcepto) {
        this.codConcepto = codConcepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getCodIva() {
        return codIva;
    }

    public void setCodIva(int codIva) {
        this.codIva = codIva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
