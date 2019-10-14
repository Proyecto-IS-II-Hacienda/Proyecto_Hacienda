/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "PLANTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantas.findAll", query = "SELECT p FROM Plantas p")
    , @NamedQuery(name = "Plantas.findByIdplanta", query = "SELECT p FROM Plantas p WHERE p.idplanta = :idplanta")
    , @NamedQuery(name = "Plantas.findByFechaplantacion", query = "SELECT p FROM Plantas p WHERE p.fechaplantacion = :fechaplantacion")})
public class Plantas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDPLANTA")
    private String idplanta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAPLANTACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaplantacion;
    @Lob
    @Column(name = "OBSERVACION")
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplanta", fetch = FetchType.LAZY)
    private List<Transformar2> transformar2List;
    @JoinColumn(name = "NOMBREDEPLANTA", referencedColumnName = "NOMBREDEPLANTA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TiposDePlantas tiposDePlanta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplanta", fetch = FetchType.LAZY)
    private List<AsignarCuidados2> asignarCuidados2List;
    @OneToMany(mappedBy = "idplanta", fetch = FetchType.LAZY)
    private List<AsignarArea2> asignarArea2List;

    public Plantas() {
    }

    public Plantas(String idplanta) {
        this.idplanta = idplanta;
    }

    public Plantas(String idplanta, Date fechaplantacion) {
        this.idplanta = idplanta;
        this.fechaplantacion = fechaplantacion;
    }

    public String getIdplanta() {
        return idplanta;
    }

    public void setIdplanta(String idplanta) {
        this.idplanta = idplanta;
    }

    public Date getFechaplantacion() {
        return fechaplantacion;
    }

    public void setFechaplantacion(Date fechaplantacion) {
        this.fechaplantacion = fechaplantacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public List<Transformar2> getTransformar2List() {
        return transformar2List;
    }

    public void setTransformar2List(List<Transformar2> transformar2List) {
        this.transformar2List = transformar2List;
    }

    public TiposDePlantas getTiposDePlanta() {
        return tiposDePlanta;
    }

    public void setTiposDePlanta(TiposDePlantas tiposDePlanta) {
        this.tiposDePlanta = tiposDePlanta;
    }

    @XmlTransient
    public List<AsignarCuidados2> getAsignarCuidados2List() {
        return asignarCuidados2List;
    }

    public void setAsignarCuidados2List(List<AsignarCuidados2> asignarCuidados2List) {
        this.asignarCuidados2List = asignarCuidados2List;
    }

    @XmlTransient
    public List<AsignarArea2> getAsignarArea2List() {
        return asignarArea2List;
    }

    public void setAsignarArea2List(List<AsignarArea2> asignarArea2List) {
        this.asignarArea2List = asignarArea2List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplanta != null ? idplanta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantas)) {
            return false;
        }
        Plantas other = (Plantas) object;
        if ((this.idplanta == null && other.idplanta != null) || (this.idplanta != null && !this.idplanta.equals(other.idplanta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.Plantas[ idplanta=" + idplanta + " ]";
    }
    
}
