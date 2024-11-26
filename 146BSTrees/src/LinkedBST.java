/*
 * Brently G
 */

//Our generic Type <T> must be comparable so <T extends Comparable<T>>
//meaning the type must implement compareTo() method and implement comparable

//TODO this is wrong, check the materials
public class LinkedBST <T extends Comparable<T>> {

	private class Node {
		T data;
		Node leftChild;
		Node rightChild;
		
		public Node(T aData) {
			this.data = aData;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	
	public Node root; //this is the root node of the tree
	
	public LinkedBST() {
		root = null;
	}
	
	//add method
	public void add(T aData) {
		if (aData == null)
			return;
		if (root == null)
			root = new Node(aData);
		else
			root = add(root, aData);
	}
	//recursive add method
	private Node add(Node aNode, T aData) {
		if(aNode == null)
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data)<0) //GO LEFT
			aNode.leftChild = add(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0) //GO RIGHT
			aNode.rightChild = add(aNode.rightChild,aData);
		return aNode;
	}
	
	public void printPreOrder() {
		printPreOrder(root);
	}
	
	private void printPreOrder(Node aNode) {
		if(aNode == null)
			return;
		System.out.println(aNode.data); //PROCESS
		printPreOrder(aNode.leftChild); //LEFT
		printPreOrder(aNode.rightChild); //RIGHT
	}
	
	public void printInOrder() {
		printInOrder(root);
	}
	
	private void printInOrder(Node aNode) {
		if(aNode == null)
			return;
		printInOrder(aNode.leftChild); //LEFT
		System.out.println(aNode.data); //PROCESS
		printInOrder(aNode.rightChild); //RIGHT	
	}
	
	public void printPostOrder() {
		printPostOrder(root);
	}
	
	private void printPostOrder(Node aNode) {
		if (aNode == null)
			return;
		printPostOrder(aNode.leftChild); //LEFT
		printPostOrder(aNode.rightChild); //RIGHT
		System.out.println(aNode.data); //PROCESS
	}
	
	public boolean search(T aData) {
		return search(root, aData);
	}
	
	private boolean search(Node aNode, T aData) {
		if(aNode == null)
			return false;
		else if(aData.compareTo(aNode.data)<0) //GO LEFT
			return search(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data)>0) //GO RIGHT
			return search(aNode.rightChild, aData);
		else
			return true; //If not <0 or >0 then it's == 0 and true.
	}
	
	public void remove(T aData) {
		root = remove(root, aData);
	}
	
	private Node remove(Node aNode, T aData) {
		//search for the node first
		if(aNode == null)
			return null;
		else if(aData.compareTo(aNode.data)<0) //GO LEFT
			aNode.leftChild = remove(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data)>0) //GO RIGHT
			aNode.rightChild = remove(aNode.rightChild, aData);
		else {
			if(aNode.rightChild == null)
				return aNode.leftChild;
			else if(aNode.leftChild == null)
				return aNode.rightChild;
			//TODO below needs to be commented, some wizardry going on there
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild, temp.data);
		}
		return aNode;
	}
	
	//TODO comment helper function for the magic spell being cast above
	private Node findMinInTree(Node aNode) {
		if(aNode == null) 
			return null;
		else if(aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
	
}
