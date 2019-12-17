/*
 * Objetivo     : 13.11 (Grade utilizando o método drawLine) Escreva um aplicativo que desenha uma grade de 8 por 8. 
 * Utilize o método Graphics drawLine.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 5 de mar de 2019
 */

package ch27.ex27_11;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GradeDrawLine extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// desenha linhas horizontais
		for (int i = 1; i <= 8; i++)
			g.drawLine(0, (getHeight() / 8) * i, getWidth(), (getHeight() / 8) * i);

		// desenha linhas verticais
		for (int i = 1; i <= 8; i++)
			g.drawLine((getWidth() / 8) * i, 0, (getWidth() / 8) * i, getHeight());

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Grade 8 por 8");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GradeDrawLine draw = new GradeDrawLine();
		frame.add(draw);

		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
