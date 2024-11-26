/*
 * Brently G
 */

public class MinHeap <T extends Comparable<T>>{
	private T[] heap;
	public static final int DEF_SIZE = 128;
	private int size;
	
	public MinHeap() {
		init(DEF_SIZE);
	}
	
	public MinHeap(int aSize) {
		init(aSize);
	}
	
	private void init(int aSize) {
		if(aSize >= 2)
			heap = (T[])(new Comparable[aSize]);
		else
			heap = (T[])(new Comparable[DEF_SIZE]);
	}
	
	//TODO write this
	public void add(T aData) {
		
	}
	
	//TODO write this
	private void bubbleUp() {
		
	}
	
	//TODO write this
	public T remove() {
		T ret = (T)(new Object());
		return ret;
	}
	
	//TODO write this
	private void bubbleDown() {
		
	}
}
