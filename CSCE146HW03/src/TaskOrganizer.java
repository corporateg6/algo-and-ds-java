/*
 * Brently George
 */

import java.util.Scanner;
import java.io.*;

public class TaskOrganizer {
	
	private GenLL<Task>[] organizedTasks;
	public static final String DELIM = "\t";
	public static final int FILE_WIDTH = 2;
	
	public TaskOrganizer() {
		//initialize
		init();
	}
	
	private void init() {
		this.organizedTasks = new GenLL[5]; //Warning message expected due to java language and generic usage
		//populate array with new LLs in each index
		for (int i=0; i<this.organizedTasks.length; i++) {
			this.organizedTasks[i] = new GenLL<Task>();
		}
	}
	
	public String addTask(String action, int priority) {
		//create the new task
		Task newTask = new Task(action, priority);
		//check for duplicates, and if so, print message and return
		if (taskExists(newTask)) {
			return newTask.toString() + " Already Exists";
		}
		//add the task to the correct list in the array
		//correct list is the list in the array at index == priority
		this.organizedTasks[newTask.getPriority()].add(newTask);
		return newTask.toString() + " Added";
	}
	
	//method to check if the appropriate linked list in the organizedTasks array already contains a specific task
	//return true if we find it, else returns false
	private boolean taskExists(Task task) {
		//store the task priority
		int p = task.getPriority();
		//reset the list
		organizedTasks[p].reset();
		//check each node in the list, return true if you find a matching task
		//note our GenLL doesn't have an equals method, so we need to check for equality ourselves.
		while(organizedTasks[p].hasMore()) {
			if (organizedTasks[p].getCurrent().equalTo(task)) {
				return true;
			}

			organizedTasks[p].gotoNext();
		}
		return false;
	}
	
	//method to look for a task in the appropriate linked list and if you find it remove it.
	//since we prevent duplicates from being added we can return once we remove the task.
	//also returns a string if the caller wants to print the result of the operation somewhere.
	
	public String removeTask(String action, int priority) {
		//create task and store priority
		Task taskToRemove = new Task(action, priority);
		int p = taskToRemove.getPriority();
		//reset the associated LL
		organizedTasks[p].reset();
		//check each item in the LL to see if we find the task
		//if we do, remove it and return success message
		while(organizedTasks[p].hasMore()) {
			if (organizedTasks[p].getCurrent().equalTo(taskToRemove)) {
				organizedTasks[p].removeCurrent();
				return taskToRemove.toString() + " removed successfully.";
			}
			organizedTasks[p].gotoNext();
		}
		//if we don't find it, just return the message stating so
		return taskToRemove.toString() + " not found.";
	}
	
	//prints all tasks in priority order
	//since priority order is determined by the array index,
	//all we need to do it print indexes in order from 0 - 4
	public void printTasks() {
		for (int i=0; i<this.organizedTasks.length; i++) {
			this.organizedTasks[i].print();
		}
	}
	
	//load from file
	//nothing special happening here, same as usual
	public void loadTaskFile(String fileName) {
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			String fileLine;
			String[] splitLine;
			//this is so if we load a new file
			//we discard existing data we may have loaded before
			init();
			while(fileScanner.hasNextLine()) {
				fileLine = fileScanner.nextLine();
				splitLine = fileLine.split(DELIM);
				if (splitLine.length != FILE_WIDTH)
					continue;
				Integer priority = Integer.parseInt(splitLine[0]);
				String action = splitLine[1];
				Task newTask = new Task(action, priority);
				this.organizedTasks[newTask.getPriority()].add(newTask);
			}
			fileScanner.close();
		} catch (Exception e) {
			System.out.println("Unable to load the file, please try again.");
			System.out.println("ERROR: "+e.getMessage());
		}
	}
	
	//takes a filename for input and then writes the contents of
	//organizedTasks data structure to the file.
	//Always overwrites
	public void writeTaskFile(String fileName) {
		try {
			System.out.println("Writing to "+fileName);
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
			//loop through the array to get each linked list
			for (int i=0; i<this.organizedTasks.length; i++) {
				//reset current LL to beginning
				organizedTasks[i].reset();
				//for each item in the linked list go through and format a line we want to write, then write it 
				while(organizedTasks[i].hasMore()) {
					String lineOut = fileOutputFormatting(organizedTasks[i].getCurrent());
					fileWriter.println(lineOut);
					organizedTasks[i].gotoNext();
				}
			}
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//this method will take a task and return a formatted string
	//this string is our desired file format for saving to a file
	//<<Priority>>\t<<Action>>
	private String fileOutputFormatting(Task task) {
		return task.getPriority() + DELIM + task.getAction();
	}
}
