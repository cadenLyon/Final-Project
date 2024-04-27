package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddEquipmentController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField makeTextField;
    @FXML
    private TextField modelInputText;
    @FXML
    private TextField serialInputText;
    @FXML
    private TextField assetInputText;
    @FXML
    private String userName;
    private String date;
    private String time;




/*
    public void addEquipment(ActionEvent event){

        String make = makeTextField.getText();
        String model = modelInputText.getText();
        String serial = serialInputText.getText();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("equipment.txt", true))) {
            writer.write(make + "," + model + "," + serial);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle file writing error
        }
    }

 */



}
