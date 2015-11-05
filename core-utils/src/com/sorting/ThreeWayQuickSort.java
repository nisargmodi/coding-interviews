package com.sorting;

public class ThreeWayQuickSort {
	
	public static void main(String[] args) {
	
		Comparable[] a = {1,7,6,6,3,4,8,10,0};
		
		/*a = bottomUpSort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"--");
		}*/
		
		//important to shuffle the array first
		ThreeWaySort(a, 0, a.length-1);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"--");
		}
	}

	private static void ThreeWaySort(Comparable[] a, int lo, int hi) {
		
		if(hi<=lo) return;
		int lowerThan = lo, greaterThan=hi, i=lo;
		Comparable v = a[lo];
		
		while(i<=greaterThan) {
			int cmp = a[i].compareTo(v);
			if(cmp<0) {
				exch(a, lowerThan++, i++);
			}
			else if(cmp>0) {
				exch(a, i, greaterThan--);
			}
			else i++;
			
		} //while ends
		
		ThreeWaySort(a, lo, lowerThan-1);
		ThreeWaySort(a, greaterThan+1, hi);
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
