/*
 * Objetivo     : 13.13 (Grade utilizando o método drawRect) Escreva um aplicativo que desenha uma grade de 10 por 10. 
 * Use o método Graphics drawRect.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 6 de mar de 2019
 */

package ch27.ex27_13;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GradeDrawRect extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int spaceAmongLines = 0;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				g.drawRect((getWidth() / 10) * j, spaceAmongLines, getWidth() / 10, getWidth() / 10);

			spaceAmongLines += getHeight() / 10;

		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Grade 10 por 10 - drawRect");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GradeDrawRect draw = new GradeDrawRect();
		frame.add(draw);
		frame.setSize(590, 601);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
