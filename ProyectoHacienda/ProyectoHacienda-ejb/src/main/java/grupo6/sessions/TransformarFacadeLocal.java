/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.Transformar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface TransformarFacadeLocal {

    void create(Transformar transformar);

    void edit(Transformar transformar);

    void remove(Transformar transformar);

    Transformar find(Object id);

    List<Transformar> findAll();

    List<Transformar> findRange(int[] range);

    int count();
    
}
