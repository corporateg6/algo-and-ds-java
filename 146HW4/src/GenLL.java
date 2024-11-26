/*
 * Brently George
 */

//TODO could use more comments maybe
public class GenLL <T>{
	
	private class ListNode {
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) {
			this.data = aData;
			this.link = aLink;
		}
	}
	
	private ListNode head; //first element
	private ListNode current; //current node of interest
	private ListNode previous; //previous node of interest
	private int size;
	
	public GenLL() {
		this.head = this.current = this.previous = null;
		this.size = 0;
	}
	
	public void add(T aData) {
		ListNode newNode = new ListNode(aData,null);//null is because this is at the end.
		if (this.head == null) { //empty list
			this.head = this.current = newNode;
			this.size ++;
			return;
		}
		//not empty list
		ListNode temp = this.head;
		while(temp.link != null) {
			temp = temp.link;
		}
		temp.link = newNode;
	}
	
	public void print() {
		ListNode temp = this.head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

	
	public void gotoNext() {
		if (this.current != null) {
			this.previous = this.current;
			this.current = this.current.link;
		}
	}
	
	public void reset() {
		this.current = this.head;
		this.previous = null;
	}
	
	public T getCurrent() {
		if (this.current == null)
			return null;
		else
			return this.current.data;
	}
	
	public void setCurrent(T aData) {
		if(this.current == null)
			return;
		this.current.data = aData;
	}
	
	public void removeCurrent() {
		if(this.current != null && this.previous == null) {
			this.head = this.head.link;
			this.current = this.head;
			this.size --;
		} else if (this.current != null && this.previous != null) {
			this.previous.link = this.current.link;
			this.current = this.current.link;
			this.size --;
		}
		
	}
	
	public void addAfterCurrent(T aData) {
		if (this.current == null)
			return;
		ListNode newNode = new ListNode(aData,this.current.link);
		this.current.link = newNode;
		this.size ++;
	}
	
	public boolean hasMore() {
		return current != null;
	}
	
	public T getAt(int index) {
		if(index < 0)
			return null;
		ListNode temp = this.head;
		for(int i=0; i<index; i++) {
			if(temp == null)
				return null;
			temp = temp.link;
		}
		return temp.data;
	}
	
	public void setAt(int index, T aData) {
		if(index < 0)
			return;
		ListNode temp = this.head;
		for(int i=0; i<index; i++) {
			if (temp == null)
				return;
			temp = temp.link;
		}
		temp.data = aData;
	}
	
	public int getSize() {
		return this.size;
	}
}
