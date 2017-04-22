package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {

    @FXML
    private TextField usernameField;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordField;

    @FXML
    void submitUserName(ActionEvent event) {

    }
    
    public void start(Stage mainstage){
    	mainstage.setTitle("Login");
    	
    }

}

