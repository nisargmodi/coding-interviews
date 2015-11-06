package com.practice.linkedin.glassdoor;

public class FlipTree {
	public static void main(String[] args) {
		
		Node n = new Node(0, null, null);
		n = n.buildTree();
		n.print(n);
		System.out.println("-----");
		Node root = flipTree(n);
		root.print(root);
		
	}
	
	public static Node flipTree ( Node root ) {
	    if (root == null)
	        return null;
	    
	    // Working base condition
	    if( root.left == null && root.right == null) {
	        return root;
	    }
	    
	    Node newRoot = flipTree(root.left);
	    
	    root.left.left = root.right;
	    root.left.right = root;
	    root.left = null;
	    root.right = null;
	    
	    return newRoot;
	}
}