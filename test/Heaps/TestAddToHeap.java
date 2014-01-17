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
		Assert.assertEquals(5, intHeap.getTopElement().intValue());
		stringHeap.addElement("am at the top");
		stringHeap.addElement("wow, i am not at the top");
		Assert.assertEquals("am at the top".compareTo(stringHeap.getTopElement()), 0);
		
		for(int i=20; i>=0; i--)
		{
			intHeap.addElement(i);
		}
		
		Assert.assertEquals(0, intHeap.getTopElement().intValue());
	}

}
