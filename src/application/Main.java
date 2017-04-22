package application;
	
import Controller.LoginViewController;
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
	}
}
