package com.example.demo2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChatApplication extends Application {

    private TextArea messages = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        HBox topBox = new HBox();
        topBox.setSpacing(10);
        topBox.setPadding(new Insets(10, 10, 10, 10));
        Label receiverName = new Label("Lisa Lisa");
        Button callButton = new Button("Call");
        Button videoCallButton = new Button("Video Call");
        topBox.getChildren().addAll(receiverName, callButton, videoCallButton);
        topBox.setAlignment(Pos.CENTER_LEFT);
        borderPane.setTop(topBox);

        TextField inputField = new TextField();
        inputField.setPrefHeight(40);
        inputField.setOnAction(event -> {
            messages.appendText(inputField.getText() + "\n");
            inputField.clear();
        });

        Button sendButton = new Button("Send");
        sendButton.setPrefSize(70, 40);
        sendButton.setOnAction(event -> {
            messages.appendText(inputField.getText() + "\n");
            inputField.clear();
        });

        HBox bottomBox = new HBox();
        bottomBox.setSpacing(10);
        bottomBox.setPadding(new Insets(10, 10, 10, 10));
        bottomBox.getChildren().addAll(inputField, sendButton);
        bottomBox.setAlignment(Pos.CENTER_RIGHT);
        borderPane.setBottom(bottomBox);

        messages.setPrefHeight(500);
        borderPane.setCenter(messages);

        Scene scene = new Scene(borderPane, 300, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
