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
    private String nombreGenerado;
    private boolean generado;
    private boolean nuevaPlanta;
    @EJB
    private PlantasFacadeLocal plantasFacadeLocal;
    @EJB
    private TiposDePlantasFacadeLocal tiposDePlantasFacadeLocal;

    public PlantasManagedBean() {
    }

    @Override
    public void nuevo() {
        plantas = new Plantas();
        nuevaPlanta = true;
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
        nuevaPlanta = false;
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

    public boolean isNuevaPlanta() {
        return nuevaPlanta;
    }

    public void setNuevaPlanta(boolean nuevaPlanta) {
        this.nuevaPlanta = nuevaPlanta;
    }

    public void verificar() {

        if (plantasFacadeLocal.find(plantas.getIdplanta()) == null) {
            notificarExito("El nombre es libre de usarse");
        } else {
            notificarError("El nombre ya está siendo usado");
        }
    }

    public void generarID() {
        generado = false;
        while (!generado) {
            nombreGenerado = "PLA" + String.valueOf((int) (Math.random() * 1000) + 1);
            if (plantasFacadeLocal.find(nombreGenerado) == null) {
                generado = true;
                plantas.setIdplanta(nombreGenerado);
            }
        }
    }
}
