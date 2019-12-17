/*
 * Objetivo     : 13.15 (Desenhando tetraedros) Escreva um aplicativo que desenha um tetraedro (uma pirâmide). 
 * Use a classe GeneralPath e o método draw da classe Graphics2D.
 * 
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data criação : 6 de mar de 2019 
 */

package ch27.ex27_15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tetraedro extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);

		Graphics2D g2d = (Graphics2D) g;

		GeneralPath tetraedro = new GeneralPath();

		// pontos para formar o tetraedro
		int[] x = { 10, 30, 50, 30, 10, 30, 30 };
		int[] y = { 40, 10, 40, 50, 40, 50, 10 };

		// cria o tetraedro
		tetraedro.moveTo(x[0], y[0]);
		for (int i = 1; i < y.length; i++)
			tetraedro.lineTo(x[i], y[i]);

		tetraedro.closePath(); // fecha a forma

		g2d.translate(100, 30); // traduz/move a origem para (100, 30)

		g2d.setColor(Color.RED);
		g2d.draw(tetraedro);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Tetraedro/Pirâmide");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Tetraedro draw = new Tetraedro();
		frame.add(draw);
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
