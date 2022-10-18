package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.aplicacion.Aplicacion;
import javafx.stage.Stage;

public class ControladorMenu1 {

    Aplicacion aplicacion = new Aplicacion();

    private Stage stage;


    public void onActionLogin(){
       aplicacion.Login();
    }

    public void onActionRegistro(){
        aplicacion.Registro();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}