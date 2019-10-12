/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "PRODUCTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByIdproducto", query = "SELECT p FROM Productos p WHERE p.idproducto = :idproducto")
    , @NamedQuery(name = "Productos.findByNombreanimal", query = "SELECT p FROM Productos p WHERE p.nombreanimal = :nombreanimal")
    , @NamedQuery(name = "Productos.findByFechaelaboracion", query = "SELECT p FROM Productos p WHERE p.fechaelaboracion = :fechaelaboracion")
    , @NamedQuery(name = "Productos.findByPeso", query = "SELECT p FROM Productos p WHERE p.peso = :peso")
    , @NamedQuery(name = "Productos.findByPrecio", query = "SELECT p FROM Productos p WHERE p.precio = :precio")
    , @NamedQuery(name = "Productos.findByFechacaducidad", query = "SELECT p FROM Productos p WHERE p.fechacaducidad = :fechacaducidad")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDPRODUCTO")
    private String idproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NOMBREANIMAL")
    private String nombreanimal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAELABORACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaelaboracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESO")
    private BigInteger peso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacaducidad;
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproducto", fetch = FetchType.LAZY)
    private List<Transformar2> transformar2List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos", fetch = FetchType.LAZY)
    private List<InventarioProductos> inventarioProductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproducto", fetch = FetchType.LAZY)
    private List<Transformar> transformarList;

    public Productos() {
    }

    public Productos(String idproducto) {
        this.idproducto = idproducto;
    }

    public Productos(String idproducto, String nombreanimal, Date fechaelaboracion, BigInteger peso, BigDecimal precio, Date fechacaducidad) {
        this.idproducto = idproducto;
        this.nombreanimal = nombreanimal;
        this.fechaelaboracion = fechaelaboracion;
        this.peso = peso;
        this.precio = precio;
        this.fechacaducidad = fechacaducidad;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombreanimal() {
        return nombreanimal;
    }

    public void setNombreanimal(String nombreanimal) {
        this.nombreanimal = nombreanimal;
    }

    public Date getFechaelaboracion() {
        return fechaelaboracion;
    }

    public void setFechaelaboracion(Date fechaelaboracion) {
        this.fechaelaboracion = fechaelaboracion;
    }

    public BigInteger getPeso() {
        return peso;
    }

    public void setPeso(BigInteger peso) {
        this.peso = peso;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getFechacaducidad() {
        return fechacaducidad;
    }

    public void setFechacaducidad(Date fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Transformar2> getTransformar2List() {
        return transformar2List;
    }

    public void setTransformar2List(List<Transformar2> transformar2List) {
        this.transformar2List = transformar2List;
    }

    @XmlTransient
    public List<InventarioProductos> getInventarioProductosList() {
        return inventarioProductosList;
    }

    public void setInventarioProductosList(List<InventarioProductos> inventarioProductosList) {
        this.inventarioProductosList = inventarioProductosList;
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
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.Productos[ idproducto=" + idproducto + " ]";
    }
    
}
