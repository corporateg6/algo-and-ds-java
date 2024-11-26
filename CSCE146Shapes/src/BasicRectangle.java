/*
 * Brently G
 */
public class BasicRectangle extends BasicShape implements Rectangle {
	private int height, width;
	
	public BasicRectangle()
	{
		super();
		this.height = this.width = 1;
	}
	
	public BasicRectangle(int aH, int aW, int aHe) {
		super(aH);
		//TODO call mutators
		this.setHeight(aHe);
		this.setWidth(aW);
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setWidth(int aW) {
		if (aW >= 1)
			this.width = aW;
		else
			this.width = 1;
	}
	
	public void setHeight(int aHe) {
		if (aHe >=1)
			this.height = aHe;
		else
			this.height = 1;
	}
	
	public void drawShape() {
		for (int i=0;i<this.height;i++) {
			skipSpaces(super.getHSpace());
			for(int j=0;j<this.width;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
