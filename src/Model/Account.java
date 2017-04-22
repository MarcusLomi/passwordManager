package Model;

public class Account {
private String username, password, email, site;

public Account(String username, String password, String email, String site){
	this.username = username;
	this.password = password;
	this.email = email;
	this.site = site;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getSite() {
	return site;
}

public void setSite(String site) {
	this.site = site;
}
	
}
