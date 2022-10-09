package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.modelo.Anunciante;
import co.uniquindio.prog3.subastasquindio.modelo.Comprador;
import co.uniquindio.prog3.subastasquindio.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


import java.io.IOException;

import static co.uniquindio.prog3.subastasquindio.persistencia.Persistencia.guardarUsuarios;

public class ControladorRegistro {

    @FXML
    TextField nombreUsuario;
    @FXML TextField correoUsuario;
    @FXML PasswordField contrasenaUsuario;
    @FXML RadioButton rbAnunciante;
    @FXML RadioButton rbComprador;

    public void onActionRegistrarse() throws IOException {
        crearCliente();
    }

    public void crearCliente() throws IOException {

        if (nombreUsuario.getText() != "" || contrasenaUsuario.getText() != "" || contrasenaUsuario.getText() != "" && !rbAnunciante.isSelected() && !rbComprador.isSelected()) {
            if(rbAnunciante.isSelected()){
                Usuario.getArrayListUsuarios().add(new Usuario(nombreUsuario.getText(), correoUsuario.getText(), contrasenaUsuario.getText(), new Anunciante()));
                guardarUsuarios(Usuario.getArrayListUsuarios());
            }else{
                Usuario.getArrayListUsuarios().add(new Usuario(nombreUsuario.getText(), correoUsuario.getText(), contrasenaUsuario.getText(), new Comprador()));
                guardarUsuarios(Usuario.getArrayListUsuarios());
            }

        }
    }
}
