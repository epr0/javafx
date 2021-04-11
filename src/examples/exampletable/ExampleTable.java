package examples.exampletable;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ExampleTable extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // LENTELĖS KŪRIMAS

        // Susikuriame stulpelius su pavadinimais Model ir Brand
        TableColumn modelColumn = new TableColumn("Model");
        TableColumn brandColumn = new TableColumn("Brand");

        // Susikuriame objektus, kuriuos talpinsime į lentelę
        Car bmw = new Car("BMW", "3 series");
        Car mercedes = new Car("Mercedes", "GL");
        Car toyota = new Car("Toyota", "Prius");

        // Susikuriame lentelę ir sudedame į ją stulpelius ir sukurtus objektus
        TableView tableView = new TableView();
        tableView.getColumns().addAll(modelColumn, brandColumn);
        tableView.getItems().addAll(bmw, mercedes, toyota);

        /*
        Kadangi lentelės stulpeliuose turės būti atskiri objektų Car fieldai (private String model,
        private String brand), tai panaudojam PropertyValueFactory konstruktorių/metodą, kuriam paduodame tuos
        private fieldus ir užsetiname (setCellValueFactory), kad iš objekto ištrauktas reikšmes priskirtų stulpeliui.
         */
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        /*
        PASTEBĖJIMAS:
        Nors Car klasėje private fieldai "model" ir "brand" prasideda iš mažosios raidės, bet programa veikia
        ir tuomet, kai būna pirma didžioji raidė new PropertyValueFactory<>("Model").
        Tačiau su stulpelio pavadinimu (kad jis prasideda iš didžiosios raidės) čia nesusiję, nes pakeitinėjus ir
        pabandžius išsiaiškinau, kad JAVA compileris konvertuoja tik pirmąją raidę į mažąją, o daugiau nieko nekeičia,
        todėl pervadinus iš didžiųjų raidžių ar pakeitus antrąją raidę į didžiąją, programa nustoja veikti.
        Taip pat neveikia, jeigu Car klasėje padarai private String bRand, o čia irgi pakeiti į
        new PropertyValueFactory<>("bRand"). Matyt, supranta kaip kaip camelCase ir kažką kitaip konvertuoja.
         */

        Button deleteButton = new Button("Delete Car");
        // setOnMouseClicked defines what happens when we click the delete button
        deleteButton.setOnMouseClicked(event -> {
            // First we get all of the objects in the table
            List<Car> allCars = tableView.getItems();
            // getSelectedItem() gives us the selected object
            Car selectedCar = (Car) tableView.getSelectionModel().getSelectedItem();
            // Then we iterate the list of all the objects in the table
            for (Car car : allCars) {
                if (car.getBrand().equals(selectedCar.getBrand()) && car.getModel().equals(selectedCar.getModel())) {
                    allCars.remove(car);
                    break;
                }
            }
        });

        // Using a VBox container so that we can display the table and the delete button underneath it
        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableView, deleteButton);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.show();
    }
}
