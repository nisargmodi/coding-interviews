package com.practice.linkedin.glassdoor;

public class ImplementOwnMathPowerFunction {

	/*basic approach
	 * 
	 int pow(a,b) {
	 	if(a == 0) return 0;
		if(b == 0) return 1;

		if(a == 1) return 1;
		if(b == 1) return a;

		int ans = 1;
		while(b>0) {
			ans = ans*a;
			b--;
		}
	return ans;
	}
	 */
	
	public static void main(String[] args) {
		
		System.out.println(pow(2.5,-5));
		System.out.println(pow(2.6,6));
		System.out.println(pow(4,2));
		
	}
	
	public static double pow(double a, int b) {
			
			if(a == 0) return 0;
			if(b == 0) return 1;

			if(a == 1) return 1;
			if(b == 1) return a;
			
			
			
		double ans = 1;

			if(b%2 == 0) {
		ans = pow(a, b/2);
		ans = ans*ans;
		}

		else {
			ans = pow(a, b/2);
		ans = ans*ans*a;
		}
		
		if(b < 0) ans = 1/ans;
		
		return ans;
	}

}
