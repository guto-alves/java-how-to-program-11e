/*
 * Objetivo     : 12.9 Crie a seguinte GUI. Você não precisa fornecer funcionalidades.
 * 
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 28 de fev de 2019
 */

package ch26.ex26_09;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
	private JTextField textField;

	private final JPanel panelButtons;
	private final JButton[] buttons;
	private final String[] namesButtons = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ",", "=",
			"+" };

	public Calculator() {
		super("Calculator");

		textField = new JTextField();
		add(textField, BorderLayout.NORTH);

		panelButtons = new JPanel(new GridLayout(4, 4, 5, 5));

		buttons = new JButton[namesButtons.length];

		for (int i = 0; i < namesButtons.length; i++) {
			buttons[i] = new JButton(namesButtons[i]);
			buttons[i].setFont(new Font("Serif", Font.PLAIN, 18));
			panelButtons.add(buttons[i]);
		}
		add(panelButtons);
	}

	public static void main(String[] args) {
		Calculator frame = new Calculator();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(225, 220);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
