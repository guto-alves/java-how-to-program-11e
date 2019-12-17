/*
 * Objetivo     : 13.23 (Gráficos de tartaruga) Modifique sua solução da Questão 7.21 
 * — Gráficos de tartaruga — para adicionar uma interface gráfica com o usuário
 * utilizando JTextFields e JButtons. Desenhe linhas em vez de asteriscos (*).
 * Quando o programa gráfico de tartaruga especificar um movimento, traduza o número
 * de posições em um número de pixels na tela multiplicando o número de posições por
 * 10 (ou qualquer valor que você escolher). Implemente o desenho com os recursos da
 * Java 2D API.
 * 
 * Comando            Significado
 *   ◄                 vira para esquerda
 *   ▲                 vira para cima
 *   ▼                 Vira para a baixo
 *   ►                 Vira para a direita
 *  Andar              Avança 40 pixels
 *  Caneta Cima        Não desenha quando Andar
 *  Caneta Baixo       Desenha quando Andar
 *  
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 12 de mar de 2019
 */

package ch27.ex27_23;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraficosTartarugaFrame extends JFrame {
	private final JPanel panelButtons = new JPanel();
	private final JButton[] buttons = new JButton[7];

	private int setaIndice = 3; // inicia com seta para direita
	private boolean caneta = true; // inicia com caneta para cima

	public GraficosTartarugaFrame() {
		super("Gráficos de Tartaruga");

		Icon iconCanetaBaixo = new ImageIcon(getClass().getResource("images/baixa.png"));
		Icon iconCanetaCima = new ImageIcon(getClass().getResource("images/cima.png"));
		Icon iconAndar = new ImageIcon(getClass().getResource("images/tartaruga23-1.png"));

		buttons[0] = new JButton("◄");
		buttons[1] = new JButton("▲");
		buttons[2] = new JButton("▼");

		buttons[3] = new JButton("►");
		buttons[3].setBackground(Color.CYAN);

		buttons[4] = new JButton();
		buttons[4].setIcon(iconCanetaCima);
		buttons[4].setBackground(Color.CYAN);

		buttons[5] = new JButton();
		buttons[5].setIcon(iconCanetaBaixo);

		buttons[6] = new JButton("Andar");
		buttons[6].setBackground(Color.GREEN);
		buttons[6].setIcon(iconAndar);

		for (int i = 0; i < buttons.length; i++)
			panelButtons.add(buttons[i]);

		add(panelButtons, BorderLayout.SOUTH);

		// tratamento dos JButtons da caneta
		buttons[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				caneta = true;
				buttons[4].setBackground(Color.CYAN);
				buttons[5].setBackground(getBackground());

			}

		});
		buttons[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				caneta = false;
				buttons[5].setBackground(Color.CYAN);
				buttons[4].setBackground(getBackground());

			}
		});

		// tratamento botão Andar
		GraficosTartarugaPanel grafico = new GraficosTartarugaPanel();
		add(grafico, BorderLayout.CENTER);
		buttons[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				grafico.avancar(setaIndice, caneta);

			}
		});

		// SetaButtonHandler para tratamento dos botões de seta/direção
		SetaButtonHandler handler = new SetaButtonHandler();
		buttons[0].addActionListener(handler);
		buttons[1].addActionListener(handler);
		buttons[2].addActionListener(handler);
		buttons[3].addActionListener(handler);
	}

	private class SetaButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < 4; i++) {
				if (e.getSource() == buttons[i]) {
					buttons[i].setBackground(Color.CYAN);
					setaIndice = i;
				} else
					buttons[i].setBackground(getBackground());
			}
		}
	}

	public static void main(String[] args) {
		GraficosTartarugaFrame frame = new GraficosTartarugaFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(550, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
