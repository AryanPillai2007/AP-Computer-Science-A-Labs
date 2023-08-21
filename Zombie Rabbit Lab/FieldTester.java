public class FieldTester
{
    public static void main(String[] args)
    {
        Field    field  = new Field(4, 4);

        Location a      = new Location(0, 0); 
        Location b      = new Location(2, 2); 

        Rabbit   rabbit = new Rabbit(field, a);

        Fox      fox    = new Fox(field, b);

        field.place(rabbit, a); //place rabbit in field at <0, 0>
        field.place(fox, b);    //place fox in field at <2, 2>

        System.out.println("Initial field state:");
        System.out.println(field); 

        System.out.println("Adjacent locations:");
        System.out.println("Rabbit: " + field.adjacentLocations(a));
        System.out.println(field.freeAdjacentLocation(a)); 
        System.out.println("\nFox: " + field.adjacentLocations(b)); 
        System.out.println(field.freeAdjacentLocation(b));

        Location c = new Location(1, 1);

        System.out.println("\nManually move rabbit to <1, 1>:");
        field.move(rabbit.getLocation(), c); 
        rabbit.setLocation(c);

        System.out.println(field); 

        System.out.println("Rabbit runs:");
        rabbit.act();

        System.out.println(field); 
        System.out.println("Fox hunts:");
        fox.hunt();

        System.out.println(field);
    }
}
