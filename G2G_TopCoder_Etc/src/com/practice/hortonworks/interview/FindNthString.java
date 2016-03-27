package com.practice.hortonworks.interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class FindNthString {
	public static void main(String[] args) {
		String[] a = {"a", "b", "v", "ade", "ab", "de", "adbgrd"};
		
		List<String> ans = getNthStrings(a, 3);
		
		for(String s:ans) {
			System.out.println(s);
		}
	}

	private static List<String> getNthStrings(String[] a, int n) {
		
		SortedMap<Integer,List<String>> sm = new TreeMap<Integer,List<String>>();
		List<String> ans = new LinkedList<>();
		for(String s: a) {
			if(!sm.containsKey(s.length())) {
				sm.put(s.length(), new LinkedList<String>());				
			}
			List<String> sm_l = sm.get(s.length());
			sm_l.add(s);
		}
		
		int count = 0;
		for(Entry<Integer,List<String>> temp : sm.entrySet()) {
			if(++count == n)
				ans = temp.getValue();
		}
		return ans;
	}

}
