package ch35.ex35_07;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class CirclePanel extends JPanel {
	private int radius;
	private int diameter;
	private double area;
	private double circumference;
	private Color color;

	public CirclePanel() {
		this(Color.BLUE);
	}

	public CirclePanel(Color c) {
		diameter = new SecureRandom().nextInt(200);
		radius = diameter / 2;
		area = Math.PI * Math.pow(radius, 2);
		circumference = 2 * Math.PI * radius;
		color = c;
		setPreferredSize(new Dimension(420, 400));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(color);
		g.fillOval(getWidth() / 3, getHeight() / 3, diameter, diameter);
	}

	public int getDiameter() {
		return diameter;
	}

	public int getRadius() {
		return radius;
	}

	public double getArea() {
		return area;
	}

	public double getCircumference() {
		return circumference;
	}

	@Override
	public String toString() {
		return String.format("�?rea = %,.0f Raio = %d Diamêtro = %d Circunferência = %,.0f", getArea(), getRadius(),
				getDiameter(), getCircumference());
	}
}
