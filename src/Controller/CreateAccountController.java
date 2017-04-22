package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountController {

    @FXML
    private TextField userTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField confirmPassTextField;

    @FXML
    private TextField emailTextField;

    
    public void start(Stage mainstage){
    	mainstage.setTitle("Create Account");
    }
}

