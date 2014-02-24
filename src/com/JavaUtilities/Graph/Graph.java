package com.JavaUtilities.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

import com.JavaUtilities.Heaps.*;

public class Graph {
	
	private int numVertices;
	private final int maxNumVertices;
	private final boolean isWeighted;
	private HashMap<Vertex, ArrayList<Edge>> graph;
	private PriorityQueue<Edge> edgeQueue;
		
	public Graph(boolean isWeighted)
	{
		this.numVertices = 0;
		this.maxNumVertices = Integer.MAX_VALUE;
		graph = new HashMap<Vertex, ArrayList<Edge>>();
		this.isWeighted = isWeighted;
		if(isWeighted)
		{
			edgeQueue = new PriorityQueue<Edge>();
		}
	}
	
	public Graph(boolean isWeighted, int maxNumVertices)
	{
		this.numVertices = 0;
		this.maxNumVertices = maxNumVertices;
		graph = new HashMap<Vertex, ArrayList<Edge>>();
		this.isWeighted = isWeighted;
		if(isWeighted)
		{
			edgeQueue = new PriorityQueue<Edge>();
		}		
	}
	
	public boolean addVertex(String label)
	{
		Vertex newVertex = new Vertex(label);
		
		if(this.numVertices == this.maxNumVertices || graph.containsKey(newVertex))
		{
			return false;
		}
		
		graph.put(newVertex, new ArrayList<Edge>());
		numVertices++;
		return true;
	}
	
	public boolean addDirectedEdge(String fromNode, String toNode)
	{
		if(this.isWeighted)
		{
			return false;
		}
		return addDirectedEdge(fromNode, toNode, null);
	}
	
	public boolean addDirectedEdge(String fromNode, String toNode, Integer weight)
	{
		if(!this.isWeighted && weight != null)
		{
			return false;
		}
		
		Vertex fromVertex = new Vertex(fromNode);
		Vertex toVertex = new Vertex(toNode);
		
		if(!graph.containsKey(fromVertex) || !graph.containsKey(toVertex))
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
		if(weight != null)
		{
			edgeQueue.addElement(e);
		}
		return true;
	}
	
	public boolean removeDirectedEdge(String fromNode, String toNode)
	{
		ArrayList<Edge> e1 = graph.get(new Vertex(fromNode));
				
		if(e1 == null)
		{
			return false;
		}
		
		for(Edge e: e1)
		{
			if(e.getToVertex().getLabel() == toNode)
			{
				e1.remove(e);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean addUndirectedEdge(String firstNode, String secondNode)
	{
		if(this.isWeighted)
		{
			return false;
		}
		return addUndirectedEdge(firstNode, secondNode, null);
	}
	
	public boolean addUndirectedEdge(String firstNode, String secondNode, Integer weight)
	{
		if(!this.isWeighted && weight != null)
		{
			return false;
		}
		
		Vertex fromVertex = new Vertex(firstNode);
		Vertex toVertex = new Vertex(secondNode);
		
		if(!graph.containsKey(fromVertex) || !graph.containsKey(toVertex))
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
		if(weight != null)
		{
			edgeQueue.addElement(e1);
		}
		
		edgeList = graph.get(toVertex);
		edgeList.add(e2);
		if(weight != null)
		{
			edgeQueue.addElement(e2);
		}
		return true;
	}
	
	public boolean removeUndirectedEdge(String firstNode, String secondNode)
	{
		ArrayList<Edge> e1 = graph.get(new Vertex(firstNode));
		ArrayList<Edge> e2 = graph.get(new Vertex(secondNode));
		
		if(e1 == null || e2 == null)
		{
			return false;
		}
		
		Edge edge1 = null, edge2 = null;
		
		for(Edge e: e1)
		{
			if(e.getToVertex().getLabel() == secondNode)
			{
				edge1 = e;
				break;
			}
		}
		
		for(Edge e: e2)
		{
			if(e.getToVertex().getLabel() == firstNode)
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
	
	public ArrayList<String> breadthFirstSearch(String startNode)
	{
		if(!graph.containsKey(new Vertex(startNode)))
		{
			return null;
		}
				
		HashSet<String> strSet = new HashSet<String>();
		LinkedList<Vertex> vertexQ = new LinkedList<Vertex>();
		ArrayList<String> retList = new ArrayList<String>();
		
		vertexQ.add(new Vertex(startNode));
		
		
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
	
	public ArrayList<String> depthFirstSearch(String startNode)
	{
		if(!graph.containsKey(new Vertex(startNode)))
		{
			return null;
		}
		
		HashSet<String> strSet = new HashSet<String>();
		Stack<Vertex> vertexStack = new Stack<Vertex>();
		ArrayList<String> retList = new ArrayList<String>();
		
		vertexStack.push(new Vertex(startNode));
		
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
		
}
