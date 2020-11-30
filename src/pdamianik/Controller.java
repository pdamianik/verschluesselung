package pdamianik;

import pdamianik.cipher.Cipher;
import pdamianik.cipher.MonoAlphabeticCipher;
import pdamianik.cipher.ShiftCipher;
import pdamianik.cipher.SubstitutionCipher;
import pdamianik.view.Layout;
import pdamianik.view.Window;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;

/**
 * The controller for the cipher program
 * @author pdamianik
 * @version 2020-11-30
 */

public class Controller implements ListSelectionListener {
	private Cipher currentCipher;
	private final Layout layout;
	private final Window window;
	private boolean lock;

	/**
	 * Initializes the UI
	 */

	public Controller() {
		String[] ciphers = new String[]{
				"Substitution cipher",
				"Shift cipher"
		};
		lock = false;
		layout = new Layout(ciphers, this, new EncryptDocumentListener(), new DecryptDocumentListener());
		window = new Window("Ciphers", layout);
	}

	/**+
	 * Reacts to the selection of a new cipher by asking the user for initialization values initializing a new cipher of the selected type
	 * @param e the ListSelectionEvent for the selection of a new cipher
	 */

	@Override
	public void valueChanged(ListSelectionEvent e) {
		try {
			switch (layout.getSelectedIndex()) {
				case 0:
					currentCipher = new SubstitutionCipher(window.getInitializationValue("Substitution alphabet", MonoAlphabeticCipher.DEFAULT_ALPHABET));
					break;
				case 1:
					currentCipher = new ShiftCipher(Integer.parseInt(window.getInitializationValue("Letter shift", "0")));
					break;
			}
		} catch (NullPointerException | NumberFormatException ignored) {
		}
	}

	/**
	 * A document listener that reacts to a change in the encryption text field
	 * @author pdamianik
	 * @version 2020-11-30
	 */

	private class EncryptDocumentListener implements DocumentListener {
		/**
		 * Reacts to an insertion of text into the encryption text field. Calls {@link #update(DocumentEvent)}
		 * @see #update(DocumentEvent)
		 * @param e the document event
		 */

		@Override
		public void insertUpdate(DocumentEvent e) {
			update(e);
		}

		/**
		 * Reacts to a deletion of text into the encryption text field. Calls {@link #update(DocumentEvent)}
		 * @see #update(DocumentEvent)
		 * @param e the document event
		 */

		@Override
		public void removeUpdate(DocumentEvent e) {
			update(e);
		}

		/**
		 * Calls the encryption method of the currently selected cipher on the encryption text field and outputs the result into the decryption text field
		 * @param e used to get the text in the text field
		 */

		private void update(DocumentEvent e) {
			if (currentCipher == null) {
				JOptionPane.showMessageDialog(window, "Please choose a cipher from the list below", "No Cipher", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (lock) {
				return;
			}
			lock = true;
			try {
				layout.encrypt(currentCipher.encrypt(e.getDocument().getText(0, e.getDocument().getLength())));
			} catch (BadLocationException badLocationException) {
				badLocationException.printStackTrace();
			}
			lock = false;
		}

		/**
		 * ignored
		 * @param e ignored
		 */

		@Override
		public void changedUpdate(DocumentEvent e) {

		}
	}

	private class DecryptDocumentListener implements DocumentListener {
		/**
		 * Reacts to an insertion of text into the decryption text field. Calls {@link #update(DocumentEvent)}
		 * @see #update(DocumentEvent)
		 * @param e the document event
		 */

		@Override
		public void insertUpdate(DocumentEvent e) {
			update(e);
		}

		/**
		 * Reacts to a deletion of text into the decryption text field. Calls {@link #update(DocumentEvent)}
		 * @see #update(DocumentEvent)
		 * @param e the document event
		 */

		@Override
		public void removeUpdate(DocumentEvent e) {
			update(e);
		}

		/**
		 * Calls the decryption method of the currently selected cipher on the decryption text field and outputs the result into the encryption text field
		 * @param e used to get the text in the text field
		 */

		private void update(DocumentEvent e) {
			if (currentCipher == null) {
				JOptionPane.showMessageDialog(window, "Please choose a cipher from the list above", "No Cipher", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (lock)
				return;
			lock = true;
			try {
				layout.decrypt(currentCipher.decrypt(e.getDocument().getText(0, e.getDocument().getLength())));
			} catch (BadLocationException badLocationException) {
				badLocationException.printStackTrace();
			}
			lock = false;
		}

		/**
		 * ignored
		 * @param e ignored
		 */

		@Override
		public void changedUpdate(DocumentEvent e) {

		}
	}

	/**
	 * Used to run the application. Creates a new {@link Controller} object
	 * @param args not used
	 */

	public static void main(String[] args) {
		new Controller();
	}
}
