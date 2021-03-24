package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet {
    boolean[] keys = new boolean[1024];

    
    // Update your forks!
    // Create a branch for today monday9
    // Write drawPlayer
    // Write movePlayer

    Player p;
    Health h;

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        p = new Player(this, width / 2, height / 2);
        h = new Health(this);
    }

    public void draw() {
        background(0);
        stroke(255);
        p.update();
        p.render();
        h.update();
        h.render();
        
        // Check collisions        
        checkCollisions();
    }

    void checkCollisions() 
    {
        if (dist(p.x, p.y, h.x, h.y) < p.halfW + h.halfW)
        {
            p.health += 10;
            h.respawn();    
        }
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