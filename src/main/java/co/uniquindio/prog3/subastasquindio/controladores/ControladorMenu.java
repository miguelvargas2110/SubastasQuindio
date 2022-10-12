package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.aplicacion.Aplicacion;

public class ControladorMenu {

    Aplicacion aplicacion = new Aplicacion();



    public void onActionAnuncios(){
        aplicacion.Anuncio();
    }

    public void onActionLogin(){
       aplicacion.Login();
    }

    public void onActionPujas(){
        aplicacion.Pujas();
    }

    public void onActionRegistro(){
        aplicacion.Registro();
    }

    public void onActionTransaccional() { aplicacion.Transaccional(); }

    public void onActionUsuarios() { aplicacion.Usuarios(); }
}