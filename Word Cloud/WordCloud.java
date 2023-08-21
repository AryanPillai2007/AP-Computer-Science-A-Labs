import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCloud
{
    private ArrayList<Word> words;

    private ArrayList<Word> topHits;

    private int totalWords;

    private int uniqueWords;

    public WordCloud(String fileName) throws FileNotFoundException
    {
        words = new ArrayList<>();
        topHits = new ArrayList<>();
        totalWords = 0;
        uniqueWords = 0;
        load(fileName);
    }

    private int getIndex(String str)
    {
        for(int i = 0; i < words.size(); i++) {
            if(words.get(i).getWord().equals(str))
     {
                return i;
            }
        }

        return -1;
    }

    private void load(String fileName) throws FileNotFoundException
    {
        Scanner s = new Scanner(new File(fileName));

        while(s.hasNext())
        {
            String toAdd = s.next().toLowerCase();

            if(toAdd.equals("-"))
            {
                continue;
            }

            while(!Character.isLetterOrDigit(toAdd.charAt(0)))
            {
                toAdd = toAdd.substring(1);
            }
            while(!Character.isLetterOrDigit(toAdd.charAt(toAdd.length() - 1)))
            {
                toAdd = toAdd.substring(0, toAdd.length() - 1);
            }

            if(getIndex(toAdd) != -1)
            {
                words.get(getIndex(toAdd)).increment();
            }
            else
            {
                words.add(new Word(toAdd));
                uniqueWords ++;
            }

            totalWords ++;
        }

        findTopHits();
    }

    private void findTopHits()
    {
        for(int i = 0; i < 30; i++)
        {
            int max = words.get(0).getCount();
            int ind = -1;

            for(int j = 1; j < words.size(); j++)
            {
                if(words.get(j).getCount() > max)
                {
                    max = words.get(j).getCount();
                    ind = j;
                }
            }

            topHits.add(words.get(ind));
            words.remove(ind);
        }
    }

    public ArrayList<Word> getTopHits()
    {
        return topHits;
    }

    public void printInfo()
    {
        System.out.println();
        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words: " + uniqueWords);
        System.out.println();
        System.out.println();

        for(int i = 0; i < topHits.size(); i++)
        {
            System.out.println((i + 1) + ")" + "\t" + topHits.get(i).toString());
        }
    }

}
