/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.AsignarArea2;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface AsignarArea2FacadeLocal {

    void create(AsignarArea2 asignarArea2);

    void edit(AsignarArea2 asignarArea2);

    void remove(AsignarArea2 asignarArea2);

    AsignarArea2 find(Object id);

    List<AsignarArea2> findAll();

    List<AsignarArea2> findRange(int[] range);

    int count();
    
}
