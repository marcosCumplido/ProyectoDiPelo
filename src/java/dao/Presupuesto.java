/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Presupuesto.findAll", query = "SELECT p FROM Presupuesto p")
    , @NamedQuery(name = "Presupuesto.findByCodPresupuesto", query = "SELECT p FROM Presupuesto p WHERE p.codPresupuesto = :codPresupuesto")
    , @NamedQuery(name = "Presupuesto.findByFecha", query = "SELECT p FROM Presupuesto p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Presupuesto.findByEstado", query = "SELECT p FROM Presupuesto p WHERE p.estado = :estado")})
public class Presupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    private String codPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    private String estado;
    @JoinColumn(name = "CodCliente", referencedColumnName = "CodCliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "CodFactura", referencedColumnName = "CodCliente")
    @ManyToOne
    private Factura codFactura;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "presupuesto1")
    private Presupuesto presupuesto;
    @JoinColumn(name = "CodPresupuesto", referencedColumnName = "CodPresupuesto", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Presupuesto presupuesto1;

    public Presupuesto() {
    }

    public Presupuesto(String codPresupuesto) {
        this.codPresupuesto = codPresupuesto;
    }

    public Presupuesto(String codPresupuesto, Date fecha, String estado) {
        this.codPresupuesto = codPresupuesto;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getCodPresupuesto() {
        return codPresupuesto;
    }

    public void setCodPresupuesto(String codPresupuesto) {
        this.codPresupuesto = codPresupuesto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public Factura getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(Factura codFactura) {
        this.codFactura = codFactura;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Presupuesto getPresupuesto1() {
        return presupuesto1;
    }

    public void setPresupuesto1(Presupuesto presupuesto1) {
        this.presupuesto1 = presupuesto1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPresupuesto != null ? codPresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuesto)) {
            return false;
        }
        Presupuesto other = (Presupuesto) object;
        if ((this.codPresupuesto == null && other.codPresupuesto != null) || (this.codPresupuesto != null && !this.codPresupuesto.equals(other.codPresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Presupuesto[ codPresupuesto=" + codPresupuesto + " ]";
    }
    
}
