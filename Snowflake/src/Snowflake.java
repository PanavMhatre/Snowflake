import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
	public SnowFlakePanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g)
	{
		int width  = getWidth();
		int height = getHeight();

		super.paintComponent(g);
		Random rand = new Random();
		float r = rand.nextFloat();
		float c = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r, c, b);


		g.setColor(randomColor);
		drawStar(g, (width-1)/2, (height-1)/2,  160);
	}
	public void drawStar(Graphics g, int x, int y, int size) {
		if(size<10) {
			return;
		}
		for(int i =1;i<=6;i++) {
			System.out.println("IN");
			System.out.println(size * Math.cos(((2 * Math.PI)/6.)*i));
			g.drawLine(x, y, 
					x + (int) (size * Math.cos(((2 * Math.PI)/6.)*i)), 
					y + (int) (size * Math.sin(((2 * Math.PI)/6.)*i)));
			drawStar(g, x + (int) (size * Math.cos(((2 * Math.PI)/6.)*i)), y + (int) (size * Math.sin(((2 * Math.PI)/6.)*i)),size/3);
		}
	 }
}

public class Snowflake
{
	public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
	}
}
