package Controller;

import java.io.IOException;

import Model.User;
import Model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ForgotPasswordViewController {

	private static final String USERS_FILE = "users.ser";

	@FXML
	private TextField emailField;
    
    @FXML
    private Text invalidEmailText;
    
    @FXML
    private Text emailSentText;
    
    @FXML
    private Button sendVerifyButton;
	
    @FXML
    void sendVerifyEmail(ActionEvent event) {
    	Users userList = Data.getInstance().getUsers();			//get a reference to the main user so we can alter it. 
    	String email = emailField.getText();
    	int valid = 0;
    	for (User u: userList.users){
    		if(u.getEmail().compareTo(email)==0){
    			valid = 1;
    			




// USER NEEDS TO PUT THEIR OWN EMAIL ACCOUNT USERNAME AND PASSWORD





    			final String username = "";
    			final String password = "";

    			Properties props = new Properties();
    			props.put("mail.smtp.auth", "true");
    			props.put("mail.smtp.starttls.enable", "true");
    			props.put("mail.smtp.host", "smtp.gmail.com");
    			props.put("mail.smtp.port", "587");

    			Session session = Session.getInstance(props,
    			  new javax.mail.Authenticator() {
    				protected PasswordAuthentication getPasswordAuthentication() {
    					return new PasswordAuthentication(username, password);
    				}
    			  });

    			try {

    				Message message = new MimeMessage(session);




// PUT EMAIL IN DOUBLE QUOTES HERE ALSO INSIDE InternetAddress("")



    				message.setFrom(new InternetAddress(""));
    				message.setRecipients(Message.RecipientType.TO,
    					InternetAddress.parse(email));
    				message.setSubject("Password Manager: Reset Password");
    				
    				String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    		        StringBuilder Str = new StringBuilder();
    		        Random rnd = new Random();
    		        while (Str.length() < 8) { // length of the random string.
    		            int index = (int) (rnd.nextFloat() * characters.length());
    		            Str.append(characters.charAt(index));
    		        }
    		        String newStr = Str.toString();
    				message.setText("Here is a new password for your account: " +  newStr);
    				Transport.send(message);
    				u.setPassword(newStr);
    				Data.getInstance().saveUsers();

    			} catch (MessagingException e) {
    				throw new RuntimeException(e);
    			}
    			break;
    			 }  
    		}
    	if(valid == 0){
    		invalidEmailText.setOpacity(1);
    	}
    	else{
    		emailSentText.setOpacity(1);
    	}
    }

	public void start(Stage stage) {
		// TODO Auto-generated method stub
		stage.setTitle("Forgot Password");
	}
}
