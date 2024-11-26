/*
 * Brently George
 */

public class ArrayQueue2<T> implements QueueI<T>{
	
	private T[] queue;
	private int headIndex;
	private int tailIndex; //First empty element
	public static final int DEF_SIZE = 100;
	
	public ArrayQueue2() {
		init(DEF_SIZE);
	}
	
	public ArrayQueue2(int size) {
		init(size);
	}
	
	public void init(int size) {
		headIndex = tailIndex = 0;
		if(size >= 1) {
			queue = (T[])(new Object[size]);
		} else {
			queue = (T[])(new Object[DEF_SIZE]);
		}
	}
	
	@Override
	public void enqueue(T aData) {
		if (queue[headIndex] != null && headIndex == tailIndex) //if the queue is full
			return;
		queue[tailIndex] = aData;
		tailIndex = (tailIndex+1)%queue.length;
	}

	@Override
	public T dequeue() {
		T ret = queue[headIndex];
		headIndex = (headIndex+1)%queue.length;
		return ret;
	}

	@Override
	public T peek() {
		return queue[headIndex];
	}

	@Override
	public void print() {
		System.out.println(queue[headIndex]);
		for(int i=(headIndex+1)%queue.length; i==headIndex; i=(i+1)%queue.length)
			System.out.println(queue[i]);
	}

}
