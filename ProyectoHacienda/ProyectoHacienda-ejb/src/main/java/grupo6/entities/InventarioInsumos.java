/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "INVENTARIO_INSUMOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioInsumos.findAll", query = "SELECT i FROM InventarioInsumos i")
    , @NamedQuery(name = "InventarioInsumos.findByIdinventarioinsumo", query = "SELECT i FROM InventarioInsumos i WHERE i.inventarioInsumosPK.idinventarioinsumo = :idinventarioinsumo")
    , @NamedQuery(name = "InventarioInsumos.findByCodinsumo", query = "SELECT i FROM InventarioInsumos i WHERE i.inventarioInsumosPK.codinsumo = :codinsumo")
    , @NamedQuery(name = "InventarioInsumos.findByCantidad", query = "SELECT i FROM InventarioInsumos i WHERE i.cantidad = :cantidad")})
public class InventarioInsumos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventarioInsumosPK inventarioInsumosPK;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventarioInsumos", fetch = FetchType.LAZY)
    private List<AsignarCuidados> asignarCuidadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventarioInsumos", fetch = FetchType.LAZY)
    private List<AsignarCuidados2> asignarCuidados2List;
    @JoinColumn(name = "CODINSUMO", referencedColumnName = "CODINSUMO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Insumos insumos;

    public InventarioInsumos() {
        inventarioInsumosPK = new InventarioInsumosPK();
    }

    public InventarioInsumos(InventarioInsumosPK inventarioInsumosPK) {
        this.inventarioInsumosPK = inventarioInsumosPK;
    }

    public InventarioInsumos(BigInteger idinventarioinsumo, String codinsumo) {
        this.inventarioInsumosPK = new InventarioInsumosPK(idinventarioinsumo, codinsumo);
    }

    public InventarioInsumosPK getInventarioInsumosPK() {
        return inventarioInsumosPK;
    }

    public void setInventarioInsumosPK(InventarioInsumosPK inventarioInsumosPK) {
        this.inventarioInsumosPK = inventarioInsumosPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public List<AsignarCuidados> getAsignarCuidadosList() {
        return asignarCuidadosList;
    }

    public void setAsignarCuidadosList(List<AsignarCuidados> asignarCuidadosList) {
        this.asignarCuidadosList = asignarCuidadosList;
    }

    @XmlTransient
    public List<AsignarCuidados2> getAsignarCuidados2List() {
        return asignarCuidados2List;
    }

    public void setAsignarCuidados2List(List<AsignarCuidados2> asignarCuidados2List) {
        this.asignarCuidados2List = asignarCuidados2List;
    }

    public Insumos getInsumos() {
        return insumos;
    }

    public void setInsumos(Insumos insumos) {
        this.insumos = insumos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioInsumosPK != null ? inventarioInsumosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioInsumos)) {
            return false;
        }
        InventarioInsumos other = (InventarioInsumos) object;
        if ((this.inventarioInsumosPK == null && other.inventarioInsumosPK != null) || (this.inventarioInsumosPK != null && !this.inventarioInsumosPK.equals(other.inventarioInsumosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.InventarioInsumos[ inventarioInsumosPK=" + inventarioInsumosPK + " ]";
    }
    
}
