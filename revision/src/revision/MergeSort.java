package revision;

public class MergeSort {
	public static void main(String[] args) {
		int[] a = {32, 17, 56, 73, 128, 54, 37, 7};
		int[] aux = new int[a.length];
		mergeSort(a, aux, 0, a.length-1);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"--");
		}
	}

	private static void mergeSort(int[] a, int[] aux, int lo, int hi) {
		if(lo<hi) {
			int mid = lo + (hi-lo)/2;
			mergeSort(a, aux, lo, mid);
			mergeSort(a, aux, mid+1, hi);
			merge(a, aux, lo, mid, hi);
		}		
	}

	private static int[] merge(int[] a, int[] aux, int lo, int mid, int hi) {
		
		for(int i=lo; i<=hi; i++) {
			aux[i] = a[i];
		}
		
		int i=lo, j=mid+1;
		
		for(int k=lo; k<=hi; k++) {
			if(i>mid) a[k] = aux[j++];
			else
			if(j>hi) a[k] = aux[i++];
			else			
			if(a[i]<a[j]) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
		
		return a;
	}
}
