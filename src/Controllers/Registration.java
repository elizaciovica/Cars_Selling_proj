package Controllers;
import database.Cryptography;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Exceptions.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Registration extends Application{
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




    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
