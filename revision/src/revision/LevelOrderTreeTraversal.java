package revision;

import java.util.LinkedList;
import java.util.Queue;

import com.symbol.tables.bst.TreeNode;

public class LevelOrderTreeTraversal {

	void BFSTree(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
			while(!q.isEmpty()) {
				int levelNodes = q.size();
					while(levelNodes>0) {
						TreeNode n = (TreeNode)q.remove();
						System.out.print(" " + n.data);
						if(n.left!=null) q.add(n.left);
						if(n.right!=null) q.add(n.right);
						levelNodes--;
					}
				System.out.println("");
			}
	}
}