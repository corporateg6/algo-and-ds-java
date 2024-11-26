/*
 * Brently G
 */

public class SortSortManager {
	
	public static GenLL<MatchString> sortStrings;
	public static final String DEF_STRING_TO_MATCH = "sort";
	private String stringToMatch;
	
	public SortSortManager() {
		this.stringToMatch = DEF_STRING_TO_MATCH;
		sortStrings = new GenLL<MatchString>();
	}
	
	//if we want to customize - but we don't right now
	public SortSortManager(String customMatch) {
		if(customMatch == null)
			this.stringToMatch = DEF_STRING_TO_MATCH;
		else
			this.stringToMatch = customMatch;
		sortStrings = new GenLL<MatchString>();
	}
	
	public void add(String addString) {
		if(addString == null)
			return;
		MatchString newMS = new MatchString(addString, stringToMatch); //create our match string, calculating how many times our string exists in the added string data.
		sortStrings.add(newMS);
	}
	
	//this converts our LL to an Array, sorts it, and then prints it.
	//A bit inefficient as this has to do the whole process each time.
	//consider updating the logic to store the sorted array
	//but for our application we only print it once and then abort the application so we can leave it like this for now.
	public void printSorted() {
		MatchString[] msArr = this.toArray();
		sortMatchStringArray(msArr);
		for(int i=0; i<msArr.length; i++) {
			System.out.println(msArr[i]);
		}
	}
	
	public void sortMatchStringArray(MatchString[] msArray) {
		//call quicksort method with array and indices
		quickSort(msArray, 0, msArray.length-1);
	}
	
	//quicksort
	public static void quickSort(MatchString[] a, int start, int end) {
		if(start >= end)
			return;
		//find the new pivot index
		int pivot = partition(a,start,end);
		//sort before and after pivot recursively
		quickSort(a,start,pivot-1);
		quickSort(a,pivot+1,end);
	}
	
	//quicksort find the pivot index
	private static int partition(MatchString[] a, int start, int end) {
		MatchString pivot = a[end];
		int i = start;
		for(int j=start; j<=end; j++) {
			if (a[j].compareTo(pivot) < 0) { //using compareTo method of my MatchString class
				MatchString temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		MatchString temp = a[i];
		a[i] = a[end];
		a[end] = temp;
		return i;
	}
	
	//converts our matchString LL to an array and returns it.
	//we need to use an array for our quickSort method
	public MatchString[] toArray() {
		int size = sortStrings.getSize();
		//put into an array.
		MatchString[] ret = new MatchString[size];
		for(int i=0; i<size; i++) {
			ret[i] = sortStrings.getAt(i);
		}
		return ret;
	}
	
}
