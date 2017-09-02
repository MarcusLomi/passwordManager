package Controller;

import java.io.IOException;

import Controller.AccountViewController;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginViewController {

    @FXML
    private TextField usernameField;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passField;
    
    @FXML
    private Text wrongPassText;
    
    @FXML
    private Button createAccountButton;
    
    @FXML
    private Button forgotPasswordButton;

    @FXML
    void createAccount(ActionEvent event) {
		try {
			Stage stage;
			Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CreateAccountView.fxml"));
			root = loader.load();
			stage = (Stage)this.createAccountButton.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			CreateAccountController ac = loader.getController();
			ac.start(stage);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void submitUserName(ActionEvent event) {
    	User validUser;
    	Users userList = Data.getInstance().getUsers();
    	for(User u: userList.users){
    		if(u.getUsername().compareTo(usernameField.getText())==0){
    			if(u.getPassword().compareTo(passField.getText())==0){
        			validUser = u;
    				try//to set up the stage 
    				{
    					Stage stage;
    					Parent root;
    					FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AccountView.fxml"));
    					root = loader.load();
    					stage = (Stage)this.loginButton.getScene().getWindow();
    					Scene scene = new Scene(root);
    					stage.setScene(scene);
    					AccountViewController ac = loader.getController();
    					ac.setCurrentUser(validUser);
    					ac.start(stage);
    					stage.show();
    					
    				}catch (IOException e) {
    					e.printStackTrace();
    				}
        		}
    		}
    	}
    	if(usernameField.getText().compareTo("admin")==0){
    		try//to set up the stage 
			{
				Stage stage;
				Parent root;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AdminView.fxml"));
				root = loader.load();
				stage = (Stage)this.loginButton.getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				AdminViewController ac = loader.getController();
				ac.start(stage);
				stage.show();
				
			}catch (IOException e) {
				e.printStackTrace();
			}
    	}
 
      
		else{
			wrongPassText.setOpacity(1);
		}
    	
    }
    
    
    @FXML
    void forgotPassword(ActionEvent event) {
    	try {
			Stage stage;
			Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ForgotPasswordView.fxml"));
			root = loader.load();
			stage = (Stage)this.createAccountButton.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			ForgotPasswordViewController fc = loader.getController();
			fc.start(stage);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
   
    public void start(Stage mainstage){
    	mainstage.setTitle("Login");
    	
    }

}
