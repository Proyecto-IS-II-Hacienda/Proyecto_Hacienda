/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "ANIMALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animales.findAll", query = "SELECT a FROM Animales a")
    , @NamedQuery(name = "Animales.findByCodanimal", query = "SELECT a FROM Animales a WHERE a.codanimal = :codanimal")
    , @NamedQuery(name = "Animales.findByPeso", query = "SELECT a FROM Animales a WHERE a.peso = :peso")
    , @NamedQuery(name = "Animales.findByAltura", query = "SELECT a FROM Animales a WHERE a.altura = :altura")
    , @NamedQuery(name = "Animales.findByFechanacimiento", query = "SELECT a FROM Animales a WHERE a.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "Animales.findByGenero", query = "SELECT a FROM Animales a WHERE a.genero = :genero")})
public class Animales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODANIMAL")
    private String codanimal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESO")
    private BigInteger peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALTURA")
    private BigInteger altura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHANACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENERO")
    private Character genero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codanimal", fetch = FetchType.LAZY)
    private List<AsignarCuidados> asignarCuidadosList;
    @JoinColumns({
        @JoinColumn(name = "RAZA", referencedColumnName = "RAZA")
        , @JoinColumn(name = "NOMBRE", referencedColumnName = "NOMBRE")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TiposDeAnimales tiposDeAnimales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codanimal", fetch = FetchType.LAZY)
    private List<AsignarArea> asignarAreaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codanimal", fetch = FetchType.LAZY)
    private List<Transformar> transformarList;

    public Animales() {
    }

    public Animales(String codanimal) {
        this.codanimal = codanimal;
    }

    public Animales(String codanimal, BigInteger peso, BigInteger altura, Date fechanacimiento, Character genero) {
        this.codanimal = codanimal;
        this.peso = peso;
        this.altura = altura;
        this.fechanacimiento = fechanacimiento;
        this.genero = genero;
    }

    public String getCodanimal() {
        return codanimal;
    }

    public void setCodanimal(String codanimal) {
        this.codanimal = codanimal;
    }

    public BigInteger getPeso() {
        return peso;
    }

    public void setPeso(BigInteger peso) {
        this.peso = peso;
    }

    public BigInteger getAltura() {
        return altura;
    }

    public void setAltura(BigInteger altura) {
        this.altura = altura;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    @XmlTransient
    public List<AsignarCuidados> getAsignarCuidadosList() {
        return asignarCuidadosList;
    }

    public void setAsignarCuidadosList(List<AsignarCuidados> asignarCuidadosList) {
        this.asignarCuidadosList = asignarCuidadosList;
    }

    public TiposDeAnimales getTiposDeAnimales() {
        return tiposDeAnimales;
    }

    public void setTiposDeAnimales(TiposDeAnimales tiposDeAnimales) {
        this.tiposDeAnimales = tiposDeAnimales;
    }

    @XmlTransient
    public List<AsignarArea> getAsignarAreaList() {
        return asignarAreaList;
    }

    public void setAsignarAreaList(List<AsignarArea> asignarAreaList) {
        this.asignarAreaList = asignarAreaList;
    }

    @XmlTransient
    public List<Transformar> getTransformarList() {
        return transformarList;
    }

    public void setTransformarList(List<Transformar> transformarList) {
        this.transformarList = transformarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codanimal != null ? codanimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animales)) {
            return false;
        }
        Animales other = (Animales) object;
        if ((this.codanimal == null && other.codanimal != null) || (this.codanimal != null && !this.codanimal.equals(other.codanimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.Animales[ codanimal=" + codanimal + " ]";
    }
    
}
