/*
 * Brently George
 */

public class GroceryList {
	
	//nodes for my linked list.
	private class ListNode {
		
		private GroceryItem data;
		private ListNode link;
		
		public ListNode() {
			this.data = null;
			this.link = null;
		}
		
		public ListNode(GroceryItem data, ListNode link) { 
			this.data = data;
			this.link = link;
		}
	}
	
	private ListNode head;  //points to first node in the list
	private ListNode current; //points to the current node for list traversal.
	private ListNode previous; //points to the previous node, for list traversal and updates.
	
	public GroceryList() {
		this.head = this.current = this.previous = null;
	}
	
	//if next (current.link) exists, first set previous to current, then set current, to next (current.link)
	//otherwise, do nothing
	public void gotoNext() {
		if (this.current.link != null) {
			this.previous = this.current;
			this.current = this.current.link;
		}
	}
	
	//if the current node isn't null, return the data there, otherwise return null.
	public GroceryItem getCurrent() {
		if (this.current != null) 
			return this.current.data;
		else
			return null;
	}
	
	//as long as the input data is not null and the current node is not null.
	//takes in a grocery item and sets the data at the current node to the input data.
	public void setCurrent(GroceryItem groceryItem) {
		if (this.current != null && groceryItem != null)
			this.current.data = groceryItem;
	}
	
	//take input item and add it to the end of the list.
	//if there are no items in the list, this will become the first item.
	public void addItem(GroceryItem groceryItem) {
		if (groceryItem == null)
			return;
		ListNode newNode = new ListNode(groceryItem, null);//this item will be at the end of the list
		//if there is no item in the list, this will become the first item, then we are done.
		//updating the head of the list and the current selector to point to this item
		// we do this here because at this point since we didn't have any items before, those head and current pointers are set to null.
		if (this.head == null) {
			this.head = this.current = newNode;
			return;
		}
		//if that wasn't the first item, lets first find the end of the list, then add it to the end.
		//start at the beginning
		ListNode temp = head;
		//let temp be equal to the next item in the list until there is no next item
		//Remember that temp.link is the next item when temp is the current item in question.
		//thus if temp.link is null, then temp is the last item.
		while (temp.link != null) {
			temp = temp.link;
		}
		//set our new item to temp.link, which is the next item while temp is the last item.
		//thus temp.link will be the new last item.
		temp.link = newNode;
	}

	//as long as the list and the input data is not null:
	//inserts the new item after the current node position
	//need to update the current node to point to this new one
	//then if the next node had already existed, we need to update this new node we add to point to that next one
	//we do this so we don't lose the rest of the list.
	public void addItemAfterCurrent(GroceryItem groceryItem) {
		if (this.current != null && groceryItem != null) {
			ListNode newNode = new ListNode(groceryItem, this.current.link); //we actually don't need to check if the next item exists or not
			//if the next item doesn't exist, this.current.link will be null anyways and this will point to the end of the list
			//if it does exist, this will point to it. 
			//but we do need to link the current node to this new one.
			this.current.link = newNode;
		}
	}
	
	//remove the node at the current node pointer
	//we need to account for 3 scenarios.
	//scenario 1: current exists and is at the beginning of the list (or previous == null).
	//-- in this case we are at the beginning so we need our next node to be the new head and the new current
	//scenario 2: current exists and is not at the beginning of the list(or previous != null).
	//-- in this case we need to set the previous next node (previous.link) to the next (current.link) node,
	//and then we need to set our current selector to the next node (current.link).
	//scenario 3: all other scenarios, do nothing
	public void removeCurrent() {
		if (this.current != null && this.previous == null) {
			this.head = this.head.link; //make the next item the new head.
			this.current = this.head; //make the new current the newly set head.
		} else if (this.current != null && this.previous != null) {
			this.previous.link = this.current.link; //make the previous item link to the next item instead of the current item.
			this.current = this.current.link; //remove the reference to the current item by moving that to the next item.
		}
	}
	
	//prints out the full contents of the list
	public void showList() {
		ListNode temp = this.head;
		//print the data until the next item (temp.link) is null
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	//iterate through list to see if any data is equal to the input parameter.
	//returns true if it finds a match, otherwise returns false
	public boolean contains(GroceryItem groceryItem) {
		ListNode temp = this.head;
		while (temp != null) {
			if (groceryItem.equals(temp.data)) {
				return true;
			}
			temp = temp.link;
		}
		return false;
	}
	
	//iterate through list and keep running total of the price of each item.
	//return price of each item, 0.0 if no items.
	public double totalCost() {
		double sum = 0.0;
		ListNode temp = this.head;
		while (temp != null) {
			sum += temp.data.getValue();
			temp = temp.link;
		}
		return sum;
	}
}
