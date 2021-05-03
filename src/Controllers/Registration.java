package Controllers;
import database.Cryptography;
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

public class Registration extends Application {
    @FXML
    private Text registrationMessage;
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
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Customer", "Manager");
    }

    public void handleRegisterAction() {
        String username = usernameField.getText();
        String mail = mailField.getText();
        String address = addressField.getText();
        String role = accountField.getText();
        String phonenumber = phoneField.getText();
        String location = locationField.getText();
        String description = descriptionField.getText();

        String password = Cryptography.getMD5(passwordField.getText());

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
        stage.setHeight(700);
        stage.setScene(scene);
        stage.show();

    }
}


