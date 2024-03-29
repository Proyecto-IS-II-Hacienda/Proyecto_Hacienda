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

@Named(value = "tiposDePlantasManagedBean")
@ViewScoped
public class TiposDePlantasManagedBean implements Serializable, Crud<TiposDePlantas> {

    private TiposDePlantas tiposDePlantas;
    private List<TiposDePlantas> listaTiposDePlantas;
    @EJB
    private TiposDePlantasFacadeLocal tiposDePlantasFacadeLocal;
    private boolean esNuevo;

    public TiposDePlantasManagedBean() {
    }

    @Override
    public void nuevo() {
        esNuevo = true;
        tiposDePlantas = new TiposDePlantas();
    }

    @Override
    public void seleccionar(TiposDePlantas clase) {
        esNuevo = false;
        this.tiposDePlantas = clase;
    }

    @Override
    public void grabar() {
        try {
            tiposDePlantas.setNombredeplanta(tiposDePlantas.getNombredeplanta().toUpperCase());
            if (esNuevo) {
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
        notificarExito("Se han eliminado los datos con éxito");
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

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

}
