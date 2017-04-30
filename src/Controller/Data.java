package Controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import Model.User;

/**
 * @author Marcus Lomi & Brian Schillaci 
 * Singleton class for handling data storage / retrieval.
 */
public class Data {
	
	private static final String USERS_FILE = "users.ser";
	
	private static Data data;
	
	private User user;
		
	private Data() {
		loadUsers();
	}
	
	/**
	 * Gets the instance of Data that exists in this application.
	 * @return the Data singleton.
	 */
	public static Data getInstance() {
		if (data == null) {
			data = new Data();
		}
		return data;
	}
	
	/**
	 * Gets the current state of the Users object for Password manager.
	 * @return Pointer to the Users object.
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * Saves the Users object to a package file "users.ser"
	 */
	public void saveUsers() {
		try {
			FileOutputStream outTest = new FileOutputStream(USERS_FILE);
			PrintWriter pw = new PrintWriter(outTest);
			pw.close(); // Empty out existing file
			FileOutputStream outFile = new FileOutputStream(USERS_FILE);
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeObject(user);
			out.close();
//			this.users = users;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadUsers() {
    	File f = new File(USERS_FILE);
    	if (!f.exists()) {
    		user = new User();
    		System.out.println("DNE");
    		saveUsers();
    		return;
    	}
    	try {
    		FileInputStream inFile = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(inFile);
			User users = (User) in.readObject();
			in.close();
			inFile.close();
			this.user = users;
			return;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}

}

