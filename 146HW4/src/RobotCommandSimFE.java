/*
 * Brently G
 */

import java.util.Scanner;

public class RobotCommandSimFE {

	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO add in UI stuff
		
		printGreeting();
		boolean quit = false;
		while (!quit) {
			printMenuChoices();
			int selection = Integer.valueOf(keyboard.nextLine());
			switch(selection) {
			case 1:
				runSim();
				break;
			case 9:
				quit = true;
				break;
			default:
				System.out.println("Selection Not Valid.");
				break;
			}
			//sort of a trick question, we aren't really prompting anew
			//we are just feeding back to the main menu here :)
			//still we are asking them if they want to run again or quit.
			//I think this fits the spec.
			System.out.println("Run another simulation?");
		}
		keyboard.close();
		System.out.println("Goodbye!");
		
	}
	
	public static void printGreeting() {
		System.out.println("Welcome to the Robot Command Simulator!");
	}
	
	public static void printMenuChoices() {
		System.out.println("Make a selection:");
		System.out.println("1: Run a Simluation.");
		System.out.println("9: Quit.");
	}
	
	//runs the simulation by
	//prompt and load board file
	//prompt and load command file
	//step through simulation
	public static void runSim() {
		
		RobotCommandSimulator sim = new RobotCommandSimulator();
		
		while(!sim.isBoardLoaded()) {
			//TODO capture file name input
			System.out.println("Enter the filename for the board data: ");
			String boardFile = String.valueOf(keyboard.nextLine());
			sim.loadBoardData(boardFile);
		}
		
		while(!sim.isRobotDataLoaded()) {
			//TODO capture file name input
			System.out.println("Enter the filename for the robot commands: ");
			String robotCommandFile = String.valueOf(keyboard.nextLine());
			sim.loadRobotData(robotCommandFile);
		}
		int step = 0;
		while(!sim.simluationComplete()) {
			if(step!=0)
				sim.simulateNextStep();
			System.out.println("Command " + step);
			System.out.println(sim.returnCurrentState());
			step++;
			System.out.println("Press Enter");
			keyboard.nextLine();
		}
		System.out.println("SIMULATION COMPLETE\n");	
	}

}
