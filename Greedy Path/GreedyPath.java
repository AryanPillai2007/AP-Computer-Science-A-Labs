import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class GreedyPath extends Path
{
    private Point[] greedyPoints;
    private double distance;
    public GreedyPath(String fileName) throws IOException
    {
        super(fileName);
        findPath();
    }

    private void findPath()
    {
        greedyPoints = new Point[super.getNumPoints()];
        for (int i = 0; i < greedyPoints.length; i++)
        {
            greedyPoints[i] = super.getPoint(i);
        }

        Point[] pointsDup = greedyPoints;
        double minDis = -1;
        pointsDup[0] = greedyPoints[0];
        int counter = 0;
        int current = 0;
        int pInd = -1;

        for (int i = 0; i < pointsDup.length-1; i++)
        {
            counter = 0;
            minDis = -1;
            while (counter < pointsDup.length-1)
            {
                if (counter != current)
                {
                    if (pointsDup[counter].getVisited())
                    {
                    }
                    else
                    {
                        minDis = pointsDup[current].getDistance(pointsDup[counter]);
                        pInd = counter;
                    }
                    if (minDis == -1)
                    {
                        counter++;
                    }
                    else
                    {
                        counter = pointsDup.length-1;
                    }
                }
                else
                {
                    counter++;
                }
            }

            for (int x = 0; x < pointsDup.length-1; x++)
            {
                if (x != current)
                {
                    if (pointsDup[x].getVisited())
                    {
                    }
                    else if (pointsDup[current].getDistance(pointsDup[x]) < minDis)
                    {
                        pInd = x;
                        minDis = pointsDup[current].getDistance(pointsDup[x]);
                    }
                }
            }

            pointsDup[pInd].setVisited(true);
            current = pInd;
            greedyPoints[i+1] = pointsDup[current];
        }

        double pe = 0;
        for (int i = 0; i < greedyPoints.length-1; i++)
        {
            pe += greedyPoints[i].getDistance(greedyPoints[i+1]);
        }
        distance = pe;
    }

    @Override
    public double getDistance()
    {
        super.getDistance();
        return distance;
    }

    @Override
    public Point getPoint(int x)
    {
        return greedyPoints[x];
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nThis is a greedy path";
    }
}