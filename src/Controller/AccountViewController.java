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
    		User current = Data.getInstance().getUser();
    		current.getAccounts().remove(index);
    		Data.getInstance().saveUsers();
    		refreshColumns();
    	});
    	
    }
    
    public void refreshColumns(){
    	User mainU = Data.getInstance().getUser();
    	ObservableList<Account> accounts = FXCollections.observableArrayList();
    	ArrayList<Account> userAccounts = mainU.getAccounts();
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
    	//For brian
    }
}