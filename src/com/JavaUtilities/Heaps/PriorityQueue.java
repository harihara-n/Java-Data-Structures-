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
		if(qArray.length == capacity)
		{
			growArray();
		}
		
		qArray[count] = element;
		count++;
		heapifyQueue();
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
		heapifyQueue();
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
		this.qArray = Arrays.copyOf(qArray, qArray.length*2);
	}
	
	
	private void heapifyQueue()
	{
		for(int i=0; i<count/2; i++)
		{
			int left = 2*i+1;
			int right = Math.min(2*(i+1), count-1);
			int maxPosition;
			
			if(this.compare((T)qArray[i], (T)qArray[left]) < 0 || this.compare((T)qArray[i], (T)qArray[right]) < 0)
			{
				if(this.compare((T)qArray[left], (T)qArray[right]) < 0)
				{
					maxPosition = right;
				}
				else
				{
					maxPosition = left;
				}
					Object temp;
					temp = qArray[maxPosition];
					qArray[maxPosition] = qArray[i];
					qArray[i] = temp;
			}
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
	