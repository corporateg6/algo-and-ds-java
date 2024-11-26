/*
 * Brently G
 */
public class SortAlgos {
	public void mergeSort(int[] a) {
		int size = a.length;
		if(size < 2)
			return;
		int mid = size / 2; //split array in half
		int leftSize = mid;
		int rightSize = size-mid; //TODO maybe implement this in your triangle.
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		for (int i=0;i<mid;i++)
			left[i] = a[i];
		for (int i=mid;i<size;i++)
			right[i-mid] = a[i];
		mergeSort(left);
		mergeSort(right);
		//TODO merge
		merge(left,right,a);
	}
	
	public static void merge(int[] left, int[] right, int[] a) {
		int leftSize = left.length;
		int rightSize = right.length;
		int i=0; //left
		int j=0; //right
		int k=0; //a - the merged array
		while (i<leftSize && j<rightSize) {
			if (left[i] <= right[j]) {
				a[k] = left[i];
				i++;
				k++;
			} else {
				a[k] = right[j];
				j++;
				k++;
			}
		}
		while (i<leftSize) {
			a[k] = left[i];
			i++;
			k++;
		}
		while (j<rightSize) {
			a[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void quickSort(int[] a, int start, int end) {
		if(start >= end)
			return;
		int pivot = partition(a,start,end);
		//!!!!!!
		//TODO THIS IS PROBABLY WRONG, check the "pivot-1" I had it as "pivot-a" but that can't be right..
		//!!!!!!
		quickSort(a,start,pivot-1);
		quickSort(a,pivot+1,end);
	}
	
	public static int partition(int[] a, int start, int end) {
		int pivot = a[end];
		int i = start;
		for(int j=start; j<=end; j++) {
			if (a[j] < pivot) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		int temp = a[i];
		a[i] = a[end];
		a[end] = temp;
		return i;
	}
}
