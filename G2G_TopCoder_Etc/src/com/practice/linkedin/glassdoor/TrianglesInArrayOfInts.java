package com.practice.linkedin.glassdoor;

import java.util.Arrays;
/*
 * 
 * 
 * Time Complexity: O(n^2).
 * The time complexity looks more because of 3 nested loops.
 * If we take a closer look at the algorithm, we observe that third is initialized
 * only once in the outermost loop.
 * The innermost loop executes at most O(n) time for every iteration of outer most
 * loop, because k starts from i+2 and goes upto n for all values of j.
 * Therefore, the time complexity is O(n^2).
 */
public class TrianglesInArrayOfInts {
	public static void main(String[] args) {
		int[] a =  {4, 6, 3, 7};
		int[] a1=  {10, 21, 22, 100, 101, 200, 300};
		
		System.out.println(countNoOfTriangles(a1));
	}
	
	public static int countNoOfTriangles(int[] a) {
		int no = 0;
		Arrays.sort(a);
		for(int i=0; i<a.length-2; i++) {
			int first = i;
			int second = i+1;
			int third = i+2;
			while(second<a.length) {
				while(third<a.length) {
					if(checkTri(a[first], a[second], a[third])) {
						third++;
					}
					else break;
				}
				no+=third-second-1;
				second++;
			}
		}
		
		return no;
	}

	private static boolean checkTri(int first, int second, int third) {
		if(first+second>third)
			return true;
		return false;
	}
}
