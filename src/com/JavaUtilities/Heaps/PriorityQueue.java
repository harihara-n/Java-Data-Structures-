//Simply making this change.

package com.JavaUtilities.Heaps;

import java.lang.reflect.Array;
import java.util.*;

public class PriorityQueue<T> implements Comparator<T> {
	
	private int capacity = 10;
	private int count = 0;
	private Comparator<T> comparator;
	private Object[] qArray;
	
	public PriorityQueue()
	{
		qArray = new Object[this.capacity];
	}
	
	public PriorityQueue(int capacity)
	{
		this.capacity = capacity;
		qArray = new Object[this.capacity];
	}
	
	public PriorityQueue(int capacity, Comparator<T> comparator)
	{
		this.capacity = capacity;
		this.comparator = comparator;
		qArray = new Object[this.capacity];
	}
	
	public boolean addElement(T element)
	{
		if(count == qArray.length)
		{
			growArray();
		}
		
		qArray[count] = element;
		count++;
		this.bottomupHeapify();
		return true;
	}
	
	public T deleteElement()
	{
		if(count == 0)
		{
			return null;
		}
		
		T returnValue = (T)qArray[0];
		qArray[0] = qArray[count-1];
		this.topdownHeapify();
		count--;
		return returnValue; 
	}
	
	public T getTopElement()
	{
		if(count == 0)
		{
			return null;
		}
		
		return (T)qArray[0];
	}
	
	private void growArray()
	{
		this.qArray = Arrays.copyOf(qArray, (qArray.length)*2);
	}
	
	
	private void topdownHeapify()
	{
		int index = 0;
		int left = 2*index+1;
		int right = Math.min(2*(index+1), count-1);
		
		while(left <count && (this.compare((T)qArray[index], (T)qArray[left])>0 || this.compare((T)qArray[index], (T)qArray[right])>0))
		{
			int minChild = (this.compare((T)qArray[left], (T)qArray[right])<0)?left:right;
			Object temp = qArray[index];
			qArray[index] = qArray[minChild];
			qArray[minChild] = temp;
			
			index = minChild;
			left = 2*index+1;
			right = Math.min(2*(index+1), count-1);
		}
	}
	
	private void bottomupHeapify()
	{
		int index = count - 1;
		int parent = Math.max(0, (index-1)/2);
		
		while(this.compare((T)qArray[index], (T)qArray[parent])<0)
		{
			Object temp = qArray[index];
			qArray[index] = qArray[parent];
			qArray[parent] = temp;
			
			index = parent;
			parent = Math.max(0, (index-1)/2);
		}
	}

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		if(this.comparator == null)
		{
			Comparable<T> comparable = (Comparable) o1;
			return comparable.compareTo(o2);
		}
		else
		{
			return this.comparator.compare(o1, o2);
		}
	}

}
	