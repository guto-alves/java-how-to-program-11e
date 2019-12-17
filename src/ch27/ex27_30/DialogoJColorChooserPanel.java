package ch27.ex27_30;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class DialogoJColorChooserPanel extends JPanel {
	private int numeroForma = 0;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);

		SecureRandom random = new SecureRandom();

		g.setColor(DialogoJColorChooserFrame.color);

		switch (numeroForma) {
		case 0: // círculo
			for (int i = 0; i < 20; i++)
				g.drawArc(random.nextInt(getWidth()), random.nextInt(getHeight()), 50, 50, 0, 360);
			break;
		case 1: // retângulo
			for (int i = 0; i < 20; i++)
				g.drawRect(random.nextInt(getWidth()), random.nextInt(getHeight()), 50, 30);
			break;
		case 2: // quadrado
			for (int i = 0; i < 20; i++)
				g.drawRect(random.nextInt(getWidth()), random.nextInt(getHeight()), 50, 50);
			break;
		case 3: // oval
			for (int i = 0; i < 20; i++)
				g.drawOval(random.nextInt(getWidth()), random.nextInt(getHeight()), 25, 50);
			break;
		}

	}

	public void desenharForma(int numeroForma) {
		this.numeroForma = numeroForma;
		repaint();
	}

}
