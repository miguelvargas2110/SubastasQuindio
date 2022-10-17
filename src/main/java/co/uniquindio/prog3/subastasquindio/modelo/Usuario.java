package co.uniquindio.prog3.subastasquindio.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

    String correo = "";
    String nombre = "";
    String contrasena = "";
    Anunciante anunciante = new Anunciante();
    Comprador comprador = new Comprador();

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

}
