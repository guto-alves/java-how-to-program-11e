/*
 * Objetivo: 14.7 (Latim de porco) Elabore um aplicativo que codifica frases da língua inglesa em latim de porco. O Pig Latin é uma forma 
 * de linguagem codificada. Há muitos métodos diferentes para formar frases em Pig Latin. Para simplificar, utilize o seguinte algoritmo:
 * Para formar uma frase em latim de porco a partir de uma frase em inglês, tokenize a frase em palavras com o método String split.
 * Para traduzir cada palavra inglesa em uma palavra do latim de porco, coloque a primeira letra da palavra inglesa no final da palavra e adicione
 * as letras “ay”. Assim, a palavra “jump” torna-se “umpjay”, a palavra “the” torna-se “hetay”, e a palavra “computer” torna-se “omputercay”.
 * Os espaços entre as palavras permanecem iguais. Suponha o seguinte: a frase inglesa consiste em palavras separadas por espaços, não
 * há nenhuma marcação de pontuação e todas as palavras têm duas ou mais letras. O método printLatinWord deve exibir cada palavra.
 * Cada token é passado para o método printLatinWord a fim de imprimir a palavra latina porco. Permita que o usuário insira a frase.
 * Continue exibindo todas as frases convertidas em uma área de texto.
 * 
 * Autor: Gustavo Alves
 * Data: 30/03/2019
 */

package ch14.ex14_07;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LatimDePorco extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;

	private JTextArea textAreaEnglish;
	private JTextArea textAreaLatim;

	public LatimDePorco() {
		super("Latim de Porco");
		setLayout(new FlowLayout(FlowLayout.CENTER));

		startGUI();
	}

	public void startGUI() {
		textAreaEnglish = new JTextArea(5, 20);
		textAreaEnglish.setWrapStyleWord(true);
		textAreaEnglish.setLineWrap(true);
		textAreaEnglish.addKeyListener(this);
		add(new JScrollPane(textAreaEnglish));

		add(new JLabel(" >> "));

		textAreaLatim = new JTextArea(5, 20);
		textAreaLatim.setWrapStyleWord(true);
		textAreaLatim.setLineWrap(true);
		add(new JScrollPane(textAreaLatim));
	}

	public void englishToPingLatin() {
		String[] tokens = textAreaEnglish.getText().split(" ");

		StringBuilder latin = new StringBuilder();

		for (int i = 0; i < tokens.length; i++) {
			try {
				latin.append(
						String.format("%s ", tokens[i].substring(1, tokens[i].length()) + tokens[i].charAt(0) + "ay"));
			} catch (Exception e) {
			}

		}
		printLatinWord(latin);

	}

	public void printLatinWord(StringBuilder latin) {
		textAreaLatim.setText(latin.toString());
	}

	public static void main(String[] args) {
		LatimDePorco frame = new LatimDePorco();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		englishToPingLatin();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		englishToPingLatin();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		englishToPingLatin();
	}

}
