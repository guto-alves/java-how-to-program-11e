/*
 * Objetivo     : 13.19 (Protetor de tela utilizandoTimer) O pacote javax.swing contém uma classe chamada Timer que é capaz de chamar 
 * o método actionPerformed da interface ActionListener em um intervalo fixo de tempo (especificado em milissegundos). Modifique sua
 * solução da Questão 13.18 para remover a chamada repaint a partir do método paintComponent. Declare sua classe para implementar
 * ActionListener. (O método actionPerformed deve simplesmente chamar repaint.) Declare uma variável de instância do tipo
 * Timer chamada timer em sua classe. No construtor da sua classe, escreva as seguintes instruções:
 * 
 * timer = new Timer(1000, this);
 * timer.start();
 * 
 * Isso cria uma instância de classe Timer que chamará o método actionPerformed do objeto this a cada 1000 milissegundos (isto é,
 * um segundo).
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 7 de mar de 2019
 */

package ch27.ex27_19;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ProtetorTelaTimer extends JPanel implements ActionListener {
	private final Timer timer;

	public ProtetorTelaTimer() {
		setBackground(Color.WHITE);

		timer = new Timer(1000, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		SecureRandom random = new SecureRandom();

		for (int i = 0; i < 100; i++)
			g.drawLine(random.nextInt(getWidth()), random.nextInt(getHeight()), random.nextInt(getWidth()),
					random.nextInt(getHeight()));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Protetor de Tela utilizando Timer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ProtetorTelaTimer draw = new ProtetorTelaTimer();
		frame.add(draw);
		frame.setSize(360, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
