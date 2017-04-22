package Controller;

import java.io.IOException;

import Controller.AccountViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginViewController {

    @FXML
    private TextField usernameField;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordField;
    
    @FXML
    private Button createAccountButton;

    @FXML
    void submitUserName(ActionEvent event) {
    	if(usernameField.getText().equals("marc")){
    		System.out.println("Logging into user marc");
    		try {
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
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	
    }
    
    public void start(Stage mainstage){
    	mainstage.setTitle("Login");
    }

}
