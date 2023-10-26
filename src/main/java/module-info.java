module com.example.practica_obligatoria_json_mario_rodriguez_cordero {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;

    opens com.example.practica_obligatoria_json_mario_rodriguez_cordero to javafx.fxml;
    exports com.example.practica_obligatoria_json_mario_rodriguez_cordero;
}