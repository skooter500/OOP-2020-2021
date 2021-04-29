package ie.tudublin;

public class Main
{
    public void catsAndDogs()
    {
        System.out.println("Hello world");

        Animal misty = new Dog("Misty");

        Animal topCat = new Cat("TopCat");

        System.out.println(misty);
        System.out.println(topCat);

        misty = topCat;

        topCat.setName("Garfield");

        System.out.println(misty);
        System.out.println(topCat);

        // What will get printed out??

        // 1. topcat, Garfield
        // 2. garfield, Garfield 

        Cat ginger = new Cat("Ginger");
        while(ginger.getNumLives() > 0)
        {
            ginger.kill();
        }
        ginger.kill();
    }

    public void helloProcessing1()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing1());
    }

    public void helloProcessing2()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing2());
    }

    public void bugZap()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
    }

    public void loops()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
    }

    public void arrays()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Arrays());
    }
    
    public void life()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Life1());
    }
    
    public void colorfulLife()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new ColorfulLife());
    }

    public void starMap()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new StarMap());
    }
    public void gantt()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Gantt());
    }

    public void audio1()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio1());
    }

    public void audio2()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio2());
    }

    public void yasc()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new YASC());
    }

    public void strings()
    {
        String s = "I may be hungry, but I sure ain't weird.";

        String ss = s.substring(9, 15);
        System.out.println(ss);

        System.out.println(s.charAt(0));
        System.out.println(s.toLowerCase());

        System.out.println(s.indexOf("hungry"));
        System.out.println(s.lastIndexOf("e"));

        for(int i = s.length() - 1; i >= 0; i--)
        {
            System.out.println(s.charAt(i));
            System.out.println(s.substring(i, i+1));
        }

        for(String sss:s.split(" "))
        {
            System.out.println(sss);
        }
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        main.gantt();
    }
} 