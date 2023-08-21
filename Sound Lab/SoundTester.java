import java.io.IOException;

public class SoundTester
{
    public static void main(String[] args) throws Exception
    {
        adjustVolumeTest();
        mixTest();
        appendTest();
        fadeInTest();
        fadeOutTest();
        reverseTest();
        speedUpTest();

    }

    public static void adjustVolumeTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(200, 1));

        Sound.show(s.clip);
        Sound.play(s.clip);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        s.adjustVolume(1.5);

        Sound.show(s.clip);
        Sound.play(s.clip);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        s.adjustVolume(0.25);

        Sound.show(s.clip);
        Sound.play(s.clip);
    }

    public static void mixTest()
    {
        SoundClip s = new SoundClip(); //default constructor call

        double[] clip1 = Sound.pureTone(200, 1);
        double[] clip2 = Sound.pureTone(400, 1);

        Sound.play(clip1);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        Sound.play(clip2);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        s.mix(clip1, clip2);

        Sound.show(s.clip);
        Sound.play(s.clip);
    }

    public static void appendTest() throws IOException
    {
        SoundClip s = new SoundClip(Sound.pureTone(300, 1));

        Sound.play(s.clip);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        s.append("samples.txt");

        Sound.show(s.clip);
        Sound.play(s.clip);
    }

    public static void fadeInTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(200, 3));

        s.fadeIn(1);

        Sound.show(s.clip);
        Sound.play(s.clip);
    }

    public static void fadeOutTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(200, 3));

        s.fadeOut(1);

        Sound.show(s.clip);
        Sound.play(s.clip);
    }

    public static void reverseTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(200, 3));

        s.fadeIn(3);

        Sound.show(s.clip);
        Sound.play(s.clip);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        s.reverse();

        Sound.show(s.clip);
        Sound.play(s.clip);
    }

    public static void speedUpTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(200, 4));

        Sound.show(s.clip);
        Sound.play(s.clip);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        s.speedUp(4);

        Sound.show(s.clip);
        Sound.play(s.clip);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }
}
