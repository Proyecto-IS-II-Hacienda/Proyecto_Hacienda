/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.utilitarios;


/**
 *
 * @author Marcelo_Echeverria
 */
public class Usuario {
    private String nombre;
    private String rol;  
    private String username;
    private String password;
    private Permiso permiso;

    public Usuario(String nombre, String rol, String username, String password, Permiso permiso) {
        this.nombre = nombre;
        this.rol = rol;
        this.username = username;
        this.password = password;
        this.permiso = permiso;
    }
    
    public Usuario(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    
}
