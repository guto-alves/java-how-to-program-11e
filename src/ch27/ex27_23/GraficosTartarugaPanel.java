/*
 * Objetivo     : 13.23 (Gráficos de tartaruga) Esta classe desenha o gráfico de tartaruga.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 12 de mar de 2019
 */

package ch27.ex27_23;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.security.SecureRandom;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraficosTartarugaPanel extends JPanel {
	private ArrayList<Boolean> canetas = new ArrayList<>();
	private ArrayList<Point2D> pontos = new ArrayList<>();
	private ArrayList<GradientPaint> colorsGradients = new ArrayList<>();

	private int xPoint = 250;
	private int yPoint = 150;

	private boolean primeiraExecucao = true;

	public GraficosTartarugaPanel() {
		setBackground(Color.WHITE);

		pontos.add(new Point(xPoint, yPoint));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		SecureRandom random = new SecureRandom();

		colorsGradients.add(new GradientPaint(random.nextInt(getWidth()), random.nextInt(getHeight()),
				new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), 35, 100,
				new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), true));

		if (primeiraExecucao) {
			g2d.setPaint(new Color(0, 121, 0));
			g2d.setFont(new Font("Serif", Font.BOLD, 18));
			g2d.drawString("T", xPoint, yPoint);
			primeiraExecucao = false;

		} else {
			for (int i = 0; i < canetas.size(); i++) {
				if (canetas.get(i) == true) { // se caneta para cima só desenha "T"
					g2d.setFont(new Font("Serif", Font.BOLD, 18));
					g2d.setPaint(new Color(0, 121, 0));
					g2d.drawString("T", xPoint, yPoint);

				} else { // desenha "T" e pinta o "chão"
					// redesenha o pontos anteriores e o novo ponto com um nova cor
					g2d.setPaint(colorsGradients.get(i));
					g2d.draw(new Line2D.Float(pontos.get(i), pontos.get(i + 1)));
					g2d.setPaint(new Color(0, 121, 0));
					g2d.setFont(new Font("Serif", Font.BOLD, 18));
					g2d.drawString("T", xPoint, yPoint);
				}

			}

		}

	}

	public void avancar(int seta, boolean caneta) {
		canetas.add(caneta);

		switch (seta) {
		case 0: // esquerda
			xPoint -= 40;
			break;
		case 1: // cima
			yPoint -= 40;
			break;
		case 2: // baixo
			yPoint += 40;
			break;
		case 3: // direita
			xPoint += 40;
			break;
		}
		
		pontos.add(new Point(xPoint, yPoint));
		repaint();
	}

}
