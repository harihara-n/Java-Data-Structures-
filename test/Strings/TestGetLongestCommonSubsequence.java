package Strings;

import static org.junit.Assert.*;
import com.JavaUtilities.Strings.Strings;

import org.junit.Before;
import org.junit.Test;

public class TestGetLongestCommonSubsequence {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEmptyStringCase() {
		
		assertEquals(Strings.getLongestCommonSubsequence("", "a"), "");
		assertEquals(Strings.getLongestCommonSubsequence("a", ""), "");
	}
	
	@Test
	public void testNormalCase() {
		assertEquals(Strings.getLongestCommonSubsequence("ab", "a"), "a");
		assertEquals(Strings.getLongestCommonSubsequence("abc", "ac"), "ac");
		assertEquals(Strings.getLongestCommonSubsequence("abc", "act"), "ac");
		assertEquals(Strings.getLongestCommonSubsequence("abracadabra", "arcane"), "arca");
		assertEquals(Strings.getLongestCommonSubsequence("hello there", "happy tuesday"), "h te");
	}

}
