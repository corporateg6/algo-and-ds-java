
/*
 * Brently George
 */

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class PrizeManager {
	//class vars
	private Prize[] allPrizes;
	private Prize[] prizes;
	public static final int GAMESIZE = 5;
	
	//push creation to init method
	public PrizeManager() {
		init(GAMESIZE);
	}
	
	//push creation to init method
	public PrizeManager(int gameSize) {
		init(gameSize);
	}
	
	//on creation, load the prize file into an array and create an array of random prizes, based on gamesize
	public void init(int gameSize) {
		if (gameSize<1)
			this.prizes = new Prize[gameSize];
		else
			this.prizes = new Prize[GAMESIZE];
		this.allPrizes = new Prize[countPrizeFileLines()];
		loadPrizeFile();
		this.prizes = getRandomPrizes(this.prizes.length);
	}
	
	//iterate through the prizes[] array and print out the prize name + price.
	//only used for debugging currently.
	public void printPrizeArray() {
		for (int i = 0; i<this.prizes.length; i++) {
			if (this.prizes[i] == null)
					continue;
			else
				System.out.println(this.prizes[i]);
		}
	}
	//iterate through all prizes from file and print them out.
	//only used for debugging currently.
	public void printAllPrizeArray() {
		for (int i = 0; i<this.allPrizes.length; i++) {
			if (this.allPrizes[i] == null)
				continue;
			else
				System.out.println(this.allPrizes[i]);
		}
	}
	
	//load prizes from file.
	public void loadPrizeFile() {
		try {
			Scanner fileScanner = new Scanner(new File("./prizeList.txt"));
			String fileLine;
			String[] splitLine;
			//Load each prize file line, splitting by tab delimiter.
			while(fileScanner.hasNextLine()) {
				fileLine = fileScanner.nextLine();
				splitLine = fileLine.split("\t");
				if (splitLine.length == 2) {
					//check if the split string has 2 parts, expected to be of type "String\tint"
					addPrizeToArray(new Prize(splitLine[0], Integer.valueOf(splitLine[1])),this.allPrizes);
				} else {
					//if we can't parse the above from the file, just add a default prize instead.
					addPrizeToArray(new Prize(), this.allPrizes);
				}
			}
			fileScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//check the prizeList.txt file and count the number of prizes in the file.
	//do this by scanning each line in the file 
	//and checking hasNextLine() and incrementing subtotal.
	//we need this for initializing the array to load the file into so we know how big the array should be.
	public static int countPrizeFileLines() {
		int lines = 0;
		try {
			Scanner fileScanner = new Scanner(new File("./prizeList.txt"));
			while (fileScanner.hasNextLine() && fileScanner.nextLine() != null)
				lines ++;
			fileScanner.close();
			return lines;
		} catch (Exception e) {
			e.printStackTrace();
			return lines;
		}
	}
	
	//With the input prize, add it to the input prize array
	//first check the input array for the first empty spot to hold a prize and then add it
	//to that location in the array.  If there is no spot available then do nothing.
	public static void addPrizeToArray(Prize aPrize, Prize[] aPrizeArr) {
		if (aPrizeArr[aPrizeArr.length - 1] != null)
			return;
		for (int i=0; i<aPrizeArr.length; i++) {
			if (aPrizeArr[i] == null) {
				aPrizeArr[i] = aPrize;
				break;
			}
		}
	}
	
	public Prize[] getRandomPrizes(int prizeCount) {
		int[] randomChoices = new int[prizeCount];
		Prize[] randomPrizes = new Prize[prizeCount];
		//update the array with unique random numbers
		//use this method to get some random unique integers and put them in an array.
		populateRandomChoiceArray(randomChoices);
		//use random choice array as a guide to select prizes
		for (int i=0; i<prizeCount; i++) {
			randomPrizes[i] = this.allPrizes[randomChoices[i]];
		}
		return randomPrizes;
	}
	
	//this will select different random prizes for this.prizes[].
	public void resetRandomPrizes() {
		this.prizes = getRandomPrizes(this.prizes.length);
	}
	
	//helper method to select numOf random integer from a total range of 0-rangeOf.
	//each selection must be a different integer.
	//return an Array that contains each selection sorted in ascending order
	//example selectRandomChoices (2,10) would select 2 random integers from 0 to 10 (non-inclusive)
	//where the selection could not repeat itself and select the same integer twice in that range.
	
	public int[] populateRandomChoiceArray(int[] choiceArr) {
		Random rnd = new Random();
		//select a random number from 0 to the length of all prizes)
		int myRand = rnd.nextInt(this.allPrizes.length);
		//check to see if we already selected the number and if not, add it to the array.
		//if we have, select a new number and keep going.
		for (int i = 0; i<choiceArr.length; i++) {
			while (intArrayContains(myRand,choiceArr))
				myRand = rnd.nextInt(this.allPrizes.length);
			choiceArr[i] = myRand;	
		}
		return choiceArr;
	}
	
	//method to check if an int array contains an int. returns boolean.
	public static boolean intArrayContains(int aInt, int[] aArray) {
		boolean result = false;
		for (int i=0; i< aArray.length; i++) {
			if (aArray[i] == aInt) 
				result = true;
		}
		return result;
	}
	
	
	//take a prize array as input.  check each prize add it's price to a running total.
	//return the sum of all prizes in the array, ensuring any null's are skipped.
	public int getPrizeValue() {
		int sum = 0;
		for (int i = 0; i<this.prizes.length; i++) {
			if (this.prizes[i] != null)
				sum += this.prizes[i].getPrice();
		}
		return sum;
	}
	
	//print the random prizes, without their prices.
	public void printPrizeNames() {
		for (int i=0; i<this.prizes.length; i++) {
			System.out.println("Prize " + (i+1) + ": " + this.prizes[i].getName());
		}
	}
	
}
