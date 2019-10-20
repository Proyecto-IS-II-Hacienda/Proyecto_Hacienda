/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.managedBeans;

import grupo6.entities.Insumos;
import grupo6.entities.InventarioInsumos;
import grupo6.entities.InventarioProductos;
import grupo6.entities.Productos;
import grupo6.sessions.InsumosFacadeLocal;
import grupo6.sessions.InventarioInsumosFacadeLocal;
import grupo6.sessions.InventarioProductosFacadeLocal;
import grupo6.sessions.ProductosFacadeLocal;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Marcelo_Echeverria
 */
@Named(value = "inventarioManagedBean")
@ViewScoped
public class inventarioManagedBean implements Serializable {

    private InventarioInsumos inventarioInsumos;
    private InventarioProductos inventarioProductos;
    private List<Insumos> listaInsumos;
    private List<Productos> listaProductos;
    private List<InventarioInsumos> listaInventarioInsumos;
    private List<InventarioProductos> listaInventarioProductos;
    @EJB
    private InventarioInsumosFacadeLocal inventarioInsumosFacadeLocal;
    @EJB
    private InventarioProductosFacadeLocal inventarioProductosFacadeLocal;
    @EJB
    private ProductosFacadeLocal productosFacadeLocal;
    @EJB
    private InsumosFacadeLocal insumosFacadeLocal;
    private boolean flag;

    /**
     * Creates a new instance of inventarioManagedBean
     */
    public inventarioManagedBean() {
    }

    @PostConstruct
    public void init() {
        listaProductos = productosFacadeLocal.findAll();
        listaInsumos = insumosFacadeLocal.findAll();
        listaInventarioInsumos = inventarioInsumosFacadeLocal.findAll();
        listaInventarioProductos = inventarioProductosFacadeLocal.findAll();
        listaInventarioInsumos.forEach((ii) -> {
            ii.setInsumos(insumosFacadeLocal.find(ii.getInventarioInsumosPK().getCodinsumo()));
        });
        listaInventarioProductos.forEach((ip) -> {
            ip.setProductos(productosFacadeLocal.find(ip.getInventarioProductosPK().getIdproducto()));
        });
        inventarioInsumos = null;
        inventarioProductos = null;
        flag = false;
    }

    public void registrarInsumo() {
        try {
            if (flag) {
                inventarioInsumos.getInventarioInsumosPK().setIdinventarioinsumo(BigInteger.valueOf(inventarioInsumos.getInventarioInsumosPK().getCodinsumo().length()));
                inventarioInsumosFacadeLocal.create(inventarioInsumos);
            } else {
                inventarioInsumosFacadeLocal.edit(inventarioInsumos);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Entrada guardada exitosamente!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error: ", "No hemos podido guardar la entrada."));
        } finally {
            inventarioInsumos = null;
            init();
            flag = false;

        }
    }

    public void registrarProducto() {
        try {
            if (flag) {
                inventarioProductos.getInventarioProductosPK().setIdinventarioproductos(inventarioProductos.getInventarioProductosPK().getIdproducto().substring(0, 6) + " inv");
                inventarioProductosFacadeLocal.create(inventarioProductos);
            } else {
                inventarioProductosFacadeLocal.edit(inventarioProductos);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Entrada guardada exitosamente!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error: ", "No hemos podido guardar la entrada."));
        } finally {
            inventarioProductos = null;
            init();
            flag = false;

        }
    }

    public void vaciar() {
        inventarioInsumos = null;
        inventarioProductos = null;
        init();
        flag = false;
    }

    public void nuevoInsumo() {
        inventarioInsumos = new InventarioInsumos();
        flag = true;
    }

    public void nuevoProducto() {
        inventarioProductos = new InventarioProductos();
        flag = true;
    }

    public void seleccionar(Object in) {
        if (in instanceof InventarioInsumos) {
            this.inventarioInsumos = (InventarioInsumos) in;
        } else if (in instanceof InventarioProductos) {
            this.inventarioProductos = (InventarioProductos) in;
        }
        
        flag = false;
    }

    public void eliminar(Object in) {
        if (in instanceof InventarioInsumos) {
            inventarioInsumosFacadeLocal.remove(new InventarioInsumos(((InventarioInsumos) in).getInventarioInsumosPK()));
            inventarioInsumos = null;
        } else if (in instanceof InventarioProductos) {
            inventarioProductosFacadeLocal.remove(new InventarioProductos(((InventarioProductos) in).getInventarioProductosPK().getIdinventarioproductos(),((InventarioProductos) in).getProductos().getIdproducto()));
               inventarioProductos = null;
        }
        init(); 
        flag = false;
    }

    public InventarioInsumos getInventarioInsumos() {
        return inventarioInsumos;
    }

    public void setInventarioInsumos(InventarioInsumos inventarioInsumos) {
        this.inventarioInsumos = inventarioInsumos;
    }

    public InventarioProductos getInventarioProductos() {
        return inventarioProductos;
    }

    public void setInventarioProductos(InventarioProductos inventarioProductos) {
        this.inventarioProductos = inventarioProductos;
    }

    public List<Insumos> getListaInsumos() {
        return listaInsumos;
    }

    public void setListaInsumos(List<Insumos> listaInsumos) {
        this.listaInsumos = listaInsumos;
    }

    public List<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<InventarioInsumos> getListaInventarioInsumos() {
        return listaInventarioInsumos;
    }

    public void setListaInventarioInsumos(List<InventarioInsumos> listaInventarioInsumos) {
        this.listaInventarioInsumos = listaInventarioInsumos;
    }

    public List<InventarioProductos> getListaInventarioProductos() {
        return listaInventarioProductos;
    }

    public void setListaInventarioProductos(List<InventarioProductos> listaInventarioProductos) {
        this.listaInventarioProductos = listaInventarioProductos;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}
