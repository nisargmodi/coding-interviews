package code.pie;

public class StringToInt {
	public static void main(String[] args) {
		convert("-1");
		convert("0");
		convert("1");
	}
	
	private static void convert(String s) {
		int count = 0;
		boolean minus = false;
		for (int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '-') {
				minus = true;
				continue;
			}
			count= count*10 + s.charAt(i)-48;
		}
		if(minus) {
			count = -count;
		}
		System.out.println(count);
	}
}