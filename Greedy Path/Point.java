public class Point
{
    private double x;
    private double y;
    private boolean visited;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Point(double a, double b, boolean v)
    {
        x = a;
        y = b;
        visited = v;
    }

    public void setVisited(boolean v)
    {
        visited = v;
    }

    public boolean getVisited()
    {
        return visited;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getDistance(Point other)
    {
        double xDist = Math.pow((other.getX()-x),2);
        double yDist = Math.pow((other.getY()-y),2);
        double dist = Math.sqrt(xDist + yDist);
        return dist; //replace
    }

    @Override
    public String toString()
    {
        String g = "X Coordinate: " + x + " Y Coordinate: " + y;
        String y = "";
        if (visited)
        {
            y = "\nIt has been visited";
        }
        else
        {
            y = "\nIt has not been visited.";
        }
        return g+y;
    }
}