/*
 * Objetivo     : 13.26 (Desenhando espirais) Escreva um aplicativo que utiliza o método Graphics drawPolyline para desenhar uma espiral 
 * semelhante àquela mostrada na Figura 13.33.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 14 de mar de 2019
 */

package ch27.ex27_26;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DesenhandoEspirais extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int[] xPoints = { 63, 60, 50, 40, 35, 40, 50, 70, 75, 70, 50, 30, 15, 25, 50, 80, 90, 80, 50 };
		int[] yPoints = { 40, 50, 55, 50, 40, 30, 20, 25, 40, 60, 70, 60, 40, 20, 10, 20, 40, 70, 83 };
		g.drawPolyline(xPoints, yPoints, 19);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Desenhando Espirais");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DesenhandoEspirais desenho = new DesenhandoEspirais();
		frame.add(desenho);
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
