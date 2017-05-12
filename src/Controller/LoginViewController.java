package Controller;

import java.io.IOException;

import Controller.AccountViewController;
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
    void createAccount(ActionEvent event) {
    	System.out.println("HI THERE");
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
    	else if(usernameField.getText().compareTo(Data.getInstance().getUser().getName()) == 0)
    	{//If the username is the same
			if(passField.getText().compareTo(Data.getInstance().getUser().getPassword()) == 0)
			{	//If the password is the same
				System.out.println("Logging into:" + Data.getInstance().getUser().getName());
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
		else{
			wrongPassText.setOpacity(1);
		}
    	
    }
    
    public void start(Stage mainstage){
    	mainstage.setTitle("Login");
    
    	User currentUser = Data.getInstance().getUser();
    	
    	if(currentUser!=null){
    		System.out.println("Current user is " + currentUser.getName());
    	}
    }

}
