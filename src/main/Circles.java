package main;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.shape.Ellipse;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;
import processing.core.PVector;

public class Circles {
	
    private static PApplet canvas;
    private PShape shape;
    private PVector position;
    private float angle;
    private float speed;
    private float weight = 20;
    private float jitter;
    private int ResX = Main.ResX;
    private int ResY = Main.ResY;


	 public Circles(PApplet papa, PVector position, int radius, int color) {
	        canvas = papa;
	        this.position = position;


	        // Shapes bring the advantage of being easily modifiable and adjustable
	        shape = canvas.createShape();
	        shape.beginShape();

	        shape.stroke(color);
	        shape.fill(color);
	        float span = PConstants.TWO_PI;
	        for (float a = -span; a < 0; a += 0.1) {
	            shape.vertex(PApplet.cos(a) * radius / 2, PApplet.sin(a) * radius / 2);
	        }

	        shape.endShape();
 
	    }
	 
	 public void display() {
	        canvas.pushMatrix();
	        shape.setStrokeWeight(weight + jitter);
	        canvas.translate(position.x, position.y);
	        canvas.shape(shape);

	        canvas.popMatrix();
	    }
	 
	    public void update() {
	       
	    	canvas.translate(position.x, position.y+360);
	    }

	    public void updateJitter(float jitter) {
	        this.jitter = jitter / 2;
	    }
}
