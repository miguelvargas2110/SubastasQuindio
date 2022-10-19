package co.uniquindio.prog3.subastasquindio.modelo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Puja implements Serializable {

    public SimpleDoubleProperty valorPuja = new SimpleDoubleProperty();
    public SimpleStringProperty nombreAnuncio = new SimpleStringProperty();
    public SimpleStringProperty nombreComprador = new SimpleStringProperty();
    public SimpleIntegerProperty idPuja = new SimpleIntegerProperty();

    public Puja() {
    }

    public double getValorPuja() {
        return valorPuja.get();
    }

    public void setValorPuja(double valorPuja) {
        this.valorPuja.set(valorPuja);
    }

    public String getNombreAnuncio() {
        return nombreAnuncio.get();
    }

    public SimpleStringProperty nombreAnuncioProperty() {
        return nombreAnuncio;
    }

    public void setNombreAnuncio(String nombreAnuncio) {
        this.nombreAnuncio.set(nombreAnuncio);
    }

    public String getNombreComprador() {
        return nombreComprador.get();
    }

    public SimpleStringProperty nombreCompradorProperty() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador.set(nombreComprador);
    }

    public int getIdPuja() {
        return idPuja.get();
    }

    public void setIdPuja(int idPuja) {
        this.idPuja.set(idPuja);
    }
}
