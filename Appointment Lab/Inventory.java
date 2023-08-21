import java.beans.VetoableChangeListener;
import java.util.ArrayList;

public class Inventory
{
    ArrayList<Vehicle> vehicleLot;

    public Inventory()
    {
        vehicleLot = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle v)
    {
        vehicleLot.add(v);
    }

    public void listInventory()
    {
        for (Vehicle v : vehicleLot)
        {
            v.getInfo();
        }
    }
}
