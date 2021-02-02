package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing2 extends PApplet
{

	public void settings()
	{
		// If you want to use the width and 
		// height variables, they have to be after settings 
		// is called
		size(500, 500);
	}

	
	public void setup() {
		
	}

	// These are fields in the class now and can be used in 
	// any of the methods in the HelloProcessing2 class 

	float x = 300;
	int i;
	String s;
	boolean b;
	
	public void draw()
	{	// Takes 1 or 3 parameters. 1 is greyscale, 3 is RGB
		background(0);         

		// Turns off drawing around shapes
		noStroke();

		// Sets the fill color
		fill(0, 0, 255); 

		// width, height mouseX and mouseY are variables defined
		// in the PApplet superclass. 
		// width & height give the width and height of the drawing window
		// mouseX and mouseY give the current X and Y
		// coordinates of the mouse
		// Draw an ellipse. cx, cy, w and h		
		ellipse(x, height / 2, mouseX, mouseY);

		fill(255, 0, 0);

		// Draws a rect ltx (top left X), tly (top left Y), w and h 
		rect(200, 90, 50, 90);

		stroke(0, 255, 255);

		// Changes the thickness of lines
		strokeWeight(1);

		// Draws a line x1, y1, x2, y2
		line (200, 300, 100, 50);

		noStroke();
		fill(0, 255, 0);
		// Draws a triangle. 3 vertices 
		triangle(300, 300, 350, 400, 250, 450);

		stroke(255);
		// Draws a single point
		point(400, 50);

		// Changes the thickness of lines
		strokeWeight(3);

		line(20, 400, 200, 410);

	}
}
