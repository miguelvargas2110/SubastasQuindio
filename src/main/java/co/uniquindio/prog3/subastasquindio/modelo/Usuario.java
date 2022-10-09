package co.uniquindio.prog3.subastasquindio.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

    static ArrayList<Usuario> usuarios = new ArrayList<>();
    String correo;
    String nombre;
    String contrasena;

    Anunciante anunciante;

    Comprador comprador;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String contrasena, Anunciante anunciante){
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.anunciante = anunciante;
    }

    public Usuario(String nombre, String correo, String contrasena, Comprador comprador){
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.comprador = comprador;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        Usuario.usuarios = usuarios;
    }

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public static ArrayList<Usuario> getArrayListUsuarios(){return usuarios;}
}
