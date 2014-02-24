package Graphs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import com.JavaUtilities.Graph.*;
import com.JavaUtilities.Heaps.PriorityQueue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGraphTraversal {
	
	Graph g = new Graph(false);
	ArrayList<String> bfsList = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		
		g.addUndirectedEdge("a", "b");
		g.addUndirectedEdge("a", "c");
		g.addUndirectedEdge("b", "d");
		g.addUndirectedEdge("c", "e");
		g.addUndirectedEdge("a", "a");
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBreadthFirstSearch() {
		bfsList.add("a");
		bfsList.add("b");
		bfsList.add("c");
		bfsList.add("d");
		bfsList.add("e");
		
		ArrayList<String> retList = g.breadthFirstSearch("a");
		Assert.assertEquals(bfsList, retList);				
	}
	
	@Test
	public void testDepthFirstSearch() {
		bfsList.add("a");
		bfsList.add("b");
		bfsList.add("d");
		bfsList.add("c");
		bfsList.add("e");
		
		ArrayList<String> retList = g.depthFirstSearch("a");
		Assert.assertEquals(bfsList, retList);				
	}

}
