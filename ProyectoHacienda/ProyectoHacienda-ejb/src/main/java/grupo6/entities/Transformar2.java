/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.entities;

import java.io.Serializable;
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
@Table(name = "TRANSFORMAR2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transformar2.findAll", query = "SELECT t FROM Transformar2 t")
    , @NamedQuery(name = "Transformar2.findByIdTra2", query = "SELECT t FROM Transformar2 t WHERE t.idTra2 = :idTra2")})
public class Transformar2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRA2")
    private Integer idTra2;
    @JoinColumn(name = "IDPLANTA", referencedColumnName = "IDPLANTA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Plantas idplanta;
    @JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productos idproducto;

    public Transformar2() {
    }

    public Transformar2(Integer idTra2) {
        this.idTra2 = idTra2;
    }

    public Integer getIdTra2() {
        return idTra2;
    }

    public void setIdTra2(Integer idTra2) {
        this.idTra2 = idTra2;
    }

    public Plantas getIdplanta() {
        return idplanta;
    }

    public void setIdplanta(Plantas idplanta) {
        this.idplanta = idplanta;
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
        hash += (idTra2 != null ? idTra2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transformar2)) {
            return false;
        }
        Transformar2 other = (Transformar2) object;
        if ((this.idTra2 == null && other.idTra2 != null) || (this.idTra2 != null && !this.idTra2.equals(other.idTra2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.Transformar2[ idTra2=" + idTra2 + " ]";
    }
    
}
