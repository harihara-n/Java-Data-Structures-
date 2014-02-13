package Strings;

import static org.junit.Assert.*;

import com.JavaUtilities.Strings.Strings;

import org.junit.Before;
import org.junit.Test;

public class TestGetLongestCommonSubstring {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEmptyStringCase() {
		
		assertEquals(Strings.getLongestCommonSubstring("", "a"), "");
		assertEquals(Strings.getLongestCommonSubstring("a", ""), "");
	}
	
	@Test
	public void testNormalCase() {
		assertEquals(Strings.getLongestCommonSubstring("ab", "a"), "a");
		assertEquals(Strings.getLongestCommonSubstring("abc", "act"), "a");
		assertEquals(Strings.getLongestCommonSubstring("abracadabra", "arcane"), "ca");
		assertEquals(Strings.getLongestCommonSubstring("abcdefghijxyz", "defghijklmnopqr"), "defghij");
	}


}
