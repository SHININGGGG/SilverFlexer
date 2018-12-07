import Model.ConstructGame;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainApp extends Application{

    @Override
    public void start (Stage primaryStage) throws Exception {
        Group layout = new Group();
        GridPane pane = new GridPane();
        Label label = new Label();
        Button start = new Button();
        pane.setMinSize(200, 200);
        pane.setVgap(30);
        pane.setHgap(20);
        pane.setAlignment(Pos.CENTER);
        start.setText("Start");

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Button back = new Button();
                /*
                Group group = new Group();
                GridPane p = new GridPane();
                Stage gameStage = new Stage();
                gameStage.setTitle("UI.GamePage");
                p.setMinSize(1000, 1000);
                p.setVgap(30);
                p.setHgap(20);
                p.add(new Label("A"), 28, 20);
                p.add(new Label("B"), 29, 20);
                p.add(new Label("C"), 30, 20);
                p.add(new Label("D"), 31, 20);
                group.getChildren().add(p);
                gameStage.setScene(new Scene(group, 900, 900));
                gameStage.show();
                */
                //ConstructGame constructGame = new ConstructGame();
                //constructGame.addNoteAtCertainFrequency(p,2);
                primaryStage.setTitle("Timeline");

                Group root = new Group();
                Scene scene = new Scene(root, 700, 700, Color.GREY);

                Circle cr = new Circle(60,100,10);
                //Text text = new Text("Hi");
                //text.setFont(Font.font(20));
                cr.setFill(Color.DARKMAGENTA);

                root.getChildren().addAll(cr);
                primaryStage.setScene(scene);
                primaryStage.show();

                Timeline tml = new Timeline();
                tml.setCycleCount(1);
                KeyFrame movePlane = new KeyFrame(Duration.millis(4000),
                        new KeyValue (cr.translateYProperty(), 400));
                tml.getKeyFrames().add(movePlane);
                tml.play();
            }
        });

        label.setText("Welcome to Piano Tiles!");
        pane.add(label, 1, 1);
        pane.add(start, 1, 2);
        layout.getChildren().add(pane);
        primaryStage.setScene(new Scene(layout, 300, 200));
        primaryStage.setTitle("Piano Tiles");
        primaryStage.show();
    }

    public static void main (String args[]) {
        launch(args);
    }

}
