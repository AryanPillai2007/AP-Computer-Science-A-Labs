import java.awt.Color;
import java.io.IOException;


public class DrawPath
{
    public static void main(String [] args) throws IOException
    {
        final String file = "usa13509.txt";

        GreedyPath p = new GreedyPath(file);

        final int delayMs = 1;

        double minX = p.getMinX();
        double minY = p.getMinY();

        double maxX = p.getMaxX();
        double maxY = p.getMaxY();

        StdDraw.setXscale(minX, maxX);
        StdDraw.setYscale(minY, maxY);

        final int N = p.getNumPoints();

        double lastX = p.getPoint(0).getX();
        double lastY = p.getPoint(0).getY();

        double t = 0.0;
        double deltaT = 1.0 / (N - 2);

        StdDraw.show(delayMs);
        for (int i = 1; i < N; i++)
        {
            double x = p.getPoint(i).getX();
            double y = p.getPoint(i).getY();

            double r = (1 - t);
            double b = (t);
            StdDraw.setPenColor(new Color((float) r, 0.0f, (float) b));

            StdDraw.line(lastX, lastY, x, y);

            if (delayMs > 0)
                StdDraw.show(delayMs);

            lastX = x;
            lastY = y;

            t += deltaT;
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        double totalDistance = p.getDistance();
        StdDraw.textLeft(minX, maxY * 1.02, "Distance: " + totalDistance);

        StdDraw.show(0);
    }
}