package com.sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {0,3,2,4,1};		
		for(int i =0; i<array.length; i++) {
			for(int j=0; j<array.length-(i+1); j++) { //i+1 is imp optimization
				if(array[j]<array[j+1]) {
					swap(array, j, j+1);
				}
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