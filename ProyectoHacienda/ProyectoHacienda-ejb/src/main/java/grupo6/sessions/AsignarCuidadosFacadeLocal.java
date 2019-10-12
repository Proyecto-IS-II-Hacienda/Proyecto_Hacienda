/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.AsignarCuidados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface AsignarCuidadosFacadeLocal {

    void create(AsignarCuidados asignarCuidados);

    void edit(AsignarCuidados asignarCuidados);

    void remove(AsignarCuidados asignarCuidados);

    AsignarCuidados find(Object id);

    List<AsignarCuidados> findAll();

    List<AsignarCuidados> findRange(int[] range);

    int count();
    
}
