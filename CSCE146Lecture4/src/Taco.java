/*
 * Brently George
 */
public class Taco {
	private String name;
	private String location;
	private double price;
	
	public Taco() {
		this.name = "none";
		this.location = "none";
		this.price = 0.0;
	}
	
	public Taco(String aName, String aLocation, double aPrice) {
		this.setName(aName);
		this.setLocation(aLocation);
		this.setPrice(aPrice);
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		if (location != null)
			this.location = location;
		else
			this.location = "none";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0)
			this.price = price;
		else
			this.price = 0.0;
	}
	
	public String toString() {
		return this.name+" "+this.location+" "+this.price;
	}
	
	public boolean equals(Taco aTaco) {
		return aTaco != null &&
				this.name.equals(aTaco.getName()) &&
				this.location.equals(aTaco.getLocation()) &&
				this.price == aTaco.getPrice();
	}
}
