package ie.tudublin;

public class Cat extends Animal
{
    public Cat(String name)
    {
        super(name);
    }

    private Integer numLives;

    public Integer getNumLives()
    {
        return numLives;
    }

    public void setnumLives(Integer numLives)
    {
        this.numLives = numLives;
    }

    /* I'm not sure how to make it work with decorator
    public Cat(Integer numLives)
    {
        this.numLives = numLives;
    }
    */
}