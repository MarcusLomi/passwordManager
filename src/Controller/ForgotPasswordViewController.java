package Controller;

import java.io.IOException;

import Model.User;
import Model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;
import javax.activation.*;

public class ForgotPasswordViewController {

	private static final String USERS_FILE = "users.ser";

	@FXML
	private TextField emailField;
    
    @FXML
    private Text invalidEmailText;
    
    @FXML
    private Text emailSentText;
    
    @FXML
    private Button sendVerifyButton;
	
    @FXML
    void sendVerifyEmail(ActionEvent event) {
    	Users userList = Data.getInstance().getUsers();			//get a reference to the main user so we can alter it. 
    	String email = emailField.getText();
    	int valid = 0;
    	for (User u: userList.users){
    		if(u.getEmail().compareTo(email)==0){
    			valid = 1;
    			break;
    		}
    	}
    	if(valid == 0){
    		invalidEmailText.setOpacity(1);
    	}
    	else{
    		emailSentText.setOpacity(1);
    	}
    }

	public void start(Stage stage) {
		// TODO Auto-generated method stub
		stage.setTitle("Forgot Password");
	}
}
