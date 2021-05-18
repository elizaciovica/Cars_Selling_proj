package Controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerController {
    ArrayList<String> cars = new ArrayList<>();
    ArrayList<String> companies = new ArrayList<>();

    public void array() {
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
    }

    public void array_company() {
        companies.add("VintageSRL");
        companies.add("Iron Man'S CARS");
        companies.add("Thor's Thunder Cars");
    }

    Button button1 = new Button("Choose");
    Button button2 = new Button("Place order");

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Customer.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    private Label message = new Label();

    public void handleList() throws Exception {

        ListView listView = new ListView();
        array_company();
        for (String car : companies) {
            listView.getItems().add(car);
        }
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        HBox hbox = new HBox(listView, button1);

        Scene scene = new Scene(hbox, 400, 300);
        final Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Available companies:");
        stage.setScene(scene);
        stage.show();

        button1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                ListView listView2 = new ListView();
                HBox hbox2 = new HBox(listView2, button2);
                array();
                for (String car : cars) {
                    listView2.getItems().add(car);
                }

                Scene scene2 = new Scene(hbox2, 400, 300);
                final Stage stage2 = new Stage();
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.initStyle(StageStyle.UTILITY);
                stage2.setTitle("Cars:");
                stage2.setScene(scene2);
                stage2.show();
            }


        });

        button2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader((getClass().getResource("../FXML/PlaceOrder.fxml")));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 600, 400);
                stage.setTitle("Place order!");
                stage.setWidth(800);
                stage.setHeight(800);
                stage.setScene(scene);
                stage.show();
            }


        });


    }

    public Button closeButton;
    public void handlePlaceOrderAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void handleSearch() {
        message.setText("The search");
    }


}

