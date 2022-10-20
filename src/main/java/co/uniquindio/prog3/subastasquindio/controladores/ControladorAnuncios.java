package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.excepciones.ExcepcionFechaAnuncioInvalida;
import co.uniquindio.prog3.subastasquindio.modelo.Anunciante;
import co.uniquindio.prog3.subastasquindio.modelo.Anuncio;
import co.uniquindio.prog3.subastasquindio.persistencia.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControladorAnuncios implements Initializable {

    ObservableList<String> opcionesChoiceBox = FXCollections.observableArrayList();
    ArrayList<String> tipoProductos = ControladorModelFactory.getInstance().cargarTipoProductos();
    @FXML private ChoiceBox cbTipoProducto;
    @FXML private TextField txtNombreAnuncio;
    @FXML private TextArea txtDescripcionAnuncio;
    @FXML private DatePicker txtFechaFinalizacionAnuncio;
    @FXML private TextField txtValorInicialAnuncio;
    @FXML private TableView<Anuncio> tablaAnuncios;
    @FXML private TableColumn columnaNombreAnuncio;
    @FXML private TableColumn columnaDescripcionAnuncio;
    @FXML private TableColumn columnaTipoProducto;
    @FXML private TableColumn columnaFechaInicio;
    @FXML private TableColumn columnaFechaFinalizacion;
    @FXML private TableColumn columnaValorInicial;
    @FXML private TableColumn columnaEstadoAnuncio;
    @FXML private Button btnPublicarAnuncio;
    @FXML private Button btnEditarAnuncio;
    @FXML private Button btnEliminarAnuncio;
    @FXML private Button btnCancelar;
    @FXML private Label lblAnuncio;

    ObservableList<Anuncio> anuncios;
    String nombreUsuario = ControladorModelFactory.getInstance().getSubastasQuindio().getUsuarioGlobalAnunciante().getNombre();

    public ControladorAnuncios() throws IOException {
    }

    @FXML private void PublicarAnuncio() throws ExcepcionFechaAnuncioInvalida, IOException {
        if(txtNombreAnuncio.getText() != "" && txtDescripcionAnuncio.getText() != "" && txtFechaFinalizacionAnuncio.getValue() != null && txtValorInicialAnuncio.getText() != ""){
            boolean ok = true;
            try {
                validarFecha(txtFechaFinalizacionAnuncio.getValue());
            }catch (ExcepcionFechaAnuncioInvalida e){
                ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en Fecha de anuncio" , 1, e.toString());
                lblAnuncio.setText("La fecha de finalizacion debe ser mayor a la fecha actual");
                ok = false;
            }
            try {
                Double.parseDouble(txtValorInicialAnuncio.getText());
            }
            catch (NumberFormatException e){
                lblAnuncio.setText("El valor inicial debe estar en numeros");
                ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en valor inicial" , 1, e.toString());
                ok = false;
            }
            if(ok){
                Anuncio anuncio = ControladorModelFactory.getInstance().crearAnuncio(nombreUsuario ,txtNombreAnuncio.getText(), cbTipoProducto.getValue().toString(), txtDescripcionAnuncio.getText(), txtFechaFinalizacionAnuncio.getValue().toString(), Double.valueOf(txtValorInicialAnuncio.getText()));
                ControladorModelFactory.getInstance().guardarAnuncio(anuncio, nombreUsuario);
                ControladorModelFactory.getInstance().guardarAnuncioArchivo(anuncio, nombreUsuario);
                lblAnuncio.setText("Se ha publicado el anuncio");
                ControladorModelFactory.getInstance().guardarRegistroLog("Se ha publicado el anuncio " + txtNombreAnuncio.getText(), 1, "guardarAnuncio");
                this.inicializarTabla();
                Cancelar();
            }
        }
    }

    private void validarFecha(LocalDate value) throws ExcepcionFechaAnuncioInvalida {
        if(value.isBefore(LocalDate.now())){
            throw new ExcepcionFechaAnuncioInvalida();
        }
    }

    @FXML private void EliminarAnuncio() throws IOException {

        Anuncio anuncioSeleccionado = getTablaAnuncioSeleccionado();

        ControladorModelFactory.getInstance().eliminarAnuncioArchivo(anuncioSeleccionado, nombreUsuario);

        lblAnuncio.setText("Se ha eliminado el anuncio");

        ControladorModelFactory.getInstance().guardarRegistroLog("Se ha eliminado el anuncio " + txtNombreAnuncio.getText(), 1, "eliminarAnuncio");

        this.inicializarTabla();

        Cancelar();
    }

    @FXML private void EditarAnuncio() throws IOException {

        Anuncio anuncioSeleccionado = getTablaAnuncioSeleccionado();

        if(txtNombreAnuncio.getText() != "" && txtDescripcionAnuncio.getText() != "" && txtFechaFinalizacionAnuncio.getValue() != null && txtValorInicialAnuncio.getText() != ""){
            if (anuncioSeleccionado.estadoAnuncio.getValue().equals(true)){
                boolean ok = true;
                try {
                    validarFecha(txtFechaFinalizacionAnuncio.getValue());
                }catch (ExcepcionFechaAnuncioInvalida e){
                    ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en Fecha de anuncio" , 1, e.toString());
                    lblAnuncio.setText("La fecha de finalizacion debe ser mayor a la fecha actual");
                    ok = false;
                }
                try {
                    Double.parseDouble(txtValorInicialAnuncio.getText());
                }
                catch (NumberFormatException e){
                    lblAnuncio.setText("El valor inicial debe estar en numeros");
                    ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion en valor inicial" , 1, e.toString());
                    ok = false;
                }
                if(ok) {
                    Anuncio anuncio = ControladorModelFactory.getInstance().crearAnuncio(nombreUsuario ,txtNombreAnuncio.getText(), cbTipoProducto.getValue().toString(), txtDescripcionAnuncio.getText(), txtFechaFinalizacionAnuncio.getValue().toString(), Double.valueOf(txtValorInicialAnuncio.getText()));
                    ControladorModelFactory.getInstance().editarAnuncioArchivo(anuncioSeleccionado, anuncio, nombreUsuario);
                    lblAnuncio.setText("Se ha editado el anuncio");
                    ControladorModelFactory.getInstance().guardarRegistroLog("Se ha editado el anuncio " + txtNombreAnuncio.getText(), 1, "editarAnuncio");
                    this.inicializarTabla();
                    Cancelar();
                }
            }
        }
    }

    @FXML private void Cancelar(){

        txtNombreAnuncio.setText("");
        cbTipoProducto.setValue(tipoProductos.get(0));
        txtDescripcionAnuncio.setText("");
        txtFechaFinalizacionAnuncio.setValue(null);
        txtValorInicialAnuncio.setText("");
        tablaAnuncios.getSelectionModel().clearSelection();

        btnPublicarAnuncio.setDisable(false);
        btnEditarAnuncio.setDisable(true);
        btnEliminarAnuncio.setDisable(true);

    }

    private void inicializarTabla() {

        anuncios = FXCollections.observableArrayList();
        anuncios.addAll(ControladorModelFactory.getInstance().getSubastasQuindio().getUsuarioGlobalAnunciante().getAnuncios());

        columnaNombreAnuncio.setCellValueFactory(new PropertyValueFactory<Anuncio, String>("nombreAnuncio"));
        columnaTipoProducto.setCellValueFactory(new PropertyValueFactory<Anuncio, String>("tipoProducto"));
        columnaDescripcionAnuncio.setCellValueFactory(new PropertyValueFactory<Anuncio, String>("descripcion"));
        columnaFechaInicio.setCellValueFactory(new PropertyValueFactory<Anuncio, String>("fechaPublicacion"));
        columnaFechaFinalizacion.setCellValueFactory(new PropertyValueFactory<Anuncio, String>("fechaCaducidad"));
        columnaValorInicial.setCellValueFactory(new PropertyValueFactory<Anuncio, Double>("valorInicial"));
        columnaEstadoAnuncio.setCellValueFactory(new PropertyValueFactory<Anuncio, Boolean>("estadoAnuncio"));

        tablaAnuncios.setItems(anuncios);

    }

    private final ListChangeListener<Anuncio> selectorTablaAnuncios = new ListChangeListener<Anuncio>() {

        @Override
        public void onChanged(Change<? extends Anuncio> c) {

            try {
                ponerAnuncioSeleccionado();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }

    };

    public Anuncio getTablaAnuncioSeleccionado() {

        if (tablaAnuncios != null) {

            List<Anuncio> tabla = tablaAnuncios.getSelectionModel().getSelectedItems();

            if (tabla.size() == 1) {

                final Anuncio anuncioSeleccionado = tabla.get(0);

                return anuncioSeleccionado;

            }

        }

        return null;

    }

    private void ponerAnuncioSeleccionado() throws ParseException {

        final Anuncio anuncio = getTablaAnuncioSeleccionado();

        if (anuncio != null) {

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(anuncio.getFechaCaducidad());

            txtNombreAnuncio.setText(anuncio.getNombreAnuncio());
            cbTipoProducto.setValue(anuncio.getTipoProducto());
            txtDescripcionAnuncio.setText(anuncio.getDescripcion());
            txtFechaFinalizacionAnuncio.setValue(LocalDate.parse(formato.format(fecha)));
            txtValorInicialAnuncio.setText(String.valueOf(anuncio.getValorInicial()));

            btnPublicarAnuncio.setDisable(true);
            btnEditarAnuncio.setDisable(false);
            btnEliminarAnuncio.setDisable(false);

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0; i < tipoProductos.size(); i++) {

            opcionesChoiceBox.add(tipoProductos.get(i));

        }

        cbTipoProducto.setValue(tipoProductos.get(0));
        cbTipoProducto.setItems(opcionesChoiceBox);

        this.inicializarTabla();

        final ObservableList<Anuncio> tablaAnuncioSel = tablaAnuncios.getSelectionModel().getSelectedItems();
        tablaAnuncioSel.addListener(selectorTablaAnuncios);

        btnEditarAnuncio.setDisable(true);
        btnEliminarAnuncio.setDisable(true);
    }
}
