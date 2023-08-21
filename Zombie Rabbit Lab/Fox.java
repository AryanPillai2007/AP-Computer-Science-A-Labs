import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fox extends Animal
{
	private static final int    RABBIT_FOOD_VALUE = 8;

	private int      foodLevel;

	public Fox(Field field, Location location)
	{
		super(10, 20, 0.77, 4, field, location);
		this.foodLevel = RABBIT_FOOD_VALUE;
	}

	public void hunt()
	{
		Location ff = findFood();
		Location l = getField().freeAdjacentLocation(getLocation());
		if(ff != null)
		{
			getField().move(getLocation(), ff);
			setLocation(ff);
		}
		else if (l != null)
		{
			getField().move(getLocation(), l);
			setLocation(l);
		}
		else
		{
			remove();
		}
	}

	private void incrementHunger()
	{
		foodLevel --;

		if(foodLevel <= 0)
		{
			remove();
		}
	}

	private Location findFood()
	{
		List<Location> adjacentLocations = getField().adjacentLocations(getLocation());

		for (Location where : adjacentLocations) //look for Rabbits in adjacent locations
		{
			Object animal = getField().getObjectAt(where);

			if (animal instanceof Rabbit) { //if this object is a rabbit...
				Rabbit rabbit = (Rabbit) animal;

				rabbit.remove();

				this.foodLevel = Fox.RABBIT_FOOD_VALUE; //Foxes goes back to full

				return where;
			}
		}
		return null;
	}

	public void act()
	{
		incrementAge();
		incrementHunger();
		hunt();

		if(!isActive())
		{
			getField().remove(getLocation());
			return;
		}

		for(int i = 0; i < breed(); i++)
		{
			Location l = getField().freeAdjacentLocation(getLocation());
			if(l != null)
			{
				Fox f = new Fox(getField(), l);
				getField().place(f, l);
			}
		}
	}
}
