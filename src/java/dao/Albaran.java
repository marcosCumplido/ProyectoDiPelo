/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alumno
 */
@Entity
@Table(catalog = "annexfactura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Albaran.findAll", query = "SELECT a FROM Albaran a")
    , @NamedQuery(name = "Albaran.findByCodAlbaran", query = "SELECT a FROM Albaran a WHERE a.codAlbaran = :codAlbaran")
    , @NamedQuery(name = "Albaran.findByFecha", query = "SELECT a FROM Albaran a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Albaran.findByCodFactura", query = "SELECT a FROM Albaran a WHERE a.codFactura = :codFactura")})
public class Albaran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    private String codAlbaran;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    private int codFactura;
    @JoinColumn(name = "CodCliente", referencedColumnName = "CodCliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "albaranCodAlbaran")
    private List<Detalle> detalleList;

    public Albaran() {
    }

    public Albaran(String codAlbaran) {
        this.codAlbaran = codAlbaran;
    }

    public Albaran(String codAlbaran, Date fecha, int codFactura) {
        this.codAlbaran = codAlbaran;
        this.fecha = fecha;
        this.codFactura = codFactura;
    }

    public String getCodAlbaran() {
        return codAlbaran;
    }

    public void setCodAlbaran(String codAlbaran) {
        this.codAlbaran = codAlbaran;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    @XmlTransient
    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAlbaran != null ? codAlbaran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Albaran)) {
            return false;
        }
        Albaran other = (Albaran) object;
        if ((this.codAlbaran == null && other.codAlbaran != null) || (this.codAlbaran != null && !this.codAlbaran.equals(other.codAlbaran))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Albaran[ codAlbaran=" + codAlbaran + " ]";
    }
    
}
