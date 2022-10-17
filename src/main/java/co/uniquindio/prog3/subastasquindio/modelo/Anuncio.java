package co.uniquindio.prog3.subastasquindio.modelo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Anuncio implements Serializable {

    public SimpleStringProperty nombreAnuncio = new SimpleStringProperty();
    public SimpleStringProperty descripcion = new SimpleStringProperty();
    public SimpleStringProperty tipoProducto = new SimpleStringProperty();
    public SimpleStringProperty foto = new SimpleStringProperty(); //o Image foto;
    public SimpleStringProperty nombreAnunciante = new SimpleStringProperty();
    public SimpleStringProperty fechaPublicacion = new SimpleStringProperty();
    public SimpleStringProperty fechaCaducidad = new SimpleStringProperty();
    public SimpleDoubleProperty valorInicial = new SimpleDoubleProperty();
    public SimpleBooleanProperty estadoAnuncio = new SimpleBooleanProperty();

    public Anuncio() {
    }

    public String getNombreAnuncio() {

        return nombreAnuncio.get();

    }

    public void setNombreAnuncio(String nombreProducto) {

        this.nombreAnuncio.set(nombreProducto);

    }

    public String getDescripcion() {

        return descripcion.get();

    }

    public void setDescripcion(String descripcion) {

        this.descripcion.set(descripcion);

    }

    public String getTipoProducto() {

        return tipoProducto.get();

    }

    public void setTipoProducto(String tipoProducto) {

        this.tipoProducto.set(tipoProducto);

    }

    public String getFoto() {

        return foto.get();

    }

    public void setFoto(String foto) {

        this.foto.set(foto);

    }

    public String getNombreAnunciante() {

        return nombreAnunciante.get();

    }

    public void setNombreAnunciante(String nombreAnunciante) {

        this.nombreAnunciante.set(nombreAnunciante);

    }

    public String getFechaPublicacion() {

        return fechaPublicacion.get();

    }

    public void setFechaPublicacion(String fechaPublicacion) {

        this.fechaPublicacion.set(fechaPublicacion);

    }

    public String getFechaCaducidad() {

        return fechaCaducidad.get();

    }

    public void setFechaCaducidad(String fechaCaducidad) {

        this.fechaCaducidad.set(fechaCaducidad);

    }

    public double getValorInicial() {

        return valorInicial.get();

    }

    public void setValorInicial(double valorInicial) {

        this.valorInicial.set(valorInicial);

    }

    public boolean getEstadoAnuncio() {

        return estadoAnuncio.get();

    }

    public void setEstadoAnuncio(boolean estadoAnuncio) {

        this.estadoAnuncio.set(estadoAnuncio);

    }
}
