/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.Transformar2;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface Transformar2FacadeLocal {

    void create(Transformar2 transformar2);

    void edit(Transformar2 transformar2);

    void remove(Transformar2 transformar2);

    Transformar2 find(Object id);

    List<Transformar2> findAll();

    List<Transformar2> findRange(int[] range);

    int count();
    
}
