/*
 * Objetivo     : 13.18 (Protetor de tela) Escreva um aplicativo que simula um protetor de tela. O aplicativo deve desenhar linhas aleatoriamente 
 * utilizando o método drawLine da classe Graphics. Depois de desenhar 100 linhas, ele deve se autorredefinir e começar a desenhar as linhas
 * novamente. Para permitir que o programa desenhe continuamente, coloque uma chamada repaint como a última linha no método paintComponent. 
 * Você notou qualquer problema com isso em seu sistema?
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 7 de mar de 2019
 */

package ch27.ex27_18;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ProtetorTela extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		SecureRandom random = new SecureRandom();

		for (int i = 0; i < 100; i++)
			g.drawLine(random.nextInt(getWidth()), random.nextInt(getHeight()), random.nextInt(getWidth()),
					random.nextInt(getHeight()));

		repaint();

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Protetor de Tela");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ProtetorTela draw = new ProtetorTela();
		draw.setBackground(Color.WHITE);
		frame.add(draw);
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
