/*
 * Brently G
 */

import java.io.File;
import java.util.Scanner;

public class FruitTreeTester {
	
	public static final String DELIM = "\t";
	public static final int FILE_WIDTH = 2;
	public static Scanner keyboard = new Scanner(System.in);
	public static LinkedBST<Fruit> fruitTree;
	public static boolean loaded = false;

	public static void main(String[] args) {
		while(!loaded) { //keep running until we load a file
			System.out.println("Please enter the name of your Fruit File: ");
			loadFile(keyboard.nextLine());
		}
		
		//print preorder
		System.out.println("\nPrinting Pre-Order");
		fruitTree.printPreOrder();
		
		//print inorder
		System.out.println("\nPrinting In-Order");
		fruitTree.printInOrder();
		
		//print postorder
		System.out.println("\nPrinting Post-Order");
		fruitTree.printPostOrder();
		
		//delete some fruit
		//we will delete this fruit
		Fruit fruitToDelete = new Fruit("Apple", 0.4859853412170728);
		System.out.println("\nDeleting this Fruit:\n" + fruitToDelete);
		fruitTree.remove(fruitToDelete);
		
		//print inorder again
		System.out.println("\nPrinting In-Order");
		fruitTree.printInOrder();
		
		keyboard.close();
	}
	
	public static void loadFile(String fileName) {
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			String fileLine;
			String[] splitLine;
			//this is so if we load a new file
			//we discard existing data we may have loaded before
			fruitTree = new LinkedBST<Fruit>();
			while(fileScanner.hasNextLine()) {
				fileLine = fileScanner.nextLine();
				splitLine = fileLine.split(DELIM);
				if (splitLine.length != FILE_WIDTH)
					continue;
				String type = splitLine[0];
				Double weight = Double.valueOf(splitLine[1]);
				Fruit newFruit = new Fruit(type, weight);
				fruitTree.add(newFruit);
			}
			//flag our file to be loaded
			loaded = true;
			fileScanner.close();
		} catch (Exception e) {
			loaded = false; //set loaded to false if for some reason it got flipped, but it shouldn't have.
			System.out.println("Unable to load the file, please try again.");
			System.out.println("ERROR: "+e.getMessage());
		}
	}

}
