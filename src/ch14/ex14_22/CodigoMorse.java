/*
 * Objetivo: 14.22 (Código Morse) Talvez o mais famoso de todos os esquemas de codificação seja o código Morse, desenvolvido por Samuel Morse em 1832
 * para utilização com o sistema de telégrafo. O código Morse atribui uma série de pontos e traços para cada letra do alfabeto, para cada dígito
 * e alguns caracteres especiais (como ponto, vírgula, dois-pontos e ponto e vírgula). Em sistemas orientados para áudio, o ponto representa
 * um som curto e o traço representa um som longo. Outras representações de pontos e traços são utilizadas com sistemas baseados em sinais
 * luminosos e sistemas baseados em sinais de bandeira. A separação entre palavras é indicada por um espaço, ou, simplesmente, a ausência
 * de um ponto ou traço. Em um sistema orientado a som, um espaço é indicado por um tempo curto durante o qual nenhum som é transmitido. A 
 * versão internacional do código Morse aparece na Figura 14.26.
 * 		Elabore um aplicativo que lê uma frase em inglês e a codifica em código Morse. Elabore também um aplicativo que lê uma frase em
 * código Morse e a converte no equivalente em inglês. Utilize um espaço em branco entre cada letra codificada em Morse e três espaços em
 * branco entre cada palavra codificada em Morse.
 * 
 * Autor: Gustavo Alves
 * Data: 14/04/2019
 */

package ch14.ex14_22;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class CodigoMorse extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textAreaNormal;
	private JTextArea textAreaMorse;

	private JButton start;

	// private JComboBox<String> comboBox;

	// private String[] items = { "Criptografar", "Descriptografar" };

	public CodigoMorse() {
		super("Código Morse");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().setBackground(Color.LIGHT_GRAY);

		// comboBox = new JComboBox<String>(items);

		textAreaNormal = new JTextArea(15, 30);
		add(textAreaNormal);

		add(new JLabel(">>"));

		textAreaMorse = new JTextArea(15, 30);
		add(textAreaMorse);

		start = new JButton("Criptografar");
		add(start);

		ButtonHandler handler = new ButtonHandler();
		start.addActionListener(handler);

	}

	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			textAreaMorse.setText(toNormal(textAreaNormal.getText()));

		}

	}

	public String toMorse(String frase) {
		String[] alfabetoMorse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
				"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

		// String[] digitosMorse = { "-----", ".----", "..---", "...--", "....-",
		// ".....", "-....", "--...", "---..", "----.", };

		frase = frase.toUpperCase();

		String[] tokens = frase.split(" ");

		StringBuilder fraseMorse = new StringBuilder();

		for (int i = 0; i < tokens.length; i++) {
			for (int j = 0; j < tokens[i].length(); j++) {
				for (int j2 = 0; j2 < 26; j2++) {
					if (tokens[i].charAt(j) == 'A' + j2)
						fraseMorse.append(alfabetoMorse[j2] + " ");
				}
			}

			fraseMorse.append("   ");
		}

		return fraseMorse.toString();
	}

	public String toNormal(String texto) {
		String[] alfabetoMorse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
				"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

		String[] tokens = texto.split(" ");

		StringBuilder novoTexto = new StringBuilder();
		for (int i = 0; i < tokens.length; i++) {
			for (int j = 0; j < alfabetoMorse.length; j++) {
				if (alfabetoMorse[j].equals(tokens[i]))
					novoTexto.append(String.format("%c", 'A' + j));
			}
		}

		return novoTexto.toString();
	}

	public static void main(String[] args) {
		CodigoMorse frame = new CodigoMorse();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(750, 350);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
