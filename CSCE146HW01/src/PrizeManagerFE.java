/*
 * Brently George
 */
import java.util.Scanner;
public class PrizeManagerFE {

	public static Scanner keyboard = new Scanner(System.in);
	public static PrizeManager pm = new PrizeManager();
	public static final int PRICEDELTA = 1300;
	public static void main(String[] args) {
		//print a greeting message and then first time player instructions
		printGreeting();
		printInstructions();
		//loop through program until user decides to quit
		boolean quit = false;
		while (!quit) {
			printPrizes();
			int guess = promptForPrice();
			boolean winner = checkForWin(guess);
			gameSummary(guess);
			if (winner)
				printWinner();
			else
				printLoser();
			quit = !promptQuit();
			//reset the prizes in case the user will play again.
			pm.resetRandomPrizes();
		}
		System.out.println("Goodbye.");
	}
	
	//to show the results of the users' guess
	public static void gameSummary(int guess) {
		System.out.println("You guessed "+ guess);
		System.out.println("The actual price is "+ pm.getPrizeValue());
	}
	
	//to prompt if the user wants to keep playing.
	public static boolean promptQuit() {
		System.out.println("Would you like to play again?");
		System.out.println("Enter y to play again");
		String quit = String.valueOf(keyboard.nextLine());
		return (quit.equals("y"));
			
	}
	
	//checks if the user entered a value <= total prices and >= total prices minus 1300
	public static boolean checkForWin(int guess) {
		return guess <= pm.getPrizeValue() &&
				guess >= pm.getPrizeValue()-PRICEDELTA;
	}
	
	//message if they win
	public static void printWinner() {
		System.out.println("You win all of the prizes!!!");
	}
	
	//message if they lose
	public static void printLoser() {
		System.out.println("You win NOTHING!! (Value of nothing is $0)");
	}
	
	//prompts the user for their guess
	public static int promptForPrice() {
		System.out.println("Guess the total price as an integer:");
		return Integer.valueOf(keyboard.nextLine());
	}
	
	//greeting message
	public static void printGreeting() {
		System.out.println("Welcome to SHOWCASE!!!");
	}
	
	//print out the random prize names
	public static void printPrizes() {
		System.out.println("Here are the prizes:");
		pm.printPrizeNames();
	}
	
	//tutorial message
	public static void printInstructions() {
		System.out.println("I will show you some prizes.");
		System.out.println("Your objective is to guess the total price of all the prizes.");
		System.out.println("If you guess the total price within $"+PRICEDELTA+" of the actual value without going over the total price, you win all the prizes!");
		System.out.println("Otherwise, you win nothing.");
		
	}

}
