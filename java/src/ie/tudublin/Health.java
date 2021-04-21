package ie.tudublin;

import processing.core.PApplet;

public class Health extends GameObject implements PowerUp{

    @Override
    public void applyTo(Player p) {
        p.health += 10;        
    }

    public Health(YASC yasc)
    {
        super(yasc, 0, 0, 0);
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

    public void render()
    {
        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        // Write this!!
        yasc.stroke(255);
        yasc.line(-halfW, halfW, -halfW, -halfW);
        yasc.line(-halfW, -halfW, halfW, -halfW);
        yasc.line(halfW, -halfW, halfW, halfW);        
        yasc.line(halfW, halfW, -halfW, halfW);

        yasc.line(0, -halfW, 0, halfW);
        yasc.line(-halfW, 0, halfW, 0);

        yasc.popMatrix();
    }

    public void update()
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