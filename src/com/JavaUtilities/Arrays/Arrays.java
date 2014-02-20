package com.JavaUtilities.Arrays;

import java.util.Comparator;

public class Arrays  {
	
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
	
	public static <T> void BubbleSort(T[] arr, Comparator<T> comp)
	{
		boolean isSwapped = false;
		
		while(!isSwapped)
		{
			boolean noBubbles = true;
			for(int i=0; i<arr.length-1; i++)
			{
				if(comp.compare(arr[i], arr[i+1]) > 0)
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
	
	public static <T> void InsertSort(T[] arr, Comparator<T> comp)
	{
		for(int i=1; i<arr.length; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(comp.compare(arr[j], arr[i]) > 0)
				{
					insertElementAt(arr, i, j);
					break;
				}
			}
		}
	}
	
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
	
	public static <T> void SelectSort(T[] arr, Comparator<T> comp)
	{
		for(int i=0; i<arr.length; i++)
		{
			T minElement = arr[i];
			int minPos = i;
			for(int j=i+1; j<arr.length; j++)
			{
				if(comp.compare(minElement, arr[j]) > 0)
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
}
