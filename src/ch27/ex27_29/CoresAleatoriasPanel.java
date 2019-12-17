/*
 * Objetivo     : 13.29 (Cores aleatórias) Modifique a Questão 13.28 para desenhar cada uma das 20 formas com dimensões 
 * aleatórias em uma cor selecionada aleatoriamente. Utilize todos os 13 objetos Color predefinidos em um array de Colors.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 13 de mar de 2019
 */

package ch27.ex27_29;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class CoresAleatoriasPanel extends JPanel {
	private int numeroForma = 0;
	private Color[] cores = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY,
			Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);

		SecureRandom random = new SecureRandom();

		switch (numeroForma) {
		case 0: // círculo
			for (int i = 0; i < 20; i++) {
				g.setColor(cores[random.nextInt(13)]);
				g.drawArc(random.nextInt(getWidth()), random.nextInt(getHeight()), 50, 50, 0, 360);
			}
			break;
		case 1: // retângulo
			for (int i = 0; i < 20; i++) {
				g.setColor(cores[random.nextInt(13)]);
				g.drawRect(random.nextInt(getWidth()), random.nextInt(getHeight()), 50, 30);
			}
			break;
		case 2: // quadrado
			for (int i = 0; i < 20; i++) {
				g.setColor(cores[random.nextInt(13)]);
				g.drawRect(random.nextInt(getWidth()), random.nextInt(getHeight()), 50, 50);
			}
			break;
		case 3: // oval
			for (int i = 0; i < 20; i++) {
				g.setColor(cores[random.nextInt(13)]);
				g.drawOval(random.nextInt(getWidth()), random.nextInt(getHeight()), 25, 50);
			}
			break;
		}

	}

	public void desenharForma(int numeroForma) {
		this.numeroForma = numeroForma;
		repaint();
	}
}
