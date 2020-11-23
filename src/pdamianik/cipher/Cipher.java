package pdamianik.cipher;

/**
 * A template for a cipher (has to at least contain a encrypt and decrypt method)
 * @author pdamianik
 * @version 2020-11-23
 */

public interface Cipher {
	/**
	 * A method to encrypt any passed string. Opposite of {@link #decrypt(String)}.
	 * @param text the text to encrypt.
	 * @return the encrypted text.
	 */

	String encrypt(String text);

	/**
	 * A method to encrypt any passed string. Opposite of {@link #encrypt(String)}.
	 * @param text the text to decrypt.
	 * @return the decrypted text.
	 */

	String decrypt(String text);
}
