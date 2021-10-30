import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * 
 * This class handles the user login and is the entry point to the program
 * @author Cole Letsche
 */
public class MainLogin implements ActionListener {

	private static final String USERS_FILENAME = "users.txt";
	private static final Dimension FRAME_DIMENSION = new Dimension(350, 150);

	private static ArrayList<User> users;

	private static JFrame frame;

	/**
	 * Swing components
	 */
	private static JLabel username;
	private static JLabel password;
	private static JTextField usernameText;
	private static JTextField passwordText;
	private static JButton submitButton;

	/**
	 * Entry to the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Handle Parsing of login data before initializing swing elements
		users = new ArrayList<User>();

		// Reading the list of users from an external file
		try {
			BufferedReader reader = new BufferedReader(new FileReader(USERS_FILENAME));

			int numUsers = Integer.parseInt(reader.readLine());

			// Parsing login data into 'User' objects
			for (int i = 0; i < numUsers; i++)
				users.add(new User(reader.readLine(), reader.readLine()));

			reader.close();

		} catch (Exception e) {
			System.out.println("[Error] Parsing login data file.");
			e.printStackTrace();
		}

		// Initialize swing elements
		JPanel panel = new JPanel();
		frame = new JFrame("Login");

		// Set frame attributes
		frame.setSize(FRAME_DIMENSION);
		frame.setPreferredSize(FRAME_DIMENSION);
		frame.setMinimumSize(FRAME_DIMENSION);
		frame.setMaximumSize(FRAME_DIMENSION);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // Center of the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);

		// Initialize Components
		username = new JLabel("Username:");
		username.setBounds(15, 10, 80, 25);
		panel.add(username);

		usernameText = new JTextField(30);
		usernameText.setBounds(90, 10, 250, 25);
		panel.add(usernameText);

		password = new JLabel("Password:");
		password.setBounds(15, 40, 80, 25);
		panel.add(password);

		passwordText = new JTextField(30);
		passwordText.setBounds(90, 40, 250, 25);
		panel.add(passwordText);

		submitButton = new JButton("Submit");
		submitButton.setBounds(125, 75, 100, 35);
		submitButton.addActionListener(new MainLogin());
		panel.add(submitButton);

		frame.setVisible(true);
	}

	/**
	 * This method is called when the submit button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		for (User user : users) {
			if (user.getUsername().equals(usernameText.getText())
					&& user.getPassword().equals(passwordText.getText())) {

				// This is the entry point to the main UI
				MainUI system = new MainUI();
				system.launchUI();
				frame.dispose();
				return;
			}
		}

		frame.dispose();

		// Inform the user that no such credentials exist
		JPanel panel = new JPanel();
		JFrame error = new JFrame();

		error.setSize(FRAME_DIMENSION);
		error.setPreferredSize(FRAME_DIMENSION);
		error.setMinimumSize(FRAME_DIMENSION);
		error.setMaximumSize(FRAME_DIMENSION);
		error.setResizable(false);
		error.setLocationRelativeTo(null);
		error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		error.add(panel);

		panel.setLayout(new GridBagLayout()); // Center JLabel in JPanel

		JLabel message = new JLabel("Login Unsuccessful!");
		message.setForeground(Color.RED);
		message.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(message);

		error.setVisible(true);
	}
}
