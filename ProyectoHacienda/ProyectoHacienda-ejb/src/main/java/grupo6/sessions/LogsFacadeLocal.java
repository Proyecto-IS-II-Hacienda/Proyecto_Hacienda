/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.Logs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface LogsFacadeLocal {

    void create(Logs logs);

    void edit(Logs logs);

    void remove(Logs logs);

    Logs find(Object id);

    List<Logs> findAll();

    List<Logs> findRange(int[] range);

    int count();
    
}
