package com.JavaUtilities.DisjointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DisjointSet<T> {
	
	private HashMap<T, SetElement> elementMap;
	private LinkedList<SetElement<T>> setList;
	
	public DisjointSet()
	{
		elementMap = new HashMap<T, SetElement>();
	}
	
	public void makeSet(T element)
	{
		SetElement newElement = new SetElement(element);
		elementMap.put(element, newElement);
		newElement.setRepresentativeElement(newElement);
		newElement.setDepth(0);
	}
	
	public T findSet(T element)
	{
		SetElement setElement = elementMap.get(element);
		
		if(setElement == null)
		{
			return null;
		}
		
		ArrayList<SetElement> setElementList = new ArrayList<>();
		setElementList.add(setElement);
		
		while(setElement.getRepresentativeElement() != setElement)
		{
			setElement = setElement.getRepresentativeElement();
			setElementList.add(setElement);
		}
		
		for(SetElement sEl: setElementList)
		{
			sEl.setRepresentativeElement(setElement); //Path Compression heuristic - reduces the running time of m merge + find operations to almost linear in number of initial sets.
		}
		
		return (T) setElement.getElement();
	}
	
	public boolean mergeSets(T element1, T element2)
	{
		T set1 = findSet(element1);
		T set2 = findSet(element2);
		
		if(set1.equals(set2))
		{
			return false;
		}
		
		SetElement repElement1 = elementMap.get(set1);
		SetElement repElement2 = elementMap.get(set2);
		
		if(repElement1.getDepth() > repElement2.getDepth())
		{
			repElement2.setRepresentativeElement(repElement1);
		}
		else if (repElement1.getDepth() < repElement2.getDepth())
		{
			repElement1.setRepresentativeElement(repElement2);
		}
		else
		{
			repElement2.setRepresentativeElement(repElement1);
			repElement1.setDepth(repElement1.getDepth() + 1);
		}
		
		return true;
	}
		
}
