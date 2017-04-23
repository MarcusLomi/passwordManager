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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AccountViewController {

	@FXML
	private TableView<Account> mainTableView;

	@FXML
    private TableColumn<Account,String> siteColumn;

    @FXML
    private TableColumn<Account,String> usernameColumn;

    @FXML
    private TableColumn<Account, String> passwordColumn;

    @FXML
    private TableColumn<Account, String> commentColumn;

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
    	accounts.add(new Account("Nitr0m4n","test","gmail.com","test"));
    	for(Account a: accounts){
    		System.out.println(a.getUsername());
    	}
    	mainTableView.setItems(accounts);
    	usernameColumn = new TableColumn<>("Username");
    	usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
    	mainTableView.getColumns().addAll(usernameColumn);
    
    }
}
