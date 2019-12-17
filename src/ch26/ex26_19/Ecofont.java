/*
 * Objetivo     : 12.19 (Ecofont) Ecofont (www.ecofont.eu/ecofont_en.html) — desenvolvida pela Spranq (uma empresa com sede na Holanda) — é
 * uma fonte gratuita de computador de código aberto projetada para reduzir em até 20% a quantidade de tinta usada para impressão, reduzindo
 * assim também o número de cartuchos de tinta usados e o impacto ambiental dos processos de produção e remessa (usando menos
 * energia, menos combustível para o transporte etc.). A fonte, baseada em Verdana sem serifa, tem pequenos “furos” circulares nas letras
 * que não são visíveis em tamanhos menores — como a fonte de 9 ou 10 pontos frequentemente utilizada. Baixe a Ecofont, então instale
 * o arquivo de fonte Spranq_eco_sans_regular.ttf usando as instruções do site da Ecofont. Em seguida, desenvolva um programa
 * baseado em GUI que permite inserir uma string de texto a ser exibida na Ecofont. Crie botões Increase Font Size e Decrease Font Size
 * que permitem aumentar ou reduzir a fonte em um ponto de cada vez. Comece com um tamanho de fonte padrão de 9 pontos. À medida
 * que aumenta o tamanho da fonte, você será capaz de ver os furos nas letras mais claramente. À medida que reduz o tamanho da fonte, os
 * furos serão menos visíveis. Qual é o menor tamanho da fonte em que você começa a perceber os furos?
 * 
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 2 de mar de 2019
 */

package ch26.ex26_19;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ecofont extends JFrame {
	private final JButton increaseButton;
	private final JButton decreaseButton;
	private final JPanel panel;

	private final JTextArea textArea;

	private int fontSize = 9;
	private final JLabel labelFontSize;

	public Ecofont() {
		super("Ecofont");

		textArea = new JTextArea("Watch the font increase or decrease size", 15, 15);
		textArea.setFont(new Font("Spranq eco sans", Font.PLAIN, fontSize));
		add(textArea);

		panel = new JPanel(new FlowLayout());

		increaseButton = new JButton("Increase Font Size");
		panel.add(increaseButton);

		decreaseButton = new JButton("Decrease Font Size");
		panel.add(decreaseButton);

		labelFontSize = new JLabel("Size: " + fontSize);
		panel.add(labelFontSize);
		add(panel, BorderLayout.SOUTH);

		ButtonHandler handler = new ButtonHandler();
		increaseButton.addActionListener(handler);
		decreaseButton.addActionListener(handler);
	}

	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == increaseButton) {
				fontSize++;
				textArea.setFont(new Font("Spranq eco sans", Font.PLAIN, fontSize));
				labelFontSize.setText("Size: " + fontSize);
			} else {
				fontSize--;
				textArea.setFont(new Font("Spranq eco sans", Font.PLAIN, fontSize));
				labelFontSize.setText("Size: " + fontSize);
			}

		}

	}

	public static void main(String[] args) {
		Ecofont frame = new Ecofont();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(600, 250);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
