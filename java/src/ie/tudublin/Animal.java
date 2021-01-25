package ie.tudublin;

public class Animal
{

    public String toString()
    {
        return name;
    }

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Animal(String name)
    {
        this.name = name;
    }
}