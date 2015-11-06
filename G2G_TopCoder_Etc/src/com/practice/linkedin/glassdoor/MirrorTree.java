package com.practice.linkedin.glassdoor;

public class MirrorTree {
	public static void main(String[] args) {
		Node n = new Node(0, null, null);
		
		n = n.buildTree();
		n.print(n);
		System.out.println("------------");
		Node root = mirror(n);
		root.print(root);
		
	}

	private static Node mirror(Node root) {
		if(root!=null){
			Node t = root.left;
			root.left = root.right;
			root.right = t;
			mirror(root.right);
			mirror(root.left);
		}
		return root;
	}
}
