/*
 * Brently G
 */
public class Sheep implements Comparable<Sheep> {
	private String name;
	private int shearingTime;
	private int arrivalTime;
	private int shearingTimeLeft;
	//defaults if we need them;
	private static final String DEF_NAME = "Defaulty";
	private static final int DEF_STIME = 5;
	private static final int DEF_ATIME = 5;
	
	public Sheep() {
		this.name = DEF_NAME;
		this.shearingTime = DEF_STIME;
		this.arrivalTime = DEF_ATIME;
		this.shearingTimeLeft = DEF_STIME;
	}
	
	public Sheep(String aName, int aSTime, int aATime) {
		this.setName(aName);
		this.setShearingTime(aSTime);
		this.setArrivalTime(aATime);
		this.setShearingTimeLeft(aSTime);
	}

	public int getShearingTimeLeft() {
		return this.shearingTimeLeft;
	}

	public void setShearingTimeLeft(int shearingTimeLeft) {
		this.shearingTimeLeft = shearingTimeLeft;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		if(aName == null)
			this.name = DEF_NAME;
		else
			this.name = aName;
	}

	public int getShearingTime() {
		return this.shearingTime;
	}

	public void setShearingTime(int aSTime) {
		if(aSTime < 0)
			this.shearingTime = DEF_STIME;
		else
			this.shearingTime = aSTime;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int aATime) {
		if(aATime < 0)
			this.arrivalTime = DEF_ATIME;
		else
			this.arrivalTime = aATime;
	}
	
	public void shearForOneMinute() {
		if(this.shearingTimeLeft == 0)
			return;
		this.shearingTimeLeft--;
	}
	
	public boolean isDone() {
		return this.shearingTimeLeft == 0;
	}
	
	//default comparison using the shearing time
	public int compareTo(Sheep aSheep) {
		if(aSheep == null)
			return -1;
		else if(this.shearingTime < aSheep.getShearingTime())
			return -1;
		else if(this.shearingTime > aSheep.getShearingTime())
			return 1;
		else
			return this.name.toLowerCase().compareTo(aSheep.getName().toLowerCase());
	}

	public String toString() {
		return "Name: " + this.name + ", Shear Time: " + this.shearingTime + ", Arrival Time: " + this.arrivalTime;
	}
	
	//second compare method for sorting by arrival time
	//tiebreak with the name of the sheep.
	public int compareArrivalTime(Sheep aSheep) {
		if(aSheep == null)
			return -1;
		else if(this.arrivalTime < aSheep.getArrivalTime())
			return -1;
		else if(this.arrivalTime > aSheep.getArrivalTime())
			return 1;
		else
			return this.name.toLowerCase().compareTo(aSheep.getName().toLowerCase());
	}
}
