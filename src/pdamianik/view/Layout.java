package pdamianik.view;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Arrays;

/**
 * The layout and structure of the main window
 * @author pdamianik
 * @version 2020-11-30
 */

public class Layout extends JPanel {
	private final JTextField encrypt, decrypt;
	private final JList<String> cipherList;

	public Layout(String[] ciphers, ListSelectionListener listSelectionListener, DocumentListener encryptDocumentListener, DocumentListener decryptDocumentListener) {
		setLayout(new BorderLayout());

		DefaultListModel<String> model = new DefaultListModel<>();
		cipherList = new JList<>(model);
		cipherList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model.addAll(Arrays.asList(ciphers));
		cipherList.addListSelectionListener(listSelectionListener);
		JScrollPane scrollPane = new JScrollPane(cipherList);
		scrollPane.setPreferredSize(new Dimension(400, 300));
		add(scrollPane, BorderLayout.CENTER);

		JPanel encryptContainer = new JPanel();
		encryptContainer.setLayout(new BoxLayout(encryptContainer, BoxLayout.LINE_AXIS));
		encryptContainer.add(new JLabel("decrypted: "));
		encrypt = new JTextField();
		encryptContainer.add(encrypt);

		JPanel decryptContainer = new JPanel();
		decryptContainer.setLayout(new BoxLayout(decryptContainer, BoxLayout.LINE_AXIS));
		decryptContainer.add(new JLabel("encrypted: "));
		decrypt = new JTextField();
		decryptContainer.add(decrypt);

		encrypt.getDocument().addDocumentListener(encryptDocumentListener);
		decrypt.getDocument().addDocumentListener(decryptDocumentListener);

		add(encryptContainer, BorderLayout.PAGE_START);
		add(decryptContainer, BorderLayout.PAGE_END);
	}

	/**
	 * Getter for the index of the selected ciphers
	 * @return the index of the selected ciphers
	 */

	public int getSelectedIndex() {
		return cipherList.getSelectedIndex();
	}

	/**
	 * After encryption, displays the decrypted values
	 * @param result the decrypted values
	 */

	public void encrypt(String result) {
		this.decrypt.setText(result);
	}

	/**
	 * After decryption, displays the encrypted values
	 * @param result the encrypted values
	 */

	public void decrypt(String result) {
		this.encrypt.setText(result);
	}
}
