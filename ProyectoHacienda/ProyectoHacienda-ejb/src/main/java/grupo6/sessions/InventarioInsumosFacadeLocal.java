/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.InventarioInsumos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface InventarioInsumosFacadeLocal {

    void create(InventarioInsumos inventarioInsumos);

    void edit(InventarioInsumos inventarioInsumos);

    void remove(InventarioInsumos inventarioInsumos);

    InventarioInsumos find(Object id);

    List<InventarioInsumos> findAll();

    List<InventarioInsumos> findRange(int[] range);

    int count();
    
}
