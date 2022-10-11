package co.uniquindio.prog3.subastasquindio.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class SubastasQuindio implements Serializable {

    ArrayList<Usuario> listaUsuarios;
    ArrayList<Anuncio> listaAnuncios;

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
}
