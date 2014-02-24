package com.JavaUtilities.Graph;
import java.util.Comparator;

import com.JavaUtilities.Graph.Vertex;

public class Edge implements Comparable<Edge> {
	
	private Vertex fromVertex;
	private Vertex toVertex;
	private Integer weight;
	
	public Edge(Vertex v1, Vertex v2)
	{
		this.fromVertex = v1;
		this.toVertex = v2;
		this.weight = null;
	}
	
	public Edge(Vertex v1, Vertex v2, int weight)
	{
		this.fromVertex = v1;
		this.toVertex = v2;
		this.weight = weight;
	}
	
	public Vertex getFromVertex() {
		return fromVertex;
	}
	public void setFromVertex(Vertex fromVertex) {
		this.fromVertex = fromVertex;
	}
	public Vertex getToVertex() {
		return toVertex;
	}
	public void setToVertex(Vertex toVertex) {
		this.toVertex = toVertex;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.weight.compareTo(o.weight);
	}	

}
