package com.practice.linkedin.glassdoor;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
	public static void main(String[] args) {
		int[] a= {1, 4, 45, 6, 10, -8};
		int sum = 90;
		
		System.out.println(TwoSum(a, sum));
		//TwoSum(a, sum);
	}

	private static boolean TwoSum(int[] a, int sum) {
		Map<Integer, Integer> myMap = new HashMap<>();
		for(int i=0; i<a.length; i++) {
			myMap.put(a[i], a[i]);
		}
		
		for(int i=0; i<a.length; i++) {
			myMap.remove(a[i]);//added later
			if(myMap.containsKey(sum-a[i])) return true;
			myMap.put(a[i],a[i]);//added later
		}
		return false;
		
	}
}