package Model;

import java.util.ArrayList;

public class User {
private String username, password, name, email, date_of_birth;

private ArrayList<Account> accounts;

public User(String username, String password, String email, ArrayList<Account> accounts){
	this.username = username;
	this.password = password;
	this.email = email;
	this.accounts = accounts;
}


}
