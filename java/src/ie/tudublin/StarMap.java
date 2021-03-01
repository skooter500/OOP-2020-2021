package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    ArrayList<Star> stars = new ArrayList<Star>();

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
        size(500, 500);
    }

    public void mouseClicked()
    {
        println("Mouse clicked");
    }

    public void setup() {
        colorMode(RGB);
        loadStars();
    }

    public void draw() {
        background(0);
    }
}