package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet {
    public void settings() {
        size(500, 500);
    }

    public void mouseClicked()
    {
        println("Mouse clicked");
    }

    public void setup() {
        colorMode(RGB);
    }

    public void draw() {
        background(0);
    }
}