/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo_Echeverria
 */
@Entity
@Table(name = "LOGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logs.findAll", query = "SELECT l FROM Logs l")
    , @NamedQuery(name = "Logs.findByTabla", query = "SELECT l FROM Logs l WHERE l.tabla = :tabla")
    , @NamedQuery(name = "Logs.findByDatosiniciales", query = "SELECT l FROM Logs l WHERE l.datosiniciales = :datosiniciales")
    , @NamedQuery(name = "Logs.findByOperacion", query = "SELECT l FROM Logs l WHERE l.operacion = :operacion")
    , @NamedQuery(name = "Logs.findByDatosfinales", query = "SELECT l FROM Logs l WHERE l.datosfinales = :datosfinales")
    , @NamedQuery(name = "Logs.findByFecha", query = "SELECT l FROM Logs l WHERE l.fecha = :fecha")
    , @NamedQuery(name = "Logs.findByUsuario", query = "SELECT l FROM Logs l WHERE l.usuario = :usuario")
    , @NamedQuery(name = "Logs.findByIdLog", query = "SELECT l FROM Logs l WHERE l.idLog = :idLog")})
public class Logs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TABLA")
    private String tabla;
    @Size(max = 20)
    @Column(name = "DATOSINICIALES")
    private String datosiniciales;
    @Size(max = 20)
    @Column(name = "OPERACION")
    private String operacion;
    @Size(max = 20)
    @Column(name = "DATOSFINALES")
    private String datosfinales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 20)
    @Column(name = "USUARIO")
    private String usuario;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LOG")
    private Integer idLog;

    public Logs() {
    }

    public Logs(Integer idLog) {
        this.idLog = idLog;
    }

    public Logs(Integer idLog, String tabla, Date fecha) {
        this.idLog = idLog;
        this.tabla = tabla;
        this.fecha = fecha;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getDatosiniciales() {
        return datosiniciales;
    }

    public void setDatosiniciales(String datosiniciales) {
        this.datosiniciales = datosiniciales;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getDatosfinales() {
        return datosfinales;
    }

    public void setDatosfinales(String datosfinales) {
        this.datosfinales = datosfinales;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logs)) {
            return false;
        }
        Logs other = (Logs) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.entities.Logs[ idLog=" + idLog + " ]";
    }
    
}
