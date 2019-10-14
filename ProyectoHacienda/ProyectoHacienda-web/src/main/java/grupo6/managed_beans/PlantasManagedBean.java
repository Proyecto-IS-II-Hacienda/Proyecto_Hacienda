package grupo6.managed_beans;

import grupo6.entities.Plantas;
import grupo6.entities.TiposDePlantas;
import grupo6.sessions.PlantasFacadeLocal;
import grupo6.sessions.TiposDePlantasFacadeLocal;
import grupo6.utilitarios.Crud;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author vjose
 */
@Named(value = "plantasManagedBean")
@ViewScoped
public class PlantasManagedBean implements Serializable, Crud<Plantas> {
    
    private Plantas plantas;
    private List<Plantas> listaPlantas;
    private List<TiposDePlantas> listaTiposDePlantas;
    @EJB
    private PlantasFacadeLocal plantasFacadeLocal;
    @EJB
    private TiposDePlantasFacadeLocal tiposDePlantasFacadeLocal;
    
    public PlantasManagedBean() {
    }
    
    @Override
    public void nuevo() {
        plantas = new Plantas();
    }
    
    @Override
    public void seleccionar(Plantas clase) {
        this.plantas = clase;
    }
    
    @Override
    public void grabar() {
        try {
            if (plantas.getIdplanta() == null) {
                plantasFacadeLocal.create(plantas);
            } else {
                plantasFacadeLocal.edit(plantas);
            }
            plantas = null;
            init();
            notificarExito("Se han guardado los datos con éxito");
        } catch (Exception e) {
            notificarError("Ha ocurrido un error al guardar los datos");
        }
    }
    
    @Override
    public void eliminar(Plantas clase) {
        plantasFacadeLocal.remove(clase);
        init();
    }
    
    @Override
    public void cancelar() {
        plantas = null;
    }
    
    @Override
    @PostConstruct
    public void init() {
        listaPlantas = plantasFacadeLocal.findAll();
        listaTiposDePlantas = tiposDePlantasFacadeLocal.findAll();
    }
    
    public Plantas getPlantas() {
        return plantas;
    }
    
    public void setPlantas(Plantas plantas) {
        this.plantas = plantas;
    }
    
    public List<Plantas> getListaPlantas() {
        return listaPlantas;
    }
    
    public void setListaPlantas(List<Plantas> listaPlantas) {
        this.listaPlantas = listaPlantas;
    }
    
    public List<TiposDePlantas> getListaTiposDePlantas() {
        return listaTiposDePlantas;
    }
    
    public void setListaTiposDePlantas(List<TiposDePlantas> listaTiposDePlantas) {
        this.listaTiposDePlantas = listaTiposDePlantas;
    }
    
}
