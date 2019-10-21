
package grupo6.manage_beans;

import grupo6.entities.Insumos;
import grupo6.sessions.InsumosFacadeLocal;
import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author XavierJC
 */
@Named(value = "insumosManagedBean")
@ViewScoped
public class InsumosManagedBean implements Serializable{

    private Insumos insumos;
    private List<Insumos> insumosList;
    private boolean edicion;
    
    @EJB
    private InsumosFacadeLocal insumosFacadeLocal;

    public InsumosManagedBean() {
    }
    
    @PostConstruct
    public void init() {
        insumosList = insumosFacadeLocal.findAll();
    }
    
    public void grabar() {

        try {          
            if (edicion) {
                insumosFacadeLocal.edit(insumos);
            } else {
                insumosFacadeLocal.create(insumos);
            }
            init();
            insumos = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "el insumo sea gravado exitosamente"));
        } catch (Exception e) {
            if (e.getCause().getCause().getCause().getCause() instanceof SQLIntegrityConstraintViolationException){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "El codigo ya existe"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "error", "ocurrio un error al gravar el insumo"));
            }
            
        }

    }

    public Insumos getInsumos() {
        return insumos;
    }

    public void setInsumos(Insumos insumos) {
        this.insumos = insumos;
    }

    public List<Insumos> getInsumosList() {
        return insumosList;
    }

    public void setInsumosList(List<Insumos> insumosList) {
        this.insumosList = insumosList;
    }

    public boolean isEdicion() {
        return edicion;
    }

    public void setEdicion(boolean edicion) {
        this.edicion = edicion;
    }
    
    public void nuevo() {
        edicion = false;
        insumos = new Insumos();

    }

    public void cancelar() {
        insumos = null;
    }

    public void selecionar(Insumos insumos) {
        edicion = true;
        this.insumos = insumos;
    }

    public void eliminar(Insumos insumos) {
       insumosFacadeLocal.remove(insumos);
        init();
    }
    
}



