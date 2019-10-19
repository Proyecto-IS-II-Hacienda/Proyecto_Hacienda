/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.managedBeans;

import grupo6.entities.TiposDeAnimales;
import grupo6.entities.TiposDeAnimalesPK;
import grupo6.sessions.TiposDeAnimalesFacadeLocal;
import java.io.Serializable;
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
@Named(value = "tiposDeAnimalesManagedBean")
@ViewScoped
public class TiposDeAnimalesManagedBean implements Serializable {

    private TiposDeAnimales tipoAnimal;
    private List<TiposDeAnimales> listaTiposAnimales;
    @EJB
    private TiposDeAnimalesFacadeLocal TAFacadeLocal;//2
    private TiposDeAnimalesPK tAPK;

    /**
     * Creates a new instance of TipodeAnimales
     */
    public TiposDeAnimalesManagedBean() {

    }

    @PostConstruct
    public void init() {
        listaTiposAnimales = TAFacadeLocal.findAll();
        tipoAnimal = null;

    }

    public void grabar() {
        try {
            tipoAnimal.setTiposDeAnimalesPK(new TiposDeAnimalesPK(tipoAnimal.getTiposDeAnimalesPK().getRaza().toUpperCase(),tipoAnimal.getTiposDeAnimalesPK().getNombre().toUpperCase()));
            for (int i = 0; i < tipoAnimal.getTiposDeAnimalesPK().getNombre().length() ; i++) {
                if(tipoAnimal.getTiposDeAnimalesPK().getNombre().length()==10) break;
                else tipoAnimal.getTiposDeAnimalesPK().setNombre("0"+tipoAnimal.getTiposDeAnimalesPK().getNombre()); 
            }
             for (int i = 0; i < tipoAnimal.getTiposDeAnimalesPK().getRaza().length() ; i++) {
                if(tipoAnimal.getTiposDeAnimalesPK().getRaza().length()==10) break;
                else tipoAnimal.getTiposDeAnimalesPK().setRaza("0"+tipoAnimal.getTiposDeAnimalesPK().getRaza()); 
            }
    
            TAFacadeLocal.create(tipoAnimal);

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

    public List<TiposDeAnimales> getListaTipoAnimal() {
        return listaTiposAnimales;
    }

    public void setListaTiposAnimal(List<TiposDeAnimales> listaTiposDeAnimales) {
        this.listaTiposAnimales = listaTiposDeAnimales;
    }

    public TiposDeAnimales getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TiposDeAnimales tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public void seleccionar(TiposDeAnimales tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public void eliminar(TiposDeAnimales tipoAnimal) {
        System.out.println(tipoAnimal.toString());
        TAFacadeLocal.remove(tipoAnimal);
        System.out.println(tipoAnimal.getTiposDeAnimalesPK().toString());

        init();
    }

    public TiposDeAnimalesPK gettAPK() {
        return tAPK;
    }

    public void settAPK(TiposDeAnimalesPK tAPK) {
        this.tAPK = tAPK;
    }

}
