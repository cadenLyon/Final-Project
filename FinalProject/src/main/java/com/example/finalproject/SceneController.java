package com.example.finalproject;
/*
Caden Lyon
Computer Science II
4/29/24
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToAddNewEquipmentPage(ActionEvent event) throws IOException {
        loadFXML("AddNewEquipmentPage.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    public void switchToViewEquipmentPage(ActionEvent event) throws IOException {
        loadFXML("ViewEquipmentPage.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
    }
    @FXML
    public void switchToCreateAccountPage(ActionEvent event) throws IOException {
        loadFXML("CreateAccountPage.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    public void switchToSignInPage(ActionEvent event) throws IOException {
        loadFXML("SignInPage.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
    }
    @FXML
    public void switchToCheckOutPage(ActionEvent event) throws IOException {
        loadFXML("CheckOutPage.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    private void loadFXML(String fxmlFileName, Stage window) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    public void switchToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRemoveEquipmentPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("RemoveEquipmentPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}