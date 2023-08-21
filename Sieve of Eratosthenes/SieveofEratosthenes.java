public class SieveofEratosthenes
{
    public static void main(String[]args)
    {
        int thousand = 1000;
        int two = 2;
        // These are the two variables, one represents 1000, the other 2. 
        while(two <= thousand)
        // While the number 2 is less of equal to the number of 1000, execute if loop.
        {
            if(two==2 || two==3 || two==5 || two==7)
            {
                System.out.print(two +" ");
                // If 2 is equal to 2, 3, 5, or 7, print the number associated. 
            }
            if(two%2!=0 && two%3!=0 && two%5!=0 && two%7!=0)
            {
                System.out.print(two + " ");
                // Modulo the remainder of the two numbers after division. 
                // Find the remainder of the 2 numbers, after the loops. 
            }
            two += 1;
            // Finally, at 1 to the number 2, and run the code again. 
        }
    }
}