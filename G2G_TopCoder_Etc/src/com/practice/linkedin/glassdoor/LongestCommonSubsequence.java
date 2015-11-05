package com.practice.linkedin.glassdoor;


/*DP soln for LCS*/

public class LongestCommonSubsequence {

	public static int LCS(String x, String y)
	{
	   int[][] L = new int[x.length()+1][y.length()+1];
	   int i=0, j = 0;
	  
	   /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
	      that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
	   for (i=0; i<=x.length(); i++) {
	     for (j=0; j<=y.length(); j++) {
	       
	    	 if (i == 0 || j == 0)
	         L[i][j] = 0;
	  
	    	 else if (x.charAt(i-1) == y.charAt(j-1))
	         L[i][j] = L[i-1][j-1] + 1;
	  
		    	 else
		         L[i][j] = max(L[i-1][j], L[i][j-1]);
	     }
	   }
	    
	   /* L[x.length][y.length] contains length of LCS for X[0..n-1] and Y[0..m-1] */
	   return L[x.length()][y.length()];
	}
	  
	/* Utility function to get max of 2 integers */
	static int max(int a, int b) {
	    return (a > b)? a : b;
	}
	  
	/* Driver program to test above function */
	public static void main(String[] args) {
		String x = "AGGTAB";
		String y = "GXTXAYB";
		
		System.out.println(LCS(x, y));
	}
		  	
}