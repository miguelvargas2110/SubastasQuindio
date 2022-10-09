package co.uniquindio.prog3.subastasquindio.controladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorAnuncios implements Initializable {

    ObservableList<String> opcionesChoiceBox = FXCollections.observableArrayList("Tecnologia","Hogar", "Vehiculos", "Deportes", "Bienes Raices");
    @FXML private ChoiceBox cbTipoProducto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbTipoProducto.setValue("Tecnologia");
        cbTipoProducto.setItems(opcionesChoiceBox);
    }
}
