/*
 * Brently George
 */

//Process class with a process name and process completion time.
public class Process {
	private String name;
	private double completionTime;
	private static final String DEF_NAME = "none";
	private static final double DEF_TIME = 0.0;
	
	public Process() {
		this.name = DEF_NAME;
		this.completionTime = DEF_TIME;
	}
	
	public Process(String name, double completionTime) {
		this.setName(name);
		this.setCompletionTime(completionTime);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null)
			this.name = DEF_NAME;
		else
			this.name = name;
	}

	public double getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(double completionTime) {
		if(completionTime < 0.0)
			this.completionTime = DEF_TIME;
		else
			this.completionTime = completionTime;
	}

	public String toString() {
		return "Process Name: " + this.name + " Completion Time: " + this.completionTime;
	}
	
	
	
}
