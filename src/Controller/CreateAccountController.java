package Controller;


import java.util.ArrayList;
import java.io.IOException;
import java.util.*;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateAccountController {

	private static final String USERS_FILE = "users.ser";

	@FXML
	private TextField userTextField;
	
	@FXML
	private PasswordField passWordField;
	
	@FXML
	private PasswordField confirmPasswordField;

    @FXML
    private TextField emailTextField;
    
    @FXML
    private Text noMatchPass;
    
    @FXML
    private Button createUserButton;

    @FXML
    void createUser(ActionEvent event) {
    	
    	if(passWordField.getText().compareTo(confirmPasswordField.getText()) != 0){
    		noMatchPass.setOpacity(1);
    	}
    	else{
    	Users userList = Data.getInstance().getUsers();			//get a reference to the main user so we can alter it. 
    	User newU = new User(userTextField.getText(),passWordField.getText(),emailTextField.getText());
    	userList.addUser(newU);
    	
    	Data.getInstance().saveUsers();
    	System.out.println(newU.getUsername());
    	try {
			Stage stage;
			Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AccountView.fxml"));
			root = loader.load();
			stage = (Stage)this.createUserButton.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			AccountViewController ac = loader.getController();
			ac.setCurrentUser(newU);
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

