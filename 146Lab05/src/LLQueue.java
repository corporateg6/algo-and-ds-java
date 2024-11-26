/*
 * Brently G
 */

//Generic Linked List Queue implementation of QueueI<T>
//uses a Generic Linked list to produce the queue functionality.
public class LLQueue<T> implements QueueI<T> {
	
	private GenLL<T> queue;
	
	public LLQueue() {
		queue = new GenLL<T>();
	}
	
	public void enqueue(T data) {
		if (data == null)
			return;
		queue.add(data);
	}
	
	public T dequeue() {
		queue.reset();
		if (!queue.hasMore())
			return null;
		T ret = queue.getCurrent();
		queue.removeCurrent();
		return ret;
	}
	
	public T peek() {
		queue.reset();
		return queue.getCurrent();
	}
	
	public void print() {
		queue.print();
	}
}
