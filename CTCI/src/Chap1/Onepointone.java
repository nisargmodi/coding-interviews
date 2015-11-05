package Chap1;

import java.util.HashMap;
import java.util.Map;

public class Onepointone {
	
	public static void main(String[] args) {
		String s1 = "abcabd";
		String s2 = "abc";
		
		System.out.println(duplicateChecker1(s1));
		System.out.println(duplicateChecker1(s2));
		
		System.out.println(duplicateChecker2(s1));
		System.out.println(duplicateChecker2(s2));
	}

	private static boolean duplicateChecker1(String s1) {
		Map<Character, Integer> myMap = new HashMap<>();
		for (int i =0; i<s1.length(); i++) {
			if(myMap.get(s1.charAt(i)) == null) {
				myMap.put(s1.charAt(i), i);
			}
			else {
				return false;
			}
		}
		
		return true;
	}

	private static boolean duplicateChecker2(String s1) {
		
		int checker = 0;
		for(int i=0; i<s1.length(); i++) {
			if((checker & (1 << s1.charAt(i))) > 1) {
				return false;
			}
			else {
				checker = checker | (1 << s1.charAt(i));
			}
		}
		return true;
	}

}
