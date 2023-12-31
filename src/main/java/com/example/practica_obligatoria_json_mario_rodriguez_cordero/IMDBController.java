package com.example.practica_obligatoria_json_mario_rodriguez_cordero;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.ArrayList;

public class IMDBController {

    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    @FXML
    private Button btnImportar;

    @FXML
    private ListView<Pelicula> lsvListado;

    @FXML
    private TextField txtDirector;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtTitulo;


    @FXML
    void importacion(ActionEvent event) {
        try {
            ArrayList<Pelicula> peliculas = JSON_MAPPER.readValue(new File("src/main/resources/peliculas.json"),
                    JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Pelicula.class));

            ObservableList<Pelicula> pelis = FXCollections.observableArrayList();

            for(int i = 0; i < peliculas.size(); i++){
                Pelicula p = new Pelicula(peliculas.get(i).getId(), peliculas.get(i).getTitulo(), peliculas.get(i).getFecha(),
                        peliculas.get(i).getDirector(), peliculas.get(i).getGenero());

                pelis.add(p);
            }

            lsvListado.setItems(pelis);
            lsvListado.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}