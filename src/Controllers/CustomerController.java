package Controllers;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class CustomerController  {
    Button button;
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Customer.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private Label message = new Label();
    public void handleList() throws Exception {
        button = new Button("Choose");

        ListView listView = new ListView();
        listView.getItems().add("Hulk");
        listView.getItems().add("Iron Man");
        listView.getItems().add("Thor");
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        HBox hbox = new HBox(listView, button);
        //hbox.setPadding(new Insets(20,20,20,20));
        //hbox.getChildren().addAll(listView, button);


        Scene scene = new Scene(hbox, 300, 300);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Available companies:");
        stage.setScene(scene);
        stage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //Stage stage = (Stage) button.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader((getClass().getResource("../FXML/CarsWindow.fxml")));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 600, 400);
                stage.setTitle("Cars");
                stage.setWidth(800);
                stage.setHeight(800);
                stage.setScene(scene);
                stage.show();

            }
        });




    }
    public void handleSearch() {
        message.setText("The search");
    }


}

