package com.sorting;

public class MergeSort {
	
	public static void main(String[] args) {
		
		Comparable[] a = {1,7,6,6,3,4,8,10,0};
		
		/*a = bottomUpSort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"--");
		}*/
		
		a = sort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"--");
		}
	}

	private static Comparable[] sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		
		mergesort(a, aux, 0, a.length-1);
		
		return a;
		
	}

	private static void mergesort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		
		if(hi<=lo) return;
		int mid = lo + (hi-lo)/2;

		mergesort(a, aux, lo, mid);
		mergesort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		
		for (int k=lo; k<=hi; k++) {
			aux[k] = a[k];
		}
		
		int i=lo, j= mid+1;
		
		for(int k=lo; k<=hi; k++) {
			
			if(i>mid)					a[k] = aux[j++];
			else if(j>hi)				a[k] = aux[i++];
			else if(aux[i].compareTo(aux[j]) < 0 )		a[k] = aux[i++];
			else 			  			a[k] = aux[j++];
		}
	}
	
	public static Comparable[] bottomUpSort(Comparable[] a) {
	
		int N = a.length;
		
		Comparable[] aux = new Comparable[N];
		
		for (int sz = 1; sz < N; sz = sz+sz)
			for (int lo = 0; lo < N-sz; lo += sz+sz)
				merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
		
		return a;
	}
	
}
