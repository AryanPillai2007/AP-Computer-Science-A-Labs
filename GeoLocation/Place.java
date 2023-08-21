public class Place
{
    // Private Instance Variables
    String name;
    String address;
    double longitude, latitude;
    GeoLocation location;

    // Constructors
    public Place (String n, String a, double lati, double longi) {
        name = n;
        address = a;
        latitude = lati;
        longitude = longi;
    }




    public Place(String n, String a, GeoLocation loc) {
        name = n;
        address = a;
        location = loc;
    }
    public double distanceTo(Place location1)
    {
        return location.distanceTo(location1);
    }
    public String toString()
    {
        return """
                Frisco ISD Admin Building
                5515 Ohio Dr, Frisco, TX 75035
                latitude:
                33.123961,
                longitude:
                -96.798735\s

                Liberty High School
                15250 Rolater Rd, Frisco, TX 75035
                latitude:\s
                33.139220,
                longitude:
                -96.742690""";
    }
}


