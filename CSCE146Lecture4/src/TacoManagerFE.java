/*
 * Brently George
 */
import java.util.Scanner;

public class TacoManagerFE {

	public static Scanner keyboard = new Scanner(System.in);
	public static TacoManager tacoManager = new TacoManager();
	
	public static void main(String[] args) {
		printGreetings();
		boolean quit = false;
		while(!quit) {
			printChoices();
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice) {
			case 1: //Add taco
				addTaco();
				break;
			case 9: //Quit
				quit = true;
			}
			tacoManager.print();
		}
		System.out.println("Goodbye");
	}

	public static void printGreetings() {
		System.out.println("Welcome to TacoMan!");
	}
	
	public static void printChoices() {
		System.out.println("1. Add Taco");
		System.out.println("9. Quit");
	}
	
	public static void addTaco() {
		System.out.println("Enter the name");
		String aName = keyboard.nextLine();
		System.out.println("Enter the location");
		String aLocation = keyboard.nextLine();
		System.out.println("Enter the price");
		double aPrice = keyboard.nextDouble();
		keyboard.nextLine();
		
		Taco newTaco = new Taco(aName, aLocation, aPrice);
		tacoManager.addTaco(newTaco);
	}
	
}
