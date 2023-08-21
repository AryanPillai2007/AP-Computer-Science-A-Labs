import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

/**
 * A class that represents a picture made up of a rectangle of {@link Pixel}s
 */
public class Picture {

    /** The 2D array of pixels that comprise this picture */
    private Pixel[][] pixels;
    private Picture Pic;

    /**
     * Creates a Picture from an image file in the "images" directory
     * @param picture The name of the file to load
     */
    public Picture(String picture) {
        File file = new File("./images/"+picture);
        BufferedImage image;
        if (!file.exists()) throw new RuntimeException("No picture at the location "+file.getPath()+"!");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        pixels = new Pixel[image.getHeight()][image.getWidth()];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                int rgb = image.getRGB(x, y);
                /*
                 * For the curious - BufferedImage saves an image's RGB info into a hexadecimal integer
                 * The below extracts the individual values using bit-shifting and bit-wise ANDing with all 1's
                 */
                pixels[y][x] = new Pixel((rgb>>16)&0xff, (rgb>>8)&0xff, rgb&0xff);
            }
        }
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param red The red value of the color
     * @param green The green value of the color
     * @param blue The blue value of the color
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int red, int green, int blue, int height, int width) {
        pixels = new Pixel[height][width];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                pixels[y][x] = new Pixel(red, green, blue);
            }
        }
    }

    /*
     * Creates a solid white Picture of a given width and height
     * @param color The {@link Color} of the Picture
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int height, int width) {
        this(Color.WHITE, height, width);
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param color The {@link Color} of the Picture
     * @param width The width of the Picture
     * @param height The height of the Picture
     */
    public Picture(Color color, int height, int width) {
        this(color.getRed(), color.getGreen(), color.getBlue(), height, width);
    }

    /**
     * Creates a Picture based off of an existing {@link Pixel} 2D array
     * @param pixels A rectangular 2D array of {@link Pixel}s. Must be at least 1x1
     */
    public Picture(Pixel[][] pixels) {
        if (pixels.length==0 || pixels[0].length==0) throw new RuntimeException("Can't have an empty image!");
        int width = pixels[0].length;
        for (int i = 0; i<pixels.length; i++) if (pixels[i].length!=width)
            throw new RuntimeException("Pictures must be rectangles. pixels[0].length!=pixels["+i+"].length!");
        this.pixels = new Pixel[pixels.length][width];
        for (int i = 0; i<pixels.length; i++) {
            for (int j = 0; j<pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel(pixels[i][j].getColor());
            }
        }
    }

    /**
     * Creates a Picture based off of an existing Picture
     * @param picture The Picture to copy
     */
    public Picture(Picture picture) {
        this(picture.pixels);
    }

    /**
     * Gets the width of the Picture
     * @return The width of the Picture
     */
    public int getWidth() {
        return pixels[0].length;
    }

    /**
     * Gets the height of the Picture
     * @return The height of the Picture
     */
    public int getHeight() {
        return pixels.length;
    }

    /**
     * Gets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @return The {@link Pixel} at the given location
     */
    public Pixel getPixel(int x, int y) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        return pixels[y][x];
    }

    /**
     * Sets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @param pixel The new {@link Pixel}
     */
    public void setPixel(int x, int y, Pixel pixel) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        if (pixel==null) throw new NullPointerException("Pixel is null"); //guard is required because pixel's value isn't used in this method
        pixels[y][x] = pixel;
    }

    /**
     * Opens a {@link PictureViewer} to view this Picture
     * @return the {@link PictureViewer} viewing the Picture
     */
    public PictureViewer view() {
        return new PictureViewer(this);
    }

    /**
     * Return the 2D array of pixels that comprise this Picture
     * You can save a reference to a Picture's pixels with the following:
     * Pixel[][] pixels = pic.getPixels(); //for a Picture object called pic
     * @return 2D array of pixels that make up this Picture
     */
    public Pixel[][] getPixels() {
        return pixels;
    }

    /********************************************************
     *************** STUDENT METHODS BELOW ******************
     ********************************************************/

    /** remove all blue tint from a picture */
    public void zeroBlue()
    {
        //TODO
        int c = getHeight();
        int r = getWidth();
        for (int x = 0; x < r; x++){
            for (int y = 0; y < c; y++){
                pixels[y][x].setBlue(0);
            }
        }
    }

    /** remove everything BUT blue tint from a picture */
    public void keepOnlyBlue()
    {
        //TODO
        int c = getHeight();
        int r = getWidth();
        for (int x = 0; x < r; x++){
            for (int y = 0; y < c; y++){
                pixels[y][x].setRed(0);
                pixels[y][x].setGreen(0);
            }
        }
    }

    /** invert a picture's colors */
    public void negate()
    {
        //TODO
        int c = getHeight();
        int r = getWidth();
        for (int x = 0; x < r; x++){
            for (int y = 0; y < c; y++){

                pixels[y][x].setBlue(255-pixels[y][x].getBlue());
                pixels[y][x].setRed(255-pixels[y][x].getRed());
                pixels[y][x].setGreen(255-pixels[y][x].getGreen());

            }
        }
    }

    /** simulate the over-exposure of a picture in film processing */
    public void solarize(int i)
    {
        //TODO
        int c = getHeight();
        int r = getWidth();

        for (int x = 0; x < r; x++){
            for (int y = 0; y < c; y++){
                if (pixels[y][x].getBlue() < i) {
                    pixels[y][x].setBlue(255 - pixels[y][x].getBlue());
                }
                if (pixels[y][x].getRed() < i){
                    pixels[y][x].setRed(255 - pixels[y][x].getRed());
                }
                if(pixels[y][x].getGreen()<i) {
                    pixels[y][x].setGreen(255 - pixels[y][x].getGreen());
                }


            }
        }
    }

    /** convert an image to grayscale */
    public void grayscale()
    {
        //TODO
        int c = getHeight();
        int r = getWidth();
        int average = 0;
        for (int x = 0; x < r; x++){
            for (int y = 0; y < c; y++){
                average = (pixels[y][x].getBlue()+pixels[y][x].getRed()+pixels[y][x].getGreen())/3;
                pixels[y][x].setBlue(average);
                pixels[y][x].setRed(average);
                pixels[y][x].setGreen(average);
            }
        }
    }



    /** change the tint of the picture by the supplied coefficients */
    public void tint(double red, double blue, double green)
    {
        //TODO
        int c = getHeight();
        int r = getWidth();
        for (int x = 0; x < r; x++){
            for (int y = 0; y < c; y++) {
                if ((int)(pixels[y][x].getBlue() *blue)>255){
                    pixels [y][x].setBlue(255);
                }
                else {
                    pixels[y][x].setBlue((int) (pixels[y][x].getBlue()*blue));
                }
                if ((int)(pixels[y][x].getRed() *red)>255){
                    pixels [y][x].setRed(255);
                }
                else {
                    pixels[y][x].setRed((int) (pixels[y][x].getRed()*red));
                }
                if ((int)(pixels[y][x].getGreen() *green)>255){
                    pixels [y][x].setGreen(255);
                }
                else {
                    pixels[y][x].setGreen((int) (pixels[y][x].getGreen()*green));
                }
            }
        }

    }

    /** reduces the number of colors in an image to create a "graphic poster" effect */
    public void posterize(int span)
    {
        //TODO
        int c = getHeight();
        int r = getWidth();
        for (int x = 0; x < r; x++){
            for (int y = 0; y < c; y++){
                pixels[y][x].setBlue(pixels[y][x].getBlue()/span*span);
                pixels[y][x].setRed(pixels[y][x].getRed()/span*span);
                pixels[y][x].setGreen(pixels[y][x].getGreen()/span*span);
            }
        }
    }


    /** mirror an image about a vertical midline, left to right */
    public void mirrorVertical()
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < width / 2; c++)
            {
                leftPixel  = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** mirror about a vertical midline, right to left */
    public void mirrorRightToLeft()
    {
        //TODO
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < width / 2; c++)
            {
                leftPixel  = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                leftPixel.setColor(rightPixel.getColor());
            }
        }

    }

    /** mirror about a horizontal midline, top to bottom */
    public void mirrorHorizontal()
    {
        //TODO
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int length = pixels.length;

        for (int r = 0; r < length/2; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
                leftPixel  = pixels[length-r-1][c];
                rightPixel = pixels[r][c];


                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /** flip an image upside down about its bottom edge */
    public void verticalFlip()
    {
        //TODO
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int length = pixels.length;

        for (int r = 0; r < length/2; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
                leftPixel  = pixels[length-r-1][c];
                rightPixel = pixels[r][c];
                Color color = rightPixel.getColor();
                Color color2 = leftPixel.getColor();
                rightPixel.setColor(color2);
                leftPixel.setColor(color);

            }
        }
    }


    /** fix roof on greek temple */
    public void fixRoof()
    {
        //TODO
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < width / 2; c++)
            {
                leftPixel  = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** detect and mark edges in an image */
    public void edgeDetection(int dist)
    {
        //TODO
        Pixel leftPixel = null;
        Pixel rightPixel = null;

        Color rightColor = null;
        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[0].length-1; c++)
            {
                leftPixel = pixels[r][c];
                rightPixel = pixels[r][c+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > dist) {
                    leftPixel.setColor(Color.BLACK);
                }
                else {
                    leftPixel.setColor(Color.WHITE);
                }
            }
        }
    }


    /** copy another picture's pixels into this picture, if a color is within dist of param Color */
    public void chromakey(Picture other, Color color, int dist)
    {
        //TODO
        Pixel [][] oPic = other.getPixels();
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                if(pixels[r][c].colorDistance(color)<dist){
                    pixels[r][c].setColor(oPic[r][c].getColor());
                }

            }
        }
    }

    /** steganography encode (hide the message in msg in this picture) */
    public void encode(Picture msg)
    {
        for (Pixel[] pixel : pixels) {
            for (Pixel value : pixel) {
                if (value.getRed() % 2 != 0) {

                    value.setRed(value.getRed() - 1);
                }
            }
        }
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[r].length; c++) {
                double num = msg.getPixel(c,r).colorDistance(Color.BLACK);
                if(num == 0)
                {
                    pixels[r][c].setRed(pixels[r][c].getRed()+1);
                }
            }
        }
    }

    /** steganography decode (return a new Picture containing the message hidden in this picture) */
    public Picture decode()
    {
        //TODO
        Picture beach = new Picture(Pic);
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[r].length; c++) {
                if(pixels[r][c].getRed() % 2 != 0)
                {
                    beach.pixels[r][c].setRed(0);
                    beach.pixels[r][c].setBlue(0);
                    beach.pixels[r][c].setGreen(0);
                } else {
                    beach.pixels[r][c].setRed(255);
                    beach.pixels[r][c].setBlue(255);
                    beach.pixels[r][c].setGreen(255);
                } }
        }
        return beach;

        //REPLACE
    }

    /** perform a simple blur using the colors of neighboring pixels */
    public Picture simpleBlur()
    {
        Picture beach = new Picture(Pic);
        for(int r = 1;r < pixels.length-1;r++)
        {
            for(int c = 1; c < pixels[r].length-1;c++)
            {
                int redAvg = (pixels[r][c].getRed() + pixels[r+1][c].getRed() +
                        pixels[r][c+1].getRed() + pixels[r+1][c+1].getRed() +pixels[r-1][c-1].getRed() +
                        pixels[r-1][c].getRed() + pixels[r][c-1].getRed() + pixels[r-1][c+1].getRed() +
                        pixels[r+1][c-1].getRed())/9;
                int greenAvg = (pixels[r][c].getGreen() + pixels[r+1][c].getGreen()
                        + pixels[r][c+1].getGreen() + pixels[r+1][c+1].getGreen() +pixels[r-1][c-
                        1].getGreen() + pixels[r-1][c].getGreen() + pixels[r][c-1].getGreen() + pixels[r-1]
                        [c+1].getGreen() + pixels[r+1][c-1].getGreen())/9;
                int blueAvg = (pixels[r][c].getBlue() + pixels[r+1][c].getBlue() +
                        pixels[r][c+1].getBlue() + pixels[r+1][c+1].getBlue() +pixels[r-1][c-1].getBlue() +
                        pixels[r-1][c].getBlue() + pixels[r][c-1].getBlue() + pixels[r-1][c+1].getBlue() +
                        pixels[r+1][c-1].getBlue())/9;

                beach.pixels[r][c].setColor(redAvg,greenAvg,blueAvg);
            }
        }
        return beach;
    }

    /** perform a blur using the colors of pixels within radius of current pixel */
    public Picture blur(int radius)
    {
        Picture beach = new Picture(Pic);
        for(int r = 1;r < pixels.length-1;r++)
        {
            for(int c = 1; c < pixels[r].length-1;c++)
            {
                int redAvg = (pixels[r][c].getRed() + pixels[r+1][c].getRed() + pixels[r][c+1].getRed() + pixels[r+1][c+1].getRed() +pixels[r-1][c-1].getRed() + pixels[r-1][c].getRed() + pixels[r][c-1].getRed() + pixels[r-1][c+1].getRed() + pixels[r+1][c-1].getRed())/9;
                int greenAvg = (pixels[r][c].getGreen() + pixels[r+1][c].getGreen() + pixels[r][c+1].getGreen() + pixels[r+1][c+1].getGreen() +pixels[r-1][c- 1].getGreen() + pixels[r-1][c].getGreen() + pixels[r][c-1].getGreen() + pixels[r-1][c+1].getGreen() + pixels[r+1][c-1].getGreen())/9;
                int blueAvg = (pixels[r][c].getBlue() + pixels[r+1][c].getBlue() + pixels[r][c+1].getBlue() + pixels[r+1][c+1].getBlue() +pixels[r-1][c-1].getBlue() + pixels[r-1][c].getBlue() + pixels[r][c-1].getBlue() + pixels[r-1][c+1].getBlue() + pixels[r+1][c-1].getBlue())/9;
                for(int ra = 2; ra < radius-1 && c > 2 && r > 2 && c + ra <
                        pixels[r].length-1 && r + ra < pixels.length-1 && c - ra > 0 && r - ra > 0;ra++)
                {
                    redAvg = (redAvg + pixels[r+ra][c].getRed() + pixels[r][c+ra].getRed() + pixels[r+ra][c+ra].getRed() +pixels[r-ra][c-ra].getRed() + pixels[r-ra][c].getRed() + pixels[r][c-ra].getRed() + pixels[r-ra][c+ra].getRed() + pixels[r+ra][c-ra].getRed())/9;
                    greenAvg = (greenAvg + pixels[r+ra][c].getGreen() + pixels[r][c+ra].getGreen() + pixels[r+ra][c+ra].getGreen() +pixels[r-ra][c-ra].getGreen() + pixels[r-ra][c].getGreen() + pixels[r][c-ra].getGreen() + pixels[r-ra][c+ra].getGreen() + pixels[r+ra][c-ra].getGreen())/9;
                    blueAvg = (blueAvg + pixels[r+ra][c].getBlue() + pixels[r][c+ra].getBlue() + pixels[r+ra][c+ra].getBlue() +pixels[r-ra][c-ra].getBlue() + pixels[r-ra][c].getBlue() + pixels[r][c-ra].getBlue() + pixels[r-ra][c+ra].getBlue() + pixels[r+ra][c-ra].getBlue())/9;
                }
                beach.pixels[r][c].setColor(redAvg,greenAvg,blueAvg);
            }
        }
        return beach;
    }

    /**
     * Simulate looking at an image through a pane of glass
     * @param dist the "radius" of the neighboring pixels to use
     * @return a new Picture with the glass filter applied
     */
    public Picture glassFilter(int dist)
    {
        //TODO

        return null; //REPLACE
    }
}