public class AllSameGoal implements Goal
{

    private int c;

    public AllSameGoal(int c)
    {
        this.c = c;
    }

    public boolean hasWon(int[] hand)
    {
        for (int i = 0; i<hand.length; i++)
        {
            if(hand[i] != c)
            {
                return false;
            }

        }
        return true;
    }

}