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
@Table(name = "ASIGNAR_CUIDADOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignarCuidados.findAll", query = "SELECT a FROM AsignarCuidados a")
    , @NamedQuery(name = "AsignarCuidados.findByCantidad", query = "SELECT a FROM AsignarCuidados a WHERE a.cantidad = :cantidad")
    , @NamedQuery(name = "AsignarCuidados.findByIdCuid", query = "SELECT a FROM AsignarCuidados a WHERE a.idCuid = :idCuid")})
public class AsignarCuidados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CUID")
    private Integer idCuid;
    @JoinColumn(name = "CODANIMAL", referencedColumnName = "CODANIMAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Animales codanimal;
    @JoinColumns({
        @JoinColumn(name = "IDINVENTARIOINSUMO", referencedColumnName = "IDINVENTARIOINSUMO")
        , @JoinColumn(name = "CODINSUMO", referencedColumnName = "CODINSUMO")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InventarioInsumos inventarioInsumos;

    public AsignarCuidados() {
    }

    public AsignarCuidados(Integer idCuid) {
        this.idCuid = idCuid;
    }

    public AsignarCuidados(Integer idCuid, BigInteger cantidad) {
        this.idCuid = idCuid;
        this.cantidad = cantidad;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdCuid() {
        return idCuid;
    }

    public void setIdCuid(Integer idCuid) {
        this.idCuid = idCuid;
    }

    public Animales getCodanimal() {
        return codanimal;
    }

    public void setCodanimal(Animales codanimal) {
        this.codanimal = codanimal;
    }

    public InventarioInsumos getInventarioInsumos() {
        return inventarioInsumos;
    }

    public void setInventarioInsumos(InventarioInsumos inventarioInsumos) {
        this.inventarioInsumos = inventarioInsumos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuid != null ? idCuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignarCuidados)) {
            return false;
        }
        AsignarCuidados other = (AsignarCuidados) object;
        if ((this.idCuid == null && other.idCuid != null) || (this.idCuid != null && !this.idCuid.equals(other.idCuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.AsignarCuidados[ idCuid=" + idCuid + " ]";
    }
    
}
