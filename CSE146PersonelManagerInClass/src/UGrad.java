/*
 * Brently George
 */
public class UGrad extends Student {
	private int level;//1=freshman...
	public UGrad() {
		super();
		this.level = 1;
	}
	public UGrad(String aN, int anID, int aL) {
		super(aN, anID);
		this.setLevel(aL);
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level >= 1 && level <=5)
			this.level = level;
		else
			this.level = 1;
	}
	public String toString() {
		return super.toString() + " Level: "+this.level;
	}
	public boolean equals (UGrad anU) {
		return anU != null &&
				super.equals(anU) &&
				this.level == anU.getLevel();
	}
}