package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.aplicacion.Aplicacion;
import co.uniquindio.prog3.subastasquindio.modelo.Anunciante;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorMenuLogueado implements Initializable {

    Aplicacion aplicacion = new Aplicacion();

    @FXML
    Button nombreCrud;
    @FXML
    Label nombreUsuario;

    @FXML private void cambiarNombresGUI(){
        if (ControladorModelFactory.getInstance().getSubastasQuindio().getUsuarioglobalComprador() != null){
            nombreUsuario.setText(ControladorModelFactory.getInstance().getSubastasQuindio().getUsuarioglobalComprador().getNombre());
            nombreCrud.setText("Pujas");
        }else{
            nombreUsuario.setText(ControladorModelFactory.getInstance().getSubastasQuindio().getUsuarioglobalAnunciante().getNombre());
            nombreCrud.setText("Anuncios");
        }

    }

    @FXML private void abrir(){
        if (ControladorModelFactory.getInstance().getSubastasQuindio().getUsuarioglobalComprador() != null){
            aplicacion.Pujas();
        }else{
            aplicacion.Anuncio();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cambiarNombresGUI();
    }
}