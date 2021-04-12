package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class YASC extends PApplet {
    boolean[] keys = new boolean[1024];

    
    // Update your forks!
    // Create a branch for today monday9
    // Write drawPlayer
    // Write movePlayer

    Player p;
    Health h;
    Ammo a;
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        p = new Player(this, width / 2, height / 2);
        h = new Health(this);
        a = new Ammo(this);
    }

    public void draw() {

        fill(255);
        background(0);
        text("Bullets: " + bullets.size(), 50, 50);
        text("FPS: " + frameRate, 50, 100);
        
        stroke(255);
        p.update();
        p.render();
        h.update();
        h.render();

        a.update();
        a.render();

        for(int i = bullets.size() - 1; i >= 0 ; i--)
        {
            Bullet b = bullets.get(i);
            b.update();
            b.render();
        }
       
        // Check collisions        
        checkCollisions();
    }

    void checkCollisions() 
    {
        if (dist(p.x, p.y, h.getX(), h.getY()) < p.halfW + h.halfW)
        {
            p.health += 10;
            h.respawn();    
        }

        if (dist(p.x, p.y, a.x, a.y) < p.halfW + a.halfW)
        {
            p.ammo += 10;
            a.respawn();    
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