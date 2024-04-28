package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateAccountController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    @FXML
    private void switchToSignInPage(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("SignInPage.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }

    @FXML
    private void writeToCredFiles(ActionEvent event) throws IOException {
        BufferedWriter usernameWriter = new BufferedWriter(new FileWriter("usernames.txt", true));
        usernameWriter.write(usernameTextField.getText());
        usernameWriter.newLine();
        BufferedWriter passwordWriter = new BufferedWriter(new FileWriter("passwords.txt", true));
        passwordWriter.write(passwordTextField.getText());
        passwordWriter.newLine();

        //usernameWriter.flush();
        //passwordWriter.flush();
        usernameWriter.close();
        passwordWriter.close();

        Parent homeParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }

}
