/*
 * Brently G
 */

import java.awt.*;
import javax.swing.*;

public class SierpinskisTriangle extends Canvas {
	
	public static final int RESOLUTION = 4;

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Sierpinski's Triangle");
		frame.setSize(600,600);
		SierpinskisTriangle sp = new SierpinskisTriangle();
		frame.add(sp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		
		//some color to fill our recursive pattern in with. 
		//not white, so I can see it against the background white color.
		Color myTriangleColor = new Color(255,2,255); 
		int myHeight = this.getHeight();
		int myWidth = this.getWidth();
		//draw initial triangle.
		//this is the large black colored triangle that is the base for our inverted triangles
		//we keep two arrays for the points in our triangle (because I don't know how to create tuples)
		//NOTE: I could create a new class for the coordinate with xpos and ypos as well, but this seemed simple enough.
		//theses are arrays[3] which have the xcoord[coord1x, coord2x, coord3x] and ycoord[coord1y, coord2y, coord3y]
		//I'm setting the default values, which are based on the Frame height and width.
		int[] xPoints = {0, myWidth/2, myWidth};
        int[] yPoints = {myHeight, 0, myHeight};
        //for my recursion process I want to draw my triangles originating from a certian point on the Frame
        //this is an array[2] with [xCoord, yCoord] of the origin of the triangle
        int[] origin = {myWidth/2, myHeight}; 
        //draw my initial triangle
		g.fillPolygon(xPoints, yPoints, 3);
		//set the draw color to my custom color
		g.setColor(myTriangleColor);
		//update coordinates for proper rendering of first inverted triangle.
		//since my recursive operation expects input data from a previously drawn INVERTED triangle
		//i need to update my coordinate arrays to invert my points.
		xPoints[2] = myWidth;
		xPoints[0] = 0;
		yPoints[1] = myHeight;
		yPoints[0] = 0;
		//now draw recursively
		drawTriangle(xPoints, yPoints, myWidth, myHeight, origin, g);
	}
	
	//my recursive drawing method
	public void drawTriangle(int[] xPoints, int[] yPoints, int myWidth, int myHeight, int[] origin, Graphics g) {
        //Printed some data for debugging
		//System.out.println("x: " + myWidth + " y: " + myHeight);
		
		//calculate the new width for the next triangle that will be drawn
		//based on the spec, each new triangle width and height will be half of the previously drawn one.
		//NOTE, since we are using integers, and integer division/2 will drop the remainder, you will see that some
		//pixels get "left behind" so to speak and we may have some gaps depending on the frame size.
		//I think it looks visually fine, but this could be corrected in a future update if needed
		//we could correct it by by detecting remainder with modulo and adding or subtracting 1 as needed.
        int newWidth = myWidth/2;
        int newHeight = myHeight/2;
        //we only continue IF our new triangle isn't smaller than our set resolution.
        //per the spec this is set to 4 but we can change easily in the constants of this class.
        if (newWidth > RESOLUTION && newHeight > RESOLUTION) {
        	//this is calculating the new points for our triangle, based on the origin we were given (which shows us where to start)
        	//and also the new width and height we just calculated
			xPoints[0] = origin[0]-(newWidth/2);
			xPoints[1] = origin[0];
			xPoints[2] = origin[0]+(newWidth/2);
			yPoints[0] = origin[1]-newHeight;
			yPoints[1] = origin[1];
			yPoints[2] = origin[1]-newHeight;
			//now we draw the new triangle
			g.fillPolygon(xPoints, yPoints, 3);
			
			//next we want to draw a triangle on top of this one
			//so we calculate the origin[x,y] for the top
			//and then call our recursive method accordingly
			int topOrigin[] = {origin[0],yPoints[0]};
			drawTriangle(xPoints,yPoints, newWidth, newHeight, topOrigin, g);
	        //same process as above but for the left side triangle
			int leftOrigin[] = {origin[0]-newWidth/2,origin[1]};
			drawTriangle(xPoints,yPoints, newWidth, newHeight, leftOrigin, g);
	        //same process as above but for the right side triangle
			int rightOrigin[] = {origin[0]+newWidth/2,origin[1]};
			drawTriangle(xPoints,yPoints, newWidth, newHeight, rightOrigin, g);
        }
	}

}
