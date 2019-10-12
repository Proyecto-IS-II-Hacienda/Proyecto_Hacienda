/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.Plantas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface PlantasFacadeLocal {

    void create(Plantas plantas);

    void edit(Plantas plantas);

    void remove(Plantas plantas);

    Plantas find(Object id);

    List<Plantas> findAll();

    List<Plantas> findRange(int[] range);

    int count();
    
}
