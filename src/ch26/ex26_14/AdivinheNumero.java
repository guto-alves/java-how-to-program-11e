/*
 * Objetivo     : 12.14 Escreva um aplicativo que execute “adivinhe o número” como mostrado
 * a seguir: Seu aplicativo escolhe o número a ser adivinhado selecionando um inteiro
 * aleatoriamente no intervalo 1–1000. O aplicativo então exibe o seguinte em um rótulo:
 * 
 * I have a number between 1 and 1000. Can you guess my number?
 * Please enter your first guess.
 * 
 * Um JTextField deve ser utilizado para entrar a suposição. Conforme cada suposição é inserida,
 * a cor de fundo deve mudar para vermelho ou azul. Vermelho indica que o usuário está ficando
 * mais “quente”, e azul, “mais frio”. Um JLabel deve exibir "Too High" ou "Too Low" para ajudar
 * a encontrar a resposta correta. Quando o usuário obtém a resposta correta, "Correct!" deve ser
 * exibido, e o JTextField usado para entrada deve ser alterado para não ser editável. Um JButton
 * deve ser fornecido para permitir ao usuário jogar de novo. Quando o JButton for clicado, um novo
 * número aleatório deverá ser gerado e a entrada JTextField deve ser alterada para o estado editável.
 * 
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 1 de mar de 2019
 */

package ch26.ex26_14;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdivinheNumero extends JFrame {
	private final SecureRandom random = new SecureRandom();

	private int randomNumber;

	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;

	private final JLabel status;

	private final JTextField textField;

	private JButton playAgain;

	private Font font;

	public AdivinheNumero() {
		super("Guess the Number");
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.WHITE);

		numberGenerator();

		font = new Font("Serif", Font.PLAIN, 15);

		label1 = new JLabel("I have a number between 1 and 1000. ");
		label1.setFont(font);
		add(label1);

		label2 = new JLabel("Can you guess my number?");
		label2.setFont(font);
		add(label2);

		label3 = new JLabel("Please enter your guess.");
		label3.setFont(font);
		add(label3);

		textField = new JTextField(3);
		textField.setToolTipText("Enter your guess and press enter!");
		add(textField);

		font = new Font("Times", Font.BOLD, 15);
		status = new JLabel("Status: waiting guess ..");
		status.setFont(font);
		add(status);

		playAgain = new JButton("Play Again?");
		playAgain.setBackground(Color.CYAN);
		playAgain.setToolTipText("Click here to play again!");
		playAgain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				numberGenerator();
				textField.setEnabled(true);
				textField.setText("");
				status.setText("Status: waiting guess ..");
				getContentPane().setBackground(Color.WHITE);
				remove(playAgain);

				repaint();
				validate();
			}
		});

		Hadler hadler = new Hadler();
		textField.addActionListener(hadler);

	}

	private class Hadler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			String text = "";
			int guess = Integer.parseInt(event.getActionCommand());

			if (guess == randomNumber) {
				text = "Correct!";
				textField.setEnabled(false);
				textField.setDisabledTextColor(Color.BLACK);
				add(playAgain);
			} else if (guess < randomNumber)
				text = "Too Low";
			else if (guess > randomNumber)
				text = "Too High";

			/*
			 * enunciado não especificou como mensurar se suposição está "quente" ou
			 * "mais fria", então propus se a diferença entre a entrada e o número gerado
			 * for maior que 100 está "mais frio"(azul), caso contrário "quente" (vermelho)
			 */
			if ((guess - randomNumber) > 100 || (guess - randomNumber) < -100)
				getContentPane().setBackground(Color.CYAN); // BLUE escurece a tela, por isso CYAN
			else
				getContentPane().setBackground(Color.RED);

			status.setText("Status: " + text);

		}
	}

	private void numberGenerator() {
		randomNumber = 1 + random.nextInt(1000);
	}

	public static void main(String[] args) {
		AdivinheNumero frame = new AdivinheNumero();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false);
		frame.setSize(280, 150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
