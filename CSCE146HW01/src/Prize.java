
/*
 * Brently George
 */

public class Prize {
	
	//class variables
	private String name;
	private int price;
	
	//constructors
	public Prize() {
		this.name = "Generic prize";
		this.price = 1;
	}
	
	public Prize(String aName, int aPrice) {
		this.setName(aName);
		this.setPrice(aPrice);
	}

	public String getName() {
		return name;
	}

	//check if the name is not null, if it is then set the name to noName.
	public void setName(String name) {
		if (name != null)
			this.name = name;
		else
			this.name = "Generic prize";
	}

	public int getPrice() {
		return price;
	}
	
	//Check if the input price >= 0, if not, set it to 0.0.
	public void setPrice(int price) {
		if (price >= 0)
			this.price = price;
		else
			this.price = 0;
	}

	public String toString() {
		return "Prize [name=" + name + ", price=" + price + "]";
	}
	
}
