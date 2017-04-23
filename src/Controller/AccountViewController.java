package Controller;
import java.io.IOException;

import Model.Account;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class AccountViewController {

	@FXML
    private TableColumn<User,String> siteColumn;

    @FXML
    private TableColumn<User,String> usernameColumn;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private TableColumn<User, String> commentColumn;

    @FXML
    private Button addSiteAccountPass;

    @FXML
    private Button deleteSiteAccount;

    @FXML
    private Button saveButton;
    
    @FXML
    void openSiteAdder(ActionEvent event) {
    	try {
			Stage stage;
			Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AddSiteView.fxml"));
			root = loader.load();
			stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			AddSiteAccountController ac = loader.getController();
			ac.start(stage);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
    	
    	
    }
    }
    
    public void start(Stage mainstage){
    	mainstage.setTitle("View Accounts");
    	ObservableList<Account> accounts = FXCollections.observableArrayList();
    	accounts.add(new Account("Nitr0m4n","test","gmail.com","test", ""));
    	
    }
}
