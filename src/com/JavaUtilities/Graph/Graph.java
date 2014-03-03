package com.JavaUtilities.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

import com.JavaUtilities.DisjointSet.DisjointSet;
import com.JavaUtilities.Heaps.*;

public class Graph {
	
	private int numVertices;
	private final int maxNumVertices;
	private final boolean isWeighted;
	private HashMap<Vertex, ArrayList<Edge>> graph;
	private HashMap<String, Vertex> stringToVertex;
		
	/**
	 * 
	 * @param isWeighted
	 */
	public Graph(boolean isWeighted)
	{
		this.numVertices = 0;
		this.maxNumVertices = Integer.MAX_VALUE;
		graph = new HashMap<Vertex, ArrayList<Edge>>();
		stringToVertex = new HashMap<>();
		this.isWeighted = isWeighted;
	}
	
	/**
	 * 	
	 * @param isWeighted
	 * @param maxNumVertices
	 */
	public Graph(boolean isWeighted, int maxNumVertices)
	{
		this.numVertices = 0;
		this.maxNumVertices = maxNumVertices;
		graph = new HashMap<Vertex, ArrayList<Edge>>();
		stringToVertex = new HashMap<>();
		this.isWeighted = isWeighted;			
	}
	
	/**
	 * 
	 * @param label
	 * @return
	 */
	public boolean addVertex(String label)
	{
		Vertex newVertex = new Vertex(label);
		
		if(this.numVertices == this.maxNumVertices || graph.containsKey(newVertex))
		{
			return false;
		}
		
		graph.put(newVertex, new ArrayList<Edge>());
		stringToVertex.put(label, newVertex);
		numVertices++;
		return true;
	}
	
	/**
	 * 
	 * @param fromNode
	 * @param toNode
	 * @return
	 */
	public boolean addDirectedEdge(String fromNode, String toNode)
	{
		if(this.isWeighted)
		{
			return false;
		}
		return addDirectedEdge(fromNode, toNode, null);
	}
	
	/**
	 * 
	 * @param fromNode
	 * @param toNode
	 * @param weight
	 * @return
	 */
	public boolean addDirectedEdge(String fromNode, String toNode, Integer weight)
	{
		if(!this.isWeighted && weight != null)
		{
			return false;
		}
		
		Vertex fromVertex = stringToVertex.get(fromNode);
		Vertex toVertex = stringToVertex.get(toNode);
		
		if(fromVertex == null || toVertex == null)
		{
			return false;
		}
		
		Edge e;
		
		if(weight == null)
		{
			e = new Edge(fromVertex, toVertex);
		}
		else
		{
			e = new Edge(toVertex, fromVertex, weight);
		}
		
		ArrayList<Edge> edgeList = graph.get(fromVertex);
		edgeList.add(e);
		return true;
	}
	
	/**
	 * 
	 * @param fromNode
	 * @param toNode
	 * @return
	 */
	public boolean removeDirectedEdge(String fromNode, String toNode)
	{
		Vertex fromVertex = stringToVertex.get(fromNode);
		Vertex toVertex = stringToVertex.get(toNode);
		
		if(fromVertex == null || toVertex == null)
		{
			return false;
		}
		
		ArrayList<Edge> e1 = graph.get(fromVertex);
				
		if(e1 == null)
		{
			return false;
		}
		
		for(Edge e: e1)
		{
			if(e.getToVertex() == toVertex)
			{
				e1.remove(e);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param firstNode
	 * @param secondNode
	 * @return
	 */
	public boolean addUndirectedEdge(String firstNode, String secondNode)
	{
		if(this.isWeighted)
		{
			return false;
		}
		return addUndirectedEdge(firstNode, secondNode, null);
	}
	
	/**
	 * 
	 * @param firstNode
	 * @param secondNode
	 * @param weight
	 * @return
	 */
	public boolean addUndirectedEdge(String firstNode, String secondNode, Integer weight)
	{
		if(!this.isWeighted && weight != null)
		{
			return false;
		}
		
		Vertex fromVertex = stringToVertex.get(firstNode);
		Vertex toVertex = stringToVertex.get(secondNode);
		
		if(fromVertex == null || toVertex == null)
		{
			return false;
		}
		
		Edge e1, e2;
		
		if(weight == null)
		{
			e1 = new Edge(fromVertex, toVertex);
			e2 = new Edge(toVertex, fromVertex);
		}
		else
		{
			e1 = new Edge(fromVertex, toVertex, weight);
			e2 = new Edge(toVertex, fromVertex, weight);
		}
		
		ArrayList<Edge> edgeList = graph.get(fromVertex);
		edgeList.add(e1);
			
		edgeList = graph.get(toVertex);
		edgeList.add(e2);
		
		return true;
	}
	
	/**
	 * 
	 * @param firstNode
	 * @param secondNode
	 * @return
	 */
	public boolean removeUndirectedEdge(String firstNode, String secondNode)
	{
		Vertex fromVertex = stringToVertex.get(firstNode);
		Vertex toVertex = stringToVertex.get(secondNode);
		
		if(fromVertex == null || toVertex == null)
		{
			return false;
		}
		
		ArrayList<Edge> e1 = graph.get(fromVertex);
		ArrayList<Edge> e2 = graph.get(toVertex);
		
		if(e1 == null || e2 == null)
		{
			return false;
		}
		
		Edge edge1 = null, edge2 = null;
		
		for(Edge e: e1)
		{
			if(e.getToVertex() == toVertex)
			{
				edge1 = e;
				break;
			}
		}
		
		for(Edge e: e2)
		{
			if(e.getToVertex() == fromVertex)
			{
				edge2 = e;
				break;
			}
		}
		
		if(edge1 == null || edge2 == null)
		{
			return false;
		}
		
		e1.remove(edge1);
		e2.remove(edge2);
		
		return true;
	}
	
	/**
	 * 
	 * @param startNode
	 * @return
	 */
	public ArrayList<String> breadthFirstSearch(String startNode)
	{
		if(!stringToVertex.containsKey(startNode))
		{
			return null;
		}
				
		HashSet<String> strSet = new HashSet<String>();
		LinkedList<Vertex> vertexQ = new LinkedList<Vertex>();
		ArrayList<String> retList = new ArrayList<String>();
		
		vertexQ.add(stringToVertex.get(startNode));
		
		
		while(!vertexQ.isEmpty())
		{
			Vertex firstNode = vertexQ.remove();
			String firstNodeStr = firstNode.getLabel();
			
			if(strSet.contains(firstNodeStr))
			{
				continue;
			}

			strSet.add(firstNodeStr);
			retList.add(firstNodeStr);
			
			ArrayList<Edge> adjEdges = graph.get(firstNode);
			
			for(Edge e: adjEdges)
			{
				if(!strSet.contains(e.getToVertex().getLabel()))
				{
					vertexQ.add(e.getToVertex());
				}
			}					
		}
		
		return retList;
	}
	
	/**
	 * 
	 * @param startNode
	 * @return
	 */
	public ArrayList<String> depthFirstSearch(String startNode)
	{
		if(!stringToVertex.containsKey(startNode))
		{
			return null;
		}
		
		HashSet<String> strSet = new HashSet<String>();
		Stack<Vertex> vertexStack = new Stack<Vertex>();
		ArrayList<String> retList = new ArrayList<String>();
		
		vertexStack.push(stringToVertex.get(startNode));
		
		while(!vertexStack.isEmpty())
		{
			Vertex topNode = vertexStack.peek();
			String topNodeStr = topNode.getLabel();
			
			if(!strSet.contains(topNodeStr))
			{
				strSet.add(topNodeStr);
				retList.add(topNodeStr);
			}	
			
			boolean allEdgesFound = true;
			
			for(Edge e: graph.get(topNode))
			{
				Vertex toNode = e.getToVertex();
				if(!strSet.contains(toNode.getLabel()))
				{
					vertexStack.push(toNode);
					allEdgesFound = false;
					break;
				}
			}
			
			if(allEdgesFound)
			{
				vertexStack.pop();
			}
		}
		
		return retList;		
	}
	
	public ArrayList<ArrayList<String>> kruskalsMinSpanningTree()
	{
		if(!isWeighted)
		{
			return null;
		}
		
		ArrayList<ArrayList<String>> retList = new ArrayList<>();
		PriorityQueue<Edge> edgeQ = new PriorityQueue<>();
		
		DisjointSet<Vertex> dSet = new DisjointSet<>();
		for(Vertex v: graph.keySet())
		{
			dSet.makeSet(v);
			for(Edge e: graph.get(v))
			{
				edgeQ.addElement(e);
			}
		}
		
		while(!edgeQ.isEmpty())
		{
			Edge e = edgeQ.deleteTopElement();
			Vertex v1 = e.getFromVertex();
			Vertex v2 = e.getToVertex();
			
			if(dSet.findSet(v1) != dSet.findSet(v2))
			{
				dSet.mergeSets(v1, v2);
				ArrayList<String> vList = new ArrayList<>();
				vList.add(v1.getLabel());
				vList.add(v2.getLabel());
				vList.add(String.valueOf(e.getWeight()));
				retList.add(vList);
			}			
		}
		
		return retList;		
	}
	
	public ArrayList<ArrayList<String>> primsMinSpanningTree()
	{
		if(!isWeighted)
		{
			return null;
		}
		
		ArrayList<ArrayList<String>> retList = new ArrayList<>();
		
		if(graph.size() == 0)
		{
			return retList;
		}
		
		PriorityQueue<Vertex> vertexQ = new PriorityQueue<>(10, new Comparator<Vertex>(){

			@Override
			public int compare(Vertex o1, Vertex o2) {
				return o1.getRank() - o2.getRank();
			}
			
		});
		
		for(Vertex v: graph.keySet())
		{
			v.setRank(Integer.MAX_VALUE);
			v.setParent(null);
			vertexQ.addElement(v);
		}
		
		Vertex topVertex = vertexQ.deleteTopElement();
		topVertex.setRank(0);
		
		while(!vertexQ.isEmpty())
		{
			ArrayList<Edge> edgeList = graph.get(topVertex);
			
			for(Edge e: edgeList)
			{
				Vertex firstVertex = e.getFromVertex();
				Vertex secondVertex = e.getToVertex();
				
				if(firstVertex.equals(secondVertex))
				{
					continue;
				}
				
				Vertex v = (firstVertex.equals(topVertex))?secondVertex:firstVertex;
				
				if(vertexQ.getIndex(v) != -1 && e.getWeight() < v.getRank())
				{
					v.setRank(e.getWeight());
					v.setParent(topVertex);
					vertexQ.deleteElement(v);
					vertexQ.addElement(v);
				}
				
			}
			
			topVertex = vertexQ.deleteTopElement();
			
			if(topVertex.getParent() == null)
			{
				continue;
			}
			
			ArrayList<String> vertexList = new ArrayList<String>();
			vertexList.add(topVertex.getParent().getLabel());
			vertexList.add(topVertex.getLabel());
			vertexList.add(String.valueOf(topVertex.getRank()));
			retList.add(vertexList);
		}
		
		return retList;
	}
	
	public HashMap<String ,Integer> getDijkstraShortestPath(String startNode)
	{
		if(!this.isWeighted)
		{
			return null;
		}
		
		HashMap<String, Integer> retMap = new HashMap<>();
		PriorityQueue<Vertex> vertexQ = new PriorityQueue<>(10, new Comparator<Vertex>(){

			@Override
			public int compare(Vertex o1, Vertex o2) {
				// TODO Auto-generated method stub
				return o1.getRank() - o2.getRank();
			}
			
		});
		
		if(!stringToVertex.containsKey(startNode))
		{
			return retMap;
		}
		
		for(Vertex v: graph.keySet())
		{
			if(v.getLabel().compareTo(startNode) == 0)
			{
				v.setRank(0);
				v.setParent(null);
			}
			else
			{
				v.setRank(Integer.MAX_VALUE);
				v.setParent(null);
			}
			vertexQ.addElement(v);
		}
		
		Vertex topNode = vertexQ.deleteTopElement();
		
		while(!vertexQ.isEmpty())
		{
			for(Edge e: graph.get(topNode))
			{
				Vertex toNode = e.getToVertex();
				
				if(toNode.equals(topNode))
				{
					continue;
				}
				
				if(vertexQ.getIndex(toNode) != -1 && toNode.getRank() > (e.getWeight() + topNode.getRank()))
				{
					toNode.setRank(e.getWeight() + topNode.getRank());
					vertexQ.deleteElement(toNode);
					vertexQ.addElement(toNode);
				}			
			}
			
			topNode = vertexQ.deleteTopElement();			
		}
		
		for(Vertex v: graph.keySet())
		{
			retMap.put(v.getLabel(), v.getRank());
		}
		
		return retMap;
		
	}
}
