/*
 * Brently George
 */

//All queues should be able to:
//enqueue: put an input object into the queue
//dequeue: remove and return the oldest item from the queue
//peek: return but don't remove the oldest item from the queue
//print: print all items in the queue.
public interface QueueI<T> {
	public void enqueue(T data);
	public T dequeue();
	public T peek();
	public void print();
}
