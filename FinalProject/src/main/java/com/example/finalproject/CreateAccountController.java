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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;


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



    @FXML
    private HashMap<String, String> writeToCredFiles(ActionEvent event) throws IOException {
        IDandPasswords iDandPasswords = new IDandPasswords();
        int secretkey = 99;

        if (usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
            passwordError.setText("Please fill in the password field");
            usernameError.setText("Please fill in the username field");

        } else {
            String encryptedPassword = IDandPasswords.refresh().encryptPassword(secretkey, passwordTextField.getText());
            IDandPasswords.refresh().addUsernameAndPassword(usernameTextField.getText(), encryptedPassword);
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
