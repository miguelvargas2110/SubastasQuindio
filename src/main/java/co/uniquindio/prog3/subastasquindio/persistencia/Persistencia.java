package co.uniquindio.prog3.subastasquindio.persistencia;

import co.uniquindio.prog3.subastasquindio.excepciones.ExcepcionUsuario;
import co.uniquindio.prog3.subastasquindio.modelo.Anunciante;
import co.uniquindio.prog3.subastasquindio.modelo.Comprador;
import co.uniquindio.prog3.subastasquindio.modelo.SubastasQuindio;
import co.uniquindio.prog3.subastasquindio.modelo.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;

public class Persistencia {
    public static final String RUTA_ARCHIVO_USUARIOS = "src/main/resources/flujoDatos/archivoUsuarios.txt";
    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/flujoDatos/SubastasLog.txt";
    public static final String RUTA_ARCHIVO_OBJETOS = "src/main/resources/flujoDatos/archivoObjetos.txt";
    public static final String RUTA_ARCHIVO_MODELO_SUBASTASQUINDIO_BINARIO = "src/main/resources/flujoDatos/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_SUBASTASQUINDIO_XML = "src/main/resources/flujoDatos/model.xml";




    public static void cargarDatosArchivos(SubastasQuindio subastasQuindio) throws FileNotFoundException, IOException {


        //cargar archivo de usuarios
        ArrayList<Usuario> usuariosCargados = cargarUsuarios();

        if(usuariosCargados.size() > 0)
            subastasQuindio.getListaUsuarios().addAll(usuariosCargados);


        /*cargar archivos empleados
        ArrayList<Empleado> empleadosCargados = cargarEmpleados();

        if(empleadosCargados.size() > 0)
            SubastasQuindio.getListaEmpleados().addAll(empleadosCargados);
        */
        //cargar archivo objetos

        //cargar archivo empleados

        //cargar archivo prestamo

    }





    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param listaUsuarios
     * @throws IOException
     */
    public static void guardarUsuarios(ArrayList<Usuario> listaUsuarios) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";

        for(Usuario usuario:listaUsuarios)
        {
            if(usuario.getClass().getSimpleName() == "Anunciante"){
                contenido += usuario.getNombre()+","+usuario.getCorreo()+","+usuario.getContrasena()+",Comprador," + listaUsuarios.indexOf(usuario) + "\n";
            }else{
                contenido += usuario.getNombre()+","+usuario.getCorreo()+","+usuario.getContrasena()+",Anunciante," + listaUsuarios.indexOf(usuario) + "\n";
            }

        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, false);

    }


//	----------------------LOADS------------------------

    /**
     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<Usuario> cargarUsuarios() throws FileNotFoundException, IOException
    {
        ArrayList<Usuario> usuarios =new ArrayList<Usuario>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_USUARIOS);
        String linea="";

        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);
            if(linea.split(",")[3] == "Anunciante"){
                Anunciante anunciante = new Anunciante();
                anunciante.setNombre(linea.split(",")[0]);
                anunciante.setCorreo(linea.split(",")[1]);
                anunciante.setContrasena(linea.split(",")[2]);
                usuarios.add(anunciante);
            }else{
                Comprador comprador = new Comprador();
                comprador.setNombre(linea.split(",")[0]);
                comprador.setCorreo(linea.split(",")[1]);
                comprador.setContrasena(linea.split(",")[2]);
                usuarios.add(comprador);
            }
        }
        return usuarios;
    }


    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {

        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }


    public static boolean iniciarSesion(String correo, String contrasena) throws IOException, ExcepcionUsuario {

        if(validarUsuario(correo,contrasena)) {
            return true;
        }else {
            throw new ExcepcionUsuario("Usuario no existe");
        }

    }

    private static boolean validarUsuario(String correo, String contrasena) throws IOException
    {
        ArrayList<Usuario> usuarios = Persistencia.cargarUsuarios();

        for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++)
        {
            Usuario usuarioAux = usuarios.get(indiceUsuario);
            if(usuarioAux.getCorreo().equalsIgnoreCase(correo) && usuarioAux.getContrasena().equalsIgnoreCase(contrasena)) {
                return true;
            }
        }
        return false;
    }


//	----------------------SAVES------------------------

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param listaUsuarios
     * @throws IOException
     */

    public static void guardarObjetos(ArrayList<Usuario> listaUsuarios) throws IOException  {
        String contenido = "";

        for(Usuario usuarioAux:listaUsuarios) {
            contenido+= usuarioAux.getNombre()+","+usuarioAux.getCorreo()+","+usuarioAux.getContrasena()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_OBJETOS , contenido, true);
    }





    //------------------------------------SERIALIZACIÓN  y XML


    public static SubastasQuindio cargarRecursoSubastasQuindioBinario() {

        SubastasQuindio subastasQuindio = null;

        try {
            subastasQuindio = (SubastasQuindio) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTASQUINDIO_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subastasQuindio;
    }

    public static void guardarRecursoSubastasQuindioBinario(SubastasQuindio subastasQuindio) {

        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTASQUINDIO_BINARIO, subastasQuindio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static SubastasQuindio cargarRecursoSubastasQuindioXML() {

        SubastasQuindio subastasQuindio = null;

        try {
            subastasQuindio = (SubastasQuindio) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTASQUINDIO_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subastasQuindio;

    }



    public static void guardarRecursoSubastasQuindioXML(SubastasQuindio subastasQuindio) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTASQUINDIO_XML, subastasQuindio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
