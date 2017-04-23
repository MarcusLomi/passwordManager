package Controller;
import Model.User;
import javafx.fxml.FXML;
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

    
    public void start(Stage mainstage){
    	mainstage.setTitle("View Accounts");
    	
    }
}
