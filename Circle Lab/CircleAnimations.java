import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircleAnimations {
    private ArrayList < Circle > circles; //the circles to animate
    private int size; //canvas width and height (will be square)
    private Random rng; //use to make random numbers

    /** create a drawing pane of a particular size */
    public CircleAnimations(int s) {
        circles = new ArrayList < > ();
        size = s;
        rng = new Random();

        //don't mess with this
        StdDraw.setCanvasSize(size, size); //set up drawing canvas
        StdDraw.setXscale(0, size); //<0, 0> is bottom left.  <size-1, size-1> is top right
        StdDraw.setYscale(0, size);
    }

    void drawCircles() {
        for (Circle c: circles) {
            c.draw();
        }
    }

    void addCircles() {
        for (int i = 0; i < 3; i++) {
            circles.add(new Circle(rng.nextInt(size), rng.nextInt(size), rng.nextInt(10, 75), new Color(rng.nextInt(0, 256), rng.nextInt(0, 256), rng.nextInt(0, 256))));
        }
    }

    void addCircles(int num) {
        for (int i = 0; i < num; i++) {
            int r = rng.nextInt(10, 75);
            circles.add(new Circle(rng.nextInt(r, size - r), rng.nextInt(r, size - r), r, new Color(rng.nextInt(0, 256), rng.nextInt(0, 256), rng.nextInt(0, 256))));
        }
    }

    void noOverlapping(int num) {
        for (int i = 0; i < num; i++) {
            Circle test = new Circle(rng.nextInt(size), rng.nextInt(size), rng.nextInt(1, 75), new Color(rng.nextInt(0, 256), rng.nextInt(0, 256), rng.nextInt(0, 256)));;

            if (!overlap(test)) {
                circles.add(test);
                continue;
            }

            while (overlap(test)) {
                test = new Circle(rng.nextInt(size), rng.nextInt(size), rng.nextInt(1, 75), new Color(rng.nextInt(0, 256), rng.nextInt(0, 256), rng.nextInt(0, 256)));
            }

            circles.add(test);
        }
    }

    boolean overlap(Circle c) {
        for (Circle cir: circles) {
            if (cir.overlaps(c)) {
                return true;
            }
        }

        return false;
    }

    void movingCircles() {
        addCircles(100);

        for (int i = 0; i < circles.size(); i++) {
            circles.get(i).setDX(rng.nextInt(1, 6));
            circles.get(i).setDY(rng.nextInt(1, 6));
        }

        while (true) {
            drawCircles();

            for (int i = 0; i < circles.size(); i++) {
                circles.get(i).update();
            }

            removeClicked();
            StdDraw.show(10);
            StdDraw.clear();
        }
    }

    void removeClicked() {
        for (int i = 0; i < circles.size(); i++) {
            if (StdDraw.isMousePressed() && circles.get(i).overlaps((int) StdDraw.mouseX(), (int) StdDraw.mouseY())) {
                circles.remove(circles.get(i));
                i--;
            }
        }
    }

}