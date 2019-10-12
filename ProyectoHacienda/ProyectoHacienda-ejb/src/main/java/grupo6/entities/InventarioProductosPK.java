/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marcelo_Echeverria
 */
@Embeddable
public class InventarioProductosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDINVENTARIOPRODUCTOS")
    private String idinventarioproductos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDPRODUCTO")
    private String idproducto;

    public InventarioProductosPK() {
    }

    public InventarioProductosPK(String idinventarioproductos, String idproducto) {
        this.idinventarioproductos = idinventarioproductos;
        this.idproducto = idproducto;
    }

    public String getIdinventarioproductos() {
        return idinventarioproductos;
    }

    public void setIdinventarioproductos(String idinventarioproductos) {
        this.idinventarioproductos = idinventarioproductos;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinventarioproductos != null ? idinventarioproductos.hashCode() : 0);
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioProductosPK)) {
            return false;
        }
        InventarioProductosPK other = (InventarioProductosPK) object;
        if ((this.idinventarioproductos == null && other.idinventarioproductos != null) || (this.idinventarioproductos != null && !this.idinventarioproductos.equals(other.idinventarioproductos))) {
            return false;
        }
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.InventarioProductosPK[ idinventarioproductos=" + idinventarioproductos + ", idproducto=" + idproducto + " ]";
    }
    
}
