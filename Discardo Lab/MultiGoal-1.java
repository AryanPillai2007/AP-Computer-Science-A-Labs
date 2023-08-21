import java.util.*;

public class MultiGoal implements Goal
{
    private List<Goal> goals;

    public MultiGoal()
    {
        goals = new ArrayList<>();
    }

    public boolean hasWon(int[] hand)
    {
        for (int i = 0; i<goals.size(); i++)
        {
            if(goals.get(i).hasWon(hand))
            {
                return true;
            }
        }

        return false;
    };