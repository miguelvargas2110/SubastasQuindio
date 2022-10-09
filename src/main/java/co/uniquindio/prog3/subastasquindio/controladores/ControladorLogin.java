package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.excepciones.ExcepcionUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

import static co.uniquindio.prog3.subastasquindio.persistencia.Persistencia.iniciarSesion;

public class ControladorLogin {


    @FXML TextField correoUsuario;
    @FXML TextField contrasenaUsuario;
    @FXML
    public void onActionLogin() {

        try {
            iniciarSesion(correoUsuario.getText(), contrasenaUsuario.getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ExcepcionUsuario e) {
            throw new RuntimeException(e);
        }
    }
}