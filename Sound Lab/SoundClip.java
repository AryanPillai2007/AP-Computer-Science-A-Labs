import java.util.Scanner;
import java.io.*;
public class SoundClip
{
    public double[] clip;

    public SoundClip()
    {
        clip = null;
    }

    public SoundClip(double[] values)
    {
        clip = new double[values.length];

        for (int i = 0; i < clip.length; i++) {

            clip[i] = values[i];

        }
    }

    public void adjustVolume(double factor) {

        for (int i = 0; i < clip.length; i++) {

            clip[i] *= factor;
        }
    }

    public void mix(double[] clip1, double[] clip2) {

        if (clip1.length > clip2.length) {

            for (int i = 0; i < clip2.length; i++) {

                clip1[i] += clip2[i];
            }
            clip = clip1;
        }
        else {

            for (int i = 0; i < clip1.length; i++) {

                clip2[i] += clip1[i];
            }
            clip = clip2;
        }
    }

    public void append(String fileName) throws FileNotFoundException {

        File file = new File("samples.txt");

        Scanner input = new Scanner(file);

        double[] result = new double[clip.length + input.nextInt()];

        for(int i = 0; i < clip.length; i++){

            result[i] = clip[i];
        }
        int hold = clip.length;

        while(input.hasNextDouble()){

            result[hold] = input.nextDouble();

            hold += 1;
        }
        clip = result;

    }

    public void fadeIn(double seconds)
    {
        double amount = Sound.toNumSamples(seconds);
        for (int i = 0; i < amount; i++) {

            clip[i] *= i/amount;

        }
    }

    public void fadeOut(double seconds)
    {
        double amount = Sound.toNumSamples(seconds);
        double ratioed = amount;
        for (int i = clip.length-(int)amount; (double) i < clip.length; i++)
        {
            clip[i] *= ratioed /amount;
            ratioed--;
        }
    }

    public void reverse() {

        double[] reversed = new double[clip.length];

        for (int i = 0; i < clip.length; i++) {

            reversed[i] = clip[clip.length - i-1];
        }
        clip = reversed;
    }
    public void speedUp(double factor)
    {
        int count = 0;
        double[] c = new double[(int) (clip.length/factor)];
        for (int i = 0; i < clip.length; i++) {

            if (i % factor == 0) {

                c[count] = clip[i];

                count++;
            }
        }
        clip = c;

    }
}