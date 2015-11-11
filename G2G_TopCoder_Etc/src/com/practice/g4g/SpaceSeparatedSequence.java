package com.practice.g4g;

import java.util.Arrays;

/*
 * 
 * Problem here: http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
 */
public class SpaceSeparatedSequence {
	public static void main(String[] args) {
		String s = "ilikesamsung";
		String[] dictionary = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango"};
		
		System.out.println("ans: "+isValidSequence(dictionary, s));
	}

	private static String isValidSequence(String[] dictionary, String s) {
			
			if(Arrays.asList(dictionary).contains(s)) {
				return s;
			}
			
			for(int i=0; i<s.length();i++) {
				String prefix = s.substring(0, i);
					if(Arrays.asList(dictionary).contains(prefix)) {
						prefix+= " ";
						String suffix = isValidSequence(dictionary, s.substring(i, s.length()));
							return prefix + suffix;
					}
			}
		return "";
	}
}
