/*
 * Objetivo     : 12.20 (Professor de digitação: aprimorando uma habilidade crucial na era da informática) Digitar rápida e corretamente 
 * é uma habilidade essencial para trabalhar de forma eficaz com computadores e a internet. Neste exercício, você construirá um aplicativo 
 * GUI que pode ajudar os usuários a aprender a digitar corretamente sem olhar para o teclado. O aplicativo deve exibir um teclado virtual 
 * (Figura 12.50) e permitir que o usuário veja o que ele está digitando na tela sem olhar para o teclado real. Use JButtons para representar as
 * teclas. À medida que o usuário pressiona cada tecla, o aplicativo destaca o JButton correspondente na GUI e adiciona o caractere a uma
 * JTextArea que mostra o que o usuário digitou até agora. [Dica: para destacar um JButton, use o método setBackground para
 * mudar a cor de fundo. Quando a tecla é liberada, redefina a cor original do fundo. Você pode obter a cor original de fundo do JButton
 * com o método getBackground antes de mudar a cor.]
 * Você pode testar seu programa digitando um pangrama — uma frase que contém todas as letras do alfabeto pelo menos uma vez —
 * como “The quick brown fox jumps over a lazy dog” ou, em português, “Um pequeno jabuti xereta viu dez cegonhas felizes”. Você pode encontrar
 * outros pangramas na web.
 * Para tornar o programa mais interessante, monitore a precisão do usuário. Você pode fazer com que o usuário digite frases específicas
 * que você pré-armazenou no seu programa e que você exibe na tela acima do teclado virtual. Pode-se monitorar quantos pressionamentos de
 * tecla o usuário digita corretamente e quantos são digitados incorretamente. Pode-se também monitorar com quais teclas o usuário tem dificuldade
 * e exibir um relatório mostrando essas teclas.

 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 2 de mar de 2019
 */

package ch26.ex26_20;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ProfessorDigitacao extends JFrame implements KeyListener {
	private final JButton[] buttons;

	private final String[] teclas = { "\"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Backspace",
			"TAB", "Q", "w", "E", "R", "T", "Y", "U", "I", "O", "P", "´", "[", "]", "Caps Lock", "A", "S", "D", "F",
			"G", "H", "J", "K", "L", "Ç", "~", "Enter", "Shift", "\\", "Z", "X", "C", "V", "B", "N", "M", ",", ".", ";",
			"/", "Shift", "Ctrl", "Alt", "Espaço", "Alt Gr", "Win", "Ctrl" };

	private final JTextArea textArea;

	private final JLabel label1;
	private final JLabel label2;
	private final JPanel panelNorth;
	private final JPanel panelSouth;

	private int indexOfTheLastKey; // índice da ultima tecla

	public ProfessorDigitacao() {
		super("Typing Application");
		setResizable(false);

		panelNorth = new JPanel(new GridLayout(2, 1));
		label1 = new JLabel(
				"Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed.");
		label2 = new JLabel("Note: Clicking the buttons with your mouse will not perform any action.");
		panelNorth.add(label1);
		panelNorth.add(label2);
		add(panelNorth, BorderLayout.SOUTH);

		textArea = new JTextArea(10, 15);
		textArea.setFont(new Font("Serif", Font.PLAIN, 14));
		add(new JScrollPane(textArea), BorderLayout.NORTH);
		textArea.addKeyListener(this);

		panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttons = new JButton[teclas.length];

		for (int i = 0; i < teclas.length; i++) {
			buttons[i] = new JButton(teclas[i]);
			panelSouth.add(buttons[i]);
		}

		add(panelSouth);

	}

	// trata pressionamento de qualquer tecla
	@Override
	public void keyPressed(KeyEvent e) {
		buttons[indexOfTheLastKey].setBackground(getBackground());
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i].getText() == KeyEvent.getKeyText(e.getKeyCode())) {
				buttons[i].setBackground(Color.RED);
				indexOfTheLastKey = i;
				break;
			}
		}

	}

	// trata liberação de qualquer tecla
	@Override
	public void keyReleased(KeyEvent e) {
		buttons[indexOfTheLastKey].setBackground(getBackground());
	}

	// trata pressionamento de uma tecla de ação
	@Override
	public void keyTyped(KeyEvent e) {

		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i].getText().equals(String.valueOf(e.getKeyChar()))) {
				buttons[i].setBackground(Color.CYAN);
				indexOfTheLastKey = i;
				break;
			}
		}

	}

	public static void main(String[] args) {
		ProfessorDigitacao frame = new ProfessorDigitacao();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(710, 420);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
