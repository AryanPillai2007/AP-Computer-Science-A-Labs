import java.util.*;

public class House
{
    ArrayList<Animal> animals = new ArrayList<>();

    public void add(Animal a)
    {
        animals.add(a);
    }

    public void printAnimals()
    {
        for(Animal a : animals)
        {
            System.out.print(a + "\n");
        }
    }

    public void cleanHouse()
    {
        for (Animal a : animals)
        {
            ArrayList<Toy> toys = a.getToys();

            for(int i = 0; i < toys.size(); i++)
            {
                while(toys.indexOf(toys.get(i)) != toys.lastIndexOf(toys.get(i)))
                {
                    toys.remove(toys.lastIndexOf(toys.get(i)));
                }
            }
        }

    }
}
