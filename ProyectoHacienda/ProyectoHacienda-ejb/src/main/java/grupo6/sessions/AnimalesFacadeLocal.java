/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.Animales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface AnimalesFacadeLocal {

    void create(Animales animales);

    void edit(Animales animales);

    void remove(Animales animales);

    Animales find(Object id);

    List<Animales> findAll();

    List<Animales> findRange(int[] range);

    int count();
    
}
