
public class DoubleBST extends LinkedBST<Double>{
	
	private class Node {
		double data;
		Node leftChild;
		Node rightChild;
		
		public Node(double aData) {
			this.data = aData;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	
	//private Node root;
	
	public double findSum() {
		return findSum();
	}
	
	private double findSum(Node aNode) {
		if(aNode == null) {
			return 0;
		}
		return aNode.data + findSum(aNode.leftChild) + findSum(aNode.rightChild);
	}
}
