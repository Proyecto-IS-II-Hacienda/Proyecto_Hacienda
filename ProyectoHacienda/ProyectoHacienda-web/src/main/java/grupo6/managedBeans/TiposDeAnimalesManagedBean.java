/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.managedBeans;

import grupo6.entities.TiposDeAnimales;
import grupo6.sessions.TiposDeAnimalesFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author gon30
 */
@Named(value = "tipoDeAnimales")
@ViewScoped
public class TiposDeAnimalesManagedBean {
    

    private TiposDeAnimales tipoAnimal;
    private List<TiposDeAnimales> listaTiposAnimales;
    @EJB
    private TiposDeAnimalesFacadeLocal TAFacadeLocal;//2

    /**
     * Creates a new instance of TipodeAnimales
     */
    public TiposDeAnimalesManagedBean() {
        
    }
    
    @PostConstruct
    public void init() {//3
        listaTiposAnimales = TAFacadeLocal.findAll();
        
        
    }
    
    
    public void grabar() {
        try {
            if (tipoAnimal.getTiposDeAnimalesPK() == null) {
                TAFacadeLocal.create(tipoAnimal);
            } else {
                TAFacadeLocal.edit(tipoAnimal);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Tipo de animal guardado exitosamente!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, ":(", "No hemos podido guardar el tipo de Animal."));
        } finally {
            tipoAnimal = null;
            init();
        }
        
        

    }
    
    
    public void vaciar() {
        tipoAnimal = null;
    }

    public void nuevo() {
        tipoAnimal = new TiposDeAnimales();
    }

    public List<TiposDeAnimales> getListaProductos() {
        return listaTiposAnimales;
    }


    public void setListaProductos(List<TiposDeAnimales> listaTiposDeAnimales) {
        this.listaTiposAnimales = listaTiposDeAnimales;
    }

    public TiposDeAnimales getProducto() {
        return tipoAnimal;
    }

    public void setProducto(TiposDeAnimales tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public void seleccionar(TiposDeAnimales tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public void eliminar(TiposDeAnimales tipoAnimal) {
        TAFacadeLocal.remove(tipoAnimal);
        init();
    }
    
}
