package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.excepciones.ExcepcionArrobaEmail;
import co.uniquindio.prog3.subastasquindio.excepciones.ExcepcionEmail;
import co.uniquindio.prog3.subastasquindio.excepciones.ExcepcionPuntoEmail;
import co.uniquindio.prog3.subastasquindio.modelo.Anunciante;
import co.uniquindio.prog3.subastasquindio.modelo.Comprador;
import co.uniquindio.prog3.subastasquindio.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.io.IOException;

import static co.uniquindio.prog3.subastasquindio.persistencia.Persistencia.guardarUsuarios;

public class ControladorRegistro {

    @FXML
    TextField nombreUsuario;
    @FXML TextField correoUsuario;
    @FXML PasswordField contrasenaUsuario;
    @FXML RadioButton rbAnunciante;
    @FXML RadioButton rbComprador;
    @FXML Label lblRegistro;

    public void onActionRegistrarse() throws IOException {
        crearCliente();
    }

    @FXML private void crearCliente() throws IOException {

        if (nombreUsuario.getText() != "" || contrasenaUsuario.getText() != "" || contrasenaUsuario.getText() != "" && !rbAnunciante.isSelected() && !rbComprador.isSelected()) {
            if(rbAnunciante.isSelected()){
                try {
                    validarEmail(correoUsuario.getText());
                }catch (ExcepcionEmail e){
                    lblRegistro.setText("la sintaxis del correo es invalida, verifique que tenga el formato ´example@example.com´");
                    ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en email", 1, e.toString());
                }
                Usuario usuario = ControladorModelFactory.getInstance().crearUsuario(nombreUsuario.getText(), correoUsuario.getText(), contrasenaUsuario.getText(), new Anunciante());
                ControladorModelFactory.getInstance().guardarUsuarioArchivo(usuario);
                ControladorModelFactory.getInstance().guardarRegistroLog("Se ha guardado el usuario" + nombreUsuario.getText(), 1, "guardarUsuario");
            }else{
                try {
                    validarEmail(correoUsuario.getText());
                }catch (ExcepcionEmail e){
                    lblRegistro.setText("la sintaxis del correo es invalida, verifique que tenga el formato ´example@example.com´");
                    ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en email", 1, e.toString());
                }
                Usuario usuario = ControladorModelFactory.getInstance().crearUsuario(nombreUsuario.getText(), correoUsuario.getText(), contrasenaUsuario.getText(), new Comprador());
                ControladorModelFactory.getInstance().guardarUsuarioArchivo(usuario);
                ControladorModelFactory.getInstance().guardarRegistroLog("Se ha guardado el usuario" + nombreUsuario.getText(), 1, "guardarUsuario");
            }

        }
    }
    @FXML private void validarEmail(String email) throws ExcepcionEmail {
        if (!email.contains("@")){
            throw new ExcepcionArrobaEmail();
        } else if (!email.contains(".")) {
            throw new ExcepcionPuntoEmail();
        }
    }
}
