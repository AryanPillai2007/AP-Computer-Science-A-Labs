public class main {
    public static void main(String[] args) {
        GeoLocation location = new GeoLocation(33.123961, -96.798735);
        String addressA = location.toString();
        System.out.println(addressA);
        Place PlaceA = new Place("FISD", "Address", location);
        String AddressB = PlaceA.toString();
        System.out.println(AddressB);

        GeoLocation location1 = new GeoLocation(33.139220, -96.742690);
        String addressB = location1.toString();
        System.out.println(addressB);
        Place PlaceB = new Place("LibertyHigh", "Address1", location1.latitude, location1.longitude);
        String AddressC = PlaceB.toString();
        System.out.println(AddressC);

        System.out.println("");
        double GeoDistance;
        GeoDistance = PlaceA.distanceTo(PlaceB);
        System.out.println(GeoDistance);


    }
}
