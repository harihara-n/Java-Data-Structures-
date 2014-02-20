package Strings;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import com.JavaUtilities.Strings.Strings;

public class TestFindNeedleExhaustive {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNullCase() {
		
		Assert.assertSame(true, Strings.findNeedleExhaustive(null, "hello").equals(new ArrayList<Integer>()));
		Assert.assertSame(true, Strings.findNeedleExhaustive("hello", "null").equals(new ArrayList<Integer>()));
		
	}

	@Test
	public void testNeedleLongerCase() {
		
		Assert.assertSame(true, Strings.findNeedleExhaustive("hel", "hello").equals(new ArrayList<Integer>()));
				
	}
	
	@Test
	public void testSingleNeedleCase() {
		
		ArrayList<Integer> result1 = new ArrayList<Integer>();
		result1.add(9);
		ArrayList<Integer> result2 = new ArrayList<Integer>();
		result2.add(3);
		
		Assert.assertSame(true, Strings.findNeedleExhaustive("hi there hello", "hello").equals(result1));
		Assert.assertSame(true, Strings.findNeedleExhaustive("banannana", "ann").equals(result2));
	}
	
	@Test
	public void testMultipleNeedleCase() {
		
		ArrayList<Integer> result1 = new ArrayList<Integer>();
		result1.add(1);
		result1.add(3);
		result1.add(6);
		ArrayList<Integer> result2 = new ArrayList<Integer>();
		result2.add(0);
		result2.add(18);
		
		Assert.assertSame(true, Strings.findNeedleExhaustive("banannana", "an").equals(result1));
		Assert.assertSame(true, Strings.findNeedleExhaustive("hello is this mr. hello", "hello").equals(result2));
	}
	
	
}
