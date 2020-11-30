package pdamianik.cipher;

import static pdamianik.cipher.TestUtil.realAssert;

/**
 * A Test that tests the class {@link ShiftCipher}
 * @author pdamianik
 * @version 2020-11-29
 */

public class ShiftCipherTest {
	public static void main(String[] args) {
		String originalAlphabet = new MonoAlphabeticCipher().getSecretAlphabet();
		int originalLength = originalAlphabet.length();
		int newLength = new ShiftCipher(2).getSecretAlphabet().length();
		realAssert(originalLength == newLength);
		realAssert(new ShiftCipher(2).getSecretAlphabet().equals(originalAlphabet.substring(2) + originalAlphabet.substring(0, 2)));
		realAssert(new ShiftCipher(newLength + 2).getSecretAlphabet().equals(new ShiftCipher(2).getSecretAlphabet()));
		realAssert(new ShiftCipher(-2).getSecretAlphabet().equals(originalAlphabet.substring(originalLength - 2) + originalAlphabet.substring(0, originalLength - 2)));
		realAssert(new ShiftCipher(-2 - newLength).getSecretAlphabet().equals(new ShiftCipher(-2).getSecretAlphabet()));
		System.out.println("Successfully tested the ShiftCipher");
	}
}
