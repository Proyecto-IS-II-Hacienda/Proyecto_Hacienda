/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.Vender;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface VenderFacadeLocal {

    void create(Vender vender);

    void edit(Vender vender);

    void remove(Vender vender);

    Vender find(Object id);

    List<Vender> findAll();

    List<Vender> findRange(int[] range);

    int count();
    
}
