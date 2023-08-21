import java.util.*;

public class Discardo
{
    public static void main(String[] args)
    {
        Discardo.test();
    }

    public static void test()
    {
        //int numCards = 3;
        int numCards = 3;
        int numTurns = play(new Human(), numCards, new AllSameGoal(2));
        System.out.println("Player reached goal in " + numTurns + " turns");
    }

    public static int play(Human p, int numCards, Goal goal)
    {
        int[] hand = new int[numCards];

        for (int i = 0; i < hand.length; i++)
            hand[i] = randomCard();

        p.init(hand, goal);

        int numTurns = 0;

        while (numTurns < 100 && !goal.hasWon(hand))
        {
            System.out.println("Turns Taken:  " + numTurns);
            System.out.println("Hand:  " + Arrays.toString(hand));
            p.maybeReplaceCard(randomCard());
            numTurns++;
        }
        System.out.println("Turns Taken:  " + numTurns);
        System.out.println("Hand:  " + Arrays.toString(hand));

        return numTurns;
    }

    public static int randomCard()
    {
        return (int)(Math.random() * 9) + 1;
    }
}