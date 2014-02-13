package com.JavaUtilities.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Strings {
	
	public static ArrayList<Integer> findNeedleExhaustive (String hayStack, String needle)
	{
		if(hayStack == null || needle == null)
		{
			return new ArrayList<Integer>();
		}
		
		ArrayList<Integer> returnIndices = new ArrayList<Integer>();
		
		for(int i=0; i<(hayStack.length() - needle.length() + 1); i++)
		{
			int tempIndex = i;
			boolean isMatch = true;
			for(int j=0; j<needle.length(); j++)
			{
				if(hayStack.charAt(tempIndex) != needle.charAt(j))
				{
					isMatch = false;
					break;
				}
				
				tempIndex++;
			}
			
			if(isMatch)
			{
				returnIndices.add(i);
			}
		}
		
		return returnIndices;
	}
	
	/*private static int[] constructShiftTable(String needle)
	{
		int[] shiftTable = new int[needle.length()];
		
		for(int preIndex =needle.length()-1, postIndex = 1;preIndex >0; preIndex--, postIndex++)
		{
			String prefixStr = needle.substring(0, preIndex);
			String postStr = needle.substring
		}
		
	}*/
	
	/*public static ArrayList<Integer> findNeedleKMP (String hayStack, String needle)
	{
		if(hayStack == null || needle == null)
		{
			return new ArrayList<Integer>();
		}
		
		ArrayList<Integer> returnIndices = new ArrayList<Integer>();
		
		
	}*/
	
	private static HashMap<ArrayList<Integer>, Integer> levenshteinMap; 
	
	private static int getLevenshteinDistanceTo(String str1, String str2, int index1, int index2)
	{
		if(index1 == -1 || index2 == -1)
		{
			return Math.max(index1, index2) + 1;
		}
		
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		indexList.add(index1);
		indexList.add(index2);
		
		if(levenshteinMap.containsKey(indexList))
		{
			return levenshteinMap.get(indexList);
		}
		
		int returnValue;
		if(str1.charAt(index1) == str2.charAt(index2))
		{
			returnValue = getLevenshteinDistanceTo(str1, str2, index1-1, index2-1);
			levenshteinMap.put(indexList, returnValue);
			return returnValue;
		}
		
		int leftDistance = getLevenshteinDistanceTo(str1, str2, index1-1, index2);
		int topDistance = getLevenshteinDistanceTo(str1, str2, index1, index2-1);
		int crossDistance = getLevenshteinDistanceTo(str1, str2, index1-1, index2-1);
		
		returnValue = Math.min(crossDistance,Math.min(leftDistance, topDistance))+1;
		levenshteinMap.put(indexList, returnValue);
		return returnValue;
	}
	
	public static int getLevenshteinDistance(String str1, String str2)
	{
		if(str1 == null || str2 == null)
		{
			throw new IllegalArgumentException("String cannot be null");
		}
		
		levenshteinMap = new HashMap<ArrayList<Integer>, Integer>();
		
		
		return getLevenshteinDistanceTo(str1, str2, str1.length()-1, str2.length()-1);
	}
	
	private static HashMap<ArrayList<String>, String> subsequenceMap;
	
	private static String getLongestCommonSubsequenceTo(String str1, String str2, int index1, int index2)
	{
		if(index1 == -1 || index2 == -1)
		{
			return "";
		}
		
		ArrayList<String> strList = new ArrayList<String>();
		strList.add(str1.substring(0, index1+1));
		strList.add(str2.substring(0, index2+1));
		
		if(subsequenceMap.containsKey(strList))
		{
			return subsequenceMap.get(strList);
		}
		
		String returnString;		
		if(str1.charAt(index1) == str2.charAt(index2))
		{
			returnString = getLongestCommonSubsequenceTo(str1, str2, index1-1, index2-1)+String.valueOf(str1.charAt(index1));
			subsequenceMap.put(strList, returnString);
			return returnString;
		}
		
		String leftString = getLongestCommonSubsequenceTo(str1, str2, index1-1, index2);
		String topString = getLongestCommonSubsequenceTo(str1, str2, index1, index2-1);
		String crossString = getLongestCommonSubsequenceTo(str1, str2, index1-1, index2-1);
		
		returnString = (leftString.length()>topString.length())?leftString:topString;
		returnString = (returnString.length()>crossString.length())?returnString:crossString;
		subsequenceMap.put(strList, returnString);
		return returnString;		
	}
	
	public static String getLongestCommonSubsequence(String str1, String str2)
	{
		if(str1 == null || str2 == null)
		{
			throw new IllegalArgumentException("String cannot be null");
		}
		
		subsequenceMap = new HashMap<ArrayList<String>, String>();
		
		return getLongestCommonSubsequenceTo(str1, str2, str1.length() - 1, str2.length() - 1);
	}
	
	private static HashMap<ArrayList<String>, String> substringMap;
	
	private static String setLongestCommonSuffixTo(String str1, String str2, int index1, int index2)
	{
		if(index1 == -1 || index2 == -1)
		{
			return "";
		}
		
		ArrayList<String> strList = new ArrayList<String>();
		strList.add(str1.substring(0, index1+1));
		strList.add(str2.substring(0, index2+1));
		
		if(substringMap.containsKey(strList))
		{
			return substringMap.get(strList);
		}
		
		String returnString = "";		
		if(str1.charAt(index1) == str2.charAt(index2))
		{
			returnString = setLongestCommonSuffixTo(str1, str2, index1-1, index2-1)+String.valueOf(str1.charAt(index1));
			substringMap.put(strList, returnString);
			return returnString;
		}
		
		substringMap.put(strList, returnString);
		return returnString;
	}
	
	public static String getLongestCommonSubstring(String str1, String str2)
	{
		if(str1 == null || str2 == null)
		{
			throw new IllegalArgumentException("String cannot be null");
		}
		
		substringMap = new HashMap<ArrayList<String>, String>();
		
		for(int i=0; i<str1.length(); i++)
		{
			for(int j=0; j<str2.length(); j++)
			{
				setLongestCommonSuffixTo(str1, str2, i, j);	
			}
		}
		
		
		String returnString = "";
		Iterator<ArrayList<String>> mapIterator = substringMap.keySet().iterator();
		
		while(mapIterator.hasNext())
		{
			String mapString = substringMap.get(mapIterator.next());
			if(mapString.length() > returnString.length())
			{
				returnString = mapString;
			}			
		}
		
		return returnString;		
	}
	
	

}
