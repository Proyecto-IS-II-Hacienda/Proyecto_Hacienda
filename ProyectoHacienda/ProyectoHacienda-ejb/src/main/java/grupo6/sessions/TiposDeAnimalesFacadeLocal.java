/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.TiposDeAnimales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface TiposDeAnimalesFacadeLocal {

    void create(TiposDeAnimales tiposDeAnimales);

    void edit(TiposDeAnimales tiposDeAnimales);

    void remove(TiposDeAnimales tiposDeAnimales);

    TiposDeAnimales find(Object id);

    List<TiposDeAnimales> findAll();

    List<TiposDeAnimales> findRange(int[] range);

    int count();

    public void eliminar();
    
}
