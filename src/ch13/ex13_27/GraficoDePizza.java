/*
 * Objetivo: 13.27 (Gráfico de pizza) Escreva um programa que insere quatro números e mostra-os como um gráfico de pizza. 
 * Use a classe Arc2D.Double e o método fill da classe Graphics2D para realizar o desenho. Desenhe cada pedaço da torta 
 * em uma cor separada.
 * 
 * Autor: Gustavo Alves
 * Data: 17/03/2019
 */

package ch13.ex13_27;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraficoDePizza extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setPaint(Color.RED);
		g2d.fill(new Arc2D.Double(50, 10, 50, 50, 0, 57, Arc2D.PIE));

		g2d.setPaint(Color.YELLOW);
		g2d.fill(new Arc2D.Double(50, 10, 50, 50, 57, 90, Arc2D.PIE));

		g2d.setPaint(Color.GREEN);
		g2d.fill(new Arc2D.Double(50, 10, 50, 50, 180, 90, Arc2D.PIE));

		g2d.setPaint(Color.BLUE);
		g2d.fill(new Arc2D.Double(50, 10, 50, 50, 0, -90, Arc2D.PIE));

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Gráfico de Pizza");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GraficoDePizza draw = new GraficoDePizza();
		frame.add(draw);

		frame.setLocationRelativeTo(null);
		frame.setSize(300, 150);
		frame.setVisible(true);
	}

}
