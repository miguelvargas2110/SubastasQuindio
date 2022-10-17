package co.uniquindio.prog3.subastasquindio.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class SubastasQuindio implements Serializable {

    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    ArrayList<Anuncio> listaAnuncios = new ArrayList<>();
    ArrayList<Puja> listaPujas = new ArrayList<>();

    public SubastasQuindio() {
    }

    public ArrayList<Usuario> getListaUsuarios() {

        return listaUsuarios;

    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {

        this.listaUsuarios = listaUsuarios;

    }

    public ArrayList<Anuncio> getListaAnuncios() {

        return listaAnuncios;

    }

    public void setListaAnuncios(ArrayList<Anuncio> listaAnuncios) {

        this.listaAnuncios = listaAnuncios;

    }

    public ArrayList<Puja> getListaPujas() {

        return listaPujas;

    }

    public void setListaPujas(ArrayList<Puja> pujas) {

        this.listaPujas = pujas;

    }

    public Usuario crearUsuario(String nombre, String correo, String contrasena, Anunciante anunciante) {

        Usuario usuario = new Usuario(nombre, correo, contrasena, anunciante);

        return usuario;

    }

    public Usuario crearUsuario(String nombre, String correo, String contrasena, Comprador comprador) {

        Usuario usuario = new Usuario(nombre, correo, contrasena, comprador);

        return usuario;

    }
}
