package Controllers;

import Users.Car;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ManagerController {


    @FXML
    private Label messageAdd=new Label();
    @FXML
    private ListView<Car> list_cars=new ListView<>();
    @FXML
    private Label messageDelete=new Label();
    @FXML

    public void handleAdd(){
        messageAdd.setText("Added car!");
        for(int i=0;i<100;i++)
        list_cars.getItems().add(new Car("Dacia",1234,5));
        //list_cars.getItems().add(new Car("Dacia1",123434,45));
        //list_cars.getItems().add(new Car("Dacia2",123544,543));
        HBox hbox = new HBox(list_cars);
        Scene scene = new Scene(hbox, 300, 120);

        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/CompanyList.fxml"));
        // Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Available companies:");
        stage.setScene(scene);//new Scene(root1));
        stage.show();

    }

    public void handleDelete(){
        messageDelete.setText("Deleted car!");
    }

    public void handleView(){}







}
