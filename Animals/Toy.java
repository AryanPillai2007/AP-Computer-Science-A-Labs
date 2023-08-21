public class Toy
{
    private String name;

    public Toy(String n)
    {
        name = n;
    }

    public String toString()
    {
        return "A " + name + ".";
    }

    @Override
    public boolean equals(Object obj)
    {
        Toy other = (Toy) obj;
        return name.equals(other.name);
    }
}
