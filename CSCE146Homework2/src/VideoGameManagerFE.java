/*
 * Brently George
 */

import java.util.Scanner;

public class VideoGameManagerFE {
	
	public static Scanner keyboard = new Scanner(System.in);
	public static VideoGameManager vgm = new VideoGameManager();
	public static void main(String[] args) {
		printGreeting();
		boolean quit = false;
		while (!quit) {
			printMenuChoices();
			int selection = Integer.valueOf(keyboard.nextLine());
			switch(selection) {
			case 1:
				loadVGFile();
				break;
			case 2:
				searchVGFile();
				break;
			case 3:
				saveSearchResults();
				break;
			case 4:
				printLoaded();
				break;
			case 5:
				printSearchResults();
				break;
			case 9:
				quit = true;
				break;
			default:
				System.out.println("Selection Not Valid.");
				break;
			}
			
		}
		System.out.println("Goodbye!");
	}
	
	//print any existing search results, if no results returns
	public static void printSearchResults() {
		if (!vgm.hasSearchResults()) {
			System.out.println("Search results empty.  Try searching.");
			return;
		}
		vgm.printSearchResults();
	}
	
	//print any loaded games from file, if no file loaded, returns
	public static void printLoaded() {
		if (!vgm.hasLoadedVGFile()) {
			System.out.println("No file loaded. Try loading a file.");
			return;
		}
		vgm.printLoadedFile();
	}
	
	//saves search results by writing them to a file, file name is specified by user.
	//user can choose to append the file they indicated, if they do not, this will overwrite the file they indicated if it already exists.
	//if there is no loaded file, or no search results available, informs user and returns.
	public static void saveSearchResults() {
		if (!vgm.hasLoadedVGFile()) {
			System.out.println("You need to load a Video Game file, and then search, before saving your search results.");
			return;
		}
		if (!vgm.hasSearchResults()) {
			System.out.println("Search results empty.  Try searching.");
			return;
		}
		System.out.println("This operation will create a new file if the file you enter does not exist.");
		System.out.println("Enter a filename to save your search results to:");
		String fileName = keyboard.nextLine();
		System.out.println("If the file already exists, and don't append, this operation will overwrite the file you indicated.");
		System.out.println("Would you like to append? Enter true or false.");
		boolean append = keyboard.nextBoolean();
		keyboard.nextLine();
		if(append)
			vgm.appendSearchResultsFile(fileName);
		else
			vgm.writeSearchResultsFile(fileName);
	}
	
	//prompts user for the search terms and triggers the search operation
	//if there are no search results, informs user and returns.
	public static void searchVGFile() {
		if (!vgm.hasLoadedVGFile()) {
			System.out.println("You need to successfully load a Video Game file before attempting to search.");
			return;
		}
		System.out.println("Enter a Video Game name or '*' to include all:");
		String vgName = keyboard.nextLine();
		System.out.println("Enter a Console name or '*' to include all:");
		String consoleName = keyboard.nextLine();
		vgm.searchVGFile(vgName, consoleName);
		if (vgm.hasSearchResults())
			vgm.printSearchResults();
		else
			System.out.println("Search results empty! Try searching again.");
	}
	
	//prompts user for a database file to load and triggers the load operation
	public static void loadVGFile() {
		System.out.println("Enter the name of the Video Game file:");
		vgm.loadVGFile(keyboard.nextLine());
	}

	public static void printGreeting() {
		System.out.println("Welcome to the Video Game Database Manager!");
	}
	
	public static void printMenuChoices() {
		System.out.println("1: Load a Video Game collection file.");
		System.out.println("2: Search Video Game collection.");
		System.out.println("3: Save latest search results to a file.");
		System.out.println("4: View Loaded Video Game collection.");
		System.out.println("5: View latest search results.");
		System.out.println("9: Quit.");
	}
}
