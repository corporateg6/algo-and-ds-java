/*
 * Brently Geeorge
 */

public class IntLL {
	
	private class ListNode {
		int data;
		ListNode link;
		public ListNode(int aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	
	private ListNode head; //first element
	private ListNode current; //current node pointer
	
	public IntLL() {
		head = null;
	}
	
	public void add(int aData) {
		ListNode newNode = new ListNode(aData,null); //new item at the end
		if(head == null) {
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while (temp.link != null)
			temp = temp.link;
		temp.link = newNode;

	}
	
	public void print() {
		/*ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}*/
		
		for(ListNode temp = head; temp!=null;temp=temp.link)
			System.out.println(temp.data);
	}
	
	public int getCurrent() {
		if (current == null)
			return 0;
		else return current.data;
	}
	
	public void setCurrent(int aData) {
		if (current != null)
			current.data = aData;
	}
	
	public void gotoNext() {
		if (current != null)
			current = current.link;
	}
	
	public void reset() {
		current = head;
	}
}
