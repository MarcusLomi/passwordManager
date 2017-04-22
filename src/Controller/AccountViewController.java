package Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class AccountViewController {

    @FXML
    private TableColumn<?, ?> siteColumn;

    @FXML
    private TableColumn<?, ?> usernameColumn;

    @FXML
    private TableColumn<?, ?> passwordColumn;

    @FXML
    private TableColumn<?, ?> commentColumn;

    public void start(Stage mainstage){
    	mainstage.setTitle("View Accounts");
    }
}
