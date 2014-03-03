package Graphs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.JavaUtilities.Graph.Graph;

public class TestMinSpanningTree {

	Graph g = new Graph(true);
	ArrayList<String> bfsList = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
				
		g.addUndirectedEdge("a", "b", 3);
		g.addUndirectedEdge("a", "e", 1);
		g.addUndirectedEdge("b", "c", 5);
		g.addUndirectedEdge("b", "e", 4);
		g.addUndirectedEdge("c", "e", 6);
		g.addUndirectedEdge("c", "d", 2);
		g.addUndirectedEdge("e", "d", 7);
				
	}
	
	@Test
	public void testKruskalsMinSpanningTree()
	{
		int expected = 11;
		ArrayList<ArrayList<String>> mst = g.kruskalsMinSpanningTree();
		int sum = 0;
		
		for(ArrayList<String> aList: mst)
		{
			sum = sum + Integer.valueOf(aList.get(2));
		}
		
		Assert.assertEquals(expected, sum);
	}
	
	@Test
	public void testPrimsMinSpanningTree()
	{
		int expected = 11;
		ArrayList<ArrayList<String>> mst = g.primsMinSpanningTree();
		int sum = 0;
		
		for(ArrayList<String> aList: mst)
		{
			sum = sum + Integer.valueOf(aList.get(2));
		}
		
		Assert.assertEquals(expected, sum);
	}
	
	@Test
	public void testDijkstraAlgorithm()
	{
		int expected = 11;
		HashMap<String, Integer> dijkMap = g.getDijkstraShortestPath("a");
				
		Assert.assertEquals(5, dijkMap.size());
		Assert.assertTrue(dijkMap.get("a") == 0);
		Assert.assertTrue(dijkMap.get("b") == 3);
		Assert.assertTrue(dijkMap.get("e") == 1);
		Assert.assertTrue(dijkMap.get("c") == 7);
		Assert.assertTrue(dijkMap.get("d") == 8);
				
	}
	
	

}
