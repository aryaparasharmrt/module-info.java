package com.example.word_dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DictionaryPageController {

    @FXML
    TextField search;

    @FXML
    public void searchButton(MouseEvent event) throws IOException{
        System.out.println("Search Button is Clicked");
        System.out.println(search.getText());
    }

    @FXML
    TextField newWord1;

    @FXML
    TextField newWord2;

    @FXML
    public void addButton(MouseEvent event) throws IOException{
        System.out.println("Add Button is Clicked");
        System.out.println(newWord1.getText());
        System.out.println(newWord2.getText());
    }


    @FXML
    TextField meaning;

    @FXML
    public void meaning(MouseEvent event) throws IOException{
        System.out.println("Meaning Button is Clicked");
        System.out.println(meaning.getText());
    }
}
