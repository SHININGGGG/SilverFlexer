package Model;

import Logic.MoveNote;
import Model.Note;
import Model.Button;
import Model.NoteList;
import javafx.scene.layout.GridPane;

import java.util.Random;
import java.util.*;

public class ConstructGame {

    NoteList noteList;

    public ConstructGame(){
        noteList = new NoteList();
    }

    public void addNoteAtCertainFrequency(GridPane pane, int seconds){
        noteList.addNoteAtCertainFrequency(pane, seconds);
    }



}
