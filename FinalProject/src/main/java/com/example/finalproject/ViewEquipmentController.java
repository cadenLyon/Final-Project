package com.example.finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ViewEquipmentController {

    @FXML
    private TableColumn<Equipment, String> modelColumn;
    @FXML
    private TableColumn<Equipment, String> makeColumn;
    @FXML
    private TableColumn<Equipment, String> serialColumn;
    @FXML
    private TableColumn<Equipment, String> assetColumn;
    @FXML
    private TableColumn<Equipment, String> userColumn;
    @FXML
    private TableColumn<Equipment, String> dateColumn;
    @FXML
    private TableColumn<Equipment, String> timeColumn;
    @FXML
    private TableColumn<Equipment, String> inUseColumn;
    @FXML
    private TableView<Equipment> equipmentTable;



    @FXML
    private void switchToHomePage(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }

    public void initialize() throws IOException {
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        makeColumn.setCellValueFactory(new PropertyValueFactory<>("make"));
        serialColumn.setCellValueFactory(new PropertyValueFactory<>("serial"));
        assetColumn.setCellValueFactory(new PropertyValueFactory<>("asset"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        inUseColumn.setCellValueFactory(new PropertyValueFactory<>("inUse"));

        readFromEquipment();
    }

    private void readFromEquipment() throws IOException {
        FileReader fileReader = new FileReader("equipment.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        List<Equipment> equipmentList = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            //lines.add(line);
            String[] strings = line.split("\\s+");
            System.out.println(Arrays.toString(strings));

            equipmentList.add(new Equipment(strings[0], strings[1], strings[2], strings[3],
                    strings[4], strings[5], strings[6], strings[7]));
        }

        equipmentTable.getItems().addAll(equipmentList);

    }
}
