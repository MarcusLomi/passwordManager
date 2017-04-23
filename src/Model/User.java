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
	return name;
}

public void setName(String name) {
	this.name = name;
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
