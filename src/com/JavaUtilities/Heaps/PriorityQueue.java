//Simply making this change.

package com.JavaUtilities.Heaps;

import java.lang.reflect.Array;
import java.util.*;

public class PriorityQueue<T> implements Comparator<T>, Iterable<T> {
	
	private int capacity = 10;
	private int count = 0;
	private Comparator<T> comparator;
	private Object[] qArray;
	
	/**
	 * 
	 */
	public PriorityQueue()
	{
		qArray = new Object[this.capacity];
	}
	
	/**
	 * 
	 * @param capacity
	 */
	public PriorityQueue(int capacity)
	{
		this.capacity = capacity;
		qArray = new Object[this.capacity];
	}
	
	/**
	 * 
	 * @param capacity
	 * @param comparator
	 */
	public PriorityQueue(int capacity, Comparator<T> comparator)
	{
		this.capacity = capacity;
		this.comparator = comparator;
		qArray = new Object[this.capacity];
	}
	
	/**
	 * 
	 * @param pQueue
	 */
	public PriorityQueue(PriorityQueue<T> pQueue)
	{
		this.capacity = pQueue.capacity;
		this.count = pQueue.count;
		this.comparator = pQueue.comparator;
		this.qArray = new Object[pQueue.qArray.length];
		
		for(int i=0; i<this.qArray.length; i++)
		{
			this.qArray[i] = pQueue.qArray[i];
		}		
	}
	
	public boolean isEmpty()
	{
		if(this.count == 0)
		{
			return true;
		}
		
		return false;
	}
	
	public int size()
	{
		return this.count;
	}
	
	public int getIndex(T element)
	{
		for(int i=0; i<this.count; i++)
		{
			if(element.equals(this.qArray[i]))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	
	/**
	 * 
	 * @param element
	 * @return
	 */
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
	
	/**
	 * 
	 * @return
	 */
	public T deleteTopElement()
	{
		if(count == 0)
		{
			return null;
		}
		
		T returnValue = (T)qArray[0];
		qArray[0] = qArray[count-1];
		this.topdownHeapify(0);
		count--;
		return returnValue; 
	}
	
	/**
	 * 
	 * @param element
	 * @return
	 */	
	public T deleteElement(T element)
	{
		int index = this.getIndex(element);
		if(index == -1)
		{
			return null;
		}
		
		return deleteElementAt(index);
	}
	
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public T deleteElementAt(int index)
	{
		if(index >= this.count)
		{
			return null;
		}
		
		T returnValue = (T)this.qArray[index];
		this.qArray[index] = this.qArray[count-1];
		this.count--;
		this.topdownHeapify(index);		
		return returnValue;		
	}
	
	/**
	 * 
	 * @return
	 */
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
	
	
	private void topdownHeapify(int index)
	{
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

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return (Iterator<T>) Arrays.asList(this.qArray).iterator();
	}

}
	