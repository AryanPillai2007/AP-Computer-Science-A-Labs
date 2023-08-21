public class RunGoal implements Goal
{

    public boolean hasWon(int[] hand)
    {
        //Below: a clever method for detecting a run in arbitrary order
        //see if you can figure out how it works
        //alternative: simply sorting the array first (but will be slower for large arrays)

        int[] freqs = new int[10];

        for (int i = 0; i < hand.length; i++)
            freqs[hand[i]]++;

        int count = 0;
        int low   = 0;

        while (freqs[low] == 0)
            low++;

        for (int i = 1; i < hand.length; i++)
            if (low + i >= 10 || freqs[low + i] != 1)
                return false;

        return true;
    }
}