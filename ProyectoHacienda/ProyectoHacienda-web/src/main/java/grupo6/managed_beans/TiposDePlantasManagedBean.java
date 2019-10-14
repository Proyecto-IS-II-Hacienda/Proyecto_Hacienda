package grupo6.managed_beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import grupo6.entities.TiposDePlantas;
import grupo6.sessions.TiposDePlantasFacadeLocal;
import grupo6.utilitarios.Crud;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author vjose
 */
@Named(value = "tiposDePlantasManagedBean")
@ViewScoped
public class TiposDePlantasManagedBean implements Serializable, Crud<TiposDePlantas> {
    private TiposDePlantas tiposDePlantas;
    private List<TiposDePlantas> listaTiposDePlantas;
    @EJB
    private TiposDePlantasFacadeLocal tiposDePlantasFacadeLocal;
    
    public TiposDePlantasManagedBean() {
    }

    @Override
    public void nuevo() {
        tiposDePlantas = new TiposDePlantas();
    }

    @Override
    public void seleccionar(TiposDePlantas clase) {
        this.tiposDePlantas = clase;
    }

    @Override
    public void grabar() {
        try {
            if (tiposDePlantas.getNombredeplanta()== null) {
                tiposDePlantasFacadeLocal.create(tiposDePlantas);
            } else {
                tiposDePlantasFacadeLocal.edit(tiposDePlantas);
            }
            tiposDePlantas = null;
            init();
            notificarExito("Se han guardado los datos con éxito");
        } catch (Exception e) {
            notificarError("Ha ocurrido un error al guardar los datos");
        }
    }

    @Override
    public void eliminar(TiposDePlantas clase) {
        tiposDePlantasFacadeLocal.remove(clase);
        init();
    }

    @Override
    public void cancelar() {
        tiposDePlantas = null;
    }

    @Override
    @PostConstruct
    public void init() {
        listaTiposDePlantas = tiposDePlantasFacadeLocal.findAll();
    }

    public TiposDePlantas getTiposDePlantas() {
        return tiposDePlantas;
    }

    public void setTiposDePlantas(TiposDePlantas tiposDePlantas) {
        this.tiposDePlantas = tiposDePlantas;
    }

    public List<TiposDePlantas> getListaTiposDePlantas() {
        return listaTiposDePlantas;
    }

    public void setListaTiposDePlantas(List<TiposDePlantas> listaTiposDePlantas) {
        this.listaTiposDePlantas = listaTiposDePlantas;
    }

}
