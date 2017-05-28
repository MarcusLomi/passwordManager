package Controller;

import java.io.IOException;

import Model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AdminViewController {

    @FXML
    private Button logoutButton;

    @FXML
    private Button addUserButton;

    @FXML
    private Button deleteUserButton;

    @FXML
    private ListView userListView;
    
    private ObservableList<String> usersList;
    
    private Users users;
    
    public void start(Stage mainstage){
    	getAllUsers();
    	refreshList();
    	
    	/*Handles the event for logging out the administrator*/
    	logoutButton.setOnMouseClicked((e)->{
    		Data.getInstance().saveUsers();			//Save changes before logging out
    		try {
				Stage stage;
				Parent root;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/LoginView.fxml"));
				root = loader.load();
				stage = (Stage)this.logoutButton.getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				LoginViewController lc = loader.getController();
				lc.start(stage);
				stage.show();
				System.out.println("Admin has been logged out");
				
			} catch (IOException i) {
				i.printStackTrace();
			}
    	});
    	
    	/*Handles event for deleting a user*/
    	deleteUserButton.setOnMouseClicked((e)->{
    		int selectedIndex = userListView.getSelectionModel().getSelectedIndex();
    		if(selectedIndex!=-1){
    			System.out.println("Deleting user " + this.users.users.get(selectedIndex).getName());
    			this.users.users.remove(selectedIndex);
    			Data.getInstance().saveUsers();
    			getAllUsers();
    			refreshList();
    			userListView.getSelectionModel().clearSelection();
    		}
    	});
    	
    	/*Handles creating a new user account from the admin control screen*/
    	addUserButton.setOnMouseClicked((e)->{
    		try {
    			Stage stage;
    			Parent root;
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CreateAccountView.fxml"));
    			root = loader.load();
    			stage = new Stage();
    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			CreateAccountController ac = loader.getController();
    			ac.start(stage);
    			stage.show();
    			
    		} catch (IOException f) {
    			f.printStackTrace();
    		}
    	});
    	
    }
    
    /**
     * Returns the master user list
     * */
    public void getAllUsers(){
    	this.users = Data.getInstance().getUsers();
    }
    
    public void refreshList(){
    	usersList=FXCollections.observableArrayList(users.getUserNames());
    	userListView.setItems(usersList);
    }
    
}
