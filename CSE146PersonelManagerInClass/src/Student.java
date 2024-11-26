/*
 * Brently George
 */
public class Student extends Person {
	private int id;
	public Student() {
		super(); //call parents default constructor
		this.id = 0;
	}
	
	public Student(String aN, int anID) {
		super(aN);
		//TODO call mutators
		this.setId(anID);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id >= 0)
			this.id = id;
		else
			this.id = 0;
	}
	
	public String toString() {
		return super.toString() + " ID: "+this.id;
	}
	
	public boolean equals(Student aS) {
		return aS != null &&
				super.equals(aS) &&
				this.id == aS.getId();
	}
}
