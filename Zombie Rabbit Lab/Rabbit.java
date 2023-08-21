import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rabbit extends Animal
{
	/* Characteristics shared by all rabbits (static fields). */

	private static double CHANCE_FOR_ZOMBIE = 0.001;
	public Rabbit(Field field, Location location)
	{
		super(5, 15, 0.22, 6, field, location);
	}

	public void act()
	{
		incrementAge();

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
				if(Math.random() <= CHANCE_FOR_ZOMBIE)
				{
					ZombieRabbit r = new ZombieRabbit(getField(), l);
					getField().place(r, l);
					CHANCE_FOR_ZOMBIE = -1;
				}
				else
				{
					Rabbit r = new Rabbit(getField(), l);
					getField().place(r, l);
				}
			}
		}

		Location l = getField().freeAdjacentLocation(getLocation());
		if(l != null)
		{
			getField().move(getLocation(), l);
			setLocation(l);
		}
		else
		{
			remove();
		}
	}

	@Override
	public String toString()
	{
		return "Rabbit, " + getAge() + " y/o, at " + getLocation();
	}
}
