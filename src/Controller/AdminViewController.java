package Controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminViewController {

    @FXML
    private Button logoutButton;

    @FXML
    private Button addUserButton;

    @FXML
    private Button deleteUserButton;

    
    public void start(Stage mainstage){

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
    	
    }
    
}
