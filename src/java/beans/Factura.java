/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Alumno
 */
@Named(value = "factura")
@RequestScoped
public class Factura {

    private int codCliente;
    private Date fecha;
    private String observaciones;
    private String estado;
    private String codFactura;
    
    List <Detalle> detalleFactura; //hacer grabar detalle /borrar detalle
    
    public Factura() {
    }

    public Factura(int codCliente, Date fecha, String observaciones, String estado, String codFactura, List<Detalle> detalleFactura) {
        this.codCliente = codCliente;
        this.fecha = fecha;
        this.observaciones = observaciones;
        this.estado = estado;
        this.codFactura = codFactura;
        this.detalleFactura = detalleFactura;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(String codFactura) {
        this.codFactura = codFactura;
    }

    public List<Detalle> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(List<Detalle> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }
    
}
