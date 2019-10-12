/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.InventarioProductos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface InventarioProductosFacadeLocal {

    void create(InventarioProductos inventarioProductos);

    void edit(InventarioProductos inventarioProductos);

    void remove(InventarioProductos inventarioProductos);

    InventarioProductos find(Object id);

    List<InventarioProductos> findAll();

    List<InventarioProductos> findRange(int[] range);

    int count();
    
}
