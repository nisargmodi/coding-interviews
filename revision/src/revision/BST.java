package revision;

import com.symbol.tables.bst.TreeNode;

public class BST {
	public static void main(String[] args) {
		
		TreeNode root = put(8, null);
		//root.setCount(1);
		put(9, root);
		put(6, root);
		put(7, root);
		put(2, root);
		put(4, root);
		put(1, root);
		put(3, root);
		put(5, root);
		
		LevelOrderTreeTraversal l = new LevelOrderTreeTraversal();
		l.BFSTree(root);
		/*TreeNode.print(root); //inorder print
		System.out.println();
		
		System.out.println(ceiling(3));
		 * 
		 
		System.out.println(floor(root, 3).data);
		System.out.println(rank(root, 8));*/
		
	}

	private static TreeNode put(int key, TreeNode root) {
		
		if(root == null) return new TreeNode(key, null, null);
		if(root.data<key) root.right = put(key, root.right);
		if(root.data>key) root.left = put(key, root.left);
		root.setCount(1 + size(root.left) + size(root.right));
		return root;
	}
	
	private static TreeNode get(int key, TreeNode root) {
		if(root.data<key) return get(key, root.right);
		if(root.data>key) return get(key, root.left);
		if(root.data == key) return root;
		
		return null;
	}

	private static TreeNode delete(int key, TreeNode root) {
		
		if(root == null) return null;
		
		if(root.data<key) {
			root.right = delete(key, root.right);
		}
		else
		if(root.data>key) {
			root.left = delete(key, root.left);
		}
		else {
			if(root.left ==null) return root.right;
			else
			if(root.right ==null) return root.left;
			else {
				TreeNode t = root;
				root = min(t.right);
				root.right = deleteMin(t.right);
				root.left = t.left;
			}
			
		}
		root.setCount(1 + size(root.left) + size(root.left));
		return root;
		
	}
	
	private static TreeNode min(TreeNode root) {
		if(root.left != null) return min(root.left);
		else return root;
	}

	private static TreeNode deleteMin(TreeNode root) {
		if(root.left == null) {
			return root.right;			
		}
		else {
			root.left = deleteMin(root.left);
			root.setCount(1 + size(root.left) + size(root.right));
			return root;
		}
	}

	private static TreeNode floor(TreeNode root, double key) {
		if(root.data == key) return root;
		else
		if(root.data < key) {
			TreeNode temp = floor(root.right, key);
			if(temp == null) return root;
			else return temp;
		}
		else {
			return floor(root.left, key);
		}
		
	}

	/*private static int ceiling(int i) {
		// TODO Auto-generated method stub
		
	}*/

	private static int rank(TreeNode root, int i) {
		if (root == null) return 0;
		if(root.data == i) return size(root.left) + 1;
		else if(root.data < i) {
			return size(root.left) + 1 + rank(root.right, i);
		}
		else {
			return rank(root.left, i);
		}
	}
	
	private static int size(TreeNode x) {
		if(x == null) return 0;
		return x.getCount();
	}
	
	
	
}