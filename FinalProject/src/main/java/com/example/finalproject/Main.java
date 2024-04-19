package com.example.finalproject;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private SignInPage signInPage;
    private Stage stage;
    private HomePage homePage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        signInPage = new SignInPage(stage;

        // Show the initial page
        signInPage.show();
    }

    public void goToHomePage(){
        homePage = new HomePage(stage);
        homePage.show();
    }


}