package examples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Vietoj VBox objekto naudojame GridPane, su kuriuo galima koreguoti mygtukų ir fieldų išdėstymą.
 * The container GridPane displays all children in a matrix format.
 */

public class ExampleGridPane extends Application {
    public static void main(String[] args) {
        System.out.println("Entering main...");
        launch();
        System.out.println("Exiting main...");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Entering start method...");

        // Creating objects that will appear in a new pop-up window

        Label label = new Label("Hello world!");    // Simple text line

        Button button = new Button("Click me!");    // Button

        CheckBox checkBox = new CheckBox("Yes/No");         // Check box

        ComboBox<String> comboBox = new ComboBox<>();               // Drop-down list
        comboBox.getItems().addAll("1st", "2nd", "3rd");

        TextField textField = new TextField("Write a line");        // Field to write text line

        TextArea textArea = new TextArea("Write a few lines");      // Text area (many text liens)

        // Adding all objects to vertical box (pop-up window)
        // VBox vBox = new VBox();
        // vBox.getChildren().addAll(label, button, checkBox, comboBox, textField, textArea);

        // Creating layout of objects
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.add(label, 0, 0);
        gridPane.add(button, 0, 1);
        gridPane.add(checkBox, 1, 1);
        gridPane.add(comboBox, 2, 1);
        gridPane.add(textField, 0, 2);
        gridPane.add(textArea, 0, 3);

        // Setting the window size
        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);

        // Setting the window name
        primaryStage.setTitle("This is my first scene");

        // Adding vBox to Scene and setting scene as primaryStage
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);

        // without the show() method window will not pop up
        primaryStage.show();
    }
}
