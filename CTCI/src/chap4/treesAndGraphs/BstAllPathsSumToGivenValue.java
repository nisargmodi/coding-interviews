package chap4.treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

import com.symbol.tables.bst.TreeNode;

public class BstAllPathsSumToGivenValue {
	public static void main(String[] args) {
		TreeNode root = buildTree();
		int sum = 14;
		int k = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		printAllPaths(root, sum, sum, q);
	}

	private static TreeNode buildTree() {
		
		TreeNode root = new TreeNode(8, null, null);
		
		root.left = new TreeNode(6, null, null);
		root.right = new TreeNode(9, null, null);
		
		root.left.left = new TreeNode(-1, null, null);
		root.left.right = new TreeNode(7, null, null);
		
		root.left.left.left = new TreeNode(1, null, null);
		root.left.left.right = new TreeNode(4, null, null);
		
		root.left.left.right.left = new TreeNode(3, null, null);
		root.left.left.right.right = new TreeNode(5, null, null);
		
		return root;
	}

	private static void printAllPaths(TreeNode root, int k, int sum, Queue<TreeNode> q) {
		
		if(root == null) return;
		q.add(root);
		if(root.data == k) {
			print(q);
		}
		
		printAllPaths(root.left, k - root.data, sum, q);
		printAllPaths(root.right, k - root.data, sum, q);
		
		printAllPaths(root.left, sum, sum, new LinkedList<TreeNode>());
		printAllPaths(root.right, sum, sum, new LinkedList<TreeNode>());
		q.remove(root);
	}

	private static void print(Queue<TreeNode> q) {
		for(TreeNode t : q) {
			System.out.print(t.data+"-->");
		}
		System.out.println();
	}
}

