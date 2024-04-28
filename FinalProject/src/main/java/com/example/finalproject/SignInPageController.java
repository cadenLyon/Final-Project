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

public class SignInPageController {
    @FXML
    private TextField userTextField;
    @FXML
    private TextField passTextField;
    @FXML
    private Label errorMessage;


    @FXML
    private void switchToHomePage(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }

    @FXML
    private void switchToCreateAccountPage(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("CreateAccountPage.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }

    public void verifyCredentials(ActionEvent event) throws IOException {

        IDandPasswords iDandPasswords = IDandPasswords.refresh();

        System.out.println("sign in page info: "+iDandPasswords.getLoginInfo());
        /*
        String user = userTextField.getText();
        String pass = passTextField.getText();

        iDandPasswords.checkCredentials(user,pass);

         */
        boolean checker = iDandPasswords.checkCredentials(userTextField.getText(), passTextField.getText());

        /*
        if(iDandPasswords.loginInfo.containsKey(user)){
            if(iDandPasswords.loginInfo.get(user).equals(pass)){

                Parent homeParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                Scene homeScene = new Scene(homeParent);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(homeScene);
                window.show();


            }

         */
        if(checker){
            iDandPasswords.setUsername(userTextField.getText());
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
