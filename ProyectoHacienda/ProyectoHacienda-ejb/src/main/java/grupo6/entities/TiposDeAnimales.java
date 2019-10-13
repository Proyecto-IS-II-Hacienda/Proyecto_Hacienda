/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "TIPOS_DE_ANIMALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeAnimales.findAll", query = "SELECT t FROM TiposDeAnimales t")
    , @NamedQuery(name = "TiposDeAnimales.findByRaza", query = "SELECT t FROM TiposDeAnimales t WHERE t.tiposDeAnimalesPK.raza = :raza")
    , @NamedQuery(name = "TiposDeAnimales.findByNombre", query = "SELECT t FROM TiposDeAnimales t WHERE t.tiposDeAnimalesPK.nombre = :nombre")})
public class TiposDeAnimales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TiposDeAnimalesPK tiposDeAnimalesPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposDeAnimales", fetch = FetchType.LAZY)
    private List<Animales> animalesList;

    public TiposDeAnimales() {
    tiposDeAnimalesPK = new TiposDeAnimalesPK();
    }

    public TiposDeAnimales(TiposDeAnimalesPK tiposDeAnimalesPK) {
        this.tiposDeAnimalesPK = tiposDeAnimalesPK;
    }

    public TiposDeAnimales(String raza, String nombre) {
        this.tiposDeAnimalesPK = new TiposDeAnimalesPK(raza, nombre);
    }

    public TiposDeAnimalesPK getTiposDeAnimalesPK() {
        return tiposDeAnimalesPK;
    }

    public void setTiposDeAnimalesPK(TiposDeAnimalesPK tiposDeAnimalesPK) {
        this.tiposDeAnimalesPK = tiposDeAnimalesPK;
    }

    @XmlTransient
    public List<Animales> getAnimalesList() {
        return animalesList;
    }

    public void setAnimalesList(List<Animales> animalesList) {
        this.animalesList = animalesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiposDeAnimalesPK != null ? tiposDeAnimalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDeAnimales)) {
            return false;
        }
        TiposDeAnimales other = (TiposDeAnimales) object;
        if ((this.tiposDeAnimalesPK == null && other.tiposDeAnimalesPK != null) || (this.tiposDeAnimalesPK != null && !this.tiposDeAnimalesPK.equals(other.tiposDeAnimalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.TiposDeAnimales[ tiposDeAnimalesPK=" + tiposDeAnimalesPK + " ]";
    }
    
}
