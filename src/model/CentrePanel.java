package model;

import processing.core.PApplet;

/**
 * this class will be at the centre and light up according to the Bass.
 * @author Marco
 *
 */
public class CentrePanel {
	
	int height;
	int width;
	int rgbColor;
	PApplet parent;
	
	/**
	 * constructor for the CentrePanel
	 * 
	 * @param height - its height dimension in pixels
	 * @param width - its width dimension in pixels
	 * @param rgbColor - its beginning color, this will be used to compute the change in color too (as a progression on the color wheel that makes sense)
	 * @param parent - the main class, so the centrePanel can be written over and displayed
	 */
	public CentrePanel(int height, int width, int rgbColor, PApplet parent){
		
		this.height = height;
		this.width = width;
		this.rgbColor = rgbColor;
		this.parent = parent;
	}
	
	/**
	 * main display functionality, call this from the mainclass to animate this object
	 * @param intensity - 0 or 1 depending on which drum is triggering the displaying event
	 */
	public void display(int intensity){
		
		if(intensity == 0){
			//TODO change color
		}
		if(intensity == 1){
			//TODO change color
		}
		if(intensity > 1 || intensity < 0 ){
			System.err.println("Displayfunctionality wasn't coded for this intesity!");
		}
	}

}
