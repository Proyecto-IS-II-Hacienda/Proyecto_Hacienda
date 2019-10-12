/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.TiposDePlantas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface TiposDePlantasFacadeLocal {

    void create(TiposDePlantas tiposDePlantas);

    void edit(TiposDePlantas tiposDePlantas);

    void remove(TiposDePlantas tiposDePlantas);

    TiposDePlantas find(Object id);

    List<TiposDePlantas> findAll();

    List<TiposDePlantas> findRange(int[] range);

    int count();
    
}
