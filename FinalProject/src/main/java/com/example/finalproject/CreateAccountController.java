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
import java.util.Random;

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

    private int getKey(){
        Random random = new Random();
        int key = random.nextInt(20,100);
        return key;
    }

    private String encryptPassword(int key){
        StringBuilder stringBuilderPassword = new StringBuilder();
        char[] passwordChars = passwordTextField.getText().toCharArray();
        for (char p : passwordChars){
            p += key;
            stringBuilderPassword.append(p);
        }
        String encryptedPassword = stringBuilderPassword.toString();
        return encryptedPassword;
    }

    private String encryptUsername(int key){
        StringBuilder stringBuilderUsername = new StringBuilder();
        char[] usernameChars = usernameTextField.getText().toCharArray();
        for (char u : usernameChars){
            u += key;
            stringBuilderUsername.append(u);
        }
        String encryptedUsername = stringBuilderUsername.toString();
        return encryptedUsername;
    }

    @FXML
    private void writeToCredFiles(ActionEvent event) throws IOException {
        String username = encryptUsername(getKey());
        String password = encryptPassword(getKey());
        BufferedWriter usernameWriter = new BufferedWriter(new FileWriter("usernames.txt", true));
        usernameWriter.write(username);
        usernameWriter.newLine();
        BufferedWriter passwordWriter = new BufferedWriter(new FileWriter("passwords.txt", true));
        passwordWriter.write(password);
        passwordWriter.newLine();

        usernameWriter.flush();
        passwordWriter.flush();
        usernameWriter.close();
        passwordWriter.close();

        Parent homeParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }

}
