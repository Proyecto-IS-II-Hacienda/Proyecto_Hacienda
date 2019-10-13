/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.managedBeans;

import grupo6.utilitarios.Permiso;
import grupo6.utilitarios.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.primefaces.PrimeFaces;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Marcelo_Echeverria
 */
@Named(value = "indexManagedBean")
@SessionScoped
public class indexManagedBean implements Serializable {

    private boolean logueado;
    private List<Usuario> usuarios;
    private Usuario usuarioLogueado;

    /**
     * Creates a new instance of indexManagedBean
     */
    public indexManagedBean() {
        usuarioLogueado = new Usuario();
        logueado = false;
        usuarios = new ArrayList<>();
    }

    public boolean isLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public void login() {
        for (Usuario usuario : usuarios) {
            if ((usuario.getUsername() == null ? usuarioLogueado.getUsername() == null : usuario.getUsername().equals(usuarioLogueado.getUsername())) && (usuario.getPassword() == null ? usuarioLogueado.getPassword() == null : usuario.getPassword().equals(usuarioLogueado.getPassword()))) {
                usuarioLogueado = usuario;
                logueado = true;
                break;
            } else {
                logueado = false;
            }
        }
        if (logueado) {
            PrimeFaces.current().dialog().closeDynamic(null);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Credenciales no válidas"));
        }
    }

    public void logout() {
        logueado = false;
        usuarioLogueado = new Usuario();
    }

    @PostConstruct
    public void lanzarVentana() {
        Map<String, Object> opciones = new HashMap<>();
        opciones.put("modal", true);
        opciones.put("contentHeight", 200);
        opciones.put("contentWith", 200);
        opciones.put("resizable", false);
        PrimeFaces.current().dialog().openDynamic("login", opciones, null);
    }

    public ServletContext getContext() {
        return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    }

    public void cargarUsuarios() {
        ServletContext context = getContext();
        try {
            HashMap<String, Permiso> permisos = new HashMap<>();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(context.getResourceAsStream("/WEB-INF/usuarios.xml"));
            document.getDocumentElement().normalize();
            NodeList listaAuxiliar;
            //System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
            listaAuxiliar = document.getElementsByTagName("AdmHacienda");
            Node nodo = listaAuxiliar.item(0);
            System.out.println("Elemento:" + nodo.getNodeName());
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodo;
                permisos.put("AH", new Permiso(Boolean.getBoolean(element.getElementsByTagName("ingreso").item(0).getTextContent()),
                        Boolean.parseBoolean(element.getElementsByTagName("modificacion").item(0).getTextContent()),
                        Boolean.parseBoolean(element.getElementsByTagName("eliminacion").item(0).getTextContent()),
                        Boolean.parseBoolean(element.getElementsByTagName("consulta").item(0).getTextContent())));
            }

            listaAuxiliar = document.getElementsByTagName("AdmCampo");
            nodo = listaAuxiliar.item(0);
            System.out.println("Elemento:" + nodo.getNodeName());
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodo;
                permisos.put("AC", new Permiso(Boolean.getBoolean(element.getElementsByTagName("ingreso").item(0).getTextContent()),
                        Boolean.parseBoolean(element.getElementsByTagName("modificacion").item(0).getTextContent()),
                        Boolean.parseBoolean(element.getElementsByTagName("eliminacion").item(0).getTextContent()),
                        Boolean.parseBoolean(element.getElementsByTagName("consulta").item(0).getTextContent())));
            }

            listaAuxiliar = document.getElementsByTagName("AdmSistema");
            nodo = listaAuxiliar.item(0);
            System.out.println("Elemento:" + nodo.getNodeName());
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodo;
                permisos.put("AS", new Permiso(Boolean.getBoolean(element.getElementsByTagName("ingreso").item(0).getTextContent()),
                        Boolean.parseBoolean(element.getElementsByTagName("modificacion").item(0).getTextContent()),
                        Boolean.parseBoolean(element.getElementsByTagName("eliminacion").item(0).getTextContent()),
                        Boolean.parseBoolean(element.getElementsByTagName("consulta").item(0).getTextContent())));
            }

            listaAuxiliar = document.getElementsByTagName("usuario");
            for (int temp = 0; temp < listaAuxiliar.getLength(); temp++) {
                nodo = listaAuxiliar.item(temp);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    usuarios.add(new Usuario(element.getElementsByTagName("nombre").item(0).getTextContent(),
                            element.getElementsByTagName("rol").item(0).getTextContent(),
                            element.getElementsByTagName("username").item(0).getTextContent(),
                            element.getElementsByTagName("password").item(0).getTextContent(),
                            permisos.get(element.getElementsByTagName("permisos").item(0).getTextContent())));
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(indexManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
