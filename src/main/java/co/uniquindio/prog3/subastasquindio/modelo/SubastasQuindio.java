package co.uniquindio.prog3.subastasquindio.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SubastasQuindio implements Serializable {

    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    ArrayList<Anuncio> listaAnuncios = new ArrayList<>();
    ArrayList<Puja> listaPujas = new ArrayList<>();
    Anunciante usuarioglobalAnunciante = null;
    Comprador usuarioglobalComprador = null;

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

    public Anunciante getUsuarioglobalAnunciante() {
        return usuarioglobalAnunciante;
    }

    public void setUsuarioglobalAnunciante(Anunciante usuarioglobalAnunciante) {
        this.usuarioglobalAnunciante = usuarioglobalAnunciante;
    }

    public Comprador getUsuarioglobalComprador() {
        return usuarioglobalComprador;
    }

    public void setUsuarioglobalComprador(Comprador usuarioglobalComprador) {
        this.usuarioglobalComprador = usuarioglobalComprador;
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

    public Anuncio crearAnuncio(String nombreAnunciante, String nombreAnuncio, String tipoProducto, String descripcion, String fechaCaducidad, Double valorInicial) {

        Anuncio anuncio = new Anuncio();

        anuncio.setNombreAnunciante(nombreAnunciante);
        anuncio.setNombreAnuncio(nombreAnuncio);
        anuncio.setTipoProducto(tipoProducto);
        anuncio.setDescripcion(descripcion);
        anuncio.setFechaPublicacion(String.valueOf(LocalDate.now()));
        anuncio.setFechaCaducidad(fechaCaducidad);
        anuncio.setValorInicial(valorInicial);
        anuncio.setEstadoAnuncio(true);

        return anuncio;
    }

    public void usuarioLogeado(String correo, String contrasena) {

        boolean flag = false;

        for(int i = 0; i < listaUsuarios.size() && !flag; i++){
            System.out.println(listaUsuarios.get(i).getClass().getSimpleName());
            if(listaUsuarios.get(i).getCorreo().equals(correo) && listaUsuarios.get(i).getContrasena().equals(contrasena)){
                if(listaUsuarios.get(i).getClass().getSimpleName().equals("Comprador")){
                    setUsuarioglobalComprador((Comprador) listaUsuarios.get(i));
                }else{
                    setUsuarioglobalAnunciante((Anunciante) listaUsuarios.get(i));
                }
                flag = true;
            }
        }
    }

    public void guardarAnuncio(Anuncio anuncio, String nombreUsuario) {

        for(int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getNombre().equals(nombreUsuario)){
                Anunciante anunciante = (Anunciante) listaUsuarios.get(i);
                anunciante.getAnuncios().add(anuncio);
                listaUsuarios.set(i, anunciante);
            }
        }

    }
}
