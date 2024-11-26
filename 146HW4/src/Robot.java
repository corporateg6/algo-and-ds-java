/*
 * Brently George
 */
import java.io.*;
import java.util.Scanner;

public class Robot {
	
	private int xPosition;
	private int yPosition;
	private boolean hasCrashed;
	private boolean commandFileLoaded;
	private QueueI<String> commandQueue;
	public static final int DEF_STARTING_X_POS = 0;
	public static final int DEF_STARTING_Y_POS = 0;
	public String[] validCommands = {"Move Up", "Move Down", "Move Left", "Move Right"};
	
	public Robot() {
		init(DEF_STARTING_X_POS, DEF_STARTING_Y_POS);
	}
	
	public Robot(int startingX, int startingY) {
		init(startingX, startingY);
	}
	
	public void init(int xPos, int yPos) {
		this.setxPosition(xPos);
		this.setyPosition(yPos);
		this.hasCrashed = false;
		this.commandFileLoaded = false;
		this.commandQueue = new LLQueue<String>();
	}

	public int getxPosition() {
		return this.xPosition;
	}

	public void setxPosition(int xPosition) {
		if (xPosition<0) {
			this.hasCrashed = true;
			this.xPosition = 0;
		} else {
			this.xPosition = xPosition;
		}
	}

	public int getyPosition() {
		return this.yPosition;
	}

	public void setyPosition(int yPosition) {
		if (yPosition<0) {
			this.hasCrashed = true;
			this.yPosition = 0;
		} else {
			this.yPosition = yPosition;
		}
	}
	
	//TODO comments
	public boolean hasCrashed() {
		return this.hasCrashed;
	}
	
	//TODO comments
	public void toggleCrashState() {
		this.hasCrashed = !this.hasCrashed;
	}
	
	//TODO comments
	private void processCommand(String command) {
		if(command == null)
			return;
		switch (command.toLowerCase()) {
		case "move up":
			this.setyPosition(this.getyPosition()-1);
			break;
		case "move down":
			this.setyPosition(this.getyPosition()+1);
			break;
		case "move left":
			this.setxPosition(this.getxPosition()-1);
			break;
		case "move right":
			this.setxPosition(this.getxPosition()+1);
			break;
		}
	}
	
	//TODO comments
	public void processNextCommand() {
		processCommand(this.commandQueue.dequeue());
	}
	
	//TODO comments
	public boolean hasMoreCommands() {
		if(this.commandQueue.peek() == null)
			return false;
		else
			return true;
	}
	
	//TODO update and build
	public void loadCommandFile(String fileName) {
		init(DEF_STARTING_X_POS, DEF_STARTING_Y_POS);
		//load in commands from file
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			String fileLine;
			while(fileScanner.hasNextLine()) {
				fileLine = fileScanner.nextLine();
				//TODO add comments
				if (fileLine.equals("Move Up") ||
						fileLine.equals("Move Down") ||
						fileLine.equals("Move Left") ||
						fileLine.equals("Move Right")) {
					this.commandQueue.enqueue(fileLine);
				}
			}
			this.commandFileLoaded = true;
			fileScanner.close();
		} catch (Exception e) {
			System.out.println("Unable to load the command file, please try again.");
			System.out.println("ERROR: "+e.getMessage());
		}
	}

	public boolean isCommandFileLoaded() {
		return this.commandFileLoaded;
	}
}
