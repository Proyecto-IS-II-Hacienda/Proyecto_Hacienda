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
@Table(name = "AREAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a")
    , @NamedQuery(name = "Areas.findByIdarea", query = "SELECT a FROM Areas a WHERE a.idarea = :idarea")
    , @NamedQuery(name = "Areas.findByDimension", query = "SELECT a FROM Areas a WHERE a.dimension = :dimension")
    , @NamedQuery(name = "Areas.findByCercado", query = "SELECT a FROM Areas a WHERE a.cercado = :cercado")
    , @NamedQuery(name = "Areas.findByTiempodeuso", query = "SELECT a FROM Areas a WHERE a.tiempodeuso = :tiempodeuso")})
public class Areas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDAREA")
    private String idarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DIMENSION")
    private String dimension;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CERCADO")
    private BigInteger cercado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIEMPODEUSO")
    private BigInteger tiempodeuso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarea", fetch = FetchType.LAZY)
    private List<AsignarArea> asignarAreaList;
    @OneToMany(mappedBy = "idarea", fetch = FetchType.LAZY)
    private List<AsignarArea2> asignarArea2List;

    public Areas() {
    }

    public Areas(String idarea) {
        this.idarea = idarea;
    }

    public Areas(String idarea, String dimension, BigInteger cercado, BigInteger tiempodeuso) {
        this.idarea = idarea;
        this.dimension = dimension;
        this.cercado = cercado;
        this.tiempodeuso = tiempodeuso;
    }

    public String getIdarea() {
        return idarea;
    }

    public void setIdarea(String idarea) {
        this.idarea = idarea;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public BigInteger getCercado() {
        return cercado;
    }

    public void setCercado(BigInteger cercado) {
        this.cercado = cercado;
    }

    public BigInteger getTiempodeuso() {
        return tiempodeuso;
    }

    public void setTiempodeuso(BigInteger tiempodeuso) {
        this.tiempodeuso = tiempodeuso;
    }

    @XmlTransient
    public List<AsignarArea> getAsignarAreaList() {
        return asignarAreaList;
    }

    public void setAsignarAreaList(List<AsignarArea> asignarAreaList) {
        this.asignarAreaList = asignarAreaList;
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
        hash += (idarea != null ? idarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.idarea == null && other.idarea != null) || (this.idarea != null && !this.idarea.equals(other.idarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.Areas[ idarea=" + idarea + " ]";
    }
    
}
