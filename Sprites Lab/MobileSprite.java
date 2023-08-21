public class MobileSprite extends Sprite{
private double vx, vy;

    public MobileSprite(double x, double y, int width, int height, String image, double xx, double yy) {
        super(x, y, width, height, image);
        vx=xx;
        vy=yy;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }
    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    @Override
    public void step(World world) {
        setX(getX() + vx);
        setY(getY() + vy);
    }
}
