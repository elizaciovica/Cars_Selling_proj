package Controllers;
import Users.User;
import database.Cryptography;
import database.Database;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Exceptions.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Registration extends Application {

    @FXML
    public TextField usernameField;
    @FXML
    public TextField passwordField;
    @FXML
    public TextField phoneField;
    @FXML
    public TextField mailField;
    @FXML
    public TextField addressField;
    @FXML
    public TextField accountField;
    @FXML
    public TextField locationField;
    @FXML
    public TextField descriptionField;
    @FXML
    private ChoiceBox Role;
    @FXML
    private Text Message;


    @FXML
    public void initialize() {
        Role.getItems().addAll("Customer", "Manager");
    }

    public void handleRegisterAction() throws IOException, ParseException {
        String username = usernameField.getText();
        String mail = mailField.getText();
        //String address = addressField.getText();
        String role = (String) Role.getValue();
        String phonenumber = phoneField.getText();
        //String location = locationField.getText();
        //String description = descriptionField.getText();

        String password = Cryptography.getMD5(passwordField.getText());
        /*if (username == null || username.isEmpty()) {
            Message.setText("Username field is empty!");
            return;}
        if (password == null || password.isEmpty()) {
            Message.setText("Password field is empty!");
            return;}
        if (mail == null || mail.isEmpty()) {
            Message.setText("Email field is empty!");
            return;}
        if (phonenumber == null || phonenumber.isEmpty()) {
            Message.setText("Phone number field is empty!");
            return;}
        if (role == null || role.isEmpty()) {
            Message.setText("Role field is empty!");
            return;
        }*/
        Database.insertUser(new User(username,password,phonenumber,mail,role));
        Database.writeUsersArray();
        //Message.setText("You have succesfully created an account!");
    }





    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../FXML/Register.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // set up the stage
        Stage stage = new Stage();
        stage.setTitle("Registration");
        stage.setWidth(800);
        stage.setHeight(800);
        stage.setScene(scene);
        stage.show();


    }
}


