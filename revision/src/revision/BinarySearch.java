package revision;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] a = {1, 12, 31, 44, 59, 76, 77};
		int key = 77;
		System.out.println(binarySearch(a, 0, a.length-1, key));
	}

	private static int binarySearch(int[] a, int lo, int hi, int key) {
		
		if(lo>hi) return -1;
		
		int mid = lo + (hi-lo)/2;
		if(a[mid] == key) return mid;
		if(a[mid]<key) return binarySearch(a, mid+1, hi, key);
		else return binarySearch(a, lo, mid-1, key);
	}

}
