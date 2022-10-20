package co.uniquindio.prog3.subastasquindio.controladores;

import co.uniquindio.prog3.subastasquindio.excepciones.ExcepcionPujaNegativa;
import co.uniquindio.prog3.subastasquindio.modelo.Anuncio;
import co.uniquindio.prog3.subastasquindio.modelo.Puja;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControladorTransaccional implements Initializable {

    @FXML
    Label lblNombreAnunciante;

    @FXML
    Label lblNombreAnuncio;
    @FXML
    Label lblTipoProducto;
    @FXML
    Label lblFechaInicio;
    @FXML
    Label lblFechaFin;
    @FXML
    Label lblDescripcion;
    @FXML
    Label lblValorInicial;
    @FXML
    Label lblSapoHpta;
    @FXML
    TextField txtValorPujar;
    @FXML
    TableView<Puja> tablaPujasGlobales;
    @FXML
    TableColumn columnaNombreComprador;
    @FXML
    TableColumn columnaValorPuja;
    ObservableList<Puja> pujas;

    @FXML
    private void Pujar() throws IOException {
        if(ControladorModelFactory.getInstance().getSubastasQuindio().getUsuarioGlobalComprador() != null){
            try{
                Double.parseDouble(txtValorPujar.getText());
                validarValorPuja(Double.parseDouble(txtValorPujar.getText()));
                Puja puja = ControladorModelFactory.getInstance().crearPuja(Double.parseDouble(txtValorPujar.getText()), ControladorModelFactory.getInstance().getSubastasQuindio().getAnuncioGlobal().getNombreAnuncio(), ControladorModelFactory.getInstance().getSubastasQuindio().getUsuarioGlobalComprador().getNombre());
                ControladorModelFactory.getInstance().guardarPuja(puja,  ControladorModelFactory.getInstance().getSubastasQuindio().getAnuncioGlobal().getNombreAnuncio());
                ControladorModelFactory.getInstance().guardarPujaArchivo(puja);
                lblSapoHpta.setText("Se ha pujado exitosamente");
                ControladorModelFactory.getInstance().guardarRegistroLog("La puja del comprador " + ControladorModelFactory.getInstance().getSubastasQuindio().getUsuarioGlobalComprador().getNombre() + " con valor " + txtValorPujar.getText() + " se ha hecho exitosamente", 1, "guardarPuja");
                this.inicializarTabla();
            }catch (ExcepcionPujaNegativa excepcionPujaNegativa){
                ControladorModelFactory.getInstance().guardarRegistroLog("Ha salado una excepcion de valor menor de valor inicial", 1, excepcionPujaNegativa.toString());
            }catch (NumberFormatException e){
                ControladorModelFactory.getInstance().guardarRegistroLog("Ha saltado una excepcion  en el valor de la puja", 1, e.toString());
            }
        }else{
            lblSapoHpta.setText("Usted no ha iniciado sesion");
        }
    }

    public void validarValorPuja (double valorPuja) throws ExcepcionPujaNegativa {
        if (valorPuja<ControladorModelFactory.getInstance().getSubastasQuindio().getAnuncioGlobal().getValorInicial()){
            throw new ExcepcionPujaNegativa();
        }
    }

    private void inicializarTabla() {

        pujas = FXCollections.observableArrayList();
        if(ControladorModelFactory.getInstance().getSubastasQuindio().getAnuncioGlobal().getPujas() != null){
            pujas.addAll(ControladorModelFactory.getInstance().getSubastasQuindio().getAnuncioGlobal().getPujas());
        }


        columnaNombreComprador.setCellValueFactory(new PropertyValueFactory<Puja, String>("nombreComprador"));
        columnaValorPuja.setCellValueFactory(new PropertyValueFactory<Puja, Double>("valorPuja"));

        tablaPujasGlobales.setItems(pujas);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblNombreAnuncio.setText(ControladorModelFactory.getInstance().getSubastasQuindio().getAnuncioGlobal().getNombreAnuncio());
        lblDescripcion.setText("Descripcion: " + ControladorModelFactory.getInstance().getSubastasQuindio().getAnuncioGlobal().getDescripcion());
        lblTipoProducto.setText("Tipo del producto: " + ControladorModelFactory.getInstance().getSubastasQuindio().getAnuncioGlobal().getTipoProducto());
        lblNombreAnunciante.setText("Nombre del anunciante: " + ControladorModelFactory.getInstance().getSubastasQuindio().getAnuncioGlobal().getNombreAnunciante());
        lblFechaInicio.setText("Fecha de inicio: " + ControladorModelFactory.getInstance().getSubastasQuindio().getAnuncioGlobal().getFechaPublicacion());
        lblFechaFin.setText("Fecha de finalizacion: " + ControladorModelFactory.getInstance().getSubastasQuindio().getAnuncioGlobal().getFechaCaducidad());
        lblValorInicial.setText("Valor inicial: " + ControladorModelFactory.getInstance().getSubastasQuindio().getAnuncioGlobal().getValorInicial());

        this.inicializarTabla();
    }
}
