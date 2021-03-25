package ie.tudublin;

import processing.core.PApplet;

public class Health {

    float x, y;
    float dx, dy;
    float w = 50;
    float halfW = w / 2;
    YASC yasc;
    float rotation;

    float speedx, speedy;

    public Health(YASC yasc, float x, float y) {
        this.yasc = yasc;
        this.x = x;
        this.y = y;
        rotation = 0;
        speedx = yasc.random(2, 8);
        speedy = yasc.random(2, 8);
    }
    void render()
    {
        yasc.pushMatrix();
        //yasc.translate(x, y);
        yasc.rotate(rotation);
        yasc.rectMode(PApplet.CENTER);
        yasc.rect(x, y, 50, 50);
        yasc.popMatrix();
    }

    void update()
    {
        //dx = PApplet.sin(rotation);
        //dy =  - PApplet.cos(rotation);
        
        x = x + speedx;
        y = y + speedy;

        if (x > yasc.width)
        {
            x = yasc.width;
            speedx *= -1;
            //rotation += 0.1f;
            //respawn();
        }
        if (x < 0)
        {
            x = 0;
            speedx *= -1;
            //rotation -= 0.1f;
            //respawn();
        }
        if (y < 0)
        {
            y = 0;
            speedy *= -1;
            //rotation -= 0.1f;
            //respawn();
        }
        if (y > yasc.height)
        {
            y = yasc.height;
            speedy *= -1;
           // rotation += 0.1f;
            //respawn();
        }
    }
}