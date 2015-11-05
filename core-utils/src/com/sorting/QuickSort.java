package com.sorting;

public class QuickSort {
	
	public static void main(String[] args) {
		
		Comparable[] a = {1,7,6,6,3,4,8,10,0};
		
		/*a = bottomUpSort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"--");
		}*/
		
		//important to shuffle the array first
		quickSort(a, 0, a.length-1);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"--");
		}
	}
	
	private static void quickSort(Comparable[] a, int lo, int hi) {
		
		if(hi <= lo) return;
		int j = partition(a, lo, hi);
		quickSort(a, lo, j-1);
		quickSort(a, j+1, hi);
		
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		
		int i = lo, j = hi + 1;
		while(true) {
			while(a[++i].compareTo(a[lo]) < 0) {
				if(i==hi) break;			
			}
			
			while(a[--j].compareTo(a[lo]) > 0) {
				if(j==lo) break;			
			}
			
			if(i>=j) break;
			exch(a, i, j);
		}
		
		exch(a, lo, j);
		return j;
		
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
}