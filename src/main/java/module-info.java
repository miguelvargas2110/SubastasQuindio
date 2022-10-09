module co.uniquindio.prog3.subastasquindio {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;

    exports co.uniquindio.prog3.subastasquindio;
    opens co.uniquindio.prog3.subastasquindio to javafx.fxml;
    exports co.uniquindio.prog3.subastasquindio.controladores;
    opens co.uniquindio.prog3.subastasquindio.controladores to javafx.fxml;



}