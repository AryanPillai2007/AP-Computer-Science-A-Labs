public class Animal implements Actor
{
    private int    BREEDING_AGE;
    private int    MAX_AGE;
    private double BREEDING_PROBABILITY;
    private int    MAX_LITTER_SIZE;
    private int      age;
    private boolean  alive;
    private Field    field;
    private Location location;

    public Animal(int breAge, int maxAge, double breProb, int maxSize, Field field, Location location)
    {
        BREEDING_AGE = breAge;
        MAX_AGE = maxAge;
        BREEDING_PROBABILITY = breProb;
        MAX_LITTER_SIZE = maxSize;

        this.field = field;
        this.location = location;
        this.age = 0;
        this.alive = true;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public Field getField() {
        return field;
    }

    public Location getLocation() {
        return location;
    }

    public void act(){}
    public boolean isActive() {return alive;}

    public void remove()
    {
        this.alive = false;
        field.remove(location);
    }

    public void incrementAge()
    {
        age++;

        if(age > MAX_AGE)
        {
            remove();
        }
    }

    public int breed()
    {
        if(canBreed() && Math.random() <= BREEDING_PROBABILITY)
        {
            return (int)(Math.random() * (MAX_LITTER_SIZE + 1));
        }
        return 0;
    }

    public boolean canBreed()
    {
        return (getAge() > BREEDING_AGE);
    }
}
