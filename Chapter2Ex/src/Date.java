/*
 * Brently G
 */
public class Date {
	
	private int month;
	private int day;
	private int year;
	private String dayName;
	
	Date() {
		this.month = 1;
		this.day = 1;
		this.year = 0;
		this.dayName = "Monday";
	}
	
	Date(int month, int day, int year, String dayName) {
		//call mutators
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month < 1 || month > 12)
			this.month = 1;
		else
			this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (day < 1 || day > 31)
			this.day = 1;
		else
			this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year < 0)
			this.year = 0;
		else
			this.year = year;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		if (dayName == null)
			this.dayName = "Monday";
		this.dayName = dayName;
	}

	@Override
	public String toString() {
		return "" + this.getMonth() + this.getDay() + this.getYear() + this.getDayName() + "";
	}
	
	
	
}
