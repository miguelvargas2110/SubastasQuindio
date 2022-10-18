package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.aplicacion.Aplicacion;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorMenu {

    private Stage stage;

    Aplicacion aplicacion = new Aplicacion();

    public void onActionAnuncios(){
        aplicacion.Anuncio();
    }

    public void onActionLogin(){
        aplicacion.Login();

    }

    public void onActionPujas(){
        aplicacion.Pujas();
    }

    public void onActionRegistro(){
        aplicacion.Registro();
    }

    public void onActionTransaccional() { aplicacion.Transaccional(); }

    public void onActionUsuarios() { aplicacion.Usuarios(); }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}