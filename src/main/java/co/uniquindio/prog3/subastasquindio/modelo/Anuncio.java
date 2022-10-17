package co.uniquindio.prog3.subastasquindio.modelo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Anuncio implements Serializable {

    public SimpleStringProperty nombreProducto = new SimpleStringProperty();
    public SimpleStringProperty descripcion = new SimpleStringProperty();
    public SimpleStringProperty tipoProducto = new SimpleStringProperty();
    public SimpleStringProperty foto = new SimpleStringProperty(); //o Image foto;
    public SimpleStringProperty nombreAnunciante = new SimpleStringProperty();
    public SimpleDateFormat fechaPublicacion = new SimpleDateFormat();
    public SimpleDateFormat fechaCaducidad = new SimpleDateFormat();
    public SimpleDoubleProperty valorInicial = new SimpleDoubleProperty();
    public SimpleBooleanProperty estadoAnuncio = new SimpleBooleanProperty();

    public Anuncio() {
    }

    public String getNombreProducto() {

        return nombreProducto.get();

    }

    public void setNombreProducto(String nombreProducto) {

        this.nombreProducto.set(nombreProducto);

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

    public SimpleDateFormat getFechaPublicacion() {

        return fechaPublicacion;

    }

    public void setFechaPublicacion(SimpleDateFormat fechaPublicacion) {

        this.fechaPublicacion = fechaPublicacion;

    }

    public SimpleDateFormat getFechaCaducidad() {

        return fechaCaducidad;

    }

    public void setFechaCaducidad(SimpleDateFormat fechaCaducidad) {

        this.fechaCaducidad = fechaCaducidad;

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
