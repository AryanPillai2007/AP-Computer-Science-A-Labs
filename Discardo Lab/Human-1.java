import java.util.*;

public class Human
{
    private static final Scanner userInput = new Scanner(System.in);

    private int[] hand;

    public void init(int[] h, Goal g)
    {
        hand = h;
    }

    public void maybeReplaceCard(int cardDrawn)
    {
        System.out.println("Card Drawn:  " + cardDrawn);
        System.out.print("Which card to discard?  ");
        while (true)
        {
            String line = userInput.nextLine();
            try
            {
                int value = Integer.parseInt(line);
                if (value == cardDrawn)
                {
                    System.out.println("--------------------------------------------------");
                    return;
                }
                for (int i = 0; i < hand.length; i++)
                {
                    if (hand[i] == value)
                    {
                        hand[i] = cardDrawn;
                        System.out.println("--------------------------------------------------");
                        return;
                    }
                }
            }
            catch(NumberFormatException e)
            {
            }
        }
    }
}