package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    public void settings() {
        size(500, 500);
        cx = width / 2;
        cy = height / 2;        
    }

    int mode = 0;

    float cx;
    float cy;

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
    }

    float offset = 0;

    public void draw() {
        background(0);
        noStroke();
        switch (mode)
        {
            case 0:
            {
                float w = 200;
                float h = 50;
                rectMode(CENTER);                    
                if (mouseX > cx -  (w /2) && mouseX < cx + (w/2) && mouseY > cy - (h/2) && mouseY < cy + (h/2))
                {
                    fill(50, 255, 255);                
                }
                else
                {
                    fill(200, 255, 255);
                }
                rect(cx, cy, w, h);
                break;
            }                
            case 1:
                fill(50, 255, 255);                                    
                if (mouseX < cx && mouseY < cy)
                {
                    rect(0, 0, cx, cy);
                }
                else if (mouseX > cx && mouseY < cy)
                {
                    rect(cx, 0, cx, cy);
                }
                else if (mouseX < cx && mouseY > cy)
                {
                    rect(0, cy, cx, cy);
                }
                else
                {
                    rect(cx, cy, cx, cy);
                }
                break;
            case 2:
            {
                int numRects = (int)(mouseX / 10.0f);
                float w = width / (float) numRects;
                float cgap = 255 / (float) numRects;
                for(int i = 0 ; i < numRects ; i ++)
                {
                    fill(i * cgap, 255, 255);
                    rect(i * w, 0, w, height);
                }
                break;
            }
            case 3:
            {
                int numCircles = (int)(mouseX / 10.0f);
                float w = width / (float) numCircles;
                float cgap = 255 / (float) numCircles;
                for(int i = 0 ; i < numCircles ; i ++)
                {
                    fill(cgap * i, 255, 255);
                    ellipse(w / 2 + (i * w), cy, w, w);
                }
                break;
            }
            case 4:
            {
                int numLines = 5;
                float theta = TWO_PI / (float) numLines;
                float radius = 100;
                for(int i = 0 ; i < numLines ; i ++)
                {
                    float angle = theta * i;
                    float x = sin(angle) * radius;
                    float y = cos(angle) * radius;
                    line(cx, cy, cx + x, cy + y);                    
                }
            }
            break;
            case 5:
            {
                rectMode(CORNER);
                int numRects = (int) mouseX / 10;
                float w = width / (float) numRects;
                float cgap = 255 / (float) numRects;
                for(int i = 0 ; i < numRects ; i ++)
                {
                    fill(cgap * i, 255, 255);
                    rect(i * w, i * w, w, w);
                    rect(width - ((i + 1) * w), i * w, w, w);
                }
                break;
            }
            case 6:
            {
                int numCircles = (int) mouseX / 10;
                float cgap = 255 / (float) numCircles;
                float gap = width / (float) numCircles;
                float w = width;
                for(int i = numCircles ; i >= 1 ; i --)
                {
                    fill(i * cgap, 255, 255);
                    w = i * gap;
                    ellipse(cx, cy, w, w);
                    
                }                
            }
            case 7:
            {
                offset += (mouseX / 100);
                int numCircles = 20;
                float w = width / (float)numCircles;
                float cgap = 255 / (numCircles + numCircles);
                for(int i = 0 ; i < numCircles ; i ++)
                {
                    for(int j = 0 ; j < numCircles ; j ++)
                    {
                        float c = ((cgap * (i + j)) + offset) % 255; 
                        fill(c, 255, 255);
                        ellipse((w / 2) + w * j, (w / 2) + w * i, w, w);
                    }
                }
                break;
            }
            case 8:
            {
                int sides = (mouseX / 50);
                float theta = TWO_PI / (float) sides;
                float radius = 200;
                stroke(255);
                for(int i = 1 ; i <= sides ; i ++)
                {
                    float x1 = sin(theta * (i - 1)) * radius;
                    float y1 = cos(theta * (i - 1)) * radius;
                    float x2 = sin(theta * i) * radius;
                    float y2 = cos(theta * i) * radius;
                    line(cx + x1, cy + y1, cx + x2, cy + y2);
                }
            }
            break;
        }
    }
}
