package Strings;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.JavaUtilities.Strings.Strings;

public class TestGetLevenshteinDistance {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testZeroLengthCase() {
		
		assertEquals(Strings.getLevenshteinDistance("", ""), 0);
		assertEquals(Strings.getLevenshteinDistance("", "a"), 1);
		assertEquals(Strings.getLevenshteinDistance("ab", ""), 2);	
	}
	
	@Test
	public void testNormalCase() {
		
		assertEquals(Strings.getLevenshteinDistance("abc", "a"), 2);
		assertEquals(Strings.getLevenshteinDistance("abc", "t"), 3);
		assertEquals(Strings.getLevenshteinDistance("ell", "hello"), 2);
		assertEquals(Strings.getLevenshteinDistance("hello", "theres"), 4);	
	}

}
