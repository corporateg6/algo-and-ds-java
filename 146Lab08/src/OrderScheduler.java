/*
 * Brently G
 */

public class OrderScheduler {
	
	private MinHeap<Order> orders;
	private Order currentOrder;
	private int currentMinute;
	private int totalOrders;
	private int summedWaitingTimes;
	
	//initialize at starting values
	public OrderScheduler() {
		this.orders = new MinHeap<Order>();
		this.currentOrder = null;
		this.currentMinute = 0;
		this.totalOrders = 0;
		this.summedWaitingTimes = 0;
	}
	
	//added because the driver is calling this, but not mentioned in the lab spec
	public Order getCurrentOrder() {
		return this.currentOrder;
	}
	
	//if there is no current order, then make this the current order
	//otherwise, add the order to the minheap
	//increment the total number of orders
	public void addOrder(Order aOrder) {
		if(this.currentOrder == null)
			this.currentOrder = aOrder;
		else
			this.orders.add(aOrder);
		this.totalOrders++;
	}
	
	//process one minute of time by
	//cooking the current order for a minute
	//then if the order is done, update the waiting times subtotal
	//and make the next order up the current order
	public void advanceOneMinute() {
		this.currentMinute++;
		this.currentOrder.cookForOneMinute();
		if(this.currentOrder.isDone()) {
			this.summedWaitingTimes += this.currentMinute - this.currentOrder.getArrivalTime();
			this.currentOrder = orders.remove();
		}
	}
	
	//checking if our cooking is done
	public boolean isDone() {
		return this.currentOrder == null;
	}
	
	//calculate and return the avg wait time.
	public double getAverageWaitingTime() {
		return (double)(this.summedWaitingTimes)/(double)(this.totalOrders);
	}
}
