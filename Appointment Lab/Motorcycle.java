public class Motorcycle extends Vehicle
{
    private int elevationOnWheelie;

    public Motorcycle(String t, int y, double p, int eOw)
    {
        super(t, y, p);
        elevationOnWheelie = eOw;
    }

    @Override
    public String getInfo()
    {
        return super.getInfo() + ", " + super.getPrice() + ", " + elevationOnWheelie + " mpg";
    }

    public boolean dangerous()
    {
        if (elevationOnWheelie >= 45)
        {
            return true;
        }
        return false;
    }
}
