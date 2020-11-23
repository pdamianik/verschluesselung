package pdamianik.cipher;

/**
 * A simple substitution cipher
 * @author pdamianik
 * @version 2020-11-23
 */

public class SubstitutionCipher extends MonoAlphabeticCipher {
	/**
	 * Tries to initialize the secret alphabet with the passed alphabet. This will fail, if the parameter does not meet
	 * the criteria for a secret alphabet (as described in {@link MonoAlphabeticCipher#setSecretAlphabet(String)}.
	 * @param secretAlphabet the initial secret alphabet.
	 */

	public SubstitutionCipher(String secretAlphabet) {
		super.setSecretAlphabet(secretAlphabet);
	}

	/**
	 * Setter for the secret alphabet. This will fail, if the parameter does not meet
	 * the criteria for a secret alphabet (as described in {@link MonoAlphabeticCipher#setSecretAlphabet(String)}.
	 * @param secretAlphabet the secret alphabet to use.
	 */

	public void setSecretAlphabet(String secretAlphabet) {
	   super.setSecretAlphabet(secretAlphabet);
	}
}
