/*
 * Brently George
 */
public class DoubleDoubleLL {
	
	//ListNode class for internal use
	private class ListNode {
		Double data;
		ListNode pLink;
		ListNode nLink;
		
		public ListNode() {
			this.data = null;
			this.pLink = this.nLink = null;
		}
		
		public ListNode(Double data, ListNode prev, ListNode next) {
			this.data = data;
			this.pLink = prev;
			this.nLink = next;
		}
	}
	
	//tracking of head and current
	private ListNode head;
	private ListNode current;
	//don't need previous since this is tracked by each ListNOde
	//private ListNode previous;
	
	public DoubleDoubleLL() {
		this.head = this.current = null;
	}
	
	//================
	//set current to the next link from the current.
	//if current is null do nothing.
	public void gotoNext() {
		if (this.current == null)
			return;
		this.current = this.current.nLink;
	}
	
	//set current to the previous link from the current
	//if current is null do nothing
	public void gotoPrev() {
		if (this.current == null)
			return;
		this.current = this.current.pLink;
	}
	
	//reset current pointer back to head of the list
	public void reset() {
		this.current = this.head;
	}
	
	//first reset, because if the current is null and we return, the caller might think we are actually at the end
	//after that, if the current pointer is null (aka empty list), we shouldn't do anything
	//then set current to the next link until there is no next link
	public void gotoEnd() {
		this.reset();
		if(this.current == null)
			return;
		while(this.current.nLink != null) {
			this.current = this.current.nLink;
		}
	}
	
	//per the spec, this method should return false if current == null, else return true
	public boolean hasMore() {
		if (this.current == null)
			return false;
		else
			return true;
	}
	//====================
	
	//====================
	//return data at current pointer, if null just return null.
	public Double getCurrent() {
		if (this.current == null)
			return null;
		else
			return this.current.data;
	}
	
	//set the data at the current pointer to the input parameter
	//if current is null do nothing.
	public void setCurrent(Double aData) {
		if (this.current == null)
			return;
		this.current.data = aData;
	}
	//====================
	
	//====================
	//NOTE: After either “add” or “addAfterCurrent” the integrity of the list must be maintained, and all links and references need to be properly set.
	public void add(Double aData) {
		//don't do anything if we try to add a null element
		if (aData == null)
			return;
		//If the head reference is null, then it adds the new node to the start of the list.
		if (this.head == null) {
			ListNode newNode = new ListNode(aData, null, null);
			//also set current to this new node
			this.head = this.current = newNode;
			return;
		}
		//must create a new node with data provided via a parameter and add it to the end of the list.
		//find the current end of the list.
		ListNode temp = head;
		while (temp.nLink != null) {
			temp = temp.nLink;
		}
		//create our new node with it's previous pointing to the current end, then add this new node to the end.
		ListNode newNode = new ListNode(aData, temp, null);
		temp.nLink = newNode;
	}
	
	public void addAfterCurrent(Double aData) {
		//If the current reference is null, then do not add the data to the list.
		if (this.current == null)
			return;
		//must create a new node with the data provided via a parameter and add it after the current reference.
		ListNode newNode = new ListNode(aData, this.current, this.current.nLink);
		//if the next link is null, we can't update that links' pLink, so check it before trying.
		if (this.current.nLink != null)
			//this is to set the next node's previous link to this new node.
			this.current.nLink.pLink = newNode;
		this.current.nLink = newNode;
	}
	//====================
	
	//====================
	//NOTE: After either “remove” or “removeCurrent” the integrity of the list must be maintained, and all links and references need to be properly set.
	//per clarification from JJ this doesn't need to remove duplicates, just return after single removal
	public void remove(Double aData) {
		//must search for data provided via a parameter, and remove the node if it is found.
		//first go back to beginning of list in case we are not.
		this.reset();
		//then go through the list 1 by 1
		while(this.current != null) {
			//if we find a match, remove it using existing remove current method and return
			if (this.getCurrent().equals(aData)) {
				this.removeCurrent();
				return;
			}
			this.gotoNext();
		}	
	}
	
	public void removeCurrent() {
		//If the current reference is null, then this method does nothing.
		//must remove the node that is at the current reference.
		//need to account for 4 scenarios, current is either
		//--beginning of list
		//--middle of list
		//--end of list
		//--only item in list (both beginning and end)
		//first if we are at the beginning and current isn't null
		if (this.current != null && this.current.pLink == null) {
			//then if we have an item after this, we need to update it's previous link to be null (because we are at the beginning.
			//but we can't do this is there is no next item so we have to check.
			//this accounts for beginning of the list and for only item in the list.
			if (this.current.nLink != null) {
				this.current.nLink.pLink = null;
			} //then update the new head of the list and the new current pointer
			this.head = this.current.nLink;
			this.current = this.head;
			//next we check if we are in the middle or end of the list by checking if there is a previous item
		} else if (this.current != null && this.current.pLink != null) {
			//same as before we need to check if there is a next item before we try to modify it.
			//this will account for middle of the list, or end of the list.
			//if we are in the middle we need to update the previous link of the next item
			if (this.current.nLink != null) {
				this.current.nLink.pLink = this.current.pLink;
			} //then update the previous item to point to the current's next item.
			this.current.pLink.nLink = this.current.nLink;
			//current should now move to something else since current has been removed
			//lets just point it to the next item in line
			this.current = this.current.nLink;
		}
	}
	//====================
	//iterate through the list and print each item
	public void print() {
		ListNode temp = this.head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.nLink;
		}
	}
	
	//====================
	//check each item to see if any contains the data
	//if we find it we can return early with true, otherwise go through the whole list and return false if we don't find it.
	public boolean contains(Double aData) {
		ListNode temp = this.head;
		while (temp != null) {
			if (temp.data.equals(aData))
				return true;
			temp = temp.nLink;
		}
		return false;
	}
	
}
