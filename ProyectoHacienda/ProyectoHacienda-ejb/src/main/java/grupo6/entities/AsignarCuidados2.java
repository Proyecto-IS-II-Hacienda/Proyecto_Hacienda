/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "ASIGNAR_CUIDADOS2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignarCuidados2.findAll", query = "SELECT a FROM AsignarCuidados2 a")
    , @NamedQuery(name = "AsignarCuidados2.findByCantidad", query = "SELECT a FROM AsignarCuidados2 a WHERE a.cantidad = :cantidad")
    , @NamedQuery(name = "AsignarCuidados2.findByIdCuid2", query = "SELECT a FROM AsignarCuidados2 a WHERE a.idCuid2 = :idCuid2")})
public class AsignarCuidados2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CUID2")
    private Integer idCuid2;
    @JoinColumns({
        @JoinColumn(name = "IDINVENTARIOINSUMO", referencedColumnName = "IDINVENTARIOINSUMO")
        , @JoinColumn(name = "CODINSUMO", referencedColumnName = "CODINSUMO")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InventarioInsumos inventarioInsumos;
    @JoinColumn(name = "IDPLANTA", referencedColumnName = "IDPLANTA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Plantas idplanta;

    public AsignarCuidados2() {
    }

    public AsignarCuidados2(Integer idCuid2) {
        this.idCuid2 = idCuid2;
    }

    public AsignarCuidados2(Integer idCuid2, BigInteger cantidad) {
        this.idCuid2 = idCuid2;
        this.cantidad = cantidad;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdCuid2() {
        return idCuid2;
    }

    public void setIdCuid2(Integer idCuid2) {
        this.idCuid2 = idCuid2;
    }

    public InventarioInsumos getInventarioInsumos() {
        return inventarioInsumos;
    }

    public void setInventarioInsumos(InventarioInsumos inventarioInsumos) {
        this.inventarioInsumos = inventarioInsumos;
    }

    public Plantas getIdplanta() {
        return idplanta;
    }

    public void setIdplanta(Plantas idplanta) {
        this.idplanta = idplanta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuid2 != null ? idCuid2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignarCuidados2)) {
            return false;
        }
        AsignarCuidados2 other = (AsignarCuidados2) object;
        if ((this.idCuid2 == null && other.idCuid2 != null) || (this.idCuid2 != null && !this.idCuid2.equals(other.idCuid2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.AsignarCuidados2[ idCuid2=" + idCuid2 + " ]";
    }
    
}
