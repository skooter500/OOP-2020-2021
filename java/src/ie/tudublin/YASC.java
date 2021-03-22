package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet {
    boolean[] keys = new boolean[1024];

    float x, y;
    float w = 50;
    float halfW = w / 2;

    // Update your forks!
    // Create a branch for today monday9
    // Write drawPlayer
    // Write movePlayer

    void drawPlayer(float x, float y)
    {
        // Write this!!
        line(x - halfW, y + halfW, x, y - halfW);
        line(x, y - halfW, x + halfW, y + halfW);
        line(x + halfW, y + halfW, x, y);
        line(x, y, x - halfW, y + halfW);
    }

    void movePlayer()
    {
        if (checkKey(UP))
        {
            y -= 1;
        }
        if (checkKey(DOWN))
        {
            y += 1;
        }
        if (checkKey(LEFT))
        {
            x -= 1;
        }
        if (checkKey(RIGHT))
        {
            x += 1;
        }
        
    }

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        x = width / 2;
        y = height / 2;
    }

    public void draw() {
        background(0);
        stroke(255);
        drawPlayer(x, y);
        movePlayer();
    }

    boolean checkKey(int k) {
        if (keys.length >= k) {
            return keys[k] || keys[Character.toUpperCase(k)];
        }
        return false;
    }

    public void mousePressed() {
    }

    public void keyPressed() {
        keys[keyCode] = true;
    }

    public void keyReleased() {
        keys[keyCode] = false;
    }
}