/*
 * Objetivo     : 13.8 (Linhas aleatórias usando a classe Line2D.Double) Modifique sua solução para a Questão 13.7 a fim de desenhar linhas
 * aleatórias em cores aleatórias e espessuras aleatórias. Utilize a classe Line2D.Double e o método draw da classe Graphics2D para desenhar
 * as linhas.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 5 de mar de 2019
 */

package ch27.ex27_08;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.security.SecureRandom;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LinhasAleatorias extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		SecureRandom random = new SecureRandom();
		int n = 10 + random.nextInt(101);

		for (int i = 0; i < n; i++) {
			int red = random.nextInt(256);
			int green = random.nextInt(256);
			int blue = random.nextInt(256);

			int x1 = random.nextInt(getWidth());
			int y1 = random.nextInt(getHeight());
			int x2 = random.nextInt(getWidth());
			int y2 = random.nextInt(getHeight());

			int lineWidth = random.nextInt(5); // largura da linha

			g2d.setPaint(new Color(red, green, blue));
			g2d.setStroke(new BasicStroke(lineWidth));
			g2d.draw(new Line2D.Double(x1, y1, x2, y2));
		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Linhas Aleatórias");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		LinhasAleatorias draw = new LinhasAleatorias();
		draw.setBackground(Color.WHITE);

		frame.add(draw);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
