package co.uniquindio.prog3.subastasquindio.modelo;

import java.io.Serializable;

public class Puja implements Serializable {

    double valorPuja;
    Anuncio anuncio;
    Comprador comprador;
    int idPuja;

    public Puja() {
    }

    public double getValorPuja() {
        return valorPuja;
    }

    public void setValorPuja(double valorPuja) {
        this.valorPuja = valorPuja;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public int getIdPuja() {
        return idPuja;
    }

    public void setIdPuja(int idPuja) {
        this.idPuja = idPuja;
    }
}
