package Arrays;

import static org.junit.Assert.*;
import com.JavaUtilities.Arrays.Arrays;

import org.junit.Test;

public class TestArraysSort {
	
	Integer[] intArray = new Integer[5];
	Integer[] sortedIntArray = new Integer[5];
		
	@Test
	public void TestBubbleSort() {
		intArray[0] = 3; sortedIntArray[0] = 1;
		intArray[1] = 1; sortedIntArray[1] = 2;
		intArray[2] = 5; sortedIntArray[2] = 3;
		intArray[3] = 4; sortedIntArray[3] = 4;
		intArray[4] = 2; sortedIntArray[4] = 5;
		
		Arrays.BubbleSort(intArray);
		
		for(int i=0; i<intArray.length; i++)
		{
			assertEquals(intArray[i], sortedIntArray[i]);
		}
	}
	
	@Test
	public void TestInsertSort() {
		
		intArray[0] = 3; sortedIntArray[0] = 1;
		intArray[1] = 1; sortedIntArray[1] = 2;
		intArray[2] = 5; sortedIntArray[2] = 3;
		intArray[3] = 4; sortedIntArray[3] = 4;
		intArray[4] = 2; sortedIntArray[4] = 5;
		
		Arrays.InsertSort(intArray);
		
		for(int i=0; i<intArray.length; i++)
		{
			assertEquals(intArray[i], sortedIntArray[i]);
		}		
	}
	
	@Test
	public void TestSelectSort() {
		
		intArray[0] = 3; sortedIntArray[0] = 1;
		intArray[1] = 1; sortedIntArray[1] = 2;
		intArray[2] = 5; sortedIntArray[2] = 3;
		intArray[3] = 4; sortedIntArray[3] = 4;
		intArray[4] = 2; sortedIntArray[4] = 5;
		
		Arrays.SelectSort(intArray);
		
		for(int i=0; i<intArray.length; i++)
		{
			assertEquals(intArray[i], sortedIntArray[i]);
		}

		
	}
	
	@Test
	public void TestMergeSort() {
		
		intArray[0] = 3; sortedIntArray[0] = 1;
		intArray[1] = 1; sortedIntArray[1] = 2;
		intArray[2] = 5; sortedIntArray[2] = 3;
		intArray[3] = 4; sortedIntArray[3] = 4;
		intArray[4] = 2; sortedIntArray[4] = 5;
		
		Arrays.mergeSort(intArray);
		
		for(int i=0; i<intArray.length; i++)
		{
			assertEquals(sortedIntArray[i], intArray[i]);
		}
		
	}
	
	@Test
	public void TestHeapSort() {
		
		intArray[0] = 3; sortedIntArray[0] = 1;
		intArray[1] = 1; sortedIntArray[1] = 2;
		intArray[2] = 5; sortedIntArray[2] = 3;
		intArray[3] = 4; sortedIntArray[3] = 4;
		intArray[4] = 2; sortedIntArray[4] = 5;
		
		Arrays.heapSort(intArray);
		
		for(int i=0; i<intArray.length; i++)
		{
			assertEquals(sortedIntArray[i], intArray[i]);
		}
		
	}
	
	@Test
	public void TestQuickSort() {
		
		intArray[0] = 3; sortedIntArray[0] = 1;
		intArray[1] = 1; sortedIntArray[1] = 2;
		intArray[2] = 5; sortedIntArray[2] = 3;
		intArray[3] = 4; sortedIntArray[3] = 4;
		intArray[4] = 2; sortedIntArray[4] = 5;
		
		Arrays.quickSort(intArray);
		
		for(int i=0; i<intArray.length; i++)
		{
			assertEquals(sortedIntArray[i], intArray[i]);
		}
		
	}

}
