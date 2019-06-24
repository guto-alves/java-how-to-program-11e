// Drawing the "Lo feather fractal" using recursion.

package ch18.ex18_19;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class FractalJPanel extends JPanel {
	private int level;

	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;

	public FractalJPanel(int currentLevel) {
		level = currentLevel;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	// draw fractal recursively
	public void drawFractal(int level, int xA, int yA, int xB, int yB, Color color, Graphics g) {
		// base case: draw a line connecting two given points
		if (level == 0) {
			g.setColor(color);
			g.drawLine(xA, yA, xB, yB);
		} else // recursion step: determine new points, draw next level
		{
			// calculate midpoint between (xA, yA) and (xB, yB)
			int xC = (xA + xB) / 2;
			int yC = (yA + yB) / 2;

			// calculate the fourth point (xD, yD) which forms an
			// isosceles right triangle between (xA, yA) and (xC, yC)
			// where the right angle is at (xD, yD)
			int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
			int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;

			// recursively draw the Fractal
			drawFractal(level - 1, xD, yD, xA, yA, color, g);
			drawFractal(level - 1, xD, yD, xC, yC, color, g);
			drawFractal(level - 1, xD, yD, xB, yB, color, g);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawFractal(level, getWidth() / 2, getHeight() / 2, (getWidth() / 2) + 80, (getHeight() / 2) - 90, Color.RED,
				g);
		drawFractal(level, getWidth() / 2, getHeight() / 2, (getWidth() / 2) + 120, (getHeight() / 2) + 20, Color.GREEN,
				g);
		drawFractal(level, getWidth() / 2, getHeight() / 2, (getWidth() / 2), (getHeight() / 2) + 100, Color.YELLOW, g);
		drawFractal(level, getWidth() / 2, getHeight() / 2, (getWidth() / 2) - 120, (getHeight() / 2) + 20, Color.PINK,
				g);
		drawFractal(level, getWidth() / 2, getHeight() / 2, (getWidth() / 2) - 80, (getHeight() / 2) - 90, Color.BLUE,
				g);
	}

	public void setLevel(int currentLevel) {
		level = currentLevel;
	}

	public int getLevel() {
		return level;
	}
}
