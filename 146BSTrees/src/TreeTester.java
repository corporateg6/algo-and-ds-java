
public class TreeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBST<Integer> iBST = new LinkedBST<Integer>();
		DoubleBST dBST = new DoubleBST();
		
		/*
		iBST.add(50);
		iBST.add(25);
		iBST.add(75);
		iBST.add(15);
		iBST.add(65);
		iBST.add(100);
		
		iBST.add(63);
		iBST.add(64);
		iBST.remove(25);
		iBST.remove(50);
		iBST.add(13);
		
		iBST.printPreOrder();
		//iBST.printInOrder();
		//iBST.printPostOrder();

		 */
		
		dBST.add(8.0);
		dBST.add(2.0);
		dBST.add(12.0);
		dBST.add(1.0);
		dBST.add(4.0);
		dBST.add(10.0);
		dBST.add(16.0);
		
		dBST.printPreOrder();
		
		System.out.println(dBST.findSum());
	}
	

}
