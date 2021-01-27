package ie.tudublin;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world");

        Animal misty = new Dog("Misty");

        Animal topCat = new Cat("TopCat");

        Cat ginger = new Cat("Ginger");

        System.out.println(misty);
        System.out.println(topCat);

        misty = topCat;

        topCat.setName("Garfield");

        //ginger.setnumLives = 9;
        int numLives = 9;

        System.out.println(misty);
        System.out.println(topCat);

        while (numLives > 0)
        {
            System.out.println("Cat just died!\n");
            numLives--;
        }
        if (numLives == 0)
        {
            System.out.println("Cat is dead!\n");
        }

        // What will get printed out??

        // 1. topcat, Garfield
        // 2. garfield, Garfield 


    }
}