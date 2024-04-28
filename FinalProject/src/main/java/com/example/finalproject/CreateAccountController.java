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

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class CreateAccountController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Label usernameError;
    @FXML
    private Label passwordError;

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
    private HashMap<String, String> writeToCredFiles(ActionEvent event) throws IOException {
        IDandPasswords iDandPasswords = new IDandPasswords();

        if (usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
            passwordError.setText("Please fill in the password field");
            usernameError.setText("Please fill in the username field");

        } else {

            iDandPasswords.addUsernameAndPassword(usernameTextField.getText(), passwordTextField.getText());
            System.out.println(iDandPasswords.getLoginInfo());


            Parent homeParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene homeScene = new Scene(homeParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(homeScene);
            window.show();

        }

        return iDandPasswords.getLoginInfo();
    }

}
