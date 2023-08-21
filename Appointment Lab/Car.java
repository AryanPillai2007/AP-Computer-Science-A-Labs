public class Car extends Vehicle
{
    private double mpg;

    public Car(String t, int y, double p, double m)
    {
        super(t, y, p);
        mpg = m;
    }

    @Override
    public String getInfo()
    {
        return super.getInfo() + ", " + super.getPrice() + ", " + mpg + " mpg";
    }

    public boolean greatMPG()
    {
        if (mpg >= 36)
        {
            return true;
        }
        return false;
    }
}
