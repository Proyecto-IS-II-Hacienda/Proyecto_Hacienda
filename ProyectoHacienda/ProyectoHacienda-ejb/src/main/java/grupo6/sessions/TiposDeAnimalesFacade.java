/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.TiposDeAnimales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marcelo_Echeverria
 */

@Stateless
public class TiposDeAnimalesFacade extends AbstractFacade<TiposDeAnimales> implements TiposDeAnimalesFacadeLocal {

    @PersistenceContext(unitName = "grupo6_ProyectoHacienda-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposDeAnimalesFacade() {
        super(TiposDeAnimales.class);
    }

    @Override
    public void eliminar() {
      
    }
    
}
