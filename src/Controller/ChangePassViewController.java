package Controller;

import java.io.IOException;

import Model.Account;
import Model.User;
import Model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangePassViewController {
    
    @FXML
    private PasswordField newPass;
    
    @FXML
    private PasswordField newPassConfirm;
    
    @FXML
    private Button submitNewPassButton;
    
    @FXML
    private Text dontMatchText;
    
    @FXML
    private Text success;
    
    private User currentUser;

    
    @FXML
    void submitNewPass(ActionEvent event) {
    	Users userList = Data.getInstance().getUsers();	
    	if(newPass.getText().compareTo(newPassConfirm.getText()) != 0){
    		dontMatchText.setOpacity(1);
    	}
    	else{
    		currentUser.setPassword(newPassConfirm.getText());
			Data.getInstance().saveUsers();
			success.setOpacity(1);
    	}
    	
    }
    
    public void setCurrentUser(User u){
    	this.currentUser =u;
    }
    
    public void start(Stage mainstage){
    	mainstage.setTitle("Change Password");
    }
    
}
