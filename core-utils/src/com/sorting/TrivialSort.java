package com.sorting;

public class TrivialSort {
	public static void main(String[] args) {
		int[] array = {0,3,2,4,1};
		for(int i =0; i<array.length-1; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[j]<array[i]) {
					swap(array, j,i);
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
