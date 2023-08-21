public interface Player
{
    /**
     *  init is called once when the game begins.
     *  hand is the array of cards dealt.
     *  goal is the condition to reach in order to end the game.
     */
    void init(int[] hand, Goal goal);

    /**
     *  called once per turn.
     *  card is the value (1 - 9) drawn.
     *  this method must either:
     *    (a) leave the array unchanged, or
     *    (b) replace exactly one element of the array with card.
     */
    void maybeReplaceCard(int card);
}