import java.awt.*;
import java.util.*;

public class Circle {
    private int x, y;
    private int dx, dy;
    private int radius;
    Color color;

    public Circle(int bx, int by, int r, Color c) {
        x = bx;
        y = by;
        radius = r;
        color = c;
    }
    public Circle(int bx, int by, int ddx, int ddy, int r, Color c) {
        x = bx;
        y = by;
        dx = ddx;
        dy = ddy;
        radius = r;
        color = c;
    }
    void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, radius);
    }

    boolean overlaps(Circle other) {
        double dist = Math.sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y));

        double totalRad = radius + other.radius;

        if (dist < totalRad) {
            return true;
        }

        return false;
    }

    void setDX(int set) {
        dx = set;
    }

    void setDY(int set) {
        dy = set;
    }

    void update() {
        x += dx;
        y += dy;
        bounce();
    }

    void bounce() {
        if (x - radius < 0 || x + radius > 600) {
            dx *= -1;
            x += dx;
        }

        if (y - radius < 0 || y + radius > 600) {
            dy *= -1;
            y += dy;
        }
    }

    boolean overlaps(int yeex, int yeey) {
        double dist = Math.sqrt((x - yeex) * (x - yeex) + (y - yeey) * (y - yeey));

        double totalRad = 2 * radius;

        if (dist < totalRad) {
            return true;
        }

        return false;
    }
}