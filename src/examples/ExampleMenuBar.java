package examples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExampleMenuBar extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creating menu bar object
        MenuBar menuBar = new MenuBar();

        // Creating menu bar buttons
        Menu carsMenu = new Menu("Cars");
        Menu driversMenu = new Menu("Drivers");

        // Adding menu bar buttons to menu bar object
        menuBar.getMenus().addAll(carsMenu, driversMenu);

        // Creating items of drop-down list
        MenuItem addCarMenuItem = new MenuItem("Add car");
        MenuItem listCarsMenuItem = new MenuItem("List cars");
        MenuItem addDriverMenuItem = new MenuItem("Add driver");

        // Adding drop-down list items to menu bar buttons
        carsMenu.getItems().addAll(addCarMenuItem, listCarsMenuItem);
        driversMenu.getItems().addAll(addDriverMenuItem);

        // We'll use VBox as a main container to hold all our graphical elements
        VBox vBox = new VBox();
        vBox.getChildren().addAll(menuBar, new Label("TEST"));

        // Setting the window size
        primaryStage.setWidth(900);
        primaryStage.setHeight(500);

        // Setting the window name
        primaryStage.setTitle("Example of drop-down list");

        // Creating our first scene - main window which will display everything from the vBox container
        Scene scene = new Scene(vBox);
        // Setting the scene as the primaryStage
        primaryStage.setScene(scene);

        // Without the show() method window will not pop up
        primaryStage.show();

    }
}
