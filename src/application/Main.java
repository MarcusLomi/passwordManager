package application;
	
import java.util.ArrayList;

import Controller.LoginViewController;
import Model.Account;
import Model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/View/LoginView.fxml"));
			AnchorPane root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			LoginViewController lc = loader.getController();
			lc.start(primaryStage);
			
			primaryStage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		ArrayList<Account> user1Accounts = new ArrayList<Account>();
		User user1 = new User("admin","pass","test3@gmail.com",user1Accounts);
		ArrayList<Account> user2Accounts = new ArrayList<Account>();
		User user2 = new User("admin2","pass","test3@gmail.com",user2Accounts);
		ArrayList<Account> user3Accounts = new ArrayList<Account>();
		User user3 = new User("admin3","pass","test3@gmail.com",user3Accounts);
		
		
	}
}
