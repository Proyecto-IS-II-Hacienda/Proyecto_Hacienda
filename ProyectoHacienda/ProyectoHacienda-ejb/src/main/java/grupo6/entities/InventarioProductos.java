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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "INVENTARIO_PRODUCTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioProductos.findAll", query = "SELECT i FROM InventarioProductos i")
    , @NamedQuery(name = "InventarioProductos.findByIdinventarioproductos", query = "SELECT i FROM InventarioProductos i WHERE i.inventarioProductosPK.idinventarioproductos = :idinventarioproductos")
    , @NamedQuery(name = "InventarioProductos.findByIdproducto", query = "SELECT i FROM InventarioProductos i WHERE i.inventarioProductosPK.idproducto = :idproducto")
    , @NamedQuery(name = "InventarioProductos.findByCantidad", query = "SELECT i FROM InventarioProductos i WHERE i.cantidad = :cantidad")})
public class InventarioProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventarioProductosPK inventarioProductosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventarioProductos", fetch = FetchType.LAZY)
    private List<Vender> venderList;
    @JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productos productos;

    public InventarioProductos() {
        inventarioProductosPK = new InventarioProductosPK();
    }

    public InventarioProductos(InventarioProductosPK inventarioProductosPK) {
        this.inventarioProductosPK = inventarioProductosPK;
    }

    public InventarioProductos(InventarioProductosPK inventarioProductosPK, BigInteger cantidad) {
        this.inventarioProductosPK = inventarioProductosPK;
        this.cantidad = cantidad;
    }

    public InventarioProductos(String idinventarioproductos, String idproducto) {
        this.inventarioProductosPK = new InventarioProductosPK(idinventarioproductos, idproducto);
    }

    public InventarioProductosPK getInventarioProductosPK() {
        return inventarioProductosPK;
    }

    public void setInventarioProductosPK(InventarioProductosPK inventarioProductosPK) {
        this.inventarioProductosPK = inventarioProductosPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public List<Vender> getVenderList() {
        return venderList;
    }

    public void setVenderList(List<Vender> venderList) {
        this.venderList = venderList;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioProductosPK != null ? inventarioProductosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioProductos)) {
            return false;
        }
        InventarioProductos other = (InventarioProductos) object;
        if ((this.inventarioProductosPK == null && other.inventarioProductosPK != null) || (this.inventarioProductosPK != null && !this.inventarioProductosPK.equals(other.inventarioProductosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.InventarioProductos[ inventarioProductosPK=" + inventarioProductosPK + " ]";
    }
    
}
