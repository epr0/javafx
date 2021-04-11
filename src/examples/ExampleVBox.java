package examples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Naudojam VBox objektą, tačiau su juo negalima koreguoti mygtukų ir fieldų išdėstymo, išsidėsto kaip parašyti kode.
 * The container VBox displays all children one below the after
 * The container HBox displays all children one right after the other
 */

public class ExampleVBox extends Application {

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

        CheckBox checkBox = new CheckBox("Yes/No");             // Check box

        ComboBox comboBox = new ComboBox();                         // Drop-down list
        comboBox.getItems().addAll("1st", "2nd", "3rd");

        TextField textField = new TextField("Write a line");        // Field to write text line

        TextArea textArea = new TextArea("Write a few lines");      // Text area (many text lines)
        textArea.setMinHeight(150);

        ListView<String> listView = new ListView<>();       // List of items
        listView.getItems().addAll("1st element", "2dn element", "3rd element");

        // We'll use VBox as a main container to hold all our graphical elements
        // The container VBox displays all children one below the after
        VBox vBox = new VBox();
        vBox.getChildren().addAll(label, button, checkBox, comboBox, textField, textArea, listView);

        // Setting the window size
        primaryStage.setWidth(700);
        primaryStage.setHeight(500);

        // Setting the window name
        primaryStage.setTitle("This is my first scene");

        // Creating our first scene - main window which will display everything from the vBox container
        Scene scene = new Scene(vBox);
        // Setting the scene as the primaryStage
        primaryStage.setScene(scene);

        // Without the show() method window will not pop up
        primaryStage.show();
    }
}
