
public class SearchAlgos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5,6,7,8,9,10};
		System.out.println(linSearch(array,11));
	}

	public static boolean linSearch(int[] a, int target) {
		for(int i=0; i<a.length; i++)
			if(a[i] == target)
				return true;
		return false;
	}
}
