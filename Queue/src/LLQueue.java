/*
 * Brently G
 */

//TODO Comments

public class LLQueue<T> implements QueueI<T> {

	/*
	private class ListNode {
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) {
			this.data = aData;
			this.link = aLink;
		}
	}
	
	private ListNode head;
	private ListNode tail;
	
	public LLQueue() {
		head = tail = null;
	}
	
	public void enqueue(T aData) {
		ListNode newNode = new ListNode (aData, null);
		if (head == null) {
			head = tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
	}
	
	public T dequeue() {
		if (head == null)
			return null;
		T ret = head.data;
		head = head.link;
		return ret;
	}
	
	public T peek() {
		if (head == null)
			return null;
		return head.data;
	}
	
	//something wrong here
	public void print() {
		for(ListNode temp = head; temp == null; temp = temp.link) {
		}
	}
	*/
	
	private GenLL<T> queue;
	
	public LLQueue() {
		queue = new GenLL<T>();
	}
	
	public void enqueue(T data) {
		if (data == null)
			return;
		this.queue.add(data);
	}
	
	public T dequeue() {
		this.queue.reset();
		if (!queue.hasMore())
			return null;
		T ret = queue.getCurrent();
		this.queue.removeCurrent();
		return ret;
	}
	
	public T peek() {
		this.queue.reset();
		return queue.getCurrent();
	}
	
	public void print() {
		this.queue.print();
	}
}
