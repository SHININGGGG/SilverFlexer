package Model;

import Model.Button;

public class Note {

    public int value;
    public Button button;

    public Note(){}

    public Note(int noteValue, Button buttonName){
        value = noteValue;
        button = buttonName;
    }

}
