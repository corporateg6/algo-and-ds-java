/*
 * Brently G
 */

import java.io.File;
import java.util.Scanner;

public class SheepShearingScheduler {

	private MinHeap<Sheep> sheepWaitHeap;
	private GenLL<Sheep> sheepDataLL;
	private Sheep[] sheepDataArray; //Maybe change to LL then convert to Array before sorting?
	private QueueI<Sheep> sheepShearingScheduleLL;
	private QueueI<Sheep> sheepArrivalQueue;
	//file constants
	public static final String DELIM = "\t";
	public static final int FILE_WIDTH = 3;
	//simulator variables
	private Sheep currentSheep;
	private int currentMinute;
	private boolean loaded;
	
	//initialize variables with objects/data
	public SheepShearingScheduler() {
		this.sheepWaitHeap = new MinHeap<Sheep>();
		this.sheepShearingScheduleLL = new LLQueue<Sheep>();
		this.sheepArrivalQueue = new LLQueue<Sheep>();
		this.currentSheep = null;
		this.currentMinute = 0;
		this.loaded = false;
	}
	
	//not used, but will leave here
	public Sheep getCurrentSheep() {
		return this.currentSheep;
	}
	
	//not used, I'm curring adding to the minheap directly, so I don't really need this.
	//leaving here anyways
	public void addSheep(Sheep aSheep) {
		if(this.currentSheep == null)
			this.currentSheep = aSheep;
		else
			this.sheepWaitHeap.add(aSheep);
	}
	
	/* this is my initial method to combine load operations, but used a different strategy.
	 ///again I will leave this here just in case I want to modify anything
	public void loadSheepData(String fileName) {
		this.loadSheepFromFile(fileName);
		this.sheepDataArray = convertSheepLLtoArray(sheepDataLL);
		this.sortSheepListByArrivalTime();
		this.populateSheepArrivalQueue();
	}*/
	
	//load sheep from the provided file name into sheep data array
	public void loadSheepFromFile(String fileName) {
		//in case we fail to load data, reset before loading another.
		//load file of sheep into sheepList data structure
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			String fileLine;
			String[] splitLine;
			//this is so if we load a new file
			//we discard existing data we may have loaded before
			this.sheepDataLL = new GenLL<Sheep>();
			while(fileScanner.hasNextLine()) {
				fileLine = fileScanner.nextLine();
				splitLine = fileLine.split(DELIM);
				if (splitLine.length != FILE_WIDTH)
					continue;
				String name = splitLine[0];
				int shearingTime = Integer.valueOf(splitLine[1]);
				int arrivalTime = Integer.valueOf(splitLine[2]);
				Sheep newSheep = new Sheep(name, shearingTime, arrivalTime);
				sheepDataLL.add(newSheep);
			}
			//flag our file as be loaded
			this.loaded = true;
			fileScanner.close();
		} catch (Exception e) {
			this.loaded = false; //set loaded to false if for some reason it got flipped, but it shouldn't have.
			System.out.println("Unable to load the file, please try again.");
			System.out.println("ERROR: "+e.getMessage());
		}
	}
	
	//check if a sheep file is loaded
	public boolean isLoaded() {
		return this.loaded;
	}
	
	//converts our sheep data LL into an array for easy sorting.
	//very inefficient, but efficiency is not a requirement of the spec
	public Sheep[] convertSheepLLtoArray(GenLL<Sheep> sheepLL) {
		int size = sheepLL.getSize();
		Sheep[] ret = new Sheep[size]; 
		for(int i=0; i<size; i++) {
			ret[i] = sheepLL.getAt(i);
		}
		return ret;
	}
	
	
	//load sheep into a queue by their arrival time
	//this is so I can just dequeue at the arrival time instead of tracking an array index
	//and comparing to the minute.
	public void populateSheepArrivalQueue() {
		for(int i=0; i<sheepDataArray.length; i++) {
			this.sheepArrivalQueue.enqueue(this.sheepDataArray[i]);
		}
	}
	
	//for debugging
	public void printArrivalQueue() {
		this.sheepArrivalQueue.print();
	}
	
	//calling quicksort on the arrival array to sort the sheep by arrival time.
	public void sortSheepArrayByArrivalTime() {
		//call quicksort method with array and indices
		quickSort(this.sheepDataArray, 0, this.sheepDataArray.length-1);
	}
	
	//quicksort, updated for sheep, comparing arrival
	//created a special method in the Sheep object to compare by arrival time.
	public static void quickSort(Sheep[] a, int start, int end) {
		if(start >= end)
			return;
		//find the new pivot index
		int pivot = partition(a,start,end);
		//sort before and after pivot recursively
		quickSort(a,start,pivot-1);
		quickSort(a,pivot+1,end);
	}
	
	//quicksort find the pivot index
	private static int partition(Sheep[] a, int start, int end) {
		Sheep pivot = a[end];
		int i = start;
		for(int j=start; j<=end; j++) {
			if (a[j].compareArrivalTime(pivot) < 0) { //using compareArrivalTime for my sheep
				Sheep temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		Sheep temp = a[i];
		a[i] = a[end];
		a[end] = temp;
		return i;
	}
	
	//I didn't want to count the amount of sheep in the file and then initialize the array
	//so I just used a linked list to load the sheep from the file, and then my method
	//to convert that to an Array
	public void populateSheepArray() {
		this.sheepDataArray = convertSheepLLtoArray(sheepDataLL);
	}
	
	//print data from the loaded sheep data array
	//mostly for testing
	public void printSheepData() {
		for(int i=0;i<sheepDataArray.length; i++) {
			System.out.println(sheepDataArray[i]);
		}
	}
	
	//each minute and at minute zero we want to see if any sheep have arrived and if so
	//place them either in the current sheep spot (if empty)
	//or load them onto the wait heap.
	//looking at the data we could have multiple sheep arrive at the same time
	//so we need to peek at the arrival queue and for each sheep that arrived at this minute
	//we can load them into the current sheep or the heap.
	public void checkSheepArrivals() {
		while(this.sheepArrivalQueue.peek() != null &&
				this.sheepArrivalQueue.peek().getArrivalTime() == this.currentMinute) {
			Sheep newSheep = this.sheepArrivalQueue.dequeue();
			if(this.currentSheep == null) {
				this.currentSheep = newSheep;
			} else {
				this.sheepWaitHeap.add(newSheep);
			}
		}
	}
	
	//advance time by one minute, then shear the current sheep
	//then if the sheep is done, put it in the schedule queue (to track the schedule generated)
	//and then load the next sheep into the active spot.
	public void advanceOneMinute() {
		this.currentMinute++;
		this.currentSheep.shearForOneMinute();
		if(this.currentSheep.isDone() || this.currentSheep == null) {
			if(!(this.currentSheep == null)) {
				this.sheepShearingScheduleLL.enqueue(currentSheep);
			}
			this.currentSheep = sheepWaitHeap.remove();
		}
	}
	
	//to see if we are done shearing, which should only happen if no sheep are waiting.
	//with our data this is ok, but technically this could be an issue if we are done shearing,
	//but we know more sheep might be arriving later
	//not a problem now, but maybe could cause an issue with different datasets
	public boolean shearingsComplete() {
		return this.currentSheep == null;
	}
	
	//to print the schedule
	public void printSheepShearingSchedule() {
		this.sheepShearingScheduleLL.print();
	}
}
