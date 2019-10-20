/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.managed_beans;

import grupo6.entities.Areas;
import grupo6.sessions.AreasFacadeLocal;
import grupo6.utilitarios.Crud;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


/**
 *
 * @author Albert
 */
@Named(value = "areasManagedBean")
@ViewScoped
public class AreasManagedBean implements Serializable, Crud <Areas>{
    private List<Areas> areasList;
    @EJB
    private AreasFacadeLocal areasFacadeLocal;
    private Areas area;
    private boolean esNuevo;

    public List<Areas> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<Areas> areasList) {
        this.areasList = areasList;
    }

    public Areas getArea() {
        return area;
    }

    public void setArea(Areas area) {
        this.area = area;
    }
    
    /**
     * Creates a new instance of AreasManagedBean
     */
    public AreasManagedBean() {
    }
    
    @PostConstruct
    @Override
    public void init(){
       areasList=null;
       areasList=areasFacadeLocal.findAll();
       area=null;
       esNuevo=false;
    }
    
    @Override
    public void nuevo(){
        area=new Areas();
        esNuevo = true;
    }

     @Override
    public void grabar() {   
        try {
            if (esNuevo) {
                area.setIdarea(area.getIdarea().toUpperCase());
                for (int i = 0; i < area.getIdarea().length(); i++) {
                    if (area.getIdarea().length() == 10) {
                        break;
                    } else {
                        area.setIdarea(area.getIdarea()+"0");
                    } 
                }
                areasFacadeLocal.create(area);
            } else {
                areasFacadeLocal.edit(area);
            }
            init();
            area = null;
            notificarExito("El área ha sido guardada exitosamente");
        } catch (Exception e) {
            notificarError("Ocurrio un error al grabar el área");
        } finally {
            area = null;
            esNuevo = false;
            init();
        }
    }
            

       
        

    @Override
    public void cancelar() {
        area=null;
    }
    
    
    @Override
    public void eliminar(Areas clase) {
        try{
            areasFacadeLocal.remove(clase);
            init();
            notificarExito("El area ha sido eliminada exitosamente");
        }catch(Exception e){
            notificarError("Ocurrio un error al eliminar el area");

        }
    }

    @Override
    public void seleccionar(Areas clase) {
        esNuevo =false;
        area=clase;
    }
}
