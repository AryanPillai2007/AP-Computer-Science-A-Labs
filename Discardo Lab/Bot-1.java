public class Bot implements Player
{
    private int[] h;
    private Goal g;
    private Object AllSameGoal;

    public void init(int[]hand, Goal goal)
    {
        setH(hand);
        setG(goal);

    }

    public void maybeReplaceCard(int card)
    {
        if (g.instanceOf(AllSameGoal))
        {
            g = ((MultiGoal)g).firstGoal();

        }

    }

    public Goal getG() {
        return g;
    }

    public void setG(Goal g) {
        this.g = g;
    }

    public int[] getH() {
        return h;
    }

    public void setH(int[] h) {
        this.h = h;
    }


}