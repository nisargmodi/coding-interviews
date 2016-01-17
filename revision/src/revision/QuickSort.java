package revision;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = {32, 17, 56, 73, 128, 54, 37, 7};
		
		quickSort(a, 0, a.length-1);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"--");
		}
	}

	private static void quickSort(int[] a, int lo, int hi) {
		if(hi<=lo) return; //<= is necessary, only == wont work
		int pivot = partition(a, lo, hi);
		quickSort(a, lo, pivot-1);
		quickSort(a, pivot+1, hi);
	}

	private static int partition(int[] a, int lo, int hi) {
		int i=lo, j=hi+1;
		while(true) {
			while(a[++i]<a[lo]) {
				if(i==hi) break;				
			}
			while(a[--j]>a[lo]) {
				if(j==lo) break;				
			}
			
			if(i>=j)
				break;
			exch(a, i, j);
		}
		exch(a,lo,j);
		return j;
	}

	private static void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
