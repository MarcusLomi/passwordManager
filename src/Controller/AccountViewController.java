package Controller;
import java.io.IOException;
import java.util.ArrayList;

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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AccountViewController {

	@FXML
	public TableView<Account> mainTableView;

	@FXML
    public TableColumn<Account,String> siteColumn;

    @FXML
    public TableColumn<Account,String> usernameColumn;

    @FXML
    public TableColumn<Account, String> passwordColumn;

    @FXML
    public TableColumn<Account, String> commentColumn;

    @FXML
    private Button addSiteAccountPass;

    @FXML
    private Button deleteSiteAccount;

    @FXML
    private Button refreshColumnButton;
    
    @FXML
    private Button logoutButton;
    
    private User currentUser;
    
    @FXML
    public void refreshAction(ActionEvent event) {
    	refreshColumns();
    }
    
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
			ac.setCurrentUser(this.currentUser);
			ac.start(stage);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
    	
		}
    }
    
    public void start(Stage mainstage){
    	mainstage.setTitle("View Accounts");
    	refreshColumns();
    	mainTableView.setOnMouseClicked((e)->{
    		refreshColumns();
    	});
    	
    	deleteSiteAccount.setOnMouseClicked((e)->{
    		int index = mainTableView.getSelectionModel().getSelectedIndex();
    		if(index!=-1){
    			
	    		currentUser.getAccounts().remove(index);
	    		Data.getInstance().saveUsers();
	    		refreshColumns();
    		}
    		
    	});
    	
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
				System.out.println("User has been logged out");
				
			} catch (IOException i) {
				i.printStackTrace();
			}
    	});
    	
    }
    
    public void refreshColumns(){
    	
    	ObservableList<Account> accounts = FXCollections.observableArrayList();
    	if(currentUser==null){
    		System.out.println("FUCK");
    	}
    	ArrayList<Account> userAccounts = currentUser.getAccounts();
    	if(userAccounts.size()!=0){
    		for(Account a: userAccounts){
    			accounts.add(a);
    		}
    	}
    	mainTableView.setItems(accounts);
    	usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
    	siteColumn.setCellValueFactory(new PropertyValueFactory<>("site"));
    	passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
    	commentColumn.setCellValueFactory(new PropertyValueFactory<>("comments"));
    	for(Account a: accounts){
    		System.out.println(a.getUsername());
    	}
    	
    }
    public void setCurrentUser(User u){
    	this.currentUser=u;
    }
    
}