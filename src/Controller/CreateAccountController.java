package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountController {

	@FXML
	private TextField userTextField;
	
	@FXML
	private PasswordField passWordField;
	
	@FXML
	private PasswordField confirmPasswordField;

    @FXML
    private TextField emailTextField;
    
    @FXML
    private Button createUserButton;

    @FXML
    void createUser(ActionEvent event) {

    }
    
    public void start(Stage mainstage){
    	mainstage.setTitle("Create Account");
    	
    }
}

