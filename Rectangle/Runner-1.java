public class Runner {
    public static void main(String[] args) {
        MyRectange one = new MyRectange(3,4);
        MyRectange two = new MyRectange(2,2);
        MyRectange three = new MyRectange(1,6);
        System.out.println(one);
        one.setWidth(6);
        System.out.println(one.getWidth());
        System.out.println(two.getArea());
        System.out.println(three.getPerimeter());
    }
}

