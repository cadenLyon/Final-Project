package com.example.finalproject;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HomePage {
    private Stage primaryStage;

    public HomePage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    public void show(){
        Group group = new Group();
        Scene scene = new Scene(group, 1150, 647, Color.web("0096C7"));

        primaryStage.setScene(scene);

        primaryStage.setTitle("Home");

        VBox vBox = new VBox();
        Label label = new Label("Welcome to the Home Page!");
        vBox.getChildren().add(label);
        group.getChildren().add(vBox);


        primaryStage.show();
    }
}
