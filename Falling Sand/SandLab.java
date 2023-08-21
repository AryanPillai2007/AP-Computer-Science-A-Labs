import java.awt.*;
import java.util.*;

public class SandLab {
    public static void main(String[] args) {
        SandLab lab = new SandLab(120, 80);
        lab.run();
    }

    public static final int EMPTY = 0;
    public static final int METAL = 1;
    public static final int SAND = 2;
    public static final int WATER = 3;
    public static final int ACID = 4;

    private int[][] grid;
    private SandDisplay display;

    public SandLab(int numRows, int numCols) {
        String[] names;
        names = new String[5];
        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
        names[SAND] = "Sand";
        names[WATER] = "Water";
        names[ACID] = "Acid";
        display = new SandDisplay("Falling Sand", numRows, numCols, names);
        grid = new int[numRows][numCols];

    }

    private void locationClicked(int row, int col, int tool) {
        grid[row][col] = tool;
    }

    public void updateDisplay() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Color color = null;
                if (grid[i][j] == EMPTY) {
                    color = new Color(0, 0, 0);
                } else if (grid[i][j] == METAL) {
                    color = new Color(128, 128, 128);
                } else if (grid[i][j] == SAND) {
                    color = new Color(255, 255, 0);
                } else if (grid[i][j] == WATER) {
                    color = new Color(51, 152, 255);
                } else if (grid[i][j] == ACID) {
                    color = new Color(67, 255, 0);
                } else {
                    color = new Color(0, 0, 0);
                }
                display.setColor(i, j, color);
            }
        }
    }

    public void step() {
        int randomRow = new Random().nextInt(grid.length);
        int randomColumn = new Random().nextInt(grid[0].length);
        int randomLocation = grid[randomRow][randomColumn];
        if (randomLocation == SAND) {
            if (randomRow < grid.length - 1) {
                int belowLocation = grid[randomRow + 1][randomColumn];
                if (belowLocation == EMPTY) {
                    moveDown(randomRow, randomColumn, EMPTY, SAND, EMPTY);
                }
                if (belowLocation == WATER) {
                    moveDown(randomRow, randomColumn, WATER, SAND, WATER);
                }
                if (belowLocation == ACID) {
                    moveDown(randomRow, randomColumn, EMPTY, ACID, ACID);
                }
            }
        } else if (randomLocation == WATER) {
            int direction = new Random().nextInt(3);
            if (direction == Direction.DOWN.ordinal()) {
                moveDown(randomRow, randomColumn, EMPTY, WATER, EMPTY);
                moveDown(randomRow, randomColumn, EMPTY, ACID, ACID);
            } else if (direction == Direction.LEFT.ordinal()) {
                moveLeft(randomRow, randomColumn, EMPTY, WATER, EMPTY);
                moveLeft(randomRow, randomColumn, EMPTY, ACID, ACID);
            } else if (direction == Direction.RIGHT.ordinal()) {
                moveRight(randomRow, randomColumn, EMPTY, WATER, EMPTY);
                moveRight(randomRow, randomColumn, EMPTY, ACID, ACID);
            }

        } else if (randomLocation == ACID) {
            int direction = new Random().nextInt(3);
            if (direction == Direction.DOWN.ordinal()) {
                moveDown(randomRow, randomColumn, EMPTY, ACID, EMPTY);
                moveDown(randomRow, randomColumn, EMPTY, ACID, METAL);
                moveDown(randomRow, randomColumn, EMPTY, ACID, WATER);
                moveDown(randomRow, randomColumn, EMPTY, ACID, SAND);
            } else if (direction == Direction.LEFT.ordinal()) {
                moveLeft(randomRow, randomColumn, EMPTY, ACID, EMPTY);
                moveLeft(randomRow, randomColumn, EMPTY, ACID, METAL);
                moveLeft(randomRow, randomColumn, EMPTY, ACID, WATER);
                moveLeft(randomRow, randomColumn, EMPTY, ACID, SAND);
            } else if (direction == Direction.RIGHT.ordinal()) {
                moveRight(randomRow, randomColumn, EMPTY, ACID, EMPTY);
                moveRight(randomRow, randomColumn, EMPTY, ACID, METAL);
                moveRight(randomRow, randomColumn, EMPTY, ACID, WATER);
                moveRight(randomRow, randomColumn, EMPTY, ACID, SAND);
            }
        }
    }

    private void moveDown(int randomRow, int randomColumn, int fromLocation, int toLocation, int nextLocationType) {
        if (randomRow < grid.length - 1) {
            int belowLocation = grid[randomRow + 1][randomColumn];
            if (belowLocation == nextLocationType) {
                grid[randomRow][randomColumn] = fromLocation;
                grid[randomRow + 1][randomColumn] = toLocation;
            }
        }
    }

    private void moveUp(int randomRow, int randomColumn, int fromLocation, int toLocation, int nextLocationType) {
        if (randomRow > 0) {
            int topLocation = grid[randomRow - 1][randomColumn];
            if (topLocation == nextLocationType) {
                grid[randomRow][randomColumn] = fromLocation;
                grid[randomRow - 1][randomColumn] = toLocation;
            }
        }
    }

    private void moveLeft(int randomRow, int randomColumn, int fromLocation, int toLocation, int nextLocationType) {
        if (randomColumn > 0) {
            int leftLocation = grid[randomRow][randomColumn - 1];
            if (leftLocation == nextLocationType) {
                grid[randomRow][randomColumn] = fromLocation;
                grid[randomRow][randomColumn - 1] = toLocation;
            }
        }
    }

    private void moveRight(int randomRow, int randomColumn, int fromLocation, int toLocation, int nextLocationType) {
        if (randomColumn < grid[0].length - 1) {
            int rightLocation = grid[randomRow][randomColumn + 1];
            if (rightLocation == nextLocationType) {
                grid[randomRow][randomColumn] = fromLocation;
                grid[randomRow][randomColumn + 1] = toLocation;
            }
        }
    }

    public void run() {
        while (true) {
            for (int i = 0; i < display.getSpeed(); i++)
                step();
            updateDisplay();
            display.repaint();
            display.pause(1);
            int[] mouseLoc = display.getMouseLocation();
            if (mouseLoc != null)
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
        }
    }

    enum Direction {
        DOWN, LEFT, RIGHT, TOP
    }
}