public class Truck extends Vehicle
{
    private int towing;

    public Truck(String t, int y, double p, int tw)
    {
        super(t, y, p);
        towing = tw;
    }

    @Override
    public String getInfo()
    {
        return super.getInfo() + ", " + super.getPrice() + ", " + towing + " towing";
    }

    public boolean greatMPG()
    {
        if (towing >= 2000)
        {
            return true;
        }
        return false;
    }
}
