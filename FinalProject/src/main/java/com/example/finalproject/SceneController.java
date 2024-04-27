package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane signInPagePane;

    public void switchToSignInPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SignInPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setSignInPagePaneColor(){
        //signInPagePane.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        signInPagePane.setStyle("-fx-background-color: #000000");
    }
    public void switchToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAddNewEquipmentPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddNewEquipmentPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCheckOutPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CheckOutPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCreateAccountPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CreateAccountPage.fxml"));
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

    public void switchToViewEquipmentPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ViewEquipmentPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}