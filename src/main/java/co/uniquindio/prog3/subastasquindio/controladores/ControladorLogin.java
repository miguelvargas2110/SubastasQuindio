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
            ControladorModelFactory.getInstance().guardarRegistroLog("El usuario con correo " + correoUsuario.getText() + " ha iniciado sesion", 1, "iniciarSesion");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ExcepcionUsuario e) {
            ControladorModelFactory.getInstance().guardarRegistroLog("El ususario no esta registrado", 1, e.toString());
        }
    }
}
