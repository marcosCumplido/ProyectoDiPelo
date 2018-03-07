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
import javax.inject.Inject;

/**
 *
 * @author Alumno
 */
@Named(value = "albaran")
@RequestScoped
public class Albaran {
    
    private String codAlbaran;
    private int codCliente;
    private Date fecha;
    private String codFactura;
    
    List<Detalle> detalleAlbaran; //hacer grabar detalle /borrar detalle
    
    @Inject
    List<Factura> listadoFacturas; //listado facturas
    
    public Albaran() {
    }

    public Albaran(String codAlbaran, int codCliente, Date fecha, String codFactura, List<Detalle> detalleAlbaran, List<Factura> listadoFacturas) {
        this.codAlbaran = codAlbaran;
        this.codCliente = codCliente;
        this.fecha = fecha;
        this.codFactura = codFactura;
        this.detalleAlbaran = detalleAlbaran;
        this.listadoFacturas = listadoFacturas;
    }

    public String getCodAlbaran() {
        return codAlbaran;
    }

    public void setCodAlbaran(String codAlbaran) {
        this.codAlbaran = codAlbaran;
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

    public String getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(String codFactura) {
        this.codFactura = codFactura;
    }

    public List<Detalle> getDetalleAlbaran() {
        return detalleAlbaran;
    }

    public void setDetalleAlbaran(List<Detalle> detalleAlbaran) {
        this.detalleAlbaran = detalleAlbaran;
    }

    public List<Factura> getListadoFacturas() {
        return listadoFacturas;
    }

    public void setListadoFacturas(List<Factura> listadoFacturas) {
        this.listadoFacturas = listadoFacturas;
    }
    
}
