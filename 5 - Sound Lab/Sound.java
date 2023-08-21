import javax.sound.sampled.*;
import javax.swing.*;

public class Sound
{
    public static final double SAMPLES_PER_SECOND = 8000;

    private static final AudioFormat FORMAT = new AudioFormat((float)SAMPLES_PER_SECOND, 8, 1, true, true);

    public static void main(String[] args)
    {
        //double[] clip = {0.5, 1, 0,-1};
        //Sound.show(clip);
        //Sound.play(clip);
        double[]clip= Sound.pureTone(1000.0, 1.0);
        Sound.show(clip);
        Sound.play(clip);
    }

    /** play the sound clip represented by the samples array */
    public static void play(double[] samples)
    {
        byte[] data = new byte[samples.length];
        for (int i = 0; i < samples.length; i++)
        {
            int intVal = (int)(127 * samples[i]);
            if (intVal > 127)
                intVal = 127;
            if (intVal < -127)
                intVal = -127;
            data[i] = (byte)intVal;
        }
        Clip clip;
        DataLine.Info info = new DataLine.Info(Clip.class, FORMAT);
        if (!AudioSystem.isLineSupported(info))
            throw new RuntimeException("not supported");
        try
        {
            clip = (Clip)AudioSystem.getLine(info);
            clip.open(FORMAT, data, 0, data.length);
            clip.start();
            clip.drain();
        }
        catch(LineUnavailableException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /** generate an array that represents a "pure" tone of the specified
     *  frequency, for the given duration
     */
    public static double[] pureTone(double freq, double seconds)
    {
        double[] samples = new double[(int)(seconds * SAMPLES_PER_SECOND)];
        for (int i = 0; i < samples.length; i++)
            samples[i] = Math.sin(2 * Math.PI * i * freq / SAMPLES_PER_SECOND);
        return samples;
    }

    /** produce a graphical representation of the supplied sound clip */
    public static void show(double[] samples)
    {
        String title = String.format("%.8f", toSeconds(samples.length));
        while (title.endsWith("0"))
            title = title.substring(0, title.length() - 1);
        if (title.endsWith("."))
            title = title.substring(0, title.length() - 1);
        JFrame frame = new JFrame(title + " seconds");
        frame.getContentPane().add(new SoundView(samples));
        frame.pack();
        frame.setVisible(true);
    }

    /** return the number of samples (array elements) for the given duration,
     *  based on the standard sampling frequency */
    public static int toNumSamples(double seconds)
    {
        return (int)(seconds * SAMPLES_PER_SECOND);
    }

    /** return the duration (in seconds) of a sound clip, given the number of
     *  samples in the clip */
    public static double toSeconds(int numSamples)
    {
        return numSamples / SAMPLES_PER_SECOND;
    }
}