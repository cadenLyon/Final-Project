package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class AddEquipmentController {

    @FXML
    private TextField makeTextField;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField serialTextField;
    @FXML
    private TextField assetTextField;
    @FXML
    private Label warningLabel;


    @FXML
    private void switchToHomePage(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }

    @FXML
    private void addEquipment(ActionEvent event) {
        IDandPasswords iDandPasswords = IDandPasswords.refresh();
        if (makeTextField.getText().isEmpty() || modelTextField.getText().isEmpty() || serialTextField.getText().isEmpty() ||assetTextField.getText().isEmpty()){
            warningLabel.setText("Please fill in all fields");
        }else{

            String make = makeTextField.getText().toUpperCase();
            String model = modelTextField.getText().toUpperCase();
            String serial = serialTextField.getText().toUpperCase();
            String asset = assetTextField.getText().toUpperCase();
            String user = IDandPasswords.refresh().getUsername();
            System.out.println(iDandPasswords.getUsername());
            String date = String.valueOf(java.time.LocalDate.now());
            String time = String.valueOf(java.time.LocalTime.now());
            String inUse = "no";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("equipment.txt", true))) {
                writer.write(make + " " + model + " " + serial + " " + asset+" "+user+" "+date+" "+time+" "+inUse);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

    }
}