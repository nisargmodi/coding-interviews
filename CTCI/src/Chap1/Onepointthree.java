package Chap1;

import java.util.Arrays;

public class Onepointthree {

	public static void main(String[] args) {
		
		String s1 = "abcde";
		String s2 = "edcab";
		String s3 = "xybba";
		System.out.println(checkForPermutation(s1, s2));
		System.out.println(checkForPermutation(s1, s3));

	}

	private static boolean checkForPermutation(String s1, String s2) {
		char [] a1 = new char[256];
		char[] a2 = new char[256];
		
		a1 = s1.toCharArray();
		a2 = s2.toCharArray();
		
		Arrays.sort(a1);
		Arrays.sort(a2);
		
		if(Arrays.equals(a1, a2)) {
			return true;
		}
		else {
			return false;
		}
	}
}
