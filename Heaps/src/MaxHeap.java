/*
 * Brently G
 */

public class MaxHeap <T extends Comparable<T>>{
	private T[] heap;
	public static final int DEF_SIZE = 128; //for a binary tree, default size is base 2
	private int size; //last index
	
	public MaxHeap() {
		
	}
	
	public MaxHeap(int aSize) {
		init(aSize);
	}
	
	private void init(int aSize) {
		if(aSize >= 2)
			heap = (T[])(new Comparable[aSize]);
		else
			heap = (T[])(new Comparable[DEF_SIZE]);
	}
	
	
	public void add(T aData) {
		if(heap[heap.length-1] != null)
			return; //this means the heap is full
		heap[size] = aData;
		this.bubbleUp();
		size ++;
	}
	
	//TODO when do we use this?
	private void bubbleUp() {
		int index = size;
		while(index > 0 && heap[(index-1)/2].compareTo(heap[index])<0) {
			T temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
			
		}
	}
	
	//TODO update this
	public T remove() {
		//TODO not done check examples for bubble down?
		if(size<=0)
			return null;
		T ret = heap[0];
		heap[0] = heap[size-1];
		size--;
		//TODO bubbleDown
		this.bubbleDown();
		return ret;
	}
	
	
	//TODO what up wit dat??
	private void bubbleDown() {
		int index = 0;
		while(index*2+1 < size) {
			//Assume left is larger
			int bigIndex = index*2+1;
			//confirm
			if(index*2+2 < size && heap[index*2+1].compareTo(heap[index*2+2]) < 0)
				bigIndex = index*2+2;
			if(heap[index].compareTo(heap[bigIndex]) < 0) {
				//SWAP
				T temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}//missing something here
			else
				break;
			index = bigIndex;
		}
	}
	
	public T peek() {
		return heap[0];
	}
	
	public void print() {
		for(int i=0; i<size; i++ ) {
			System.out.println(heap[i]);
		}
	}
}
