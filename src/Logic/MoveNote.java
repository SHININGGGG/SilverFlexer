package Logic;

import Model.Note;
import Model.Button;

import java.util.*;

public class MoveNote {

    public int noteValue;
    public Button button;
    Timer timer = new Timer();

    class moveTask extends TimerTask{
        public void run(){
            if(noteValue <= -500){
                timer.cancel();
            } else {
                noteValue = noteValue - 10;
            }
            //System.out.println("button: " + button.buttonName + "  noteValue: " + noteValue);
        }
    }

    public MoveNote(){
        Timer timer = new Timer();
        TimerTask task = new moveTask();
        timer.scheduleAtFixedRate(task,0, 10);
    }

    public MoveNote(Note note){
        noteValue = note.value;
        button = note.button;
        TimerTask task = new moveTask();
        timer.scheduleAtFixedRate(task,0, 10);
    }
}
