package Model;

import Model.Button;
import Model.Note;
import Logic.MoveNote;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import java.util.*;

public class NoteList {

    Button upLeft = new Button("upLeft");;
    Button upRight= new Button("upRight");
    Button downLeft= new Button("downLeft");
    Button downRight= new Button("downRight");
    HashMap<Button, Vector<Note> > listMap = new HashMap<>();

    public NoteList(){
        Vector<Note> vector = new Vector<>();
        listMap.put(upLeft, vector);
        listMap.put(upRight, vector);
        listMap.put(downLeft, vector);
        listMap.put(downRight, vector);
    }

    public Note generateNote(){
        Random rand = new Random();
        int temp = rand.nextInt(4) + 1;
        if (temp == 1) {
            return new Note(4000, upLeft);
        } else if (temp == 2) {
            return new Note(4000, upRight);
        } else if (temp == 3) {
            return new Note(4000, downLeft);
        } else if (temp == 4) {
            return new Note(4000, downRight);
        } else {
            return new Note(-500, new Button("error"));
        }
    }

    public void addNoteToList(){
        Note toAdd = generateNote();
        Button addTo = toAdd.button;
        Vector<Note> v = listMap.get(addTo);
        v.add(toAdd);
        listMap.put(addTo, v);
        int index = listMap.get(addTo).size() - 1;
        new MoveNote(listMap.get(addTo).get(index));
    }

    Timer timer;
    int timeLeft = 60000;
    int timeInterval;
    int numOfNotesAdded = 0;

    class addNoteAtCertainFrequencyTask extends TimerTask{
        public void run(){
            if(timeLeft <= 0){
                System.out.println("In total, " + numOfNotesAdded + " notes added.");
                timer.cancel();
            } else {
                addNoteToList();
                timeLeft = timeLeft - timeInterval;
                numOfNotesAdded++;
                System.out.println("One note added...");
            }
        }
    }

    public void addNoteAtCertainFrequency(GridPane pane, int seconds){
        timeInterval = seconds * 1000;
        timer = new Timer();
        timer.scheduleAtFixedRate(new addNoteAtCertainFrequencyTask(), 0, timeInterval);
    }

}
