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

public class SignInPageController {
    @FXML
    private TextField userTextField;
    @FXML
    private TextField passTextField;
    @FXML
    private Label errorMessage;

    @FXML
    private void switchToCreateAccountPage(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("CreateAccountPage.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }

    public void verifyCredentials(ActionEvent event) throws IOException {
        int secretKey = 99;


        String encryptedPassword = IDandPasswords.refresh().encryptPassword(secretKey, passTextField.getText());
        boolean checker = IDandPasswords.refresh().checkCredentials(userTextField.getText(), encryptedPassword);

        if(checker){
            String username = userTextField.getText();
            IDandPasswords.refresh().setUsername(username);
            Parent homeParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene homeScene = new Scene(homeParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(homeScene);
            window.show();
        }else{
            errorMessage.setText("Credentials are invalid");
        }
    }


}
