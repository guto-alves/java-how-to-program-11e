/*
 * Objetivo     : 13.14 (Grade utilizando a classe Rectangle2D.Double) Modifique sua solução da Questão 13.13 para desenhar a grade 
 * utilizando instâncias da classe Rectangle2D.Double e o método draw da classe Graphics2D.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 7 de mar de 2019
 */

package ch27.ex27_14;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GradeRectangle2D extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		int spaceAmongLines = 0;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				g2d.draw(new Rectangle2D.Double((getWidth() / 10) * j, spaceAmongLines, getWidth() / 10,
						getWidth() / 10));

			spaceAmongLines += getHeight() / 10;
		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Grade 10 por 10 - Rectangle2D.Double");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GradeRectangle2D draw = new GradeRectangle2D();
		frame.add(draw);
		frame.setSize(400, 412);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
