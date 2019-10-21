/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "TIPOS_DE_PLANTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDePlantas.findAll", query = "SELECT t FROM TiposDePlantas t")
    , @NamedQuery(name = "TiposDePlantas.findByNombredeplanta", query = "SELECT t FROM TiposDePlantas t WHERE t.nombredeplanta = :nombredeplanta")
    , @NamedQuery(name = "TiposDePlantas.findByDiascosecha", query = "SELECT t FROM TiposDePlantas t WHERE t.diascosecha = :diascosecha")})
public class TiposDePlantas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NOMBREDEPLANTA")
    private String nombredeplanta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIASCOSECHA")
    private BigInteger diascosecha;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposDePlanta", fetch = FetchType.LAZY)
    private List<Plantas> plantasList;

    public TiposDePlantas() {
    }

    public TiposDePlantas(String nombredeplanta) {
        this.nombredeplanta = nombredeplanta;
    }

    public TiposDePlantas(String nombredeplanta, BigInteger diascosecha, String descripcion) {
        this.nombredeplanta = nombredeplanta;
        this.diascosecha = diascosecha;
        this.descripcion = descripcion;
    }

    public String getNombredeplanta() {
        return nombredeplanta;
    }

    public void setNombredeplanta(String nombredeplanta) {
        this.nombredeplanta = nombredeplanta;
    }

    public BigInteger getDiascosecha() {
        return diascosecha;
    }

    public void setDiascosecha(BigInteger diascosecha) {
        this.diascosecha = diascosecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Plantas> getPlantasList() {
        return plantasList;
    }

    public void setPlantasList(List<Plantas> plantasList) {
        this.plantasList = plantasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombredeplanta != null ? nombredeplanta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDePlantas)) {
            return false;
        }
        TiposDePlantas other = (TiposDePlantas) object;
        if ((this.nombredeplanta == null && other.nombredeplanta != null) || (this.nombredeplanta != null && !this.nombredeplanta.equals(other.nombredeplanta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.TiposDePlantas[ nombredeplanta=" + nombredeplanta + " ]";
    }
    
}
