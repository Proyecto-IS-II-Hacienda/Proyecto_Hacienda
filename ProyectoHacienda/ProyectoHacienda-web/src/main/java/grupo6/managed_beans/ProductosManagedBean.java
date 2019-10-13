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
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Albert
 */
@Named(value = "productosManagedBean")
@RequestScoped
public class ProductosManagedBean implements Serializable, Crud<Productos> {
    private List<Productos> productosList;
    @EJB
    private ProductosFacadeLocal productosFacadeLocal;
    private Productos producto;
   
    /**
     * Creates a new instance of ProductosManagedBean
     */
    public ProductosManagedBean() {
    }
    
    @PostConstruct
    @Override
    public void init(){
       productosList=productosFacadeLocal.findAll();
    }
    
    @Override
    public void nuevo(){
        producto=new Productos();
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
            if (producto.getIdproducto() == null) {
                productosFacadeLocal.create(producto);
            } else {
                productosFacadeLocal.edit(producto);
            }
            init();
            producto=null;
            notificarExito("La factura ha sido guardada exitosamente");

        }catch(Exception e){
            notificarError("Ocurrio un error al grabar la factura");
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
            notificarExito("La factura ha sido eliminada exitosamente");
        }catch(Exception e){
            notificarError("Ocurrio un error al grabar la factura");

        }
    }

    @Override
    public void seleccionar(Productos clase) {
        producto=clase;
    }
}
