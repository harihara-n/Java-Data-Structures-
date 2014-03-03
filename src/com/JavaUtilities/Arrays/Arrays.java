package com.JavaUtilities.Arrays;

import java.util.Comparator;
import java.util.LinkedList;

import com.JavaUtilities.Heaps.*;

public class Arrays  {
	
	/**
	 * 
	 * @param arr
	 */
	public static <T> void BubbleSort(T[] arr)
	{
		Comparator<T> comparator = new Comparator<T>(){

			@Override
			public int compare(T arg0, T arg1) {
				
				Comparable<T> comparable = (Comparable)arg0;
				return comparable.compareTo(arg1);
			}
			
		};
		
		BubbleSort(arr, comparator);
	}
	
	/**
	 * 
	 * @param arr
	 * @param comp
	 */	
	public static <T> void BubbleSort(T[] arr, Comparator<T> comparator)
	{
		boolean isSwapped = false;
		
		while(!isSwapped)
		{
			boolean noBubbles = true;
			for(int i=0; i<arr.length-1; i++)
			{
				if(comparator.compare(arr[i], arr[i+1]) > 0)
				{
					T temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					noBubbles = false;
				}
			}
			
			if(noBubbles)
			{
				isSwapped = true;
			}
		}				
	}
	
	private static <T> void insertElementAt (T[] arr, int origPos, int newPos)
	{
		T origElement = arr[origPos];
		
		for(int i=origPos; i>newPos; i--)
		{
			arr[i] = arr[i-1];
		}
		
		arr[newPos] = origElement;
	}
	
	/**
	 * 
	 * @param arr
	 */
	public static <T> void InsertSort(T[] arr)
	{
		Comparator<T> comparator = new Comparator<T>(){

			@Override
			public int compare(T arg0, T arg1) {
				
				Comparable<T> comparable = (Comparable)arg0;
				return comparable.compareTo(arg1);
			}
			
		};
		
		InsertSort(arr, comparator);
	}
	
	/**
	 * 
	 * @param arr
	 * @param comp
	 */
	public static <T> void InsertSort(T[] arr, Comparator<T> comparator)
	{
		for(int i=1; i<arr.length; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(comparator.compare(arr[j], arr[i]) > 0)
				{
					insertElementAt(arr, i, j);
					break;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param arr
	 */	
	public static <T> void SelectSort(T[] arr)
	{
		Comparator<T> comparator = new Comparator<T>(){

			@Override
			public int compare(T arg0, T arg1) {
				
				Comparable<T> comparable = (Comparable)arg0;
				return comparable.compareTo(arg1);
			}
			
		};
		
		SelectSort(arr, comparator);
	}
	
	/**
	 * 
	 * @param arr
	 * @param comp
	 */
	public static <T> void SelectSort(T[] arr, Comparator<T> comparator)
	{
		for(int i=0; i<arr.length; i++)
		{
			T minElement = arr[i];
			int minPos = i;
			for(int j=i+1; j<arr.length; j++)
			{
				if(comparator.compare(minElement, arr[j]) > 0)
				{
					minElement = arr[j];
					minPos = j;
				}
			}
			
			T temp = arr[i];
			arr[i] = arr[minPos];
			arr[minPos] = temp;
		}
	}
	
	/**
	 * 
	 * @param arr
	 */	
	public static <T> void mergeSort(T[] arr)
	{
		Comparator<T> comparator = new Comparator<T>(){

			@Override
			public int compare(T arg0, T arg1) {
				Comparable<T> comparable = (Comparable)arg0;
				return comparable.compareTo(arg1);
			}
			
		};
		
		mergeSort(arr, comparator);
	}
	
	/**
	 * 
	 * @param arr
	 * @param comp
	 */
	public static<T> void mergeSort(T[] arr, Comparator<T> comparator)
	{
		sortForMergeSort(arr, 0, arr.length-1, comparator);
	}
	
	private static<T> void sortForMergeSort(T[] arr, int start, int end, Comparator<T> comparator)
	{
		if(start > end)
		{
			throw new IllegalArgumentException("start cannot be greater than end");
		}
		
		if(start == end)
		{
			return;
		}
		
		int mid = (start+end)/2;
		
		sortForMergeSort(arr, start, mid, comparator);
		sortForMergeSort(arr, mid+1, end, comparator);
		
		mergeForMergeSort(arr, start, mid, end, comparator);
	}
	
	private static<T> void mergeForMergeSort(T[] arr, int start, int mid, int end, Comparator<T> comparator)
	{
		LinkedList<T> firstList = new LinkedList<T>();
		LinkedList<T> secondList = new LinkedList<T>();
		
		for(int i=start; i<=mid; i++)
		{
			firstList.add(arr[i]);
		}
		
		for(int i=mid+1; i<=end; i++)
		{
			secondList.add(arr[i]);
		}
		
		for(int i=start; i<=end; i++)
		{
			if(!firstList.isEmpty() && !secondList.isEmpty())
			{
				if(comparator.compare(firstList.get(0), secondList.get(0)) < 0)
				{
					arr[i] = firstList.remove(0);
				}
				else
				{
					arr[i] = secondList.remove(0);
				}
			}
			else if(firstList.isEmpty())
			{
				arr[i] = secondList.remove(0);
			}
			else
			{
				arr[i] = firstList.remove(0);
			}
		}		
	}
	
	/**
	 * 
	 * @param arr
	 */
	public static <T> void heapSort(T[] arr)
	{
		Comparator<T> comparator = new Comparator<T>(){

			@Override
			public int compare(T arg0, T arg1) {
				Comparable<T> comparable = (Comparable)arg0;
				return comparable.compareTo(arg1);
			}
			
		};
		
		heapSort(arr, comparator);
	}
	
	/**
	 * 
	 * @param arr
	 * @param comp
	 */
	public static<T> void heapSort(T[] arr, Comparator<T> comparator)
	{
		PriorityQueue<T> pQueue = new PriorityQueue<T>(arr.length, comparator);
		
		for(int i=0; i<arr.length; i++)
		{
			pQueue.addElement(arr[i]);
		}
		
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = pQueue.deleteTopElement();
		}
	}
	
	/**
	 * 
	 * @param arr
	 */
	public static <T> void quickSort(T[] arr)
	{
		Comparator<T> comparator = new Comparator<T>(){

			@Override
			public int compare(T arg0, T arg1) {
				Comparable<T> comparable = (Comparable)arg0;
				return comparable.compareTo(arg1);
			}
			
		};
		
		heapSort(arr, comparator);
	}
	
	/**
	 * 
	 * @param arr
	 * @param comp
	 */
	public static<T> void quickSort(T[] arr, Comparator<T> comparator)
	{
		if(arr.length == 0)
		{
			return;
		}
		
		quickSortRecursive(arr, 0, arr.length-1, comparator);
	}
	
	private static <T> void quickSortRecursive(T[] arr, int start, int end, Comparator<T> comparator)
	{
		if(start > end)
		{
			throw new IllegalArgumentException("start cannot be greater than end");
		}
		
		if(start == end)
		{
			return;
		}
		
		int mid = (start+end)/2;
		
		int i = start;
		int j = end;
		
		while(i<j)
		{
			while(comparator.compare(arr[i], arr[mid]) < 0)
			{
				i++;
			}
			
			while(comparator.compare(arr[mid], arr[j]) < 0)
			{
				j--;
			}
			
			if(i<=j)
			{
				T temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		
		if(start != mid)
		{
			quickSortRecursive(arr, start, mid-1, comparator);
		}
		
		quickSortRecursive(arr, mid+1, end, comparator);
	}
	
}
