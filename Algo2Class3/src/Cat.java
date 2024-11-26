/*
 * Brently George
 */
public class Cat {  //Step 1. Define the class
	
	//Step 2. Data/Instance variables and Class constants
	private String name;
	private double weight;
	private int numberOfLegs;
	
	//Step 3. Constructors
	public Cat() {//No parameters, default constructor
		this.name = "none";
		this.weight = 1.0;
		this.numberOfLegs = 4;
	}
	
	public Cat(String name, double weight, int legs) {// with params
		//TODO call mutators
		this.setName(name);
		this.setWeight(weight);
		this.setNumberOfLegs(legs);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null)
			this.name = name;
		else
			this.name = "none";
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (weight > 0.0)
			this.weight = weight;
		else
			this.weight = 1.0;
	}

	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		if (numberOfLegs >= 0 && numberOfLegs <=4)
			this.numberOfLegs = numberOfLegs;
		else
			this.numberOfLegs = 4;
	}
	
	//Step 6. Other methods
	
	public String toString() {
		return this.name + " " + this.weight + " " + this.numberOfLegs;
	}
	
	public boolean equals (Cat otherCat) {
		//TODO update from lecture notes, check this
		return otherCat != null &&
				this.name.equals(otherCat.getName()) &&
				this.weight == otherCat.getWeight() &&
				this.numberOfLegs == otherCat.getNumberOfLegs();
	}
}

	
