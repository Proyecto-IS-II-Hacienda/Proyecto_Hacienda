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
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Albert
 */
@Named(value = "areasManagedBean")
@RequestScoped
public class AreasManagedBean implements Serializable, Crud <Areas>{
    private List<Areas> areasList;
    @EJB
    private AreasFacadeLocal areasFacadeLocal;
    private Areas area;

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
       areasList=areasFacadeLocal.findAll();
    }
    
    @Override
    public void nuevo(){
        area=new Areas();
    }

     @Override
    public void grabar() {
        try{
            if (area.getIdarea() == null) {
                areasFacadeLocal.create(area);
            } else {
                areasFacadeLocal.edit(area);
            }
            init();
            area=null;
            notificarExito("La factura ha sido guardada exitosamente");

        }catch(Exception e){
            notificarError("Ocurrio un error al grabar la factura");
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
            notificarExito("La factura ha sido eliminada exitosamente");
        }catch(Exception e){
            notificarError("Ocurrio un error al grabar la factura");

        }
    }

    @Override
    public void seleccionar(Areas clase) {
        area=clase;
    }
}
