
package grupo6.manage_beans;

import grupo6.entities.Clientes;
import grupo6.sessions.ClientesFacadeLocal;
import java.util.List;
import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
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
@Named(value = "clienteManagedBean")
@ViewScoped
public class ClienteManagedBean implements Serializable{

    
    private Clientes clientes;
    private List<Clientes> clientesList;
    private boolean edicion;

    @EJB
    private ClientesFacadeLocal clientesFacadeLocal;
    
    public ClienteManagedBean() {
    }
    
     @PostConstruct
    public void init() {
        clientesList =  clientesFacadeLocal.findAll();
    }
    
    public void grabar() {

        try {
            
            if (edicion) {
                clientesFacadeLocal.edit(clientes);
            } else {
                clientesFacadeLocal.create(clientes);
            }
            init();
            clientes = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "el cliente sea gravado exitosamente"));
        } catch (Exception e) {
             if (e.getCause().getCause().getCause().getCause() instanceof SQLIntegrityConstraintViolationException){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "La cédula ya existe"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "error", "ocurrio un error al gravar el cliente"));
            }
        }
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    public boolean isEdicion() {
        return edicion;
    }

    public void setEdicion(boolean edicion) {
        this.edicion = edicion;
    }
    
    public void nuevo() {
        edicion = false;
        clientes = new Clientes();

    }

    public void cancelar() {
        clientes = null;
    }

    public void selecionar(Clientes clientes) {
        edicion = true;
        this.clientes = clientes;
    }

    public void eliminar(Clientes clientes) {
        clientesFacadeLocal.remove(clientes);
        init();
    }
    
    
}
