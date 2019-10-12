/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.AsignarArea;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface AsignarAreaFacadeLocal {

    void create(AsignarArea asignarArea);

    void edit(AsignarArea asignarArea);

    void remove(AsignarArea asignarArea);

    AsignarArea find(Object id);

    List<AsignarArea> findAll();

    List<AsignarArea> findRange(int[] range);

    int count();
    
}
