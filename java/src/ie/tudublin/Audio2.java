package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet {

    Minim minim;
    AudioPlayer ap;
    AudioBuffer ab;
    AudioInput ai;
    FFT fft;

    public void settings() {
        size(1024, 1024);
        //fullScreen(P3D, SPAN); // Try this for full screen multiple monitor support :-) Be careful of exceptions!
    }

    float y = 200;
    float lerpedY = y;

    int which = 0;

    public void setup() {         
        colorMode(HSB);

        minim = new Minim(this);
        ap = minim.loadFile("heroplanet.mp3", width);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16); 
        ab = ai.mix;

        fft = new FFT(width, 44100);

    }

    public void keyPressed() {
        if (keyCode >= '0' && keyCode <= '5') {
            which = keyCode - '0';
        }
        if (keyCode == ' ')
        {
            if (ap.isPlaying())
            {
                ap.pause();
            }
            else
            {
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
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
            //line(i, halfHeight - (ab.get(i) * halfHeight), i, halfHeight + (ab.get(i) * halfHeight));
        }

        fft.window(FFT.HAMMING);
        fft.forward(ab);

        int highestBand = 0;
        for(int i = 0 ; i < fft.specSize() ; i ++)
        {
            stroke(map(i, 0, fft.specSize(), 0, 255), 255, 255);
            line(i, 0, i, fft.getBand(i) * halfHeight);
        }

        float freq = fft.indexToFreq(highestBand);
        textSize(24);
        fill(255);
        text("Frequency: " + freq, 10, 50);
    }
}