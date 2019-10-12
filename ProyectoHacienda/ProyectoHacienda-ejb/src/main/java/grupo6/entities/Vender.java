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
@Table(name = "VENDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vender.findAll", query = "SELECT v FROM Vender v")
    , @NamedQuery(name = "Vender.findByCantidad", query = "SELECT v FROM Vender v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "Vender.findByIdVenta", query = "SELECT v FROM Vender v WHERE v.idVenta = :idVenta")})
public class Vender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VENTA")
    private Integer idVenta;
    @JoinColumn(name = "CEDULA", referencedColumnName = "CEDULA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clientes cedula;
    @JoinColumns({
        @JoinColumn(name = "IDINVENTARIOPRODUCTOS", referencedColumnName = "IDINVENTARIOPRODUCTOS")
        , @JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InventarioProductos inventarioProductos;

    public Vender() {
    }

    public Vender(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Vender(Integer idVenta, BigInteger cantidad) {
        this.idVenta = idVenta;
        this.cantidad = cantidad;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Clientes getCedula() {
        return cedula;
    }

    public void setCedula(Clientes cedula) {
        this.cedula = cedula;
    }

    public InventarioProductos getInventarioProductos() {
        return inventarioProductos;
    }

    public void setInventarioProductos(InventarioProductos inventarioProductos) {
        this.inventarioProductos = inventarioProductos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vender)) {
            return false;
        }
        Vender other = (Vender) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.Vender[ idVenta=" + idVenta + " ]";
    }
    
}
