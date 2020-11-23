package pdamianik.cipher;

/**
 * A Test that tests the class {@link SubstitutionCipher}
 * @author pdamianik
 * @version 2020-11-23
 */

public class SubstitutionCipherTest {
	public static void main(String[] args) {
		SubstitutionCipher cipher = new SubstitutionCipher("kipgauly\u00fcj\u00e4tsmxcfbrow\u00dfnevzq\u00f6dh");
		cipher.setSecretAlphabet("klewhu\u00e4sm\u00f6of\u00dfqgjvcaxrpnty\u00fcibdz");
		try {
			cipher.setSecretAlphabet("abc");
			throw new AssertionError();
		} catch (IllegalArgumentException ignored) {}
		try {
			cipher.setSecretAlphabet("abcdefghijklmnopqrstuvwxyz\u00e4\u00f6\u00fc+");
			throw new AssertionError();
		} catch (IllegalArgumentException ignored) {}
		try {
			cipher.setSecretAlphabet(null);
			throw new AssertionError();
		} catch (NullPointerException ignored) {}
		String ciphered = cipher.encrypt("Hello world!");
		realAssert(!ciphered.equals("Hello world!"));
		realAssert(cipher.decrypt(ciphered).equals("Hello world!".toLowerCase()));
	}

	/**
	 * Throws an {@link AssertionError}, when the passed parameter is false, does nothing otherwise.
	 * @param condition whether an {@link AssertionError} shall be thrown or not.
	 * @throws AssertionError will be thrown when the parameter is false.
	 */

	private static void realAssert (boolean condition) throws AssertionError {
		if (!condition)
			throw new AssertionError();
	}
}
