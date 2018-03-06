/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "Impuesto.findAll", query = "SELECT i FROM Impuesto i")
    , @NamedQuery(name = "Impuesto.findByCodIva", query = "SELECT i FROM Impuesto i WHERE i.codIva = :codIva")
    , @NamedQuery(name = "Impuesto.findByValorIva", query = "SELECT i FROM Impuesto i WHERE i.valorIva = :valorIva")
    , @NamedQuery(name = "Impuesto.findByDescripcion", query = "SELECT i FROM Impuesto i WHERE i.descripcion = :descripcion")})
public class Impuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer codIva;
    @Basic(optional = false)
    @NotNull
    private int valorIva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codIva")
    private List<Conceptos> conceptosList;

    public Impuesto() {
    }

    public Impuesto(Integer codIva) {
        this.codIva = codIva;
    }

    public Impuesto(Integer codIva, int valorIva, String descripcion) {
        this.codIva = codIva;
        this.valorIva = valorIva;
        this.descripcion = descripcion;
    }

    public Integer getCodIva() {
        return codIva;
    }

    public void setCodIva(Integer codIva) {
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

    @XmlTransient
    public List<Conceptos> getConceptosList() {
        return conceptosList;
    }

    public void setConceptosList(List<Conceptos> conceptosList) {
        this.conceptosList = conceptosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIva != null ? codIva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impuesto)) {
            return false;
        }
        Impuesto other = (Impuesto) object;
        if ((this.codIva == null && other.codIva != null) || (this.codIva != null && !this.codIva.equals(other.codIva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Impuesto[ codIva=" + codIva + " ]";
    }
    
}
