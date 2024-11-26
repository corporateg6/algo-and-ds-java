/*
 * Brently George
 * CSCE146 Homework 00
 */

import java.util.Scanner;

public class vectors {

	public static void main(String[] args) {
		//display menu and process selection
		int selection = -1;
		//main program loop
		while (selection != 0) {
			//display menu and return selection number
			selection = mainMenu();
			//check for out of bounds menu selection
			if (selection > 3 || selection < -1) {
				System.out.println("Invalid Selection");
				continue;
			} else if (selection == 1) {
				// vector addition
				vectorAddition();
				enterBreak();
			} else if (selection == 2) {
				// vector subtraction
				vectorSubtraction();
				enterBreak();
			} else if (selection == 3) {
				// vector magnitude
				vectorMagnitude();
				enterBreak();
			} else if (selection == 0) {
				// exit the program
				System.out.println("Exiting program...");
				break;
			}
		}
		
	}
	
	//prompt for vector size with input message
	public static int getVectorSize(String message) {
		Scanner keyboard = new Scanner(System.in);
		int vectorSize = 0;
		while (vectorSize < 1) {
			System.out.println(message);
			vectorSize = Integer.valueOf(keyboard.nextLine());
			if (vectorSize < 1) {
				System.out.println("ERROR: Vector size must be 1 or greater.");
			}
		}		
		return vectorSize;
	}
	
	//This method takes an input message and a vector
	//We create a new double array and prompt the user to input the values with the custom input message
	//then we have the user input values in each index of the array.
	//finally we return the array back to the caller.
	public static double[] getVectorValues(int vectorSize, String message) {
		Scanner keyboard = new Scanner(System.in);
		double[] vector = new double[vectorSize];
		System.out.println(message);
		for (int i = 0; i < vectorSize; i++) {
			vector[i] = Double.valueOf(keyboard.nextLine());
		}
		return vector;
	}
	
	//This method simply takes a double array as input, and prints all the values
	//at each index in the array out to the console.
	public static void printArray(double[] inputArray) {
		//loop through array length and output values
		//i is for index
		int i = 0;
		while (i < inputArray.length) {
		    System.out.println(inputArray[i]);
		    i++;
		}
	}
	
	//method to add two vectors
	//this method is the full process for:
	//prompting a user for 2 vectors to add.
	//adding the two vectors together
	//printing the resulting sum of the vectors to the console.
	public static void vectorAddition() {
		//why are we prompting for both vector sizes if they need to be the same?
		//because the assignment says so I guess... :)
		//prompt for vector sizes and values
		boolean vectorSizesEqual = false;
		while (!vectorSizesEqual) {
			System.out.println("===============");
			System.out.println("VECTOR ADDITION");
			System.out.println("===============");
			int vectorASize = getVectorSize("Enter a size for Vector A:");
			double[] vectorA = getVectorValues(vectorASize, "Enter Vector A values of type Double:");
			int vectorBSize = getVectorSize("Enter a size for Vector B:");
			double[] vectorB = getVectorValues(vectorBSize, "Enter Vector B values of type Double:");
			//ensure vectors are the same size and if not, throw an error and try again.
			if (vectorASize == vectorBSize) {
				vectorSizesEqual = true;
				//send the vectors off for math and output
				vectorMathAdd(vectorA, vectorB);
			} else {
				System.out.println("ERROR: Vectors must be the same size to proceed. Try again.");
				enterBreak();
			}
		}
	}
	
	//method to do the vector addition math and output result
	//this is the addition process of adding to double vectors.
	//take two double vectors as input, sum them together, print the result to the console.
	//the logic here could be improved, and likely we should just sum the vectors,
	//and then return a new resulting summed vector to the caller,
	//which would make the code more extensible.
	public static void vectorMathAdd(double[] vectorA, double[] vectorB) {
		//assume both input arrays are the same size
		//initialize a new array to hold the resulting sum
		double[] vectorSum = new double[vectorA.length];
		//iterate through arrays summing each value at the index and storing
		// the result in the vectorSum array
		//i is for index
		int i = 0;
		while (i < vectorA.length) {
			System.out.println("while");
			vectorSum[i] = vectorA[i] + vectorB[i];
			i++;
		}
		//output Result and break for review
		System.out.println("Resulting Sum of Vectors:");
		printArray(vectorSum);
	}
	
	//similar to vectorMathAdd() except for subtraction.
	//same comments as before regarding potential refactor or redesign of this code.
	public static void vectorMathSub(double[] vectorA, double[] vectorB) {
		//assume both input arrays are the same size
		//initialize a new array to hold the resulting difference of Vector A minus Vector B
		double[] vectorDiff = new double[vectorA.length];
		//iterate through arrays differencing each value at the index and storing
		// the result in the vectorDiff array
		//i is for index
		int i = 0;
		while (i < vectorA.length) {
			System.out.println("while");
			vectorDiff[i] = vectorA[i] - vectorB[i];
			i++;
		}
		//output Result and break for review
		System.out.println("Resulting Difference of Vectors:");
		printArray(vectorDiff);
	}
	
	//method to subtract two vectors
	// full process for vector Subtraction
	// see vectorAddition() comments for similar process and comments.
	public static void vectorSubtraction() {
		//why are we prompting for both vector sizes if they need to be the same?
		//because the assignment says so I guess... :)
		//prompt for vector sizes and values
		boolean vectorSizesEqual = false;
		while (!vectorSizesEqual) {
			System.out.println("==================");
			System.out.println("VECTOR SUBTRACTION");
			System.out.println("==================");
			int vectorASize = getVectorSize("Enter a size for Vector A:");
			double[] vectorA = getVectorValues(vectorASize, "Enter Vector A values of type Double:");
			int vectorBSize = getVectorSize("Enter a size for Vector B:");
			double[] vectorB = getVectorValues(vectorBSize, "Enter Vector B values of type Double:");
			//ensure vectors are the same size and if not, throw an error and try again.
			if (vectorASize == vectorBSize) {
				vectorSizesEqual = true;
				//send the vectors off for math and output
				vectorMathSub(vectorA, vectorB);
			} else {
				System.out.println("ERROR: Vectors must be the same size to proceed. Try again.");
				enterBreak();
			}
		}
	}
	
	//method for magnitude of 1 vector
	//full process for getting vector magnitude.
	//prompts user to input a vector, calculates the magnitude, and outputs the magnitude
	// to the console.
	public static void vectorMagnitude() {
		System.out.println("================");
		System.out.println("VECTOR MAGNITUDE");
		System.out.println("================");
		//get vector size
		int vectorSize = getVectorSize("Enter a size for the Vector:");
		double[] vector = getVectorValues(vectorSize, "Enter Vector values of type Double:");
		vectorMathMag(vector);
	}
	
	//arithmetic method to calculate the magnitude of the input double vector.
	//similar comments to my other arithmetic vectors, we should separate the
	//console printing part of this method from the math portion of it.
	// we would ideally have a method that returns the result as a double, and another method
	// or process to display it separately.  If I need this code in the future, this
	// is something i would update to make this more extensible.
	public static void vectorMathMag(double[] vector) {
		//initialize contain to hold sum of squares
		double sumOfSquares = 0;
		//sum the squares in a loop, i for index
		int i = 0;
		while (i < vector.length) {
			sumOfSquares += vector[i] * vector[i];
			i++;
		}
		double magnitude = Math.sqrt(sumOfSquares);
		System.out.println("Resulting Magnitude of Vector:");
		System.out.println(magnitude);
	}
	
	//method to display the main menu and return selection number
	//displays main mention and prompts for selection.
	//this could be improved by catching for type mismatch to gather the menu selection
	//for example if a user just hits enter, or inputs a character instead of an int,
	//then the program throws and exception and terminates.
	//This isn't ideal, I would likely just capture a string and then use that to determine
	//what to do instead, which in my mind should account for any potential exceptions that could
	//occur.  Then with the string we could just determine what to do next, or if to prompt
	//the user to select again.1
	
	public static int mainMenu() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("=========");
		System.out.println("MAIN MENU");
		System.out.println("=========");
		System.out.println("Enter a selection 1 to 3, 0 to exit.");
		System.out.println("1) Add 2 Vectors");
		System.out.println("2) Subtract 2 Vectors");
		System.out.println("3) Magnitude of a Vector");
		System.out.println("0) Exit Program");
		int selection = Integer.valueOf(keyboard.nextLine());
		return selection;
	}
	
	//method to insert a break in the output for better UX
	//when reviewing results or errors
	//prompts the user to press enter to continue
	
	public static void enterBreak() {
		System.out.println("Press Enter to continue...");
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();
	}
	
}
