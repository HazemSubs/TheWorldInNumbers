/**
 * This class provides a data structure for holding information on a given user.
 * @author Cole Letsche
 */
public class User {

	/**
	 * Keeps track of the username
	 */
	private String username;
	
	/**
	 * Keeps track of the users password
	 */
	private String password;

	/**
	 * Constructor for the User class
	 * @param username the username of the user
	 * @param password the password of the user
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Returns the username
	 * @return the username of the user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Returns the password
	 * @return the users password
	 */
	public String getPassword() {
		return password;
	}
}
