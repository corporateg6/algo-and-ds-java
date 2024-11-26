/*
 * Brently G
 */
public class Order implements Comparable<Order> {
	
	private String customer;
	private String foodOrder;
	private int cookingTime;
	private int arrivalTime;
	private int cookingTimeLeft;
	
	//default values
	private static final String DEF_CUSTOMER = "none";
	private static final String DEF_FOOD_ORDER = "none";
	private static final int DEF_COOKING_TIME = 1;
	private static final int DEF_ARRIVAL_TIME = 0;
	private static final int DEF_COOKING_TIME_LEFT = DEF_COOKING_TIME;
	
	public Order() {
		this.customer = DEF_CUSTOMER;
		this.foodOrder = DEF_FOOD_ORDER;
		this.cookingTime = DEF_COOKING_TIME;
		this.arrivalTime = DEF_ARRIVAL_TIME;
		this.cookingTimeLeft = DEF_COOKING_TIME_LEFT;
	}
	
	public Order(String aCustomer, String aFoodOrder, int aCookingTime, int aArrivalTime) {
		this.setCustomer(aCustomer);
		this.setFoodOrder(aFoodOrder);
		this.setCookingTime(aCookingTime);
		this.setArrivalTime(aArrivalTime);
		this.setCookingTimeLeft(aCookingTime);
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		if(customer == null)
			this.customer = DEF_CUSTOMER;
		else
			this.customer = customer;
	}

	public String getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(String foodOrder) {
		if(foodOrder == null)
			this.foodOrder = DEF_FOOD_ORDER;
		else
			this.foodOrder = foodOrder;
	}

	public int getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(int cookingTime) {
		if(cookingTime < DEF_COOKING_TIME)
			this.cookingTime = DEF_COOKING_TIME;
		else
			this.cookingTime = cookingTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		if(arrivalTime < DEF_ARRIVAL_TIME)
			this.arrivalTime = DEF_ARRIVAL_TIME;
		else
			this.arrivalTime = arrivalTime;
	}

	public int getCookingTimeLeft() {
		return cookingTimeLeft;
	}

	public void setCookingTimeLeft(int cookingTimeLeft) {
		if(cookingTimeLeft < DEF_COOKING_TIME_LEFT)
			this.cookingTimeLeft = DEF_COOKING_TIME_LEFT;
		else
			this.cookingTimeLeft = cookingTimeLeft;
	}
	
	public String toString() {
		return "Customer: " + customer + ", Order: " + foodOrder + ", Cooking Time Left: " + cookingTimeLeft;
	}
	
	public int compareTo(Order aOrder) {
		if (aOrder == null)
			return -1;
		else if(this.cookingTime < aOrder.getCookingTime())
			return -1;
		else if(this.cookingTime > aOrder.getCookingTime())
			return 1;
		else
			return 0;
	}
	
	public void cookForOneMinute() {
		if(this.cookingTimeLeft == 0)
			return; //no need to cook further if no time is left, might want to update if we want to check for burnt?
		this.cookingTimeLeft--;
	}
	
	public boolean isDone() {
		return this.cookingTimeLeft == 0;
	}
	
}
