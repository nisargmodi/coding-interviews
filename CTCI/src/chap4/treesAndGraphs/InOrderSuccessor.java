package chap4.treesAndGraphs;

import com.symbol.tables.bst.TreeNode;

public class InOrderSuccessor {
	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree();
		TreeNode.printPreOrder(root);
		
		System.out.println(inOrderSuccuessor(root).data);
	}

	private static TreeNode inOrderSuccuessor(TreeNode root) {
		TreeNode leftMost = getLeftMost(root.right);
		TreeNode parent = root.parent;
		if(leftMost == null) {
			while(parent != null) {
				if(parent.right == root) return parent;
				else {
					root = parent;
					parent = parent.parent;
				}
			}
				
		}
		
		return null;
	}

	private static TreeNode getLeftMost(TreeNode right) {
		if(right == null) return null;
		if(right.left == null) return right;
		return getLeftMost(right.left);
	}

}
