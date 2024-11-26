/*
 * Brently George
 */

import java.util.Scanner;
import java.io.*;

public class Board {

	private Character[][] gameBoard;
	private boolean boardLoaded;
	//board dimensions
	public static final int DEF_BOARD_WIDTH = 10;
	public static final int DEF_BOARD_HEIGHT = 10;
	//Characters to represent game board
	public static final Character OBSTACLE = 'X';
	public static final Character ROBOT = '0';
	public static final Character CRASH = '!';
	public static final String NEWLINE = "\n";
	
	
	public Board() {
		init(DEF_BOARD_WIDTH, DEF_BOARD_HEIGHT);
	}
	
	//in case I want to extend with additional game board sizes
	//probably didn't need all of this
	public Board(int width, int height) {
		if (width > 0 && height > 0)
			init(width, height);
		else if (width > 0)
			init(width, DEF_BOARD_HEIGHT);
		else if (height > 0)
			init(DEF_BOARD_WIDTH, height);
		else
			init(DEF_BOARD_WIDTH, DEF_BOARD_HEIGHT);
	}
	
	public void init(int width, int height) {
		this.gameBoard = new Character[width][height];
		this.setBoardLoaded(false);
	}

	//need to check if the board actually got loaded
	//as to prompt again for loading in case it didn't
	public boolean isBoardLoaded() {
		return this.boardLoaded;
	}
	
	//set the board's loaded state
	public void setBoardLoaded(boolean loaded) {
		this.boardLoaded = loaded;
	}
	
	//Only using default values for now but might want to make this customizable.
	public int getBoardWidth() {
		return DEF_BOARD_WIDTH;
	}
	
	//Only using default values for now but might want to make this customizable.
	public int getBoardHeight() {
		return DEF_BOARD_HEIGHT;
	}
	
	//checks the loaded board to see if there is the
	//character that is an obstacle located at that position.
	//protected this method from running in case somehow this runs
	//without the board being loaded then .equals on null will cause an exception.
	public boolean hasObstacleAt(int x, int y) {
		if(this.isBoardLoaded())
			return gameBoard[x][y].equals(OBSTACLE);
		else
			return false;
	}
	
	//reads game file into gameBoard[][] array
	//the specs didn't ask for it, but I'm not doing any validation
	//to check if the game board file is accurate and won't cause
	//any exception when attempting to load an incorrectly formatted
	//board file..  Could be something to update if needed in the future.
	public void readGameBoardFile(String fileName) {
		init(DEF_BOARD_WIDTH, DEF_BOARD_HEIGHT); //Would need to update this when loading files to accomodate custom board sizes.
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			String fileLine;
			int lineNumber = 0;
			//grab each line from the file
			while(fileScanner.hasNextLine()) {
				fileLine = fileScanner.nextLine();
				//for each line, for up to that line's length, put each character in the array.
				//here could be an issue if we feed in a board file where the
				//lines are longer than the array length of 10;
				for(int i=0; i<fileLine.length(); i++) {
					gameBoard[i][lineNumber] = fileLine.charAt(i);
				}
				lineNumber++;
			}
			//set our board as loaded
			setBoardLoaded(true);
			fileScanner.close();
		} catch (Exception e) {
			System.out.println("Unable to load the game board, please try again.");
			System.out.println("ERROR: "+e.getMessage());
		}
	}
	
	/*
	//NOT NEEDEDreturn string of full game board - currently not coded.
	// this isn't used or needed currently but leaving this here in
	//case I want to implement later
	public String outputGameBoard() {
		return "Printing game board...";
	}*/
	
	//input robot xy position, return string of full game board w\ robot
	public String ouputGameBoardWithRobot(int robotX, int robotY) {
		//placeholder for the board we will return
		String ret = "";
		for (int i=0; i<10; i++) {
			//placeholder for the row we will append the ret placeholder
			String row = "";
			for (int j=0; j<10; j++) {
				//if we reached the robot position add it to the ret
				if(j==robotX && i==robotY)
					row += ROBOT;
				else //otherwise add the board character
					row += gameBoard[j][i];
			}
			row += NEWLINE; //at the end of the row add a newline
			ret += row; //append our ret string object with each row
		}
		return ret;
	}
	
	//same as outputGameBoardWIthRobot BUT instead of ROBOT use the CRASH char 
	public String outputGameBoardWithCrash(int crashX, int crashY) {
		String ret = "ROBOT CRASH AT (" + crashX + ", " + crashY + ")!\n";
		for (int i=0; i<10; i++) {
			String row = "";
			for (int j=0; j<10; j++) {
				if(j==crashX && i==crashY)
					row += CRASH;
				else
					row += gameBoard[j][i];
			}
			row += NEWLINE;
			ret += row;
		}
		return ret;
	}
	
	/*
	//No longer needed keeping placehoder in case I want later.
	public boolean hasCrashed(int robotX, int robotY) {
		//TODO write this
		return false;
	}*/
	
}
