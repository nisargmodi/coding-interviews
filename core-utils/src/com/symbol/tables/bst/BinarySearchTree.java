package com.symbol.tables.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
 
	private Node root;
 
	private class Node {
		
		private Key key;
		private Value val;
		private Node left, right;
		private int count; //how many nodes in the subtree including this node itself?
		
		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
	}
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val) {
	 if (x == null) return new Node(key, val);
	 int cmp = key.compareTo(x.key);
	 if (cmp < 0)
	 x.left = put(x.left, key, val);
	 else if (cmp > 0)
	 x.right = put(x.right, key, val);
	 else if (cmp == 0)
		 x.val = val;
	 
	 x.count = 1 + size(x.left) + size(x.right);
	 
	 return x;
	}
	
	public Value get(Key key) {
		Node x = root;
		 while (x != null){
		 int cmp = key.compareTo(x.key);
		 if (cmp < 0) x = x.left;
		 else if (cmp > 0) x = x.right;
		 else if (cmp == 0) return x.val;
		 }
		 return null;
	}
	
	public void delete(Key key)	 {
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key) {
		//x is root
		
		if (x == null) return null;
		
		int cmp = key.compareTo(x.key);	 
		
		if (cmp < 0) {
			x.left = delete(x.left, key);
		}
		else if (cmp > 0) {
			x.right = delete(x.right, key);
		}
			 else {
				 if (x.right == null) return x.left;
				 if (x.left == null) return x.right;
				 
				 //if two children
				 
				 /* Consider node to be deleted as x
				  * 
				  * 1. first save the node to be deleted (t=x)
				  * since we'll need it later for it's references.
				  * 
				  * 2. Then find the min node of the right subtree of x,
				  * which will basically replace x i.e. put in the tree in place of x.
				  * 
				  * 3. delete the min found in above step from the right subtree of x.
				  * 
				  * 4. Set references of new node that replaced x
				  * 
				  */
				 Node t = x; //Step 1
				 x = min(t.right); //Step 2. gives min of the subtree starting with the root of node passed in as argument
				 x.right = deleteMin(t.right); //Steps 3 and returned is 4a
				 x.left = t.left; //Step 4b
			 }
		
	 x.count = size(x.left) + size(x.right) + 1;
	 
	 return x;
	 }
	 
	 private Node min(Node x) {
		 while(x.left!=null) {
			 x = x.left;
		 }
		 return x;
	 }
	
	 public void deleteMin() {
		 root = deleteMin(root);
	 }
	 
	 private Node deleteMin(Node x) {
		 if (x.left == null) return x.right;
		 x.left = deleteMin(x.left);
		 x.count = 1 + size(x.left) + size(x.right);
		 return x;
	 }
	
	public Iterable<Key> keys()	{
		Queue<Key> q = new LinkedList<Key>();
		 inorder(root, q);
		 return q;
	}
	
	private void inorder(Node x, Queue<Key> q) {
		if (x == null) return;
		inorder(x.left, q);
		q.add(x.key);
		inorder(x.right, q);
	} 
	
	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null) return null;
		return x.key;
	}
	
	private Node floor(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		if (cmp < 0) return floor(x.left, key);
		
		Node t = floor(x.right, key);
		if (t != null) return t;
		else return x;
	}
	
	public int size() { 
		return size(root);
	}
	
	//how many nodes in the subtree including this node itself?
	private int size(Node x) {
		if (x == null) return 0;
		return x.count;
	}
	
	public int rank(Key key){
		 return rank(key, root);
	}
	 
	private int rank(Key key, Node x) {
	  if (x == null) return 0;
	  int cmp = key.compareTo(x.key);
	  if (cmp < 0) return rank(key, x.left);
	  else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
	  else if (cmp == 0) return size(x.left);
	  return 0;
	}
	 
}