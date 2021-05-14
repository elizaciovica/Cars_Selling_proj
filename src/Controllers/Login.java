package Controllers;

import Users.*;
import database.Cryptography;
import database.Database;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.event.ActionEvent;

//import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Exceptions.*;

public class Login extends Application implements Initializable {

    @FXML
    private Text loginMessage;
    @FXML
    public TextField usernameField;
    @FXML
    public TextField passwordField;
    @FXML
    private ChoiceBox role;

    private Button cancelButton;
    @FXML
    private Button loginButton;
    private Label loginMessageLabel;

    public void setCancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**public void handleButtonClick() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Login.class.getResource("../FXML/Customer.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
           /** Scene scene = new Scene(fxmlLoader.load(), 630, 400);
            Stage stage = new Stage();
            stage.setTitle("Customer view");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(Login.class.getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    } **/

    /*public void initialize() {
        role.getItems().addAll("Customer", "Manager");
    }*/

    public void handleLoginAction(ActionEvent actionEvent) {
       // loginMessageLabel.setText("Login trying");
        String username = usernameField.getText();
        String password = Cryptography.getMD5(passwordField.getText());

        if ((username != null) && !username.isEmpty()) {
            if (password == null || password.isEmpty()) {
                loginMessage.setText("Password field is empty!");
                return;
            }
            try{
                User user = User.getUser(username,password);
                //Moderator.stage = (Stage) loginMessage.getScene().getWindow();
                if(user instanceof Customer) {
                    try {
                        Stage stage = (Stage) loginButton.getScene().getWindow();
                        FXMLLoader loader  = new FXMLLoader((getClass().getResource("../FXML/Logger.fxml")));
                        Parent root = loader.load();
                        Scene scene = new Scene(root, 600, 400);
                        stage.setTitle("Login");
                        stage.setWidth(800);
                        stage.setHeight(800);
                        stage.setScene(scene);
                        /*Stage window = (Stage)loginButton.getScene().getWindow();
                        window.setScene(new Scene(root, 750, 500));*/

                        stage.show();
                        stage.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                if(user instanceof Manager){
                    try {
                        Stage stage = (Stage) loginButton.getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader((getClass().getResource("../FXML/Logger.fxml")));
                        Parent root =loader.load();
                        Scene scene = new Scene(root, 600, 400);
                        stage.setTitle("Login");
                        stage.setWidth(800);
                        stage.setHeight(800);
                        stage.setScene(scene);
                        //Stage window = (Stage)loginButton.getScene().getWindow();
                        //window.setScene(new Scene(root, 750, 500));
                        stage.show();
                        stage.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (UserNotFoundException e){
                loginMessage.setText("User not found.Please try again");
            } catch (IncorrectPasswordException e){
                loginMessage.setText("Incorrect password.Please try again");
            }




            loginMessage.setText("You have logged in succesfully!");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Login.class.getResource("../FXML/Customer.fxml"));
                /*
                 * if "fx:controller" is not set in fxml
                 * fxmlLoader.setController(NewWindowController);
                 */
                Scene scene = new Scene(fxmlLoader.load(), 630, 400);
                Stage stage = new Stage();
                stage.setTitle("Customer view");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                Logger logger = Logger.getLogger(Login.class.getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }



        } else {
            loginMessage.setText("Please type in a username!");
            return;
        }


    }


        /**
       Parent root = null;/**
        try {
            root = FXMLLoader.load(getClass().getResource("Logger.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }**//**
        Stage stage = (Stage) loginButton.getScene().getWindow();
        FXMLLoader loader  = new FXMLLoader((getClass().getResource("../FXML/Logger.fxml")));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);


    }**/
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../FXML/Logger.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // set up the stage
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setWidth(800);
        stage.setHeight(800);
        stage.setScene(scene);

        stage.show();


        /**Parent panel_parent = null;
        try {
            panel_parent = FXMLLoader.load(getClass().getResource("CustomerPanel.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene panel_scene = new Scene(panel_parent);
        Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow() ;
        app_stage.setScene(panel_scene);
        app_stage.show();**/






    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /*public void handle_link_to_panel(javafx.event.ActionEvent actionEvent) {
        Parent panel_parent = null;
        try {
            panel_parent = FXMLLoader.load(getClass().getResource("CustomerPanel.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene panel_scene = new Scene(panel_parent);
        Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow() ;
        app_stage.setScene(panel_scene);
        app_stage.show();
    }*/
}
