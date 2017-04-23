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
import javafx.stage.Stage;

public class AddSiteAccountController {
	  @FXML
	    private TextField site;

	    @FXML
	    private TextField username;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private TextField comments;
	    
	    @FXML
	    private Button submitButton;

	   // @FXML
	    void addAccount(ActionEvent event) {
	    	
	    }
	    
	    @FXML
	    void submit(ActionEvent event) {
	    	User currUser = Data.getInstance().getUser();
	    	System.out.println("Submit button clicked");
	    	Account temp = new Account(username.getText(),password.getText(),"",site.getText(), comments.getText());
	    	ArrayList<Account> tempAccounts = currUser.getAccounts();
	    	tempAccounts.add(temp);
	    	
	    }
	    
	    public void start(Stage mainstage){
	    	mainstage.setTitle("Add new account");
	    }
}
