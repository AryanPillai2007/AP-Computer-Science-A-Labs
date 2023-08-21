public class Dog extends Animal
{
    private boolean doggy;

    public Dog(String name, int birthYear, boolean g)
    {
        super(name, birthYear);
        doggy = g;
    }

    @Override
    public String toString()
    {
        String ret = super.toString();

        if(doggy)
        {
            ret += "I am a good boy!";
        }
        else
        {
            ret += "I am a bad boy >:(";
        }

        return ret;
    }
}
