package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    ArrayList<Star> stars = new ArrayList<Star>();

    int startStar = -1;
    int endStar = -1;


    
    void drawGrid()
    {
        float border = 0.1f * width;
        textAlign(CENTER, CENTER);
        //float drawable = width - (border * 2.0f);
        // /float gap = drawable / 10.0f;
        for(int i = -5 ; i <=5 ; i ++)
        {
            float x = map(i, -5, 5, border, width - border);
            float y = map(i, -5, 5, border, height - border);
            //float x = border + ((i + 5) * gap);
            //float y = border + ((i + 5) * gap);
            stroke(0, 0, 255);
            line(x, border,x, height - border);
            line(border, y, width - border, y);
            fill(255);
            text(i, x, border / 2);
            text(i, border / 2, y);
        }
    }

    void printStars()
    {
        for(Star s: stars)
        {
            println(s);
        }
    }

    void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
        for(TableRow row:table.rows())
        {
            Star s = new Star(row);
            stars.add(s);
        }
    }

    public void settings() {
        size(800, 800);
    }

    public void mouseClicked()
    {
        float border = width * 0.1f;
        for(int i = 0 ; i < stars.size() ; i ++)
        {
            Star s = stars.get(i);
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);
            if (dist(mouseX, mouseY, x, y ) < s.getAbsMag() / 2)
            {
                println(s.getDisplayName());
                break;
            }
        }
    }

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();
    }

    public void drawStars()
    {
        for(Star s: stars)
        {
            s.render(this);
        }
    }

    public void draw() {
        background(0);
        drawGrid();
        drawStars();
    }
}