public class HeavySprites extends BouncingSprite{

    public HeavySprites(double x, double y, int width, int height, String image, double xx, double yy) {
        super(x, y, width, height, image, xx, yy);
    }
    @Override
    public void step(World world){
        super.step(world);
        double g = .1;
        setVy(getVy()-g);
    }
}
