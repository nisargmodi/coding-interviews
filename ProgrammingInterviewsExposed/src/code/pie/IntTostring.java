package code.pie;

public class IntTostring {
	public static void main(String[] args) {
		convert(-1);
		convert(0);
		convert(1);
	}

	private static void convert(int i) {
		StringBuilder str = new StringBuilder();
		boolean minus = false;
		if(i<0) {
			minus = true;
			i = -i;
		}
		do {
			str.append((i%10));
			i = i/10;
		}while (i!=0);
		if(minus) {
			System.out.print("-");
		}
		System.out.println(str.reverse());
	}
}
