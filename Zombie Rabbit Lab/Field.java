import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field
{    
	private int height, width;
	private Object[][] field;

	public Field(int height, int width)
	{
		this.width = width;
		this.height = height;

		field = new Object[height][width];
	}

	/** Empty the field */
	public void clear()
	{
		for(int i = 0; i < field.length; i++)
		{
			for(int j = 0; j < field[i].length; j++)
			{
				field[i][j] = null;
			}
		}
	}

	
	public void place(Object animal, int row, int col)
	{
		field[row][col] = animal;
	}

	
	public void place(Object animal, Location location)
	{
		place(animal, location.getRow(), location.getCol());
	}
	
	
	public void move(Location oldLocation, Location newLocation)
	{
		field[newLocation.getRow()][newLocation.getCol()] = field[oldLocation.getRow()][oldLocation.getCol()];
		remove(oldLocation);
	}
	
	
	public void remove(Location location)
	{
		field[location.getRow()][location.getCol()] = null;
	}
	
	
	public Object getObjectAt(Location location)
	{
		return getObjectAt(location.getRow(), location.getCol());
	}


	public Object getObjectAt(int row, int col)
	{
		return field[row][col];
	}

	
	public List<Location> adjacentLocations(Location location)
	{
		List<Location> locations = new ArrayList<>();

		int row = location.getRow();
		int col = location.getCol();

		int width = field[0].length;
		int height = field.length;

		for(int i = row - 1; i <= row + 1; i++)
		{
			for(int j = col - 1; j <= col + 1; j++)
			{
				if(i < 0 || i >= height || j < 0 || j >= width || (i == row && j == col))
				{
					continue;
				}

				locations.add(new Location(i, j));
			}
		}

		Collections.shuffle(locations);

		return locations;
	}

	
	public Location freeAdjacentLocation(Location location)
	{
		List<Location> l = adjacentLocations(location);
		List<Location> ret = new ArrayList<>();

		for(int i = 0; i < l.size(); i++)
		{
			int row = l.get(i).getRow();
			int col = l.get(i).getCol();

			if(field[row][col] == null)
			{
				ret.add(new Location(row, col));
			}
		}

		Collections.shuffle(ret);
		if(ret.size() >= 1)
		{
			return ret.get(0);
		}

		return null;
	}

	@Override
	public String toString() //quick picture of the state of the field, for debugging
	{
		String result = "";
		
		for (int r = 0; r < this.height; r++)
		{
			for (int c = 0; c < this.width; c++)
			{
				Object obj = this.field[r][c];
				
				if (obj instanceof Rabbit)
					result += "R\t";
				else if (obj instanceof Fox)
					result += "F\t";
				else
					result += "x\t";
			}
			result += "\n";
		}
		
		return result;
	}
	
	public int getHeight() { return this.height; }
	
	public int getWidth() { return this.width; }
}
