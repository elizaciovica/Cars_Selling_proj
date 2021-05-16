package Controllers;

import Exceptions.CarAlreadyExists;
import Exceptions.IncorrectPasswordException;
import Exceptions.UserNotFoundException;
import Users.Car;
import Users.Manager;
import Users.User;
import database.Database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class ManagerController {
    public ArrayList<Car> arr=new ArrayList<>();
    public Manager curr;
    @FXML
    private Label messageAdd=new Label();
    @FXML
    public ListView<Car> list_cars=new ListView<>();
    @FXML
    private Label messageDelete=new Label();
    @FXML
    private TextField nameField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField priceField;
    @FXML
    private Label Message=new Label();

    @FXML
    private TextField nameToDelete;
    @FXML
    private TextField yearToDelete;


    public void delete() {
        String name=nameToDelete.getText();
        String year=yearToDelete.getText();
        String usr=Login.currentuser;//get Username from Login screen
        String pass=Login.currentpass;//get pass from login screen
        curr=new Manager(usr,pass,null,null,"Manager");
        if (name == null || name.isEmpty()) {
            Message.setText("Name field is empty!");
            return;}
        if (year == null || year.isEmpty()) {
            Message.setText("Year field is empty!");
            return;}

        try{
            curr.deleteCar(name, Integer.parseInt(year));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //list_cars.getItems().add(new Car(name, Integer.parseInt(year),Integer.parseInt(price)));
        Message.setText("Car successfully deleted");
    }

    public void add() throws CarAlreadyExists {
        String name=nameField.getText();
        String year=yearField.getText();
        String price= priceField.getText();
        String usr=Login.currentuser;//get Username from Login screen
        String pass=Login.currentpass;//get pass from login screen
        curr=new Manager(usr,pass,null,null,"Manager");
        if (name == null || name.isEmpty()) {
            Message.setText("Name field is empty!");
            return;}
        if (year == null || year.isEmpty()) {
            Message.setText("Year field is empty!");
            return;}
        if (price == null || price.isEmpty()) {
            Message.setText("Price field is empty!");
            return;}
        try{
            curr.addCar(new Car(name, Integer.parseInt(year),Integer.parseInt(price)));
            arr.add(new Car(name, Integer.parseInt(year),Integer.parseInt(price)));}
        catch (CarAlreadyExists carAlreadyExists) {
            carAlreadyExists.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //list_cars.getItems().add(new Car(name, Integer.parseInt(year),Integer.parseInt(price)));
        Message.setText("Car successfully added");
    }


        public void handleAdd()  {
        messageAdd.setText("");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/AddCar.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Add car");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void handleDelete(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/DeleteCar.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Delete car");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        messageDelete.setText("Deleted car!");
    }

    public void handleView() throws UserNotFoundException, IncorrectPasswordException {
        String usr=Login.currentuser;//get Username from Login screen
        String pass=Database.getUserPassword(usr);
        //ArrayList<Car> arr = ((Manager) (User.getUser(usr, pass))).getCars();
        curr=new Manager(usr,pass,null,null,"Manager");
        curr.setCars(arr);
        list_cars.getItems().addAll(curr.cars);
        HBox hbox = new HBox(list_cars);
        Scene scene = new Scene(hbox, 300, 120);


        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("My available cars:");
        stage.setScene(scene);//new Scene(root1));
        stage.show();
    }







}
