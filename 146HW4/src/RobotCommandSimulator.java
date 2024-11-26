/*
 * Brently George
 */

public class RobotCommandSimulator {
	
	//Using this "middle" code to make the code in the front in
	//cleaner and clearer and hide some of the logic.
	
	private Robot robot;
	private Board board;
	
	public RobotCommandSimulator() {
		init();
	}
	
	public void init() {
		this.robot = new Robot();
		this.board = new Board();
	}
	
	public void loadBoardData(String fileName) {
		this.board.readGameBoardFile(fileName);
	}
	
	public void loadRobotData(String fileName) {
		this.robot.loadCommandFile(fileName);
	}
	
	public boolean robotHasCommands() {
		return this.robot.hasMoreCommands();
	}
	
	public boolean isBoardLoaded() {
		return this.board.isBoardLoaded();
	}
	
	public boolean isRobotDataLoaded() {
		return this.robot.isCommandFileLoaded();
	}
	
	//check if the robot has crashed by checking if any of these is true
	//there is an obstacle on the board at the robot's current position
	//something has triggered the robots hasCrashed state to be true
	//if the robot has wandered off the X side past the size of the board
	//if the robot has wandered off the Y side past the size of the board
	public boolean hasCrashed() {
		return this.board.hasObstacleAt(this.robot.getxPosition(), this.robot.getyPosition()) ||
				this.robot.hasCrashed() ||
				this.robot.getxPosition() > this.board.getBoardWidth() ||
				this.robot.getyPosition() > this.board.getBoardHeight();
	}
	
	/*
	//NOT NEEDED for now
	public String returnBoard() {
		return this.board.outputGameBoard();
	}*/
	
	public String returnCurrentState() {
		if(hasCrashed()) //if the robot has crashed, render the crash board
			return this.board.outputGameBoardWithCrash(this.robot.getxPosition(), this.robot.getyPosition());
		else //otherwise render the non-crashed board
			return this.board.ouputGameBoardWithRobot(this.robot.getxPosition(), this.robot.getyPosition());
	}
	
	//check if the simulation is done meaning either the robot has crashed
	//or there are no more commands
	public boolean simluationComplete() {
		return (this.hasCrashed() || !this.robotHasCommands());
	}
	
	public void simulateNextStep() {
		robot.processNextCommand();
	}
	
}
