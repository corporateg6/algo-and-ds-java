/*
 * Brently George
 */

import java.util.Scanner;

public class SortSortFE {
	
	public static Scanner keyboard = new Scanner(System.in);
	public static SortSortManager ssMgr;
	
	public static void main(String[] args) {
		printGreeting();
		boolean quit = false;
		while (!quit) {
			ssMgr = new SortSortManager();
			collectStrings();
			printSorted();
			System.out.println("Go again? Enter yes if so:");
			String input = keyboard.nextLine();
			if(!input.toLowerCase().equals("yes"))
				quit = true;
		}
		keyboard.close();
		System.out.println("Goodbye!");

	}
	
	public static void collectStrings() {
		boolean stop = false;
		while (!stop) {
			System.out.println("Enter a string or 'stop':");
			String input = keyboard.nextLine();
			if(input.toLowerCase().equals("stop"))
				stop = true;
			else if(input != null){
				ssMgr.add(input);
			}
		}
	}
	
	public static void printSorted() {
		System.out.println("Strings sorted by 'sort' frequency:");
		System.out.println("___________________________________");
		ssMgr.printSorted();
		System.out.println("___________________________________\n");
		
	}
	
	public static void printGreeting() {
		System.out.println("Welcome to the Sort Sorter!");
		System.out.println("Enter any number of strings.");
		System.out.println("After you are done inputting strings, enter 'stop' without quotes.");
		System.out.println("I will count the number of times the string 'sort' appears in each string.");
		System.out.println("Then I will sort those strings from least to most and output the results.");
		
	}

}
