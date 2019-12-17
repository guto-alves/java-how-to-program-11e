/*
 * Objetivo: 13.22 (Protetor de tela utilizando a Java 2D API) Modifique sua solução da Questão 13.21 para utilizar as classes e as 
 * capacidades de desenho da Java 2D API. Desenhe formas como retângulos e ovais, com gradientes gerados aleatoriamente. Utilize a 
 * classe GradientPaint para gerar o gradiente.
 * 
 * Autor: Gustavo Alves
 * Data: 16/03/2019
 */

package ch27.ex27_22;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.security.SecureRandom;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class ProtetorTelaJava2DAPI extends JPanel implements ActionListener {
	private final Timer timer;
	private static JTextField textField = new JTextField("0");

	public ProtetorTelaJava2DAPI() {
		timer = new Timer(1000, this);
		timer.start();

		textField.setToolTipText("Digite a quantidade de formas que ira aparecer");
		setBackground(Color.WHITE);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		SecureRandom random = new SecureRandom();

		int numberLines;
		try {
			numberLines = Integer.parseInt(textField.getText());
		} catch (Exception e) {
			numberLines = 0;
		}

		// desenha formas com a Java 2D API com gradientes gerados aleatoriamente
		for (int i = 0; i < numberLines; i++) {
			// determa qual forma exibir
			switch (random.nextInt(4)) {
			case 0: // retângulo
				g2d.setPaint(new GradientPaint(random.nextInt(getWidth()), random.nextInt(getHeight()),
						new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), 35, 100,
						new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), true));
				g2d.fill(new Rectangle2D.Double(random.nextInt(getWidth()), random.nextInt(getHeight()), 50, 30));
				break;
			case 1: // círculo
				g2d.setPaint(new GradientPaint(random.nextInt(getWidth()), random.nextInt(getHeight()),
						new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), 35, 100,
						new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), true));
				g2d.fill(new Ellipse2D.Double(random.nextInt(getWidth()), random.nextInt(getHeight()), 50, 50));
				break;
			case 2: // oval
				g2d.setPaint(new GradientPaint(random.nextInt(getWidth()), random.nextInt(getHeight()),
						new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), 35, 100,
						new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), true));
				g2d.fill(new Ellipse2D.Double(random.nextInt(getWidth()), random.nextInt(getHeight()), 30, 50));
				break;
			case 3: // quadrado
				g2d.setPaint(new GradientPaint(random.nextInt(getWidth()), random.nextInt(getHeight()),
						new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), 35, 100,
						new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), true));
				g2d.fill(new Rectangle2D.Double(random.nextInt(getWidth()), random.nextInt(getHeight()), 50, 50));
				break;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Protetor de Tela - Java 2D API");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ProtetorTelaJava2DAPI draw = new ProtetorTelaJava2DAPI();
		frame.add(draw);

		frame.add(textField, BorderLayout.SOUTH);
		frame.setSize(360, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
