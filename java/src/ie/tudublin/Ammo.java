package ie.tudublin;

import processing.core.PApplet;

public class Ammo {

    float x, y;
    float dx, dy;
    float w = 50;
    float halfW = w / 2;
    YASC yasc;
    float rotation;

    public Ammo(YASC yasc)
    {
        this.yasc = yasc;
        rotation = 0;
        respawn();            
    }

    void respawn()
    {
        // Roll a dice
        int dice = (int) yasc.random(5);
        switch (dice)
        {
            case 0:
                // left
                x = -w;
                y = yasc.random(0, yasc.height);
                dx = yasc.random(1, 4);
                dy = yasc.random(-1, 1);
                break;
            case 1:
                // top 
                x = yasc.random(0, yasc.width);
                y = -w;
                dx = yasc.random(-1, 1);
                dy = yasc.random(1, 4);
                break;
            case 2:
                // right
                x = yasc.width + w;
                y = yasc.random(0, yasc.height);
                dx = yasc.random(-1, -4);
                dy = yasc.random(-1, 1);
                break;
            case 3:
                // bottom
                x = yasc.random(0, yasc.width);
                y = yasc.height + w;
                dx = yasc.random(-1, 1);
                dy = yasc.random(-1, -4);
                break;
        }
    }

    void render()
    {
        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        // Write this!!
        yasc.stroke(0, 255, 0);
        yasc.noFill();
        yasc.triangle(-halfW, halfW, 0, - halfW, halfW, halfW);        
        yasc.popMatrix();
    }

    void update()
    {        
        x += dx;
        y += dy;
        rotation += 0.01f;

        if (x < - w)
        {
            respawn();
        }
        if (x > yasc.width + w)
        {
            respawn();
        }

        if (y < - w)
        {
            respawn();
        }
        if (y > yasc.height + w)
        {
            respawn();
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }
}