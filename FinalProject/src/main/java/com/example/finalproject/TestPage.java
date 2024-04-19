package com.example.finalproject;

import javafx.application.Application;
import javafx.stage.Stage;

public class TestPage extends Application {

    private TestPage2 testPage2;
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        testPage2 = new TestPage2(stage);

        // Show the initial page
        testPage2.show();
    }
}