/*
 * Brently George
 */

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
	
	public GenLL() {
		this.head = this.current = this.previous = null;
	}
	
	public void add(T aData) {
		ListNode newNode = new ListNode(aData,null);//null is because this is at the end.
		if (this.head == null) { //empty list
			this.head = this.current = newNode;
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
		if (this.current.link != null) {
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
		} else if (this.current != null && this.previous != null) {
			this.previous.link = this.current.link;
			this.current = this.current.link;
		}
		
	}
	
	public void addAfterCurrent(T aData) {
		if (this.current == null)
			return;
		ListNode newNode = new ListNode(aData,this.current.link);
		this.current.link = newNode;
	}
	
}
