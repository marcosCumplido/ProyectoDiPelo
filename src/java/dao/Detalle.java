/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alumno
 */
@Entity
@Table(catalog = "annexfactura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d")
    , @NamedQuery(name = "Detalle.findByCodFactura", query = "SELECT d FROM Detalle d WHERE d.codFactura = :codFactura")
    , @NamedQuery(name = "Detalle.findByCodAlbaran", query = "SELECT d FROM Detalle d WHERE d.codAlbaran = :codAlbaran")
    , @NamedQuery(name = "Detalle.findByConcepto", query = "SELECT d FROM Detalle d WHERE d.concepto = :concepto")
    , @NamedQuery(name = "Detalle.findByCantidad", query = "SELECT d FROM Detalle d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detalle.findByImporteUnitario", query = "SELECT d FROM Detalle d WHERE d.importeUnitario = :importeUnitario")
    , @NamedQuery(name = "Detalle.findByCodIva", query = "SELECT d FROM Detalle d WHERE d.codIva = :codIva")
    , @NamedQuery(name = "Detalle.findByDescuento", query = "SELECT d FROM Detalle d WHERE d.descuento = :descuento")
    , @NamedQuery(name = "Detalle.findByEstado", query = "SELECT d FROM Detalle d WHERE d.estado = :estado")
    , @NamedQuery(name = "Detalle.findByNumdetalle", query = "SELECT d FROM Detalle d WHERE d.numdetalle = :numdetalle")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    private String codFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    private String codAlbaran;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    private String concepto;
    @Basic(optional = false)
    @NotNull
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    private int importeUnitario;
    @Basic(optional = false)
    @NotNull
    private int codIva;
    @Basic(optional = false)
    @NotNull
    private int descuento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    private Double numdetalle;
    @JoinColumn(name = "albaran_CodAlbaran", referencedColumnName = "CodAlbaran")
    @ManyToOne(optional = false)
    private Albaran albaranCodAlbaran;
    @JoinColumn(name = "factura_CodFactura", referencedColumnName = "CodFactura")
    @ManyToOne(optional = false)
    private Facturas facturaCodFactura;

    public Detalle() {
    }

    public Detalle(Double numdetalle) {
        this.numdetalle = numdetalle;
    }

    public Detalle(Double numdetalle, String codFactura, String codAlbaran, String concepto, int cantidad, int importeUnitario, int codIva, int descuento, String estado) {
        this.numdetalle = numdetalle;
        this.codFactura = codFactura;
        this.codAlbaran = codAlbaran;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.importeUnitario = importeUnitario;
        this.codIva = codIva;
        this.descuento = descuento;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getNumdetalle() {
        return numdetalle;
    }

    public void setNumdetalle(Double numdetalle) {
        this.numdetalle = numdetalle;
    }

    public Albaran getAlbaranCodAlbaran() {
        return albaranCodAlbaran;
    }

    public void setAlbaranCodAlbaran(Albaran albaranCodAlbaran) {
        this.albaranCodAlbaran = albaranCodAlbaran;
    }

    public Facturas getFacturaCodFactura() {
        return facturaCodFactura;
    }

    public void setFacturaCodFactura(Facturas facturaCodFactura) {
        this.facturaCodFactura = facturaCodFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numdetalle != null ? numdetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.numdetalle == null && other.numdetalle != null) || (this.numdetalle != null && !this.numdetalle.equals(other.numdetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Detalle[ numdetalle=" + numdetalle + " ]";
    }
    
}
