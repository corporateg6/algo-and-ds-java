/*
 * Brently George
 */

//Process scehduler
public class ProcessScheduler {

	//Processes stored in a Linked List Queue of type Process.
	private LLQueue<Process> processes;
	//holds the current process
	private Process currentProcess;
	
	public ProcessScheduler() {
		this.processes = new LLQueue<Process>();
		this.currentProcess = null;
	}
	
	public Process getCurrentProcess() {
		return this.currentProcess;
	}
	
	//if there is no current Process, set the input process as the current Process
	//if there is a current process, enqueue the input process into the process queue.
	public void addProcess(Process process) {
		if(this.currentProcess == null) {
			this.currentProcess = process;
		} else {
			this.processes.enqueue(process);
		}
	}
	
	//take the next process from the queue and make it the current process
	public void runNextProcess() {
		this.currentProcess = this.processes.dequeue();
	}
	
	//remove the current process, and then set the next process from the queue as the current process.
	//this is functionally the same as above because if there is nothing left in the queue to dequeue,
	//then dequeue will return null, thus making the current process null when the queue is empty.
	public void cancelCurrentProcess() {
		this.currentProcess = this.processes.dequeue();
	}
	
	public void printProcessQueue() {
		this.processes.print();
	}
}
