package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Model.Account;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    	if(passWordField.getText().compareTo(confirmPasswordField.getText()) != 0){
    		System.out.println("Passwords don't match, Re-enter passwords.");
    	}
    	else{
    	ArrayList <Account> accounts = new ArrayList<Account>();
    	User admin = new User(userTextField.getText(), passWordField.getText(), emailTextField.getText(), accounts);
    	System.out.println(admin.getUsername());
    	try {
			Stage stage;
			Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AccountView.fxml"));
			root = loader.load();
			stage = (Stage)this.createUserButton.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			AccountViewController ac = loader.getController();
			ac.start(stage);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	}
    }
    
    public void start(Stage mainstage){
    	mainstage.setTitle("Create Account");
    	
    }
}

