package com.example.word_dictionary;

import java.io.*;
import java.util.HashMap;

public class DictionarySaver {
    private HashMap<String,String> dictionaryList; //How private access modifier working here?

    DictionarySaver(){
        dictionaryList=new HashMap<>();
    }

    HashMap<String,String> getDictionaryList(){
        return dictionaryList;
    }
    void serialization() throws IOException {
        FileOutputStream fos=new FileOutputStream("dict_File");
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        oos.writeObject(dictionaryList); //Why dict list here doing? ..What if i take write instead of writeObject?
        oos.close();
        fos.close();
    }

    void deserialization() throws IOException, ClassNotFoundException { //What are these Exceptions??
        FileInputStream file=new FileInputStream("dict_file");
        ObjectInputStream ois=new ObjectInputStream(file);

        dictionaryList=(HashMap<String,String>)ois.readObject();
    }


   
}

