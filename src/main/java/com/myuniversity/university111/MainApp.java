package com.myuniversity.university111;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("com.myuniversity.university111.hello-view.fxml"));
        Parent root = loader.load();

        // Set the scene and stage properties
        primaryStage.setTitle("University Application");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}

