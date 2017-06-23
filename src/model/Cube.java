package model;

import processing.core.PApplet;

/**
 * floating cubes
 * @author Marco
 *
 */
public class Cube {
	
//spawn position
float startingZ = -10000;
float maxZ = 1000;

//position values
float x, y, z;
float rotX, rotY, rotZ;
float sumRotX, sumRotY, sumRotZ;

PApplet parent;

//Constructor
public Cube() {
  
  x = parent.random(0, parent.width);
  y = parent.random(0, parent.height);
  z = parent.random(startingZ, maxZ);
  
  //give each cube a random rotation
  rotX = parent.random(0, 1);
  rotY = parent.random(0, 1);
  rotZ = parent.random(0, 1);
}

void display(float scoreLow, float scoreMid, float scoreHi, float intensity, float scoreGlobal, PApplet parent) {

	int displayColor = 13118920;
  parent.fill(displayColor, 255);
  

  int strokeColor = 13153480;
  parent.stroke(strokeColor);
  parent.strokeWeight(1 + (scoreGlobal/300));
  
  //set matrix
  parent.pushMatrix();
  
  //Displacement
  parent.translate(x, y, z);
  
  //calculate rotation intensity
  sumRotX += intensity*(rotX/1000);
  sumRotY += intensity*(rotY/1000);
  sumRotZ += intensity*(rotZ/1000);
  
  //apply rotation
  parent.rotateX(sumRotX);
  parent.rotateY(sumRotY);
  parent.rotateZ(sumRotZ);
  
  //create the box
  parent.box(100+(intensity/2));
  
  //apply the matrix
  parent.popMatrix();
  
  //displacement in z
  z+= (1+(intensity/5)+(parent.pow((scoreGlobal/150), 2)));
  
  //replace the invisivble box
  if (z >= maxZ) {
    x = parent.random(0, parent.width);
    y = parent.random(0, parent.height);
    z = startingZ;
  }
}
}
