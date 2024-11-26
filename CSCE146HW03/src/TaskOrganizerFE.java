/*
 * Brently George
 */

import java.util.Scanner;

public class TaskOrganizerFE {
	
	public static Scanner keyboard = new Scanner(System.in);
	public static TaskOrganizer taskOrganizer = new TaskOrganizer();
	
	public static void main(String[] args) {
		printGreeting();
		boolean quit = false;
		while (!quit) {
			printMenuChoices();
			int selection = Integer.valueOf(keyboard.nextLine());
			switch(selection) {
			case 1:
				addTask();
				break;
			case 2:
				removeTask();
				break;
			case 3:
				printLoadedTasks();
				break;
			case 4:
				loadTaskFile();
				break;
			case 5:
				writeTaskFile();
				break;
			case 9:
				quit = true;
				break;
			default:
				System.out.println("Selection Not Valid.");
				break;
			}
		}
		keyboard.close();
		System.out.println("Goodbye!");

	}
	
	//TODO comments
	public static void addTask() {
		System.out.println("Enter an Action:");
		String action = keyboard.nextLine();
		System.out.println("Enter a Priority from 0(high) to 4(low).");
		System.out.println("NOTE: Any priority number you enter outside of this range will default to 4.");
		int priority = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println(taskOrganizer.addTask(action, priority));
	}
	
	public static void removeTask() {
		System.out.println("Enter an Action:");
		String action = keyboard.nextLine();
		System.out.println("Enter a Priority from 0(high) to 4(low).");
		System.out.println("NOTE: Any priority number you enter outside of this range will default to 4.");
		int priority = Integer.valueOf(keyboard.nextLine());
		System.out.println(taskOrganizer.removeTask(action, priority));
	}
	
	public static void printLoadedTasks() {
		taskOrganizer.printTasks();
	}
	
	public static void loadTaskFile() {
		System.out.println("Enter the filename of the Tasks file:");
		taskOrganizer.loadTaskFile(keyboard.nextLine());
	}
	
	public static void writeTaskFile() {
		System.out.println("Enter a filename to save your Tasks to:");
		String fileName = keyboard.nextLine();
		taskOrganizer.writeTaskFile(fileName);
	}
	
	public static void printGreeting() {
		System.out.println("Welcome to the Task Organizer!");
	}
	
	public static void printMenuChoices() {
		System.out.println("1: Add a Task.");
		System.out.println("2: Remove a Task.");
		System.out.println("3: Print Tasks to the Console.");
		System.out.println("4: Load a Tasks file.");
		System.out.println("5: Save Tasks to a file.");
		System.out.println("9: Quit.");
	}

}
