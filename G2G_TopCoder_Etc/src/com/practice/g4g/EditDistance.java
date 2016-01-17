package com.practice.g4g;

public class EditDistance {
	public static void main(String[] args) {
		String s1 = "abcdef";
		String s2 = "bcdfg";
		
		System.out.println(editDistance(s1, s2));
	}

	private static int editDistance(String s1, String s2) {
		
		if(s1 == null) return s2.length();
		if(s2 == null) return s1.length();
		if(s1.equals(s2)) return 0;
		int n = ((s1.length()>s2.length()) ? s2.length() : s1.length());
		
		for(int i=0; i<n;i++) {
			
			if(s1.charAt(i) == s2.charAt(i))
				return editDistance(s1.substring(i+1, s1.length()), s2.substring(i+1, s2.length()));
			else return 1 + min(
					editDistance(s1.substring(i, s1.length()), s2.substring(i+1, s2.length())),
					editDistance(s1.substring(i+1, s1.length()), s2.substring(i, s2.length()))
					);
			
				
		}
		
		return 0;
	}

	private static int min(int e1, int e2) {
		return e1>e2?e2:e1;
	}

	
}


/*

public static int minDistance(String word1, String word2) {
int len1 = word1.length();
int len2 = word2.length();

// len1+1, len2+1, because finally return dp[len1][len2]
int[][] dp = new int[len1 + 1][len2 + 1];

for (int i = 0; i <= len1; i++) {
	dp[i][0] = i;
}

for (int j = 0; j <= len2; j++) {
	dp[0][j] = j;
}

//iterate though, and check last char
for (int i = 0; i < len1; i++) {
	char c1 = word1.charAt(i);
	for (int j = 0; j < len2; j++) {
		char c2 = word2.charAt(j);

		//if last two chars equal
		if (c1 == c2) {
			//update dp value for +1 length
			dp[i + 1][j + 1] = dp[i][j];
		} else {
			int replace = dp[i][j] + 1;
			int insert = dp[i][j + 1] + 1;
			int delete = dp[i + 1][j] + 1;

			int min = replace > insert ? insert : replace;
			min = delete > min ? min : delete;
			dp[i + 1][j + 1] = min;
		}
	}
}

return dp[len1][len2];
}

*/