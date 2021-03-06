package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Model.Account;
import Model.User;
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

public class AddSiteAccountController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private TextField site;

    @FXML
    private TextField comments;

    @FXML
    private Button submitButton;

    @FXML
    private Text addSiteTextMessage;
	   
    private User currentUser;
    
    @FXML
    void submit(ActionEvent event) {
    	
    	System.out.println(currentUser.getName());
    	
		if(currentUser.getAccounts()==null){
			System.out.println("Accounts arraylist is null");
		}
		
		currentUser.addAccount(new Account(username.getText(),password.getText(),site.getText(),comments.getText()));
		Data.getInstance().saveUsers();
    	
    	for(Account a: currentUser.getAccounts()){
    		System.out.print(a);
    	}
    	(((Node) event.getSource())).getScene().getWindow().hide();
    	}
    
    public void start(Stage mainstage){
    	mainstage.setTitle("Add new account");
    }
    
    public void setCurrentUser(User u){
    	this.currentUser=u;
    }
}
