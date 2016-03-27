package com.symbol.tables.bst;
/*
 * Example:
 * 				  8
 * 			   6		9
 * 		  2		  7
 *	   1     4
 * 		   3   5
 * 
 * In order traversal should give: 1-2-3-4-5-6-7-8-9
 */
public class TreeNode {
	
	public int data;
	public TreeNode left;
	public TreeNode right;
	
	private int count = 1;
	
	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public static TreeNode buildTree() {
		TreeNode root = new TreeNode(8, null, null);
		
		root.left = new TreeNode(6, null, null);
		root.right = new TreeNode(9, null, null);
		
		root.left.left = new TreeNode(2, null, null);
		root.left.right = new TreeNode(7, null, null);
		
		root.left.left.left = new TreeNode(1, null, null);
		root.left.left.right = new TreeNode(4, null, null);
		
		root.left.left.right.left = new TreeNode(3, null, null);
		root.left.left.right.right = new TreeNode(5, null, null);
		
		return root;
		
	}
	
	public static TreeNode buildTree1() {
		TreeNode root = new TreeNode(8, null, null);
		
		root.left = new TreeNode(6, null, null);
		root.right = new TreeNode(9, null, null);
		
		root.left.left = new TreeNode(2, null, null);
		root.left.right = new TreeNode(7, null, null);
		
		return root;
		
	}

	/*
	 * recursive preorder traversal
	 */
	public static void printPreOrder(TreeNode n) {
		if(n==null) return;
		System.out.print(n.data+"--");
		printPreOrder(n.left);
		printPreOrder(n.right);
	}
	
	/*
	 * recursive inorder traversal
	 */
	public static void printInOrder(TreeNode n) {
		if(n==null) return;
		printInOrder(n.left);
		System.out.print(n.data+"--");
		printInOrder(n.right);
	}
	
	/*
	 * recursive postorder traversal
	 */
	public static void printPostOrder(TreeNode n) {
		if(n==null) return;
		printPreOrder(n.left);
		printPreOrder(n.right);
		System.out.print(n.data+"--");
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}	

}