package ie.tudublin;

import processing.core.PApplet;

public class Player {

    float x, y;
    float w = 50;
    float halfW = w / 2;
    YASC yasc;

    public Player(YASC yasc, float x, float y)
    {
        this.yasc = yasc;
        this.x = x;
        this.y = y;
    }

    void render()
    {
        // Write this!!
        yasc.line(x - halfW, y + halfW, x, y - halfW);
        yasc.line(x, y - halfW, x + halfW, y + halfW);
        yasc.line(x + halfW, y + halfW, x, y);
        yasc.line(x, y, x - halfW, y + halfW);
    }

    void update()
    {
        if (yasc.checkKey(PApplet.UP))
        {
            y -= 1;
        }
        if (yasc.checkKey(PApplet.DOWN))
        {
            y += 1;
        }
        if (yasc.checkKey(PApplet.LEFT))
        {
            x -= 1;
        }
        if (yasc.checkKey(PApplet.RIGHT))
        {
            x += 1;
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