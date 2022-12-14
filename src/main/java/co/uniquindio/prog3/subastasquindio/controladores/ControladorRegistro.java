package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.aplicacion.Aplicacion;
import co.uniquindio.prog3.subastasquindio.excepciones.*;
import co.uniquindio.prog3.subastasquindio.modelo.Anunciante;
import co.uniquindio.prog3.subastasquindio.modelo.Comprador;
import co.uniquindio.prog3.subastasquindio.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;


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
    Stage stage;
    Aplicacion aplicacion = new Aplicacion();
    private int validarContraseña = 0;

    public void onActionRegistrarse() throws IOException {
        crearCliente();
    }

    @FXML private void crearCliente() throws IOException {

        if (nombreUsuario.getText() != "" && contrasenaUsuario.getText() != "" && contrasenaUsuario.getText() != "" && !rbAnunciante.isSelected() && !rbComprador.isSelected()) {
            boolean ok = true;
            if(rbAnunciante.isSelected()){
                try {
                    validarEmail(correoUsuario.getText());
                }catch (ExcepcionEmail e){
                    lblRegistro.setText("la sintaxis del correo es invalida, verifique que tenga el formato ´example@example.com´");
                    ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en email", 2, e.toString());
                    ok = false;
                }
                try {
                    validarUsuario(nombreUsuario.getText());
                }catch (ExcepcionNombreUsuarioInvalido e){
                    lblRegistro.setText("El nombre de usuario es muy corto, debe superar los 8 caracteres");
                    ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en nombre de usuario", 2, e.toString());
                    ok = false;
                }try{
                    validarContrasena(contrasenaUsuario.getText(), nombreUsuario.getText());
                } catch (ExcepcionContraseña e){
                    if(validarContraseña == 1){
                        lblRegistro.setText("La contraseña no puede ser igual que el nombre de usuario");
                        ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en contraseña" , 2, e.toString());
                        ok = false;
                    }else{
                        lblRegistro.setText("La contraseña es muy corta, debe superar los 8 caracteres");
                        ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en contraseña" , 2, e.toString());
                        ok = false;
                    }
                }
                if(ok){
                    Usuario usuario = ControladorModelFactory.getInstance().crearAnunciante(nombreUsuario.getText(), correoUsuario.getText(), contrasenaUsuario.getText());
                    ControladorModelFactory.getInstance().guardarUsuarioArchivo(usuario);
                    ControladorModelFactory.getInstance().guardarRegistroLog("Se ha guardado el usuario " + nombreUsuario.getText(), 1, "guardarUsuario");
                    aplicacion.Login();
                    stage.close();
                }
            }else{
                try {
                    validarEmail(correoUsuario.getText());
                }catch (ExcepcionEmail e){
                    lblRegistro.setText("la sintaxis del correo es invalida, verifique que tenga el formato ´example@example.com´");
                    ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en email", 2, e.toString());
                    ok = false;
                }
                try {
                    validarUsuario(nombreUsuario.getText());
                }catch (ExcepcionNombreUsuarioInvalido e){
                    lblRegistro.setText("El nombre de usuario es muy corto, debe superar los 8 caracteres");
                    ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en nombre de usuario", 2, e.toString());
                    ok = false;
                }try{
                    validarContrasena(contrasenaUsuario.getText(), nombreUsuario.getText());
                } catch (ExcepcionContraseña e){
                    if(validarContraseña == 1){
                        lblRegistro.setText("La contraseña no puede ser igual que el nombre de usuario");
                        ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en contraseña" , 2, e.toString());
                        ok = false;
                    }else{
                        lblRegistro.setText("La contraseña es muy corta, debe superar los 8 caracteres");
                        ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en contraseña" , 2, e.toString());
                        ok = false;
                    }

                }
                if(ok){
                    Usuario usuario = ControladorModelFactory.getInstance().crearComprador(nombreUsuario.getText(), correoUsuario.getText(), contrasenaUsuario.getText());
                    ControladorModelFactory.getInstance().guardarUsuarioArchivo(usuario);
                    ControladorModelFactory.getInstance().guardarRegistroLog("Se ha guardado el usuario " + nombreUsuario.getText(), 1, "guardarUsuario");
                    aplicacion.Login();
                    stage.close();
                }
            }

        }
    }
    private void validarEmail(String email) throws ExcepcionEmail {
        if (!email.contains("@")){
            throw new ExcepcionArrobaEmail();
        } else if (!email.contains(".")) {
            throw new ExcepcionPuntoEmail();
        }
    }
    private void validarUsuario (String nombreUsuario) throws ExcepcionNombreUsuarioInvalido{
        if (nombreUsuario.length()<8){
            throw new ExcepcionNombreUsuarioInvalido();
        }
    }
    private void validarContrasena (String contrasena, String nombreUsuario) throws ExcepcionContraseña{
        if(contrasena.length() < 8) {
            if (contrasena.equals(nombreUsuario)) {
                validarContraseña = 1;
                throw new ExcepcionContraseña();
            } else {
                validarContraseña = 2;
                throw new ExcepcionContraseña();
            }
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}