package com.practice.linkedin.glassdoor;
/*
 * 
 * Alternate soln to find the first and last pos of element and return
 * last-first+1 is here:
 * http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
 */
public class CountOfElementInSortedArray {
	static int count = 0;
	public static void main(String[] args) {
		int[] a = {1,1,2,2,2,3,4,5,6,6,7,8,9,9,9};
		int key = 7;
		System.out.println(count(a, key));
	}
	
	public static int count(int[] a, int key) {
		return binarySearchCount(a, 0, a.length-1, key);
	}

	private static int binarySearchCount(int[] a, int lo, int hi, int key) {
		if(lo>hi) return count;
		int mid = lo + (hi-lo)/2;
		
		if(a[mid] == key) {
			count++;
			if(mid !=0)
			if(a[mid-1] == key) binarySearchCount(a, lo, mid-1, key);
			if(mid !=a.length-1)
			if(a[mid+1] == key) binarySearchCount(a, mid+1, hi, key);
		}
		else if(a[mid] < key) {
				lo = mid+1;
				binarySearchCount(a, lo, hi, key);
				}
			 else if(a[mid] > key) {
				 hi = mid-1;
				 binarySearchCount(a, lo, hi, key);
			 }
		
		return count;
	}
	
}