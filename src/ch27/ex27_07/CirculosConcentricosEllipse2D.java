/*
 * Objetivo     : 13.7 (Círculos concêntricos utilizando a classe Ellipse2D.Double) Modifique sua solução da Questão 13.6 para desenhar 
 * as ovais utilizando a classe Ellipse2D.Double e o método draw da classe Graphics2D.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 5 de mar de 2019
 */

package ch27.ex27_07;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CirculosConcentricosEllipse2D extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		// desenha 8 círculos concêntricos com a classe Ellipse2D.Double
		for (int i = 1; i <= 8; i++) {
			int x = getWidth();
			int y = getHeight();
			g2d.draw(new Ellipse2D.Double(x / 2 - 10 * i, y / 2 - 10 * i, 20 * i, 20 * i));
		}

	}

	public static void main(String[] args) {
		JFrame application = new JFrame("Círculos Concêntricos - classe Ellipse2D.Double");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CirculosConcentricosEllipse2D draw = new CirculosConcentricosEllipse2D();
		application.add(draw);
		application.setSize(440, 225);
		application.setLocationRelativeTo(null);
		application.setVisible(true);

	}

}
