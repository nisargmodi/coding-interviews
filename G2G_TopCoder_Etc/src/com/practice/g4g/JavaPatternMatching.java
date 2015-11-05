package com.practice.g4g;

public class JavaPatternMatching {
	
	//same question asked to Nisarg Shah in his on-campus Google interview
	public static void main(String[] args) {
		String s2 = "abckkkkkde";
		String s1 = "abc3kkkkkde";
		StringBuilder ans = new StringBuilder();
		int count = 1, i;
		for(i= 0 ; i<s1.length()-1; i++) {
			int j=i+1;
			
			if(s1.charAt(i) == s1.charAt(j)) {
				while(s1.charAt(i)==s1.charAt(j)) {
					count++;
					j++;
				}
				ans.append(count+"x"+s1.charAt(i));
				i=j-1;
				
			}
			else //if(Character.isDigit(s1.charAt(i))){
				if(s1.charAt(i)>='0' && s1.charAt(i)<='9'){
					ans.append("1x"+s1.charAt(i));
					}
				else {
					ans.append(s1.charAt(i));
				}
		}
		while(i<s1.length()) ans.append(s1.charAt(i++));
		
		System.out.println(ans);
	}
}
