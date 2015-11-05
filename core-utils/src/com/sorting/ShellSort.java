package com.sorting;

public class ShellSort {
	public static void main(String[] args) {
		int[] array = {0,2,7,4,1,3};
		int N = array.length;
		int h = 1;		
			
		while(h<N/3) {
			h=3*h+1;
		}
		
		while(h>=1) {
			
			for(int i = h; i<N; i++) {
				
				for(int j=i; j>=h; j=j-h) {
					if(array[j]<array[j-h]) {
						swap(array, j, j-h);
					}
				}
				
				for(int k=0; k<array.length; k++) {
					System.out.print(array[k]);
				}
				System.out.println();
			}				
		h=h/3;
		
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