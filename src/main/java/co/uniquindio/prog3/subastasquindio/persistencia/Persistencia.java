package co.uniquindio.prog3.subastasquindio.persistencia;

import co.uniquindio.prog3.subastasquindio.excepciones.ExcepcionUsuario;
import co.uniquindio.prog3.subastasquindio.modelo.Anunciante;
import co.uniquindio.prog3.subastasquindio.modelo.SubastasQuindio;
import co.uniquindio.prog3.subastasquindio.modelo.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;

public class Persistencia {
    public static final String RUTA_ARCHIVO_USUARIOS = "src/main/java/co/uniquindio/prog3/subastasquindio/persistencia/archivoUsuarios.txt";
    public static final String RUTA_ARCHIVO_LOG = "src/resources/SubastasLog.txt";
    public static final String RUTA_ARCHIVO_OBJETOS = "src/resources/archivoObjetos.txt";
    public static final String RUTA_ARCHIVO_MODELO_SUBASTASQUINDIO_BINARIO = "src/resources/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_SUBASTASQUINDIO_XML = "src/resources/model.xml";




    public static void cargarDatosArchivos(SubastasQuindio subastasQuindio) throws FileNotFoundException, IOException {


        //cargar archivo de usuarios
        ArrayList<Usuario> usuariosCargados = cargarUsuarios();

        if(usuariosCargados.size() > 0)
            subastasQuindio.getListaUsuarios().addAll(usuariosCargados);


        /*cargar archivos empleados
        ArrayList<Empleado> empleadosCargados = cargarEmpleados();

        if(empleadosCargados.size() > 0)
            banco.getListaEmpleados().addAll(empleadosCargados);
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
            if(usuario.getAnunciante() == null){
                contenido += usuario.getNombre()+","+usuario.getCorreo()+","+usuario.getContrasena()+"," + usuario.getComprador() + "\n";
            }else{
                contenido += usuario.getNombre()+","+usuario.getCorreo()+","+usuario.getContrasena()+"," + usuario.getAnunciante() + "\n";
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
            Usuario usuario = new Usuario();
            usuario.setNombre(linea.split(",")[0]);
            usuario.setCorreo(linea.split(",")[1]);
            usuario.setContrasena(linea.split(",")[2]);
            usuarios.add(usuario);
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


    public static SubastasQuindio cargarRecursoBancoBinario() {

        SubastasQuindio subastasQuindio = null;

        try {
            subastasQuindio = (SubastasQuindio) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTASQUINDIO_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subastasQuindio;
    }

    public static void guardarRecursoBancoBinario(SubastasQuindio subastasQuindio) {

        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTASQUINDIO_BINARIO, subastasQuindio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static SubastasQuindio cargarRecursoBancoXML() {

        SubastasQuindio subastasQuindio = null;

        try {
            subastasQuindio = (SubastasQuindio) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTASQUINDIO_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subastasQuindio;

    }



    public static void guardarRecursoBancoXML(SubastasQuindio subastasQuindio) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTASQUINDIO_XML, subastasQuindio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }










}
