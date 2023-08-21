public class Vehicle
{
    private String type;
    private int year;
    private double price;

    public Vehicle(String t, int y, double p)
    {
        type = t;
        year = y;
        price = p;
    }

    public double getPrice()
    {
        return price;
    }

    public int getYear()
    {
        return year;
    }

    public String getType()
    {
        return type;
    }

    public String getInfo()
    {
        return year + " " + type;
    }
}
