package pdamianik.cipher;

/**
 * A simple shift/caesar cipher
 * @author pdamianik
 * @version 2020-11-23
 */

public class ShiftCipher extends MonoAlphabeticCipher {

	/**
	 * Initializes the secret alphabet with a shifted version
	 * @param value the shift of the alphabets letters
	 */

	public ShiftCipher(int value) {
		setShiftValue(value);
	}

	/**
	 * Creates a new secret alphabet based on a new shift
	 * @param value the shift of the alphabets letters
	 */

	public void setShiftValue(int value) {
		String secretAlphabet = MonoAlphabeticCipher.DEFAULT_ALPHABET;
		if (value < 0)
			value = secretAlphabet.length() - (Math.abs(value) % secretAlphabet.length());
		else
			value = value % secretAlphabet.length();
		super.setSecretAlphabet(secretAlphabet.substring(value) + secretAlphabet.substring(0, value));
	}
}

