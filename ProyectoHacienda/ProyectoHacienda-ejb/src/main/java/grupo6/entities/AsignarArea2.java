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
@Table(name = "ASIGNAR_AREA2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignarArea2.findAll", query = "SELECT a FROM AsignarArea2 a")
    , @NamedQuery(name = "AsignarArea2.findByIdAs2", query = "SELECT a FROM AsignarArea2 a WHERE a.idAs2 = :idAs2")})
public class AsignarArea2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AS2")
    private Integer idAs2;
    @JoinColumn(name = "IDAREA", referencedColumnName = "IDAREA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Areas idarea;
    @JoinColumn(name = "IDPLANTA", referencedColumnName = "IDPLANTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Plantas idplanta;

    public AsignarArea2() {
    }

    public AsignarArea2(Integer idAs2) {
        this.idAs2 = idAs2;
    }

    public Integer getIdAs2() {
        return idAs2;
    }

    public void setIdAs2(Integer idAs2) {
        this.idAs2 = idAs2;
    }

    public Areas getIdarea() {
        return idarea;
    }

    public void setIdarea(Areas idarea) {
        this.idarea = idarea;
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
        hash += (idAs2 != null ? idAs2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignarArea2)) {
            return false;
        }
        AsignarArea2 other = (AsignarArea2) object;
        if ((this.idAs2 == null && other.idAs2 != null) || (this.idAs2 != null && !this.idAs2.equals(other.idAs2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.AsignarArea2[ idAs2=" + idAs2 + " ]";
    }
    
}
