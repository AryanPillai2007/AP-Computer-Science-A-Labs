public class Word
{
    private String word0;
    private int count1;

    public Word(String w)
    {
        word0 = w;
        count1 = 0;
    }

    public String getWord()
    {
        return word0;
    }

    public int getCount()
    {
        return count1;
    }

    public void increment()
    {
        count1++;
    }

    public String toString()
    {
        int countUp = count1 + 1;
        return word0 + "\t\t" + countUp;
    }

}
