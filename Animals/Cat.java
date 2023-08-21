public class Cat extends Animal
{
    private int numLives;

    public Cat(String name, int birthYear, int numLives)
    {
        super(name, birthYear);
        this.numLives = numLives;
    }

    public Cat(String name, int birthYear)
    {
        this(name, birthYear, 9);
    }

    @Override
    public String toString()
    {
        return super.toString() + "\n I have " + numLives + " lives.";
    }
}
