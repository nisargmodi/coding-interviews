package chap4.treesAndGraphs;

import com.symbol.tables.bst.TreeNode;

public class GivenBtIsBst {
	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree();
		System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	private static boolean isBST(TreeNode root, int lo, int hi) {
		
		if(root == null) return true;
		if(root.data<lo || root.data>hi) return false;
		return isBST(root.left, lo, root.data) && isBST(root.right, root.data, hi) ;
	}
}
