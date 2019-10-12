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
@Table(name = "TRANSFORMAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transformar.findAll", query = "SELECT t FROM Transformar t")
    , @NamedQuery(name = "Transformar.findByCantidad", query = "SELECT t FROM Transformar t WHERE t.cantidad = :cantidad")
    , @NamedQuery(name = "Transformar.findByIdTans", query = "SELECT t FROM Transformar t WHERE t.idTans = :idTans")})
public class Transformar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TANS")
    private Integer idTans;
    @JoinColumn(name = "CODANIMAL", referencedColumnName = "CODANIMAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Animales codanimal;
    @JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productos idproducto;

    public Transformar() {
    }

    public Transformar(Integer idTans) {
        this.idTans = idTans;
    }

    public Transformar(Integer idTans, BigInteger cantidad) {
        this.idTans = idTans;
        this.cantidad = cantidad;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdTans() {
        return idTans;
    }

    public void setIdTans(Integer idTans) {
        this.idTans = idTans;
    }

    public Animales getCodanimal() {
        return codanimal;
    }

    public void setCodanimal(Animales codanimal) {
        this.codanimal = codanimal;
    }

    public Productos getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Productos idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTans != null ? idTans.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transformar)) {
            return false;
        }
        Transformar other = (Transformar) object;
        if ((this.idTans == null && other.idTans != null) || (this.idTans != null && !this.idTans.equals(other.idTans))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.Transformar[ idTans=" + idTans + " ]";
    }
    
}
