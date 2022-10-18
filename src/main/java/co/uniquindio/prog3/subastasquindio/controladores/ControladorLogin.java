package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.aplicacion.Aplicacion;
import co.uniquindio.prog3.subastasquindio.excepciones.ExcepcionUsuario;
import co.uniquindio.prog3.subastasquindio.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static co.uniquindio.prog3.subastasquindio.persistencia.Persistencia.iniciarSesion;

public class ControladorLogin {

    private Stage stage;

    Aplicacion aplicacion = new Aplicacion();
    @FXML TextField correoUsuario;
    @FXML TextField contrasenaUsuario;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void onActionLogin() {

        try {
            ControladorModelFactory.getInstance().getSubastasQuindio().setUsuarioglobalComprador(null);
            ControladorModelFactory.getInstance().getSubastasQuindio().setUsuarioglobalAnunciante(null);
            iniciarSesion(correoUsuario.getText(), contrasenaUsuario.getText());
            ControladorModelFactory.getInstance().usuarioLogeado(correoUsuario.getText(), contrasenaUsuario.getText());
            ControladorModelFactory.getInstance().guardarRegistroLog("El usuario con correo " + correoUsuario.getText() + " ha iniciado sesion", 1, "iniciarSesion");
            aplicacion.MenuLogeado();
            stage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ExcepcionUsuario e) {
            ControladorModelFactory.getInstance().guardarRegistroLog("El ususario no esta registrado", 1, e.toString());
        }
    }
}
