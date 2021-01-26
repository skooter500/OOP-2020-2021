package ie.tudublin;

public class Cat extends Animal
{
    private int numLives;
    
    public Cat(String name)
    {
        super(name);
        numLives = 9;
    }

    void kill()
    {
        if (numLives > 0)
        {
            numLives --;
            System.out.println("Ouch!");
        }
        else
        {
            System.out.println("I am dead");
        }
    }

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }
}