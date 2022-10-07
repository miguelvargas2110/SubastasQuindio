package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;

import static co.uniquindio.prog3.subastasquindio.persistencia.Persistencia.guardarUsuarios;

public class controladorRegistro {

    @FXML
    TextField nombreUsuario;
    @FXML TextField correoUsuario;
    @FXML PasswordField contrasenaUsuario;

    public void onActionRegistrarse() throws IOException {
        crearCliente();
    }

    public void crearCliente() throws IOException {

        if (nombreUsuario.getText() != "" || contrasenaUsuario.getText() != "" || contrasenaUsuario.getText() != "") {
            Usuario.getArrayListUsuarios().add(new Usuario(nombreUsuario.getText(), correoUsuario.getText(), contrasenaUsuario.getText()));
            guardarUsuarios(Usuario.getArrayListUsuarios());
        }
    }
}
