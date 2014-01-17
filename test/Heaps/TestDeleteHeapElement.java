package Heaps;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.JavaUtilities.Heaps.PriorityQueue;

public class TestDeleteHeapElement {

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
		Assert.assertEquals(10, intHeap.deleteElement().intValue());
		Assert.assertEquals(null, intHeap.deleteElement());
		
		stringHeap.addElement("hello world");
		stringHeap.addElement("not saying hello world");
		Assert.assertEquals("hello world".compareTo(stringHeap.deleteElement()), 0);
		Assert.assertEquals("not saying hello world".compareTo(stringHeap.deleteElement()), 0);
		Assert.assertEquals(null, stringHeap.deleteElement());
		
		for(int i=20; i>=0; i--)
		{
			intHeap.addElement(i);
		}
		for(int i=0; i<=20; i++)
		{
			Assert.assertEquals(i, intHeap.deleteElement().intValue());
		}
			
	}


}
