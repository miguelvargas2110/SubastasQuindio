package co.uniquindio.prog3.subastasquindio.controladores;


import co.uniquindio.prog3.subastasquindio.modelo.SubastasQuindio;

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
        guardarResourceBinario();
        cargarResourceBinario();
        cargarResourceXML();
        guardarResourceXML();
        //4. Guardar y Cargar el recurso serializable XML
        //Siempre se debe verificar si la raiz del recurso es null
        if(subastasQuindio == null) {
            System.out.println("es null");
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

        subastasQuindio = Persistencia.cargarRecursoBancoBinario();
    }
//
//
    public void guardarResourceBinario() {

        Persistencia.guardarRecursoBancoBinario(subastasQuindio);
    }
//
//
    public void cargarResourceXML() {

        subastasQuindio = Persistencia.cargarRecursoBancoXML();
    }


    public void guardarResourceXML() {

        Persistencia.guardarRecursoBancoXML(subastasQuindio);
    }


    public SubastasQuindio getSubastasQuindio() {
        return subastasQuindio;
    }
//
//    public void setUniversidad(Universidad universidad) {
//        this.universidad = universidad;
//    }
//
//
//    public Estudiante crearEstudiante(String nombre, String codigo, ArrayList<Double> notas) {
//
//
//        Estudiante estudiante;
//
//        estudiante = getUniversidad().crearEstudiante(nombre, codigo, notas);
//
//
//        return estudiante;
//
//    }
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

