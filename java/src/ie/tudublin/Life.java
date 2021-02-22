package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {
    
    int mode = 0;
    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(RGB);
        size(500, 500);
    }


    public void draw() {
        background(0);
    }
}
