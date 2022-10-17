package co.uniquindio.prog3.subastasquindio.controladores;


import co.uniquindio.prog3.subastasquindio.modelo.Anunciante;
import co.uniquindio.prog3.subastasquindio.modelo.Comprador;
import co.uniquindio.prog3.subastasquindio.modelo.SubastasQuindio;

import co.uniquindio.prog3.subastasquindio.modelo.Usuario;
import co.uniquindio.prog3.subastasquindio.persistencia.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorModelFactory {

    private static ControladorModelFactory instancia;

    SubastasQuindio subastasQuindio = new SubastasQuindio();


    //------------------------------  Singleton ------------------------------------------------
    public static ControladorModelFactory getInstance(){
        if(instancia == null){
            instancia = new ControladorModelFactory();
        }
        return instancia;
    }

    private ControladorModelFactory() {

        cargarDatosDesdeArchivos();

        if(Persistencia.cargarRecursoSubastasQuindioXML() == null) {
            System.out.println("es null");
            guardarResourceXML();
            cargarResourceXML();
        }else{
            cargarResourceXML();
            guardarResourceXML();
        }

    }

   public void guardarRegistroLog(String mensaje, int nivel, String accion){
       Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }
//
//    public void guardarEstudianteArchivo(Estudiante estudiante) throws IOException {
//        universidad.getEstudiantes().add(estudiante);
//        Persistencia.guardarEstudiantes(universidad.getEstudiantes());
//    }
//
//    public void guardarPrograma(Programa programa){
//        universidad.getProgramas().add(programa);
//        Persistencia.guardarRecursoUniversidadXML(universidad);
//    }
    private void cargarDatosDesdeArchivos() {

        try {

            Persistencia.cargarDatosArchivos(getSubastasQuindio());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//
    public void cargarResourceBinario() {

        subastasQuindio = Persistencia.cargarRecursoSubastasQuindioBinario();
    }
//
//
    public void guardarResourceBinario() {

        Persistencia.guardarRecursoSubastasQuindioBinario(subastasQuindio);
    }
//
//
    public void cargarResourceXML() {

        subastasQuindio = Persistencia.cargarRecursoSubastasQuindioXML();
    }


    public void guardarResourceXML() {

        Persistencia.guardarRecursoSubastasQuindioXML(subastasQuindio);
    }


    public SubastasQuindio getSubastasQuindio() {
        return subastasQuindio;
    }
//
public void setUniversidad(SubastasQuindio subastasQuindio) {
       this.subastasQuindio = subastasQuindio;
}
//
//
   public Usuario crearUsuario(String nombre, String correo, String contrasena, Anunciante anunciante) {

       Usuario usuario;

       usuario = getSubastasQuindio().crearUsuario(nombre, correo, contrasena, anunciante);

       return usuario;

   }

    public Usuario crearUsuario(String nombre, String correo, String contrasena, Comprador comprador) {

        Usuario usuario;

        usuario = getSubastasQuindio().crearUsuario(nombre, correo, contrasena, comprador);

        return usuario;

    }

    public void guardarUsuarioArchivo(Usuario usuario) throws IOException {

        subastasQuindio.getListaUsuarios().add(usuario);

        Persistencia.guardarUsuarios(subastasQuindio.getListaUsuarios());

        Persistencia.guardarRecursoSubastasQuindioXML(subastasQuindio);

    }
//
//    public Programa crearPrograma(String nombre, String documento, String modalidad){
//        Programa programa;
//        programa = getUniversidad().crearPrograma(nombre, documento, modalidad);
//        return programa;
//    }
//
//    public Estudiante buscarEstudiante(String codigo) {
//        Estudiante estudiante = getUniversidad().buscarEstudiante(codigo);
//        return estudiante;
//    }
//
//    public Programa buscarPrograma(String codigo) {
//        Programa programa = getUniversidad().buscarPrograma(codigo);
//        return programa;
//    }
//
}

