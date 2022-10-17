package co.uniquindio.prog3.subastasquindio.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

    public Anunciante crearAnunciante(String nombre, String correo, String contrasena) {

        Anunciante anunciante = new Anunciante();
        anunciante.setNombre(nombre);
        anunciante.setCorreo(correo);
        anunciante.setContrasena(contrasena);

        return anunciante;

    }

    public Comprador crearComprador(String nombre, String correo, String contrasena) {

        Comprador comprador = new Comprador();
        comprador.setNombre(nombre);
        comprador.setCorreo(correo);
        comprador.setContrasena(contrasena);

        return comprador;

    }

    public Anuncio crearAnuncio(String nombreAnuncio, String tipoProducto, String descripcion, String fechaCaducidad, Double valorInicial) {

        Anuncio anuncio = new Anuncio();

        anuncio.setNombreAnuncio(nombreAnuncio);
        anuncio.setTipoProducto(tipoProducto);
        anuncio.setDescripcion(descripcion);
        anuncio.setFechaPublicacion(String.valueOf(LocalDate.now()));
        anuncio.setFechaCaducidad(fechaCaducidad);
        anuncio.setValorInicial(valorInicial);
        anuncio.setEstadoAnuncio(true);

        return anuncio;
    }
}
