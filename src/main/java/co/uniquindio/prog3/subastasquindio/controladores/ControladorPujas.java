package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.excepciones.ExcepcionFechaAnuncioInvalida;
import co.uniquindio.prog3.subastasquindio.modelo.Anuncio;
import co.uniquindio.prog3.subastasquindio.modelo.Puja;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControladorPujas {

    @FXML private TextField txtValorPuja;
    @FXML private TableView<Puja> tablaPujas;
    @FXML private TableColumn columnaNombreAnuncio;
    @FXML private TableColumn columnaTipoProducto;
    @FXML private TableColumn columnaFechaInicio;
    @FXML private TableColumn columnaFechaFin;
    @FXML private TableColumn columnaValorPujado;
    @FXML private Label nombreAnuncio;
    @FXML private Label tipoProducto;
    @FXML private Label descripcion;
    @FXML private Label fechaInicio;
    @FXML private Label fechaFin;



}
