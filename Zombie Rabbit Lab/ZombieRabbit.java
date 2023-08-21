import java.util.List;

public class ZombieRabbit implements Actor
{
    public Field getField() {
        return field;
    }

    public Location getLocation() {
        return location;
    }

    private Field    field;
    private Location location;

    public ZombieRabbit(Field field, Location location)
    {
        this.field = field;
        this.location = location;
    }

    @Override
    public void act()
    {
        Location l = findFood();
        if(l != null)
        {
            getField().move(this.location, l);
            location = l;
        }
    }

    @Override
    public boolean isActive() {return true;}

    @Override
    public void remove() {}

    private Location findFood()
    {
        List<Location> adjacentLocations = field.adjacentLocations(location);

        for (Location where : adjacentLocations) //look for Rabbits in adjacent locations
        {
            Object o = getField().getObjectAt(where);

            if (o instanceof Fox)
            {
                Animal animal = (Animal)o;
                animal.remove();

                return where;
            }
            else if(o instanceof Rabbit && (Math.random() < 0.6969))
            {
                Rabbit r = (Rabbit)o;
                Location l = r.getLocation();
                r.remove();

                ZombieRabbit raby = new ZombieRabbit(getField(), l);
                getField().place(raby, l);

            }
        }
        return getField().freeAdjacentLocation(getLocation());
    }
}
