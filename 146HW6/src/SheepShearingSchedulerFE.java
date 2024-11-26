/*
 * Brently G
 */

import java.util.Scanner;

public class SheepShearingSchedulerFE {

	public static SheepShearingScheduler ss;
	public static boolean quit = false;
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		//run simulation with collected filename
		while(!quit) {
			//initialize a new scheduler
			ss = new SheepShearingScheduler();
			System.out.println("Welcome to the Sheep Schedule Simulator!");
			
			//collect filename and load file
			while(!ss.isLoaded()) {
				System.out.println("Enter a Sheep file filename to run the simlution against:");
				String filename = keyboard.nextLine();
				ss.loadSheepFromFile(filename);
			}
			
			runSimulation();
			
			//prompt for running the program again
			System.out.println("\nRun the simulation again? Enter yes if so.");
			String selection = keyboard.nextLine();
			if(!selection.equalsIgnoreCase("yes"))
				quit = true;
		}
		keyboard.close();
		System.out.println("Goodbye!");
			
	}
	
	public static void runSimulation() {

		//move data from file loaded into the LL into an array
		ss.populateSheepArray();
		//sort the array by the arrival time of the sheep
		ss.sortSheepArrayByArrivalTime();
		//put the sorted array into a queue to make the coding for dequeue simpler.
		ss.populateSheepArrivalQueue();
		//check if any sheep have arrived at minute 0 and load them into the active slot
		ss.checkSheepArrivals();

		//keep shearing until we are done with all shearing
		while(!ss.shearingsComplete()) {
			//we just advance the time and check for new arrivals at each minute, until we are done shearing everyone
			ss.advanceOneMinute();
			ss.checkSheepArrivals();
		}
		
		//print the schedule
		System.out.println("SCHEDULE GENERATED\n");
		ss.printSheepShearingSchedule();
	}

}
