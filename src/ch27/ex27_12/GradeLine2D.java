/*
 * Objetivo     : 13.12 (Grade utilizando a classe Line2D.Double) Modifique sua solução da Questão 13.11 para desenhar 
 * a grade utilizando instâncias da classe Line2D.Double e o método draw da classe Graphics2D.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 6 de mar de 2019
 */

package ch27.ex27_12;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GradeLine2D extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		// desenha linhas horizontais
		for (int i = 1; i <= 9; i++)
			g2d.draw(new Line2D.Double(0, (getHeight() / 8) * i, getWidth(), (getHeight() / 8) * i));

		// desenha linhas verticais
		for (int i = 1; i <= 9; i++)
			g2d.draw(new Line2D.Double(0, (getHeight() / 8) * i, getWidth(), (getHeight() / 8) * i));

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Grade 8 por 8");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GradeLine2D draw = new GradeLine2D();
		frame.add(draw);

		frame.setSize(260, 150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
