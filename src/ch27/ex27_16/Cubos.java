/*
 * Objetivo     : 13.16 (Desenhando cubos) Escreva um aplicativo que desenha um cubo. Escreva um programa que desenha um cubo.
 * 
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data criação : 6 de mar de 2019 
 */

package ch27.ex27_16;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cubos extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		GeneralPath cubo = new GeneralPath();

		// pontos para formar o cubo
		int[] x = { 10, 60, 85, 85, 30, 10, 60, 60, 85, 30, 30, 85, 60, 60, 10, 30, 10, 10 };
		int[] y = { 70, 70, 60, 10, 10, 20, 20, 70, 60, 60, 10, 10, 20, 70, 70, 60, 70, 20 };

		cubo.moveTo(x[0], y[0]);

		// cria o cubo
		for (int i = 1; i < y.length; i++)
			cubo.lineTo(x[i], y[i]);

		g2d.draw(cubo);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Cubo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Cubos draw = new Cubos();
		frame.add(draw);
		frame.setSize(230, 130);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
