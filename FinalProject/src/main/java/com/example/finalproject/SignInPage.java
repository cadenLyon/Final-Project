package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignInPage{
    private Stage primaryStage;

    public SignInPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    public void show(){
        Group group = new Group();
        Scene scene = new Scene(group, 1150, 647,Color.web("0096C7"));


        VBox vBox = new VBox();
        vBox.getChildren().add(addVBox());
        //vBox.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sign in");

        group.getChildren().addAll(vBox);
        double x = (scene.getWidth() - vBox.prefWidth(-1))/2;

        vBox.setLayoutX(x);
        primaryStage.show();
    }

    public VBox addVBox() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(100));
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);


        Text userNameText = new Text("Enter Username");
        userNameText.setFont(Font.font("Verdana", 20));
        userNameText.setFill(Color.web("000000"));

        TextField userNameInput = new TextField();

        Text passWordText = new Text("Enter Password");
        passWordText.setFont(Font.font("Verdana", 20));


        TextField passWordInput = new TextField();

        Button signInButton = new Button("Sign in");
        signInButton.setMinHeight(35);
        signInButton.setFont(Font.font(16));

        EventHandler<ActionEvent> goHome = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //primaryStage.goToHomePage();
            }
        };

        signInButton.setOnAction(goHome);

        Button createAccountButton = new Button("Create an account");
        createAccountButton.setMinHeight(35);
        createAccountButton.setFont(Font.font(16));

        vBox.getChildren().addAll(userNameText,userNameInput,passWordText,passWordInput,signInButton,createAccountButton);

        return vBox;
    }



}