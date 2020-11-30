package pdamianik.cipher;

/**
 * A util class for the tests
 * @author pdamianik
 * @version 2020-11-30
 */

public class TestUtil {
	/**
	 * Throws an {@link AssertionError}, when the passed parameter is false, does nothing otherwise.
	 * @param condition whether an {@link AssertionError} shall be thrown or not.
	 * @throws AssertionError will be thrown when the parameter is false.
	 */

	public static void realAssert (boolean condition) throws AssertionError {
		if (!condition)
			throw new AssertionError();
	}
}
