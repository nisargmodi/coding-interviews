package com.practice.g4g;

import java.util.HashMap;
import java.util.Map;

public class DNAmatching {
	
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		Map<String, String> ans = checkDna(s);
		
		for(Map.Entry<String, String> entry : ans.entrySet()) {
			System.out.println(entry.getKey());
		}
	}
	public static Map<String, String> checkDna(String s) {
		//String s= AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT;
		Map<String, String> result = new HashMap<String, String>();
		for(int i=0; i<s.length()-10; i++) {
			String s1 = s.substring(i, i+10);
			Map<String, String> myMap = new HashMap<String, String>();
			for(int j=i+10; j<s.length()-10; j++) {
			String sTemp = s.substring(j, j+10);
			myMap.put(sTemp, sTemp);
		}
		if(myMap.containsKey(s1)) 
		if(!result.containsKey(s1)) result.put(s1,s1);
		}
		return result;
		}
}