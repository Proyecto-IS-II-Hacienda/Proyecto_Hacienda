/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.utilitarios;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcelo_Echeverria
 */
public interface Crud<T> {

    void nuevo();

    void seleccionar(T clase);

    void grabar();

    void eliminar(T clase);

    void cancelar();

    void init();

    default void notificar(FacesMessage.Severity severidad,String titulo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidad, titulo, mensaje));
    }
    default void notificarExito(String mensaje) {
        notificar(FacesMessage.SEVERITY_INFO, "Exito", mensaje);
    }
    default void notificarError(String mensaje) {
        notificar(FacesMessage.SEVERITY_ERROR, "Fracaso", mensaje);
    }
}
