package com.JavaUtilities.Trees;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree<T> {
	
	public class BinaryTreeNode
	{
		T value;
		private BinaryTreeNode left;
		private BinaryTreeNode right;
		public BinaryTreeNode (T val)
		{
			this.value = val;
		}
		
		public void reAssignValue(T val)
		{
			this.value = val;
		}
		
		public void assignLeftNode(BinaryTreeNode left)
		{
			this.left = left;
		}
		
		public void assignRightNode(BinaryTreeNode right)
		{
			this.right = right;
		}		
	}
	
	private BinaryTreeNode rootNode;
	
	public BinaryTreeNode getRoot()
	{
		return this.rootNode;
	}
	
	public void assignRoot(BinaryTreeNode node)
	{
		rootNode = node;
	}
	
	private void inOrderRecursion(BinaryTreeNode root, ArrayList<T> arrayList)
	{
		if(root != null)
		{
			inOrderRecursion(root.left, arrayList);
			arrayList.add(root.value);
			inOrderRecursion(root.right, arrayList);
		}			
	}
	
	private void preOrderRecursion(BinaryTreeNode root, ArrayList<T> arrayList)
	{
		if(root != null)
		{
			arrayList.add(root.value);
			preOrderRecursion(root.left, arrayList);
			preOrderRecursion(root.right, arrayList);
		}			
	}
	
	private void postOrderRecursion(BinaryTreeNode root, ArrayList<T> arrayList)
	{
		if(root != null)
		{
			postOrderRecursion(root.left, arrayList);
			postOrderRecursion(root.right, arrayList);
			arrayList.add(root.value);
		}			
	}
	
	public ArrayList<T> getInOrderRecursion(BinaryTreeNode root)
	{
		ArrayList<T> arrayList = new ArrayList<T>();
		inOrderRecursion(root, arrayList);
		return arrayList;
	}
	
	public ArrayList<T> getPreOrderRecursion(BinaryTreeNode root)
	{
		ArrayList<T> arrayList = new ArrayList<T>();
		preOrderRecursion(root, arrayList);
		return arrayList;
	}
	
	public ArrayList<T> getPostOrderRecursion(BinaryTreeNode root)
	{
		ArrayList<T> arrayList = new ArrayList<T>();
		postOrderRecursion(root, arrayList);
		return arrayList;
	}
	
	public ArrayList<T> getPreOrderIterative(BinaryTreeNode root)
	{
		ArrayList<T> arrayList = new ArrayList<T>();
		if(root != null)
		{
			Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
			nodeStack.push(root);
			BinaryTreeNode topNode = root;
			
			while(!nodeStack.isEmpty())
			{
				//topNode = nodeStack.peek();
				while (topNode.left != null)
				{
					nodeStack.push(topNode.left);
					topNode = topNode.left;
				}
				
				topNode = nodeStack.pop();
				arrayList.add(topNode.value);
				
				if(topNode.right != null)
				{
					nodeStack.push(topNode.right);
					topNode = topNode.right;
				}
			}
		}		
		return arrayList;
	}
	
	
	
}
