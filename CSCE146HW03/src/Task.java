/*
 * Brently George
 */
public class Task {

	private String action;
	private int priority;
	private static final String DEFAULT_ACTION = "none";
	private static final int DEFAULT_PRIORITY = 4;
	
	public Task() {
		this.action = DEFAULT_ACTION;
		this.priority = DEFAULT_PRIORITY;
	}
	
	public Task(String action, int priority) {
		this.setAction(action);
		this.setPriority(priority);
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		if (action != null)
			this.action = action;
		else
			this.action = DEFAULT_ACTION;
	}

	public int getPriority() {
		return priority;
	}

	//if given priority is outside of the range, set it to the default
	public void setPriority(int priority) {
		if (priority >= 0 && priority <= 4)
			this.priority = priority;
		else
			this.priority = DEFAULT_PRIORITY;
	}

	//format string
	public String toString() {
		return "Task [priority=" + this.priority + ", action=" + this.action + "]";
	}
	
	//check if input task equals existing task
	public boolean equalTo(Task task) {
		return (this.action.equals(task.getAction()) &&
				this.priority == task.getPriority());
	}
	
}
