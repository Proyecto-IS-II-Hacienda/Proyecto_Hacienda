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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marcelo_Echeverria
 */
@Embeddable
public class InventarioInsumosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDINVENTARIOINSUMO")
    private BigInteger idinventarioinsumo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODINSUMO")
    private String codinsumo;

    public InventarioInsumosPK() {
    }

    public InventarioInsumosPK(BigInteger idinventarioinsumo, String codinsumo) {
        this.idinventarioinsumo = idinventarioinsumo;
        this.codinsumo = codinsumo;
    }

    public BigInteger getIdinventarioinsumo() {
        return idinventarioinsumo;
    }

    public void setIdinventarioinsumo(BigInteger idinventarioinsumo) {
        this.idinventarioinsumo = idinventarioinsumo;
    }

    public String getCodinsumo() {
        return codinsumo;
    }

    public void setCodinsumo(String codinsumo) {
        this.codinsumo = codinsumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinventarioinsumo != null ? idinventarioinsumo.hashCode() : 0);
        hash += (codinsumo != null ? codinsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioInsumosPK)) {
            return false;
        }
        InventarioInsumosPK other = (InventarioInsumosPK) object;
        if ((this.idinventarioinsumo == null && other.idinventarioinsumo != null) || (this.idinventarioinsumo != null && !this.idinventarioinsumo.equals(other.idinventarioinsumo))) {
            return false;
        }
        if ((this.codinsumo == null && other.codinsumo != null) || (this.codinsumo != null && !this.codinsumo.equals(other.codinsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.InventarioInsumosPK[ idinventarioinsumo=" + idinventarioinsumo + ", codinsumo=" + codinsumo + " ]";
    }
    
}
