package com.practice.linkedin.glassdoor;

import java.util.HashMap;
import java.util.Map;

public class CommonAncestorsOfTwoNodesInBTree {
	
	static Map<Node, Boolean> hasP = new HashMap<>();
	static Map<Node, Boolean> hasQ = new HashMap<>();
	
	public static void main(String[] args) {
		Node node = new Node(100, null, null);
		Node root = node.buildTree();
		//node.print(root);
		
		System.out.println(findCommonAncestors(root, 6, 9));
	}

	private static int findCommonAncestors(Node root, int p, int q) {
		
		if(hasP(root.left, p) && hasQ(root.left, q)) return findCommonAncestors(root.left, p, q);
		
		else if(hasP(root.right, p) && hasQ(root.right, q)) return findCommonAncestors(root.right, p, q);
		
			 else  return root.data;
		
	}

	private static boolean hasQ(Node root, int q) {
		
		if(hasQ.containsKey(root)) {
			return hasQ.get(root);
		}
		else {
			
			if(root == null) {
				hasQ.put(root, false);
				return false;
			}
			
			if(root.data == q) {
				hasQ.put(root, true);
				return true;
			}
			
			return (hasQ(root.left, q) || hasQ(root.right, q));
		}
		
	}

	private static boolean hasP(Node root, int p) {
		
		if(hasP.containsKey(root)) {
			return hasP.get(root);
		}
		else {

			if(root == null) {
				hasP.put(root, false);
				return false;
			}
			
			if(root.data == p) {
				hasP.put(root, true);
				return true;
			}
		
		return (hasP(root.left, p) || hasP(root.right, p));
		
		}
		
	}
	
	
}