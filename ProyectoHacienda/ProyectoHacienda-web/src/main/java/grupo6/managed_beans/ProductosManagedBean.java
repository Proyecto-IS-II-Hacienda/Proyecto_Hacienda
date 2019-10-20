/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.managed_beans;


import java.io.Serializable;
import grupo6.entities.Productos;
import grupo6.sessions.ProductosFacadeLocal;
import grupo6.utilitarios.Crud;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Albert
 */
@Named(value = "productosManagedBean")
@ViewScoped
public class ProductosManagedBean implements Serializable, Crud<Productos> {
    private List<Productos> productosList;
    @EJB
    private ProductosFacadeLocal productosFacadeLocal;
    private Productos producto;
    private boolean esNuevo;
   
    /**
     * Creates a new instance of ProductosManagedBean
     */
    public ProductosManagedBean() {
    }
    
    @PostConstruct
    @Override
    public void init(){
       productosList=null;
       productosList=productosFacadeLocal.findAll();
       producto=null;
       esNuevo=false;
    }
    
    @Override
    public void nuevo(){
        producto=new Productos();
        esNuevo=true;
    }
    
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setFacturaList(List<Productos> productoList) {
        this.productosList = productoList;
    }

    public Productos getProductos() {
        return producto;
    }

    public void setProductos(Productos producto) {
        this.producto = producto;
    }

    @Override
    public void grabar() {
        try{
            if (esNuevo) {
                producto.setIdproducto(producto.getIdproducto().toUpperCase());
                for (int i = 0; i < producto.getIdproducto().length(); i++) {
                    if (producto.getIdproducto().length() == 10) {
                        break;
                    } else {
                        producto.setIdproducto(producto.getIdproducto()+"0");
                    } 
                }
                productosFacadeLocal.create(producto);
            } else {
                productosFacadeLocal.edit(producto);
            }
            init();
            producto=null;
            notificarExito("El producto ha sido guardado exitosamente");

        }catch(Exception e){
            notificarError("Ocurrio un error al grabar el producto");
        }
        
    }

    @Override
    public void cancelar() {
        producto=null;
    }

    @Override
    public void eliminar(Productos clase) {
        try{
            productosFacadeLocal.remove(clase);
            init();
            notificarExito("El producto ha sido eliminado exitosamente");
        }catch(Exception e){
            notificarError("Ocurrio un error al eliminar el producto");

        }finally {
            producto = null;
            esNuevo = false;
            init();
        }
    }

    @Override
    public void seleccionar(Productos clase) {
        esNuevo=false;
        producto=clase;
    }
}
