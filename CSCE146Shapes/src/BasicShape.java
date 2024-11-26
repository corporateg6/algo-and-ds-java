/*
 * Brently G
 */
public class BasicShape implements Shape {

	private int hSpace;
	
	public BasicShape() {
		this.hSpace = 0;
		}
	
	public BasicShape(int aH) {
		setHSpace(aH);
	}
	
	public int getHSpace() {
		return this.hSpace;
	}
	
	public void setHSpace(int aH) {
		if (aH >= 0)
			this.hSpace = aH;
		else
			this.hSpace = 0;
	}
	
	public void drawShape() {
		skipSpaces(this.hSpace);
		System.out.println("*");
	}
	
	public void drawShapeAt(int lineNumber) {
		for(int i=0;i<lineNumber;i++) {
			System.out.println();
		}
		drawShape();
	}
	
	public static void skipSpaces(int aH) {
		for(int i=0;i<aH;i++) {
			System.out.print(" ");
		}
	}
}
