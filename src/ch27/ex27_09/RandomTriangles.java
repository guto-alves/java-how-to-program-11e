/*
 * Objetivo     : 13.9 (Triângulos aleatórios) Escreva um aplicativo que exibe triângulos aleatoriamente gerados em diferentes cores. 
 * Cada triângulo deve ser preenchido com uma cor diferente. Utilize a classe GeneralPath e o método fill da classe Graphics2D para desenhar os triângulos.
 * 
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 6 de mar de 2019 
 */

package ch27.ex27_09;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.security.SecureRandom;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomTriangles extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		setBackground(Color.WHITE);

		SecureRandom random = new SecureRandom();

		GeneralPath triangulo = new GeneralPath();

		// pontos para formar um triângulo
		int[] xPoints = { 10, 50, 30 };
		int[] yPoints = { 50, 50, 15 };

		// configura a coordenada inicial do General Path
		triangulo.moveTo(xPoints[0], yPoints[0]);

		// cria o triângulo -- isso não desenha o triângulo
		for (int count = 1; count < yPoints.length; count++)
			triangulo.lineTo(xPoints[count], yPoints[count]);

		triangulo.closePath(); // fecha a forma

		for (int i = 0; i < 100; i++) {
			g2d.translate(random.nextInt(200), random.nextInt(100));
			g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
			g2d.fill(triangulo);

		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Triângulos Aleatórios");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		RandomTriangles draw = new RandomTriangles();
		frame.add(draw);
		frame.setSize(300, 150);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

}
