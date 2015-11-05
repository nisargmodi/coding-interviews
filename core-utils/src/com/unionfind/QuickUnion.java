package com.unionfind;

public class QuickUnion {
	private int[] id;
	
	public QuickUnion(int N) {
		for (int i=0; i<N; i++) {
			id[i] = i;
		}
	}
		
	public int root(int i) {
		
		while(i!=id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		if(root(p) == root(q)) {
			return true;
		}
		
		return false;
	}
	
	public void union(int p, int q) {
		
		if(connected(p,q)) {
			return;
		}
		
		int pid = root(p);
		int qid = root(q);
		
		id[pid] = qid;
	}
		
}
