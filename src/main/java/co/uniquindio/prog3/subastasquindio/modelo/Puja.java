package co.uniquindio.prog3.subastasquindio.modelo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.Serializable;

public class Puja implements Serializable {

    public SimpleDoubleProperty valorPuja = new SimpleDoubleProperty();
    public SimpleObjectProperty<Anuncio> anuncio = new SimpleObjectProperty<Anuncio>();
    public SimpleObjectProperty<Comprador> comprador = new SimpleObjectProperty<Comprador>();
    public SimpleIntegerProperty idPuja = new SimpleIntegerProperty();

    public Puja() {
    }

    public double getValorPuja() {
        return valorPuja.get();
    }

    public void setValorPuja(double valorPuja) {
        this.valorPuja.set(valorPuja);
    }

    public Anuncio getAnuncio() {
        return anuncio.get();
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio.set(anuncio);
    }

    public Comprador getComprador() {
        return comprador.get();
    }

    public void setComprador(Comprador comprador) {
        this.comprador.set(comprador);
    }

    public int getIdPuja() {
        return idPuja.get();
    }

    public void setIdPuja(int idPuja) {
        this.idPuja.set(idPuja);
    }
}
