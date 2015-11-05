package com.sorting;

public class SelectionSort {
	public static void main(String[] args) {
		int[] array = {0,3,2,4,1};
		int min;
		for(int i =0; i<array.length-1; i++) {
			min = i;
			for(int j=i+1; j<array.length; j++) {
				if(array[j]<array[min]) {
					min = j;
				}
			}
			
			if(min!=i) {
				swap(array, i, min);
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
