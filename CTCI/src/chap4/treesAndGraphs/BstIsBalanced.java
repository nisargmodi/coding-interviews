package chap4.treesAndGraphs;

import com.symbol.tables.bst.TreeNode;

public class BstIsBalanced {
	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree();
		root.printPreOrder(root);
		System.out.println(isBalanced(root));
		
		TreeNode root1 = TreeNode.buildTree1();
		root.printPreOrder(root1);
		System.out.println(isBalanced(root1));
	}

	private static boolean isBalanced(TreeNode root) {
		
		/*if(getHeight(root) == -1)
			return false;
		
		return true;*/
		
		return getHeight(root) == -1 ? false : true;
	}

	private static int getHeight(TreeNode root) {
		if(root==null) return 0;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		if( leftHeight == -1 || rightHeight == -1)
			return -1;
		else {
			if(Math.abs(leftHeight - rightHeight) > 1) return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
}
