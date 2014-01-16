package Heaps;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.JavaUtilities.Heaps.*;

public class TestAddToHeap {

	PriorityQueue<String> stringHeap;
	PriorityQueue<Integer> intHeap;
	@Before
	public void setUp() throws Exception {
		intHeap = new PriorityQueue<Integer>();
		stringHeap = new PriorityQueue<String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void NoConstructorTest() {
		intHeap.addElement(10);
		Assert.assertEquals(10, intHeap.getTopElement().intValue());
		stringHeap.addElement("hello world");
		Assert.assertEquals("hello world".compareTo(stringHeap.getTopElement()), 0);
		intHeap.addElement(30);
		intHeap.addElement(5);
		Assert.assertEquals(30, intHeap.getTopElement().intValue());
	}

}
