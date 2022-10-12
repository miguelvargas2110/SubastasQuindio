package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.aplicacion.Aplicacion;

public class ControladorMenu1 {

    Aplicacion aplicacion = new Aplicacion();


    public void onActionLogin(){
       aplicacion.Login();
    }

    public void onActionRegistro(){
        aplicacion.Registro();
    }

}