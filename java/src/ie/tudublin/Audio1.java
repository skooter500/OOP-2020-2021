package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {

    Minim minim; // Connect to minim
    AudioInput ai; // How to connect to mic
    AudioPlayer ap;
    AudioBuffer ab; // Samples

    float[] lerpedBuffer;

    public void settings() {
        size(512, 512);
        // fullScreen(P3D, SPAN); // Try this for full screen multiple monitor support :-) Be careful of exceptions!
    }

    float y = 200;
    float lerpedY = y;

    int which = 0;

    public void setup() {
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        //ap = minim.loadFile("heroplanet.mp3", width);
        ab = ai.mix; // Connect the ab to mic
        //ab = ap.mix; // Connect the ab to the mp3 file
        colorMode(HSB);
        lerpedBuffer = new float[width];

    }

    public void keyPressed() {
        if (keyCode >= '0' && keyCode <= '5') {
            which = keyCode - '0';
        }
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    float lerpedAverage = 0;

    public void draw() {
        background(0);
        stroke(255);
        float halfHeight = height / 2;
        float average = 0;
        float sum = 0;

        // Calculate the average of the buffer
        for (int i = 0; i < ab.size(); i ++)
        {
            sum += abs(ab.get(i));
        }
        average = sum / ab.size();
        // Move lerpedAverage 10% closer to average every frame
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);

        switch (which)
        {
            case 0:
            {
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        
                    line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, halfHeight + lerpedBuffer[i] * halfHeight * 4, i);
                }

                // See the difference lerping makes? It smooths out the jitteryness of average, so the visual looks smoother
                ellipse(width / 4, 100, average * 500, average * 500);
                ellipse(width / 2, 100, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        
                // This is another example of how lerping works
                ellipse(200, y, 30, 30);
                ellipse(300, lerpedY, 30, 30);
                y += random(-10, 10);
                lerpedY = lerp(lerpedY, y, 0.1f);
                break;
            }   
            case 1:
            {
                strokeWeight(2);
                for (int i = 0; i < ab.size(); i ++)
                {
                    float sample = ab.get(i) * halfHeight;
                    stroke(map(i, 0, ab.size(), 0, 255), 255, 255);

                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.02f);

                    sample = lerpedBuffer[i] * width * 6;    
                    stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
                    float x = (int) map(i, 0, ab.size(), 0, width);
                    line(x, height / 2 - sample, x, height/2 + sample); 
                }
                break;
            }
            case 2:
            {
                strokeWeight(2);
                for (int i = 0; i < ab.size(); i ++)
                {
                    float sample = ab.get(i) * halfHeight;
                    stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
                    //line(i, halfH + sample, i, halfH - sample); 

                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.01f);

                    sample = lerpedBuffer[i] * width * 6;    
                    stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
                    
                    float x = map(i, 0, ab.size(), 0, width);
                    float y = map(i, 0, ab.size(), 0, height);
                        
                    line(0, y, sample, y); 
                    line(width, y, width - sample, y); 
                    line(x, 0, x, sample); 
                    line(x, height, x, height - sample);
                }
                break;
            }
            case 3:
            {
                noFill();
                strokeWeight(2);
                stroke(map(lerpedAverage, 0, 1, 0, 255), 255, 255);
                ellipse(width / 2, halfHeight, lerpedAverage * width * 2, lerpedAverage * width * 2);
                break;
            }
            case 4:
            {
                noFill();
                strokeWeight(2);
                stroke(map(lerpedAverage, 0, 1, 0, 255), 255, 255);
                rectMode(CENTER);
                rect(width / 2, halfHeight, lerpedAverage * width * 2, lerpedAverage * width * 2);
                break;
            }
            case 5:
            {
                // ??
                break;
            }
        }        
    }
}