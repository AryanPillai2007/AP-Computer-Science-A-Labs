import java.util.*;
public class Animal
{
    private String name;
    private int birthYear;
    private Animal friend;
    private ArrayList<Toy> toys = new ArrayList<>();
    static int currentYear = 2023;

    public Animal(String name, int birthYear)
    {
        this.name = name;
        this.birthYear = birthYear;
    }

    public int getAge()
    {
        return (currentYear - birthYear);
    }

    public ArrayList<Toy> getToys()
    {
        return toys;
    }

    public void addToy(Toy t)
    {
        toys.add(t);
    }

    public void setFriend(Animal f)
    {
        friend = f;
    }

    public String toString()
    {
        String ret = "Hello, I am " + name + ". I am " + getAge() + " years old. ";

        if(friend != null)
        {
            ret += "I have a friend named " + friend.name + ".";
        }
        else
        {
            ret += "I have no friends :( ";
        }

        ret += "\n I have the following toys: " + toys.toString() + ". ";

        return ret;
    }
}
