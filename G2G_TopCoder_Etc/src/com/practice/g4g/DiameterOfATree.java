package com.practice.g4g;

import java.util.LinkedList;
import java.util.List;

import com.symbol.tables.bst.TreeNode;

public class DiameterOfATree {
	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree();
		TreeNode.printPreOrder(root);
		
		LocalAnswer la = findDiameter(root);
		for(TreeNode t : la.max_list) {
			System.out.println(t.data + "-->");
		}
	}

	private static LocalAnswer findDiameter(TreeNode root) {
		LocalAnswer la = new LocalAnswer();
		la.curr_list = new LinkedList<TreeNode>();
		la.max_list = new LinkedList<TreeNode>();
		if(root == null) {
			la.height = 0;
			return la;
		}
		LocalAnswer laLeft = findDiameter(root.left);
		LocalAnswer laRight = findDiameter(root.right);
		la.height = Math.max(laLeft.height, laRight.height) + 1;
		la.curr_list.add(root);
		la.curr_list = currListCalculator(laLeft, laRight,la.curr_list);
		la.max_list = findMaxList(laLeft.max_list, laRight.max_list, la.curr_list);
		
		return la;
	}

	private static List<TreeNode> currListCalculator(LocalAnswer laLeft, LocalAnswer laRight, List<TreeNode> curr_list) {
		
		if(laLeft.height > laRight.height) {
			laLeft.curr_list.addAll(curr_list);
			return curr_list;
		}
		else {
			laRight.curr_list.addAll(curr_list);
			return curr_list;
		}
	}

	private static List<TreeNode> findMaxList(List<TreeNode> max_list_left, List<TreeNode> max_list_right,
			List<TreeNode> curr_list) {
		if(max_list_left.size()>max_list_right.size())
			if(max_list_left.size() > curr_list.size())
				return max_list_left;
			else return curr_list;
		else if(max_list_right.size() > curr_list.size())
				return max_list_right;
			 else return curr_list;
	}
}

class LocalAnswer {
	List<TreeNode> curr_list;
	List<TreeNode> max_list;
	int height;
}