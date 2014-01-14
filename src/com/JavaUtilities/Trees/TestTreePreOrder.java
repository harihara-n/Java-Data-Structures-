package com.JavaUtilities.Trees;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import com.JavaUtilities.Trees.BinaryTree.BinaryTreeNode;

public class TestTreePreOrder {

	private BinaryTree<Integer> bTreeInteger;
	
	@Before
	public void setUp() throws Exception {
		bTreeInteger = new BinaryTree<Integer>();
		bTreeInteger.assignRoot(bTreeInteger.new BinaryTreeNode(10));
		bTreeInteger.getRoot().assignLeftNode(bTreeInteger.new BinaryTreeNode(20));
		bTreeInteger.getRoot().assignRightNode(bTreeInteger.new BinaryTreeNode(30));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPreOrderRecursion() {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList = bTreeInteger.getPreOrderRecursion(bTreeInteger.getRoot());
		
		assertNotNull(arrList);
		
		Iterator<Integer> iterator = arrList.iterator();
		assertEquals(iterator.next(), new Integer(10));
		assertEquals(iterator.next(), new Integer(20));
		assertEquals(iterator.next(), new Integer(30));		
	}

}
