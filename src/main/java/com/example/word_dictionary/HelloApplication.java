package com.example.word_dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Dictionary;

public class HelloApplication extends Application {
    public static Group root;
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        root=new Group();
        DictionaryPage page=new DictionaryPage();
        root.getChildren().add(page.root);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Word Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}