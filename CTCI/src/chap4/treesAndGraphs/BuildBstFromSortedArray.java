package chap4.treesAndGraphs;

import com.symbol.tables.bst.TreeNode;

public class BuildBstFromSortedArray {
	public static void main(String[] args) {
		int[] a = {1, 3, 4, 6, 7, 8, 9, 13};
		TreeNode.printInOrder(buildBst(a, 0, a.length-1));
	}

	private static TreeNode buildBst(int[] a, int lo, int hi) {
		if(lo<=hi) {
			int mid = lo + (hi-lo)/2;
			TreeNode root = new TreeNode(a[mid], null, null);
			root.left = buildBst(a, lo, mid-1);
			root.right = buildBst(a, mid+1, hi);
			return root;
		}
		return null;
		
	}
}
