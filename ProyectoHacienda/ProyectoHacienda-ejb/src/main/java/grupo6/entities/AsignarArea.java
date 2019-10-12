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
@Table(name = "ASIGNAR_AREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignarArea.findAll", query = "SELECT a FROM AsignarArea a")
    , @NamedQuery(name = "AsignarArea.findByIdAsngar", query = "SELECT a FROM AsignarArea a WHERE a.idAsngar = :idAsngar")})
public class AsignarArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ASNGAR")
    private Integer idAsngar;
    @JoinColumn(name = "CODANIMAL", referencedColumnName = "CODANIMAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Animales codanimal;
    @JoinColumn(name = "IDAREA", referencedColumnName = "IDAREA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Areas idarea;

    public AsignarArea() {
    }

    public AsignarArea(Integer idAsngar) {
        this.idAsngar = idAsngar;
    }

    public Integer getIdAsngar() {
        return idAsngar;
    }

    public void setIdAsngar(Integer idAsngar) {
        this.idAsngar = idAsngar;
    }

    public Animales getCodanimal() {
        return codanimal;
    }

    public void setCodanimal(Animales codanimal) {
        this.codanimal = codanimal;
    }

    public Areas getIdarea() {
        return idarea;
    }

    public void setIdarea(Areas idarea) {
        this.idarea = idarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsngar != null ? idAsngar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignarArea)) {
            return false;
        }
        AsignarArea other = (AsignarArea) object;
        if ((this.idAsngar == null && other.idAsngar != null) || (this.idAsngar != null && !this.idAsngar.equals(other.idAsngar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.AsignarArea[ idAsngar=" + idAsngar + " ]";
    }
    
}
