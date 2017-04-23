package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
private static final long serialVersionUID = 431709636391093399L;
private String username, password, email, date_of_birth;
public static User mainUser;

private ArrayList<Account> accounts;

public static void setMainUser(User in){
	mainUser = in;
}

public User(String username, String password, String email, ArrayList<Account> accounts){
	this.username = username;
	this.password = password;
	this.email = email;
	this.accounts = accounts;
	accounts= new ArrayList<Account>();
}

public User(){
	this.username="default";
	this.password="default";
	this.email="default";
	this.accounts=null;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return this.username;
}

public void setName(String name) {
	this.username = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getDate_of_birth() {
	return date_of_birth;
}

public void setDate_of_birth(String date_of_birth) {
	this.date_of_birth = date_of_birth;
}

}
