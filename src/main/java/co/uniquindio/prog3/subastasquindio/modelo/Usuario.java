package co.uniquindio.prog3.subastasquindio.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

    static ArrayList<Usuario> usuarios = new ArrayList<>();
    String correo;
    String nombre;
    String contrasena;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String contrasena){
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
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
