package com.example.word_dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DictionaryPageController {

    private DictionarySaver db;
    Alert alert=new Alert(Alert.AlertType.INFORMATION);
    @FXML
    TextField search;

    @FXML
    public void searchButton(MouseEvent event) throws IOException, ClassNotFoundException {
       db =new DictionarySaver();
//       db.serialization();
       db.deserialization();


       alert.setHeaderText("Dictionary");
       if(db.getDictionaryList().containsKey(search.getText().toLowerCase()))
           alert.setContentText("Word is available in the Dictionary");
       else
           alert.setContentText("Word is not available in the Dictionary");
       alert.showAndWait();

    }

    @FXML
    TextField newWord1;

    @FXML
    TextField newWord2;

    @FXML
    public void addButton(MouseEvent event) throws IOException,ClassNotFoundException{
          db=new DictionarySaver();
//          db.serialization();
          db.deserialization();
          alert.setHeaderText("Dictionary");
          //if word is not in file then simply put it with its meaning
          String str=newWord1.getText().toLowerCase();
          boolean isTrue=true;
          for(int i=0;i<str.length();i++){
              char ch=str.charAt(i);

              if(ch<97||ch>122) {
                  isTrue = false;
                  break;
              }
          }

          if(isTrue){
              if(!db.getDictionaryList().containsKey(newWord1.getText().toLowerCase())) {
                  db.getDictionaryList().put(newWord1.getText().toLowerCase(), newWord2.getText().toLowerCase());
                  alert.setContentText("Word is Added to the dictionary");
              }else
                  alert.setContentText("Word is already in Dictionary ");
          }else
              alert.setContentText("Provide a valid string ");
          alert.showAndWait();
          db.serialization();

    }


    @FXML
    TextField meaning;

    @FXML
    public void meaning(MouseEvent event) throws IOException, ClassNotFoundException {
        db=new DictionarySaver();
        db.deserialization();
        alert.setHeaderText("Meaning");
        //if word is present with its meaning then reflect its meaning
        String str=meaning.getText();
        boolean isTrue=true;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(ch<97||ch>122) {
                isTrue = false;
                break;
            }
        }

        if(isTrue){
            if(!db.getDictionaryList().containsKey(meaning.getText())) {
                alert.setContentText("Word is not in the dictionary");
            }else
                alert.setContentText(db.getDictionaryList().get(meaning.getText()));
        }else
            alert.setContentText("Provide a valid string "+str);
        alert.showAndWait();
    }
}
