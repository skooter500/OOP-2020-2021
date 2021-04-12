// Bullets wrap around the screen
// Bullets live for 5 seconds then they get destroyed.
// update method in bullets get called 60 fps


package ie.tudublin;

import processing.core.PApplet;

public class Bullet extends GameObject{

    float lifetime;

    public Bullet(YASC yasc, float x, float y, float rotation)
    {
        super(yasc, x, y, rotation);
        lifetime = 5;
        timeAlive = 0;
    }

    public void render()
    {
        yasc.stroke(255);
        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        yasc.line(0, -5, 0, 5);
        yasc.popMatrix();
    }
    

    float timeAlive;

    public void update()
    {
        dx = PApplet.sin(rotation);
        dy =  - PApplet.cos(rotation);

        x += dx * speed;
        y += dy * speed;

        timeAlive += (1 / 60.0f);
        if (timeAlive > lifetime)
        {
            yasc.bullets.remove(this);
        }

        if (x < 0)
        {
            x = yasc.width;
        }
        if ( x > yasc.width)
        {
            x = 0;
        }
        if (y < 0 )
        {
            y = yasc.height;
        }
        if (y > yasc.height)
        {
            y = 0;
        }

    }


}
