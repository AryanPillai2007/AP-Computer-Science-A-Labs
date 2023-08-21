
import java.awt.*;
import javax.swing.*;

public class SoundView extends JComponent
{
	private double[] clip;

	public SoundView(double[] clip)
	{
		this.clip = new double[clip.length];
		for (int i = 0; i < clip.length; i++)
			this.clip[i] = clip[i];
		setPreferredSize(new Dimension(600, 300));
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLUE);
		int middle = getHeight() / 2;
		for (int i = 0; i < clip.length; i++)
		{
			int x1 = i * getWidth() / clip.length;
			int x2 = (i + 1) * getWidth() / clip.length;
			int y1 = getHeight() - (int)((clip[i] + 1) * getHeight() / 2);
			int width = Math.max(x2 - x1, 1);
			if (y1 < middle)
			{
				int height = middle - y1;
				g.fillRect(x1, y1, width, height);
			}
			else
			{
				int height = y1 - middle;
				g.fillRect(x1, middle, width, height);
			}
		}
		g.setColor(Color.BLACK);
		g.drawLine(0, middle, getWidth(), middle);
	}
}
