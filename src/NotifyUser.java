import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class will is used to notify the user with a given message (likely an error)
 * @author Cole Letsche
 */
public class NotifyUser {

	/**
	 * Static JFrame dimensions
	 */
	private static final Dimension FRAME_DIMENSIONS = new Dimension(400, 150);

	/**
	 * Sends the user a message
	 * @param msg The message to send the user
	 */
	public static void notify(String msg) {
		JPanel panel = new JPanel();
		JFrame error = new JFrame();

		// Setting frame attributes
		error.setSize(FRAME_DIMENSIONS);
		error.setPreferredSize(FRAME_DIMENSIONS);
		error.setMinimumSize(FRAME_DIMENSIONS);
		error.setMaximumSize(FRAME_DIMENSIONS);
		error.setResizable(false);
		error.setLocationRelativeTo(null);
		error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		error.add(panel);

		panel.setLayout(new GridBagLayout()); // Center JLabel in JPanel

		JLabel message = new JLabel(msg);
		message.setForeground(Color.RED);
		message.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(message);

		error.setVisible(true);
	}
}
