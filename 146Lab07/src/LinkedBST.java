/*
 * Brently G
 */

//Our generic Type <T> must be comparable so <T extends Comparable<T>>
//meaning the type must implement compareTo() method and implement comparable

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
	
	private Node root; //this is the root node of the tree
	
	public LinkedBST() {
		root = null;
	}
	
	//add method
	public void add(T aData) {
		if (aData == null)
			return;
		if (root == null) //if the BST is empty, this node becomes the root
			root = new Node(aData);
		else //otherwise use our recursive add method
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
	
	//to remove we set our root node equal to whatever our recursive method returns
	public void remove(T aData) {
		root = remove(root, aData);
	}
	
	//return a node finally that is the root of our BST with the node in question removed
	private Node remove(Node aNode, T aData) {
		//search for the node first
		if(aNode == null)
			return null;
		else if(aData.compareTo(aNode.data)<0) //GO LEFT - if our node in question it less than current, remove it from the left side
			aNode.leftChild = remove(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data)>0) //GO RIGHT - if our node in question is greater than the current, remove it from the right side
			aNode.rightChild = remove(aNode.rightChild, aData);
		else { //once we find the node, we need to remove it
			if(aNode.rightChild == null) 
				return aNode.leftChild;
			else if(aNode.leftChild == null)
				return aNode.rightChild;
			//if the node has children, we need to find the data to replace this node with, and then remove what we used to replace it.
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild, temp.data);
		}
		return aNode;
	}
	
	//recursive method to find the lowest value in a BST starting at the input node.
	private Node findMinInTree(Node aNode) {
		if(aNode == null) 
			return null;
		else if(aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
}
