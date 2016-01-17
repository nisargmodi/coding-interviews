package com.sorting;

import java.util.Arrays;
/*
 * O(N) time, O(N) space!
 */
public class KeyIndexedCounting {

	public static void main(String[] args) {
		
		int[] a = {0, 2, 4, 4, 2, 3, 4, 8, 9, 12 ,132, 132, 13, 12, 9, 8}; //suppose it's an array of ages
		
		a = sort(a);
		System.out.println();
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"--");
		}
		System.out.println();
		Arrays.sort(a);
		for(int i=0; i<a.length; i++) {
		System.out.print(a[i]+"--");
		}
		
	}

	private static int[] sort(int[] a) {
		int[] count = new int[134];
		
		for(int i=0; i<a.length; i++) {
			count[a[i]+1]++;
		}
		
		
		for(int i=0; i<count.length-1; i++) {
			count[i+1] += count[i]; 
		}
		
		/*for(int i=0; i<count.length; i++) {
			System.out.print(count[i]+"--");
		}*/
		
		int[] aux = new int[133];
		for(int i=0; i<a.length; i++) {
			aux[count[a[i]]++] = a[i];
		}
		
		for(int i=0; i<a.length; i++) {
			a[i] = aux[i];
		}
		return a;
	}
}
