/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.entities;

import java.io.Serializable;
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
@Table(name = "INSUMOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumos.findAll", query = "SELECT i FROM Insumos i")
    , @NamedQuery(name = "Insumos.findByCodinsumo", query = "SELECT i FROM Insumos i WHERE i.codinsumo = :codinsumo")
    , @NamedQuery(name = "Insumos.findByNombreanimal", query = "SELECT i FROM Insumos i WHERE i.nombreanimal = :nombreanimal")
    , @NamedQuery(name = "Insumos.findByTipo", query = "SELECT i FROM Insumos i WHERE i.tipo = :tipo")})
public class Insumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODINSUMO")
    private String codinsumo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NOMBREANIMAL")
    private String nombreanimal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumos", fetch = FetchType.LAZY)
    private List<InventarioInsumos> inventarioInsumosList;

    public Insumos() {
    }

    public Insumos(String codinsumo) {
        this.codinsumo = codinsumo;
    }

    public Insumos(String codinsumo, String nombreanimal, String tipo) {
        this.codinsumo = codinsumo;
        this.nombreanimal = nombreanimal;
        this.tipo = tipo;
    }

    public String getCodinsumo() {
        return codinsumo;
    }

    public void setCodinsumo(String codinsumo) {
        this.codinsumo = codinsumo;
    }

    public String getNombreanimal() {
        return nombreanimal;
    }

    public void setNombreanimal(String nombreanimal) {
        this.nombreanimal = nombreanimal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<InventarioInsumos> getInventarioInsumosList() {
        return inventarioInsumosList;
    }

    public void setInventarioInsumosList(List<InventarioInsumos> inventarioInsumosList) {
        this.inventarioInsumosList = inventarioInsumosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codinsumo != null ? codinsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumos)) {
            return false;
        }
        Insumos other = (Insumos) object;
        if ((this.codinsumo == null && other.codinsumo != null) || (this.codinsumo != null && !this.codinsumo.equals(other.codinsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.Insumos[ codinsumo=" + codinsumo + " ]";
    }
    
}
