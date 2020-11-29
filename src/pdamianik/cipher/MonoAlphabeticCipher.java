package pdamianik.cipher;

import java.util.Arrays;

/**
 * A simple mono alphabetic cipher
 * @author pdamianik
 * @version 2020-11-23
 */

public class MonoAlphabeticCipher implements Cipher {
	private String secretAlphabet;
	public static final String DEFAULT_ALPHABET = "abcdefghijklmnopqrstuvwxyz\u00e4\u00f6\u00fc\u00df";
	private static final char[] DEFAULT_ALPHABET_SORTED = "abcdefghijklmnopqrstuvwxyz\u00df\u00e4\u00f6\u00fc".toCharArray();

	/**
	 * Initializes the secret alphabet in order (a - z, ä, ö, ü, ß).
	 */

	public MonoAlphabeticCipher() {
		this.secretAlphabet = DEFAULT_ALPHABET;
	}

	/**
	 * Getter for the secret alphabet.
	 * @return the secret alphabet.
	 */

	public String getSecretAlphabet() {
		return secretAlphabet;
	}

	/**
	 * Setter for the secret alphabet. Checks if the passed alphabet meets following criteria: it has to contain the lowercase
	 * letters from a to z and additionally the special german letters "ä, ö, ü, ß". Every letter in the definition secret alphabet
	 * has to exist once and only once in the secret alphabet.
	 * @param secretAlphabet the secret alphabet to use.
	 */

	protected void setSecretAlphabet(String secretAlphabet) {
		if (!checkSecretAlphabet(secretAlphabet)) {
			throw new IllegalArgumentException("Invalid alphabet");
		}
		this.secretAlphabet = secretAlphabet;
	}

	/**
	 * Checks if the passed alphabet meets the criteria for a secret alphabet (letters a - z, ä, ö, ü, ß in random order and each letter only once)
	 * @param secretAlphabet the candidate for the secret alphabet that has to be checked.
	 * @return whether the parameter meets the criteria for a secret alphabet.
	 */

	private boolean checkSecretAlphabet(String secretAlphabet) {
		char[] letters = secretAlphabet.toLowerCase().toCharArray();
		Arrays.sort(letters);
		return Arrays.equals(DEFAULT_ALPHABET_SORTED, letters);
	}

	/**
	 * Replaces every letter in the passed text with the assigned letter of the secret alphabet, but only if the letter in the passed
	 * text is part of the secret alphabet. Otherwise the unknown letter/symbol will just be copied to the resulting encrypted text.
	 * @param text the text to encrypt.
	 * @return the encrypted text.
	 */

	@Override
	public String encrypt(String text) {
		text = text.toLowerCase();
		StringBuilder result = new StringBuilder();
		for (char symbol : text.toCharArray()) {
			if (DEFAULT_ALPHABET.contains(String.valueOf(symbol))) {
				result.append(secretAlphabet.charAt(DEFAULT_ALPHABET.indexOf(symbol)));
			} else {
				result.append(symbol);
			}
		}
		return result.toString();
	}

	/**
	 * Inverts the encryption operation (see {@link #encrypt(String)})
	 * @param text the text to decrypt.
	 * @return the decrypted text.
	 */

	@Override
	public String decrypt(String text) {
		text = text.toLowerCase();
		StringBuilder result = new StringBuilder();
		for (char symbol : text.toCharArray()) {
			if (DEFAULT_ALPHABET.contains(String.valueOf(symbol))) {
				result.append(DEFAULT_ALPHABET.charAt(secretAlphabet.indexOf(symbol)));
			} else {
				result.append(symbol);
			}
		}
		return result.toString();
	}
}
