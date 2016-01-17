package revision;

public class KeyIndexedCounting {
	public static void main(String[] args) {
		int[] a = {32, 17, 56, 73, 128, 54, 37, 7}; //ages of people
		a = sortKeyIndexedCounting(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"--");
		}
		
	}

	private static int[] sortKeyIndexedCounting(int[] a) {
		
		int[] count = new int[135];
		
		for(int i=0; i<a.length; i++) {
			count[a[i] + 1]++; 
		}
		
		for(int i=1; i<count.length; i++) {
			count[i]+=count[i-1];
		}
		
		for(int i=0; i<a.length; i++) {
			count[a[i] + 1]++; 
		}
		
		int[] aux = new int[133];
		for(int i=0; i<a.length; i++) {
			aux[count[a[i]]++] = a[i];
		}
		
		for(int i=0; i<a.length; i++) {
			a[i] = aux[i];
		}
		
		return a;
	}
}
