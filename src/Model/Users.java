package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Users implements Serializable {
	private static final long serialVersionUID = 8994011860650604839L;
	
	/**
	 * The Users contained in PhotoAlbum.
	 */
	public ArrayList<User> users;
	
	/**
	 * Instantiates a new Users object.
	 */
	public Users() {
		users = new ArrayList<User>();
	}
	
	/**
	 * Adds a User to this Users object.
	 * @param user the User to add.
	 * @return true if the User could be added, false if another User by that username exists.
	 */
	public boolean addUser(User user) {
		for (User u : users) {
			if (u.equals(user)) {
				return false;
			}
		}
		users.add(user);
		return true;
		
	}
	
	/**
	 * Looks up a User by name.
	 * @param name the username to look up.
	 * @return A User if a matching one could be found, null otherwise.
	 */
	public User getUser(String name) {
		for (User u : users) {
			if (u.getName().equals(name)) return u;
		}
		return null;
	}
	
	/**
	 * Gets the names of all the Users contained in this instance.
	 * @return a List of usernames.
	 */
	public ArrayList<String> getUserNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (User u : users) names.add(u.getName());
		return names;
	}
	

}
