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
        processing.core.PApplet.runSketch( a, new Life());
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

    public static void main(String[] args)
    {
        Main main = new Main();
        main.starMap();
    }
} 