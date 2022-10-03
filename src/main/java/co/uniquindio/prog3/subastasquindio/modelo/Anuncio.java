package co.uniquindio.prog3.subastasquindio.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Anuncio implements Serializable {

    TipoProducto tipoProducto;
    String nombreProducto;
    String descripcion;
    String foto; //o Image foto;
    String nombreAnunciante;
    Date fechaPublicacion;
    Date fechaCaducidad;
    double valorInicial;
    boolean estadoAnuncio;
    ArrayList<Puja> listaPujas;

    public Anuncio() {
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombreAnunciante() {
        return nombreAnunciante;
    }

    public void setNombreAnunciante(String nombreAnunciante) {
        this.nombreAnunciante = nombreAnunciante;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public boolean isEstadoAnuncio() {
        return estadoAnuncio;
    }

    public void setEstadoAnuncio(boolean estadoAnuncio) {
        this.estadoAnuncio = estadoAnuncio;
    }

    public ArrayList<Puja> getListaPujas() {
        return listaPujas;
    }

    public void setListaPujas(ArrayList<Puja> listaPujas) {
        this.listaPujas = listaPujas;
    }
}
