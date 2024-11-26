/*
 * Brently G
 */

public class MinHeap <T extends Comparable<T>>{
	private T[] heap;
	public static final int DEF_SIZE = 128;
	private int size; //last Index
	
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
	
	public void add(T aData) {
		if(size >= heap.length)
			return;
		heap[size] = aData;
		this.bubbleUp();
		size++;
	}
	
	private void bubbleUp() {
		int index = size;
		while(index > 0 && heap[parentOf(index)].compareTo(heap[index])>0) {
			T temp = heap[parentOf(index)];
			heap[parentOf(index)] = heap[index];
			heap[index] = temp;
			index = parentOf(index);
		}
		
	}
	
	private int parentOf(int index) {
		return (index-1)/2;
	}
	
	private int leftChildOf(int index) {
		return index*2+1;
	}
	
	private int r(int index) {
		return index*2+2;
	}
	
	public T remove() {
		if(size<=0)
			return null;
		T ret = heap[0];
		heap[0] = heap[size-1];
		size--;
		this.bubbleDown();
		return ret;
	}
	
	private void bubbleDown() {
		int index = 0;
		while(leftChildOf(index)<size) {
			int smallestIndex = leftChildOf(index);
			if(r(index) < size && heap[leftChildOf(index)].compareTo(heap[r(index)])>0)
				smallestIndex = r(index);
			if(heap[index].compareTo(heap[smallestIndex])>0) {
				T temp = heap[index];
				heap[index] = heap[smallestIndex];
				heap[smallestIndex] = temp;
			}
			else
				break;
			index = smallestIndex;
		}
	}
	
	public T peek() {
		return heap[0];
	}
	
	public void print() {
		for(int i=0; i<size; i++)
			System.out.println(heap[i]);
	}
	
	public void heapSort(T[] array) {
		if(array == null)
			return;
		MinHeap<T> mHeap = new MinHeap<T>(array.length);
		for(int i=0; i<array.length; i++)
			mHeap.add(array[i]);
		for(int i=0; i<array.length; i++)
			array[i] = mHeap.remove();
	}
	
}
