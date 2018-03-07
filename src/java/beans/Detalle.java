/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Alumno
 */
public class Detalle {

    private String codFactura;
    private String codAlbaran;
    private String concepto;
    private int cantidad;
    private int importeUnitario;
    private int codIva;
    private int descuento;
    private int estado;
    private Double numdetalle;
    private String factura_CodFactura;
    private String albaran_CodAlbaran;
    
    
    public Detalle() {
    }

    public Detalle(String codFactura, String codAlbaran, String concepto, int cantidad, int importeUnitario, int codIva, int descuento, int estado, Double numdetalle, String factura_CodFactura, String albaran_CodAlbaran) {
        this.codFactura = codFactura;
        this.codAlbaran = codAlbaran;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.importeUnitario = importeUnitario;
        this.codIva = codIva;
        this.descuento = descuento;
        this.estado = estado;
        this.numdetalle = numdetalle;
        this.factura_CodFactura = factura_CodFactura;
        this.albaran_CodAlbaran = albaran_CodAlbaran;
    }

    public String getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(String codFactura) {
        this.codFactura = codFactura;
    }

    public String getCodAlbaran() {
        return codAlbaran;
    }

    public void setCodAlbaran(String codAlbaran) {
        this.codAlbaran = codAlbaran;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getImporteUnitario() {
        return importeUnitario;
    }

    public void setImporteUnitario(int importeUnitario) {
        this.importeUnitario = importeUnitario;
    }

    public int getCodIva() {
        return codIva;
    }

    public void setCodIva(int codIva) {
        this.codIva = codIva;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Double getNumdetalle() {
        return numdetalle;
    }

    public void setNumdetalle(Double numdetalle) {
        this.numdetalle = numdetalle;
    }

    public String getFactura_CodFactura() {
        return factura_CodFactura;
    }

    public void setFactura_CodFactura(String factura_CodFactura) {
        this.factura_CodFactura = factura_CodFactura;
    }

    public String getAlbaran_CodAlbaran() {
        return albaran_CodAlbaran;
    }

    public void setAlbaran_CodAlbaran(String albaran_CodAlbaran) {
        this.albaran_CodAlbaran = albaran_CodAlbaran;
    }
    
    
    
    
}
