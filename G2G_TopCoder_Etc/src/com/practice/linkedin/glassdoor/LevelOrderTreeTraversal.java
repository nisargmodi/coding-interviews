package com.practice.linkedin.glassdoor;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTreeTraversal {

	void BFSTree(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
			while(!q.isEmpty()) {
				int levelNodes = q.size();
					while(levelNodes>0) {
						Node n = (Node)q.remove();
						System.out.print(" " + n.data);
						if(n.left!=null) q.add(n.left);
						if(n.right!=null) q.add(n.right);
						levelNodes--;
					}
				System.out.println("");
			}
	}
}