package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio2 extends PApplet {

    Minim minin;
    AudioPlayer ai;
    AudioBuffer ab;

    public void settings() {
        size(512, 512, P3D);
        //fullScreen(P3D, SPAN); // Try this for full screen multiple monitor support :-) Be careful of exceptions!
    }

    float y = 200;
    float lerpedY = y;

    int which = 0;

    public void setup() {         
        colorMode(HSB);
        
    }

    public void keyPressed() {
        if (keyCode >= '0' && keyCode <= '5') {
            which = keyCode - '0';
        }
    }

    float lerpedAverage = 0;

    public void draw() {
        background(0);
        stroke(255);
    }
}