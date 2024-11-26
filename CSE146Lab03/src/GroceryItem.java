/*
 * Brently George
 */

//pretty standard custom class with a name and value of type double
public class GroceryItem {
	private String name;
	private double value;
	public static final String DEFAULT_NAME = "none";
	public static final double DEFAULT_VALUE = 0.0;
	
	public GroceryItem() {
		this.name = DEFAULT_NAME;
		this.value = DEFAULT_VALUE;
	}
	
	public GroceryItem(String name, double value) {
		this.setName(name);
		this.setValue(value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null)
			this.name = name;
		else
			this.name = DEFAULT_NAME;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		if (value >= 0.0)
			this.value = value;
		else
			this.value = DEFAULT_VALUE;
		
	}

	public String toString() {
		return "Grocery Item Name: " + name + " Value: " + value;
	}
	
	//compare equality by checking if the input item is not null, has the same name and has the same value
	public boolean equals(GroceryItem gItem) {
		return gItem != null &&
				gItem.getName().equals(this.getName()) &&
				gItem.getValue() == this.getValue();
	}
	
}
