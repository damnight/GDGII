package main;

import java.util.ArrayList;
import java.util.Random;

import controller.Player;
import ddf.minim.AudioPlayer;
import ddf.minim.Controller;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Ellipse;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;


public class Main extends PApplet {
	
	int backgroundcolor = 0;
	private Object minim;
    private static Player player;
    private AudioPlayer player1;
	private ArrayList<Circles> circles;
	private PGraphics pg;
    private static FFT fft;
    final static int ResX = 1280;
     final static int ResY = 720;
	
	public void settings() {
        setSize(ResX, ResY);
    }


    public void setup() {
    	//pg = createGraphics(ResX, ResY);
    	 /*player = new Player(this, "src/data/aphex.mp3");
    	 fft = player.getFFT();*/
    	background(backgroundcolor);
    	 minim = new Minim(this);
    	 player1 = ((Minim) minim).loadFile("src/data/aphex.mp3", 2048);
    	  // play the file
    	  //player1.play();
    	  player1.loop();
    	  fft = new FFT( player1.bufferSize(), player1.sampleRate() );

    	}
    
    
    Circles createCircles(){
    	
  	  int radius = 50;
  	  Random rand = new Random();
  	  //						MAXIMUM			MINIMUM
  	  int  posX = rand.nextInt(ResX-radius) + ((ResX/2)+radius);
  	  int  posY = rand.nextInt((ResY/2)-radius) + radius;
  	  PVector position = new PVector(posX, posY);
  	  int color = 255;
  	  
    	Circles circle = new Circles(this, position, radius, color);
		return circle;
    }
    
    public void draw() {
    	
    	//fft.forward(player.getSong().mix);
    	fft.forward(player1.mix);
    	
    	if(System.nanoTime() % 12 == 1){
    	Circles circle = createCircles();
    	circle.display();

    	}
    }

    
    public static void main(String[] args) {
        PApplet.main(new String[]{Main.class.getName()});
    }
}
