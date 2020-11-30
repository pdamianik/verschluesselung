package pdamianik.view;

import javax.swing.*;

/**
 * A simple window to display a panel
 * @author pdamianik
 * @version 2020-11-30
 */

public class Window extends JFrame {
	public Window(String title, JPanel contentPanel) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(contentPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Ask the user for an initialization value for a cipher
	 * @param valueName the name of the initialization value
	 * @param initialValue the initial value of the initialization value
	 * @return the resulting value
	 */

	public String getInitializationValue(String valueName, String initialValue) {
		return JOptionPane.showInputDialog(this, valueName, initialValue);
	}
}
