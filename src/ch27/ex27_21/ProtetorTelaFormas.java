/*
 * Objetivo     : 13.21 (Protetor de tela com formas) Modifique sua solução da Questão 13.20 para que ela utilize a geração de números 
 * aleatórios a fim de escolher diferentes formas a exibir. Utilize os métodos da classe Graphics.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 11 de mar de 2019
 */

package ch27.ex27_21;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class ProtetorTelaFormas extends JPanel implements ActionListener {
	private final Timer timer;
	private static JTextField textField = new JTextField("0");

	public ProtetorTelaFormas() {
		timer = new Timer(1000, this);
		timer.start();

		textField.setToolTipText("Digite a quantidade de formas que ira aparecer");

		setBackground(Color.WHITE);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		SecureRandom random = new SecureRandom();

		int numberLines;
		try {
			numberLines = Integer.parseInt(textField.getText());
		} catch (Exception e) {
			numberLines = 0;
		}

		for (int i = 0; i < numberLines; i++) {
			// determa qual forma exibir
			switch (random.nextInt(4)) {
			case 0: // retângulo
				g.drawRect(random.nextInt(getWidth()), random.nextInt(getHeight()), 50, 30);
				break;
			case 1: // círculo
				g.drawArc(random.nextInt(getWidth()), random.nextInt(getHeight()), 50, 50, 0, 360);
				break;
			case 2: // oval
				g.drawOval(random.nextInt(getWidth()), random.nextInt(getHeight()), 30, 50);
				break;
			case 3: // quadrado
				g.drawRect(random.nextInt(getWidth()), random.nextInt(getHeight()), 50, 50);
				break;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Protetor de Tela - Formas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ProtetorTelaFormas draw = new ProtetorTelaFormas();
		frame.add(draw);

		frame.add(textField, BorderLayout.SOUTH);
		frame.setSize(360, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
