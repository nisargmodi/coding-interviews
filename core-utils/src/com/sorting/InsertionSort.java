package com.sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int[] array = {0,3,2,4,1};		
		for(int i =0; i<array.length; i++) {
			for(int j=i; j>0; j--) {
				if(array[j]<array[j-1]) {
					swap(array, j, j-1);
				}
				else break; //important optimization
			}
		}
		
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}

	private static void swap(int[] array, int j, int i) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}