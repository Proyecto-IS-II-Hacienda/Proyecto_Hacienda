/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.managedBeans;

import grupo6.entities.Animales;
import grupo6.entities.TiposDeAnimales;
import grupo6.entities.TiposDeAnimalesPK;
import grupo6.sessions.AnimalesFacadeLocal;
import grupo6.sessions.TiposDeAnimalesFacadeLocal;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Named(value = "animalesManagedBean")
@ViewScoped
public class AnimalesManagedBean implements Serializable {
    

    private Animales animal;
    private List<Animales> listaAnimales;
    private List<TiposDeAnimales> listaTiposAnimales;
    @EJB
    private TiposDeAnimalesFacadeLocal TAFacadeLocal;
    @EJB
    private AnimalesFacadeLocal AFacadeLocal;//2
    private boolean flag;

    /**
     * Creates a new instance of TipodeAnimales
     */
    public AnimalesManagedBean() {
        
    }
    
    @PostConstruct
    public void init() {
        listaAnimales = AFacadeLocal.findAll();
        listaTiposAnimales = TAFacadeLocal.findAll();
        animal = null;
        flag = false;
    }
    
    
    public void grabar() {
        try {
            if (flag) {
                AFacadeLocal.create(animal);
            } else {
                AFacadeLocal.edit(animal);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Animal guardado exitosamente!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error: ", "No hemos podido guardar el Animal."));
        } finally {
            animal = null;
            flag = false;
            init();
        }
    }
    
    
    public void vaciar() {
        animal = null;
        flag = false;
    }

    public void nuevo() {
        animal = new Animales();
        flag = true;
    }

    public Animales getAnimal() {
        return animal;
    }

    public void setAnimal(Animales animal) {
        this.animal = animal;
    }

    public List<Animales> getListaAnimales() {
        return listaAnimales;
    }

    public void setListaAnimales(List<Animales> listaAnimales) {
        this.listaAnimales = listaAnimales;
    }

    public List<TiposDeAnimales> getListaTiposAnimales() {
        return listaTiposAnimales;
    }

    public void setListaTiposAnimales(List<TiposDeAnimales> listaTiposAnimales) {
        this.listaTiposAnimales = listaTiposAnimales;
    }



    public void seleccionar(Animales animal) {
        this.animal = animal;
    }

    public void eliminar(Animales animal) {
        AFacadeLocal.remove(animal);
        init();
    }


    
    
    
}
