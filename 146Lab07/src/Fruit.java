/*
 * Brently G
 */

public class Fruit implements Comparable<Fruit> {
	
	private String type;
	private double weight;
	
	//array of acceptable types of fruit
	private static final String[] ACC_TYPES = {"apple", "orange", "banana", "kiwi", "tomato"};
	private static final String DEF_TYPE = ACC_TYPES[0];
	private static final double DEF_WEIGHT = 1.0;
	
	
	public Fruit() {
		this.type = DEF_TYPE;
		this.weight = DEF_WEIGHT;
	}
	
	public Fruit(String type, double weight) {
		this.setType(type);
		this.setWeight(weight);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		if (!isAcceptedType(type))
			this.type = DEF_TYPE;
		else
			this.type = type;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		if (weight <= 0)
			this.weight = DEF_WEIGHT;
		else
			this.weight = weight;
	}
	
	//check if the provided fruit type is valid.
	public boolean isAcceptedType(String type) {
		for (int i=0; i<ACC_TYPES.length; i++) {
			if (ACC_TYPES[i].equals(type.toLowerCase()))
				return true;
		}
		return false;
	}

	public String toString() {
		return "Type: " + type + " Weight: " + weight;
	}
	
	//compare two fruits by weight and then by type.
	//type comparison is just a string comparison
	public int compareTo(Fruit fruit) {
		if (fruit == null || this.weight < fruit.getWeight())
			return -1;
		else if (this.weight > fruit.getWeight())
			return 1;
		else
			return this.type.toLowerCase().compareTo(fruit.getType().toLowerCase());
		
	}
	
}
