package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    public void settings() {
        size(500, 500);                
    }

    int mode = 0;

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
    }

    float offset = 0;

    public void draw() {
        background(0);
        noStroke();
    }
}
