package model;

import java.awt.Color;

import processing.core.PApplet;

/**
 * This Class builds the walls
 * 
 * 
 * @author Marco
 *
 */
public class Wall extends PApplet{

		  //Minimum and maximum Position
		  float startingZ = -10000;
		  float maxZ = 50;
		  
		  PApplet parent;
		  
		  //Position values
		  float x, y, z;
		  float sizeX, sizeY;
		  
		  //Constructor
		 public Wall(float x, float y, float sizeX, float sizeY, PApplet parent) {
		    //make the line appear at the right spot
		    this.x = x;
		    this.y = y;
		    //random depth
		    this.z = random(startingZ, maxZ);  
		    
		    //accounting for different wall sizes
		    this.sizeX = sizeX;
		    this.sizeY = sizeY;
		    
		    this.parent = parent;
		  }


		
		public void display(float scoreLow, float scoreMid, float scoreHi, float intensity, float scoreGlobal) {
		    int displayColor = 8181016;
		    
		    //Edge color
		    parent.fill(displayColor);
		    parent.noStroke();
		    
		    //set Matrix
		    parent.pushMatrix();
		    
		    //Displacement
		    parent.translate(x, y, z);
		    
		    //Enlargement
		    if (intensity > 100) intensity = 100;
		    parent.scale(sizeX*(intensity/100), sizeY*(intensity/100), 20);
		    
		    //Creation of the box
		    parent.box(1);
		    parent.popMatrix();
		    
		    //Second Band, always same size
		    displayColor = color(123,144,22);
		    parent.fill(displayColor, (scoreGlobal/5000)*(255+(z/25)));
		    //set Matrix
		    parent.pushMatrix();
		    
		    //Displacement
		    parent.translate(x, y, z);
		    
		    //Enlargement
		    parent.scale(sizeX, sizeY, 10);
		    
		    //Creation of the box
		    parent.box(1);
		    parent.popMatrix();


		    //Displacement in z
		    z+= (pow((scoreGlobal/150), 2));
		    if (z >= maxZ) {
		      z = startingZ;  
		    }
		}
}
