import java.util.Random;
public class MyRectange {
    private int length, width;
    public MyRectange()
    {
        Random rand = new Random();
        length = rand.nextInt(10) +1;
        width = rand.nextInt(10) +1;
        // puts the length and width from 1-10.
    }
    public MyRectange(int l, int w){
        length = l;
        width = w;
    }
    public int getLength(){
        return length;
    }
    public void setLength(int x){
        length = x;
    }
    public int getWidth(){
        return width;
    }
    public void setWidth(int y){
        width = y;
    }
    public int getArea(){
        return length * width;
        //getting the area
    }
    public int getPerimeter(){
        return length + length + width + width;
        //getting the perimeter
    }
    public String toString(){
        return ("L: "+ length+" W: "+ width);
        //prints the length and width
    }
}