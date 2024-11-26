
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s;
		s = new BasicShape();
		//Rectangle r;
		//s = r;
		Shape[] shapes = new Shape[3];
		shapes[0] = new BasicShape(4);
		shapes[1] = new BasicRectangle(2,3,4);
		shapes[2] = new BasicRectangle(4,5,6);
		
		for(int i=0; i<shapes.length;i++) {
			shapes[i].drawShapeAt(i);
		}
	}

}
