
public class LinkedListTest {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		/*
		Node head = new Node(1, null);
		head.link = new Node(2, null);
		head.link.link = new Node(3, null);
		head.link.link.link = new Node(4, null);
		head.link.link.link.link = new Node(5, null);
		
		head.link.link = new Node(17, head.link.link.link);
		*/
		
		/*
		 * 
	
		IntLL iLL = new IntLL();
		for(int i=0;i<10;i++)
			iLL.add(i);
		iLL.print();
	}
			 */
		GenLL<Integer> iLL = new GenLL<Integer>();
		GenLL<Double> dLL = new GenLL<Double>();
		GenLL<String> sLL = new GenLL<String>();
		
		for(int i=0;i<5;i++) {
			iLL.add(i);
			dLL.add((double)i);
			sLL.add("String" + i);
		}
		
		/*
		iLL.print();
		dLL.print();
		sLL.print();
		*/
		
		iLL.gotoNext();
		iLL.setCurrent(42);
		iLL.print();
		iLL.gotoNext();
		iLL.removeCurrent();
		iLL.print();
	}
	
}

