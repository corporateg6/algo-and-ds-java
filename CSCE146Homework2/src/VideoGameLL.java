/*
 * Brently George
 */

public class VideoGameLL {
	
	private class ListNode {
		private VideoGame data;
		private ListNode link;
		
		public ListNode() {
			this.data = null;
			this.link = null;
		}
		
		public ListNode(VideoGame data, ListNode link) {
			this.data = data;
			this.link = link;
		}
	}
	
	private ListNode head; //points to the beginning of the list.
	private ListNode current; //points to current item in the list.
	private ListNode previous; //points to the item before current in the list. if current is head, previous is null.
	
	//new list, there are no items, point to null with everything
	public VideoGameLL() {
		this.head = this.current = this.previous = null;
	}
	
	//add
	
	//adds a video game to the end of the list.
	//if the list is empty, starts the list.
	public void add(VideoGame data) {
		ListNode newNode = new ListNode(data, null); //create a new node with the input, link it to null
		//if the list is empty, start the list, update pointers and return
		if (this.head == null) {
			this.head = this.current = newNode;
			return;
		}
		//otherwise, find the end of the list and add this newnode at the end
		ListNode temp = head;
		//set temp to last non-null item in the list
		while(temp.link != null) {
			temp = temp.link;
		}
		//link the last item to the new node
		temp.link = newNode;
	}
	
	//insert an item into the list after the current pointer (if current isn't null)
	public void addAfterCurrent(VideoGame data) {
		if (this.current == null)
			return;
		//create the new node, linking it to the current next item
		ListNode newNode = new ListNode(data, current.link);
		//update the link of the current item to this new item.
		this.current.link = newNode;
	}
	
	//remove
	
	//removes the current item
	public void removeCurrent() {
		//if current is the head, meaning there is no previous
		//meaning we are at the beginning
		if(this.current != null && this.previous == null) {
			this.head = this.head.link;
			this.current = this.head;
		} else if (this.current != null && this.previous != null) {
			//or if we are in the middle of the list
			this.previous.link = this.current.link;
			this.current = this.current.link;
		}
	}
	
	//update
	
	//sets the data of the current item to the input data
	//only works if the current item exists aka !null
	public void setCurrent(VideoGame data) {
		if(this.current == null)
			return;
		this.current.data = data;
	}
	
	//traversal
	
	//move current to the next item, only if the next item isn't null
	public void gotoNext() {
		if (this.current.link != null) {
			//first update reference to previous
			this.previous = this.current;
			this.current = this.current.link;
		}
	}
	
	//reset position in the list
	public void reset() {
		this.current = this.head;
		//there is no item before the head
		this.previous = null;
	}
	
	//returns true if there is an item after the current item.
	//otherwise false
	public boolean hasNext() {
		if (this.current.link == null)
			return false;
		else
			return true;
	}
	
	//read & print
	
	//gets the current item and returns it, if the current item isn't null
	public VideoGame getCurrent() {
		if (this.current == null)
			return null;
		else
			return this.current.data;
	}
	
	//prints the list data
	public void print() {
		ListNode temp = this.head;
		//for each item in the list until the item is null aka empty
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	//returns true if head is null aka list is empty, else return false.
	public boolean isEmpty() {
		if (this.head == null)
			return true;
		else
			return false;
	}
	
	//comparison
	
	//search entire list to see if there is a data that matches the input data
	public boolean contains(VideoGame data) {
		ListNode temp = this.head;
		while (temp != null) {
			if (data.equals(temp.data)) {
				return true;
			}
			temp = temp.link;
		}
		return false;
	}
}
