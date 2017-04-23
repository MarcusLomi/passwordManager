package Model;

import java.io.Serializable;

public class Account implements Serializable{
private static final long serialVersionUID = 487879453578974541L;
private String username, password, site, comments;

public String getComments() {
	return comments;
}
@Override
public String toString(){
	String result = "Info";
	result+=this.username+", ";
	result+=this.password+", ";
	result+=this.site+", ";
	result+=this.comments+", ";
	return result;
}

public void setComments(String comments) {
	this.comments = comments;
}

public Account(String username, String password, String site, String comments){
	this.username = username;
	this.password = password;
	this.site = site;
	this.comments = comments;
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

public String getSite() {
	return site;
}

public void setSite(String site) {
	this.site = site;
}
	
}
