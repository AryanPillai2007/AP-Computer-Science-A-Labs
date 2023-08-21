
public class Location
{
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	private int row;
	private int col;

	/**
	 * Represent a row and column.
	 * @param row The row.
	 * @param col The column.
	 */
	public Location(int row, int col)
	{
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString()
	{
		return "<" + row + ", " + col + ">";
	}

	@Override
	public boolean equals(Object o)
	{
		Location other = (Location) o;

		if(row == other.row && col == other.col)
		{
			return true;
		}

		return false;
	}

	
	@Override
	public int hashCode()
	{
		//don't mess with this
		return (row << 16) + col;
	}
}
