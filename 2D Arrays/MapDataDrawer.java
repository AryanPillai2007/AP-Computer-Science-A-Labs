import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MapDataDrawer
{
    /** the 2D array containing the elevations */
    private int[][] grid;

    /** constructor, parses input from the file into grid */
    public MapDataDrawer(String fileName) throws IOException
    {
        File file = new File(fileName);
        Scanner fileReader = new Scanner(file);
        grid = new int[fileReader.nextInt()][fileReader.nextInt()];
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                grid[r][c] = fileReader.nextInt();
            }
        }
    }

    /** @return the min value in the entire grid */
    public int findMin()
    {
        int min = grid[0][0];
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c <grid[r].length; c++)
            {
                if (min > grid[r][c])
                {
                    min = grid[r][c];
                }
            }
        }
        return min;
    }

    /** @return the max value in the entire grid */
    public int findMax()
    {
        int max = grid[0][0];
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                if (max < grid[r][c])
                {
                    max = grid[r][c];
                }
            }
        }
        return max;
    }

    /**
     * Draws the grid using the given Graphics object.
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */
    public void drawMap(Graphics g)
    {
        int max = findMax();
        int min = findMin();
        for (int r = 0; r < getRows(); r++)
        {
            for (int c = 0; c < getCols(); c++)
            {
                int difference = max - grid[r][c];
                int color = (int) (255 * ((double) grid[r][c] - min) / (max - min));
                g.setColor(new Color(color, color, color));
                g.fillRect(c, r, 1, 1);
            }
        }
    }

    /**
     * Find a path from West-to-East starting at given row.
     * Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawLowestElevPath(Graphics g, int row)
    {
        int greedyRow = row;
        int totalChange = 0;
        for (int c = 1; c < grid[greedyRow].length-1; c++)
        {
            if (greedyRow > 0 && greedyRow < grid.length-1)
            {
                int step1 = Math.abs(grid[greedyRow][c-1]-grid[greedyRow - 1][c]);
                int step2 = Math.abs(grid[greedyRow][c-1]-grid[greedyRow][c]);
                int step3 = Math.abs(grid[greedyRow][c-1]-grid[greedyRow + 1][c]);
                if (step1 < step2 && step1 < step3)
                {
                    totalChange += step1;
                    g.fillRect(c, greedyRow - 1, 1, 1);
                    greedyRow -= 1;
                }
                else if (step3 < step1 && step3 < step2) {
                    totalChange += step3;
                    g.fillRect(c, greedyRow + 1, 1, 1);
                    greedyRow += 1;
                }
                else
                {
                    totalChange += step2;
                    g.fillRect(c, greedyRow, 1, 1);
                }
            }
            else if (greedyRow == 0)
            {
                int step1 = Math.abs(grid[greedyRow][c-1]-grid[greedyRow][c]);
                int step2 = Math.abs(grid[greedyRow][c-1]-grid[greedyRow + 1][c]);
                if (step1 < step2)
                {
                    totalChange += step1;
                    g.fillRect(c, greedyRow - 1, 1, 1);
                }
                else
                {
                    totalChange += step2;
                    g.fillRect(c, greedyRow, 1, 1);
                    greedyRow+=1;
                }
            }
            else
            {
                int step1 = Math.abs(grid[greedyRow][c-1]-grid[greedyRow - 1][c]);
                int step2 = Math.abs(grid[greedyRow][c-1]-grid[greedyRow][c]);
                if (step2 < step1)
                {
                    totalChange += step1;
                    g.fillRect(c, greedyRow - 1, 1, 1);
                }
                else
                {
                    totalChange += step2;
                    g.fillRect(c, greedyRow, 1, 1);
                    greedyRow-=1;
                }
            }
        }
        return totalChange;
    }

    /** @return the index of the starting row for the lowest-elevation-change path in the entire grid. */
    public int indexOfLowestElevPath(Graphics g)
    {
        int bestRow = 0;
        int elevation = drawLowestElevPath(g,0);
        int length = grid.length;
        int width = grid[0].length;
        for (int x = 1; x < length; x++)
        {
            int difference = drawLowestElevPath(g, x);
            if (difference < elevation)
            {
                bestRow = x;
            }
        }

        return bestRow;
    }

    public int getRows()
    {

        return grid.length;
    }

    public int getCols()
    {

        return grid[0].length;
    }
}