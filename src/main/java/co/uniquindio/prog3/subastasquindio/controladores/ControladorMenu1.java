package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.aplicacion.Aplicacion;
import co.uniquindio.prog3.subastasquindio.modelo.Anuncio;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControladorMenu1 implements Initializable {

    Aplicacion aplicacion = new Aplicacion();

    @FXML
    private TableView<Anuncio> tablaAnunciosMenu;
    @FXML private TableColumn columnaNombreAnuncio;
    @FXML private TableColumn columnaNombreAnunciante;
    @FXML private TableColumn columnaFechaInicio;
    @FXML private TableColumn columnaFechaFinalizacion;
    @FXML private TableColumn columnaValorInicial;

    ObservableList<Anuncio> anuncios;

    private Stage stage;


    public void onActionLogin(){
       aplicacion.Login();
    }

    public void onActionRegistro(){
        aplicacion.Registro();
    }

    public void onActionRefrescar(){inicializarTabla();}

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    private void inicializarTabla() {

        anuncios = FXCollections.observableArrayList();
        if(ControladorModelFactory.getInstance().getSubastasQuindio().getListaAnuncios() != null){
            anuncios.addAll(ControladorModelFactory.getInstance().getSubastasQuindio().getListaAnuncios());
        }

        columnaNombreAnuncio.setCellValueFactory(new PropertyValueFactory<Anuncio, String>("nombreAnuncio"));
        columnaNombreAnunciante.setCellValueFactory(new PropertyValueFactory<Anuncio, String>("nombreAnunciante"));
        columnaFechaInicio.setCellValueFactory(new PropertyValueFactory<Anuncio, String>("fechaPublicacion"));
        columnaFechaFinalizacion.setCellValueFactory(new PropertyValueFactory<Anuncio, String>("fechaCaducidad"));
        columnaValorInicial.setCellValueFactory(new PropertyValueFactory<Anuncio, Double>("valorInicial"));

        tablaAnunciosMenu.setItems(anuncios);

    }

    private final ListChangeListener<Anuncio> selectorTablaAnuncios = new ListChangeListener<Anuncio>() {

        @Override
        public void onChanged(Change<? extends Anuncio> c) {
            if(getTablaAnuncioSeleccionado() != null){
                ControladorModelFactory.getInstance().getSubastasQuindio().setAnuncioGlobal(getTablaAnuncioSeleccionado());
                tablaAnunciosMenu.getSelectionModel().clearSelection();
                aplicacion.Transaccional();
            }
        }
    };

    public Anuncio getTablaAnuncioSeleccionado() {

        if (tablaAnunciosMenu != null) {

            List<Anuncio> tabla = tablaAnunciosMenu.getSelectionModel().getSelectedItems();

            if (tabla.size() == 1) {

                final Anuncio anuncioSeleccionado = tabla.get(0);

                return anuncioSeleccionado;

            }

        }

        return null;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.inicializarTabla();

        final ObservableList<Anuncio> tablaAnuncioSel = tablaAnunciosMenu.getSelectionModel().getSelectedItems();
        tablaAnuncioSel.addListener(selectorTablaAnuncios);
    }
}