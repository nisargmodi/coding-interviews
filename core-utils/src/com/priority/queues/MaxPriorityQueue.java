package com.priority.queues;

public class MaxPriorityQueue {
	
	private void swim(int k)
	{
	while (k > 1 && less(k/2, k))
	{
	exch(k, k/2);
	k = k/2;
	}
	parent of node at k is at k/2
	}
	
	private void sink(int k)
	{
	
	while (2*k <= N)
	{
	int j = 2*k;
	if (j < N && less(j, j+1)) j++;
	if (!less(k, j)) break;
	exch(k, j);
	k = j;
	}
	}
	
	public void insert(Key x)
	{
	pq[++N] = x;
	swim(N);
	}
	
	public Key delMax()
	
	{
	Key max = pq[1];
	exch(1, N--);
	P
	sink(1);
	pq[N+1] = null;
	N
	return max;
	}
	
	public boolean isEmpty()
	{
	return N == 0;
	}
	
	private boolean less(int i, int j)
	{
	return pq[i].compareTo(pq[j]) < 0; }
	
	private void exch(int i, int j)
	{
	Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
	}
}