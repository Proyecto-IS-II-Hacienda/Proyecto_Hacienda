/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.utilitarios;

/**
 *
 * @author Marcelo_Echeverria
 */
public class Permiso {
    private boolean ingreso;
    private boolean modificacion;
    private boolean eliminacion;
    private boolean consulta;

    public Permiso(boolean ingreso, boolean modificacion, boolean eliminacion, boolean consulta) {
        this.ingreso = ingreso;
        this.modificacion = modificacion;
        this.eliminacion = eliminacion;
        this.consulta = consulta;
    }

    public boolean isIngreso() {
        return ingreso;
    }

    public void setIngreso(boolean ingreso) {
        this.ingreso = ingreso;
    }

    public boolean isModificacion() {
        return modificacion;
    }

    public void setModificacion(boolean modificacion) {
        this.modificacion = modificacion;
    }

    public boolean isEliminacion() {
        return eliminacion;
    }

    public void setEliminacion(boolean eliminacion) {
        this.eliminacion = eliminacion;
    }

    public boolean isConsulta() {
        return consulta;
    }

    public void setConsulta(boolean consulta) {
        this.consulta = consulta;
    }
    
}
