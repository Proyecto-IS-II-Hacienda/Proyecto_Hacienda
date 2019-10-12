/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.AsignarCuidados2;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface AsignarCuidados2FacadeLocal {

    void create(AsignarCuidados2 asignarCuidados2);

    void edit(AsignarCuidados2 asignarCuidados2);

    void remove(AsignarCuidados2 asignarCuidados2);

    AsignarCuidados2 find(Object id);

    List<AsignarCuidados2> findAll();

    List<AsignarCuidados2> findRange(int[] range);

    int count();
    
}
