public class GeoLocation {
   // Private Instance Variables

    public double latitude;
    public double longitude;

    // Constructors

    public GeoLocation(double lati, double longi)
    {
        latitude = lati;
        longitude = longi;
    }
    public String toString(){
        return "Latitude: " + latitude + "Longitude: " + longitude;
    }

    public double distanceTo(Place location1)
    {
        double lat1 = Math.toRadians(latitude);
        double long1 = Math.toRadians(longitude);
        double lat2 = Math.toRadians(location1.latitude);
        double long2 = Math.toRadians(location1.longitude);

        double theCos = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) *
                Math.cos(lat2) * Math.cos(long1 - long2);
        double arcLength = Math.acos(theCos);
        return arcLength * 3963.1676;

    }



}
