/*
 * Objetivo: 12.12 (Conversão de temperatura) Escreva um aplicativo de conversão de temperatura que
 * converte de Fahrenheit em Celsius. A temperatura em Fahrenheit deve ser inserida pelo teclado
 * (por um JTextField). Um JLabel deve ser utilizado para exibir a temperatura convertida.
 * Utilize a seguinte fórmula para a conversão:
 * 			 Celsius = 5/9 x (Fahrenheit – 32)
 * 
 * Autor: Gustavo Alves
 * Data: 24/03/2019
 */

package ch26.ex26_12;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConversaoDeTemperatura extends JFrame implements KeyListener {
	private final JTextField fahrenheitTextField;
	private final JLabel celsiusLabel;

	public ConversaoDeTemperatura() {
		super("Conversão de Temperatura");
		setLayout(new FlowLayout(FlowLayout.CENTER));

		fahrenheitTextField = new JTextField("0", 3);
		fahrenheitTextField.setToolTipText("Digite a temperatura em Fahrenheit aqui");
		fahrenheitTextField.addKeyListener(this);
		add(fahrenheitTextField);

		celsiusLabel = new JLabel("0,00°F = -17,78°C");
		celsiusLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		add(celsiusLabel);
	}

	public double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		double fahrenheit = 0;

		try {
			fahrenheit = Double.parseDouble(fahrenheitTextField.getText());
		} catch (Exception e2) {
		}

		celsiusLabel.setText(String.format("%,.2f°F = %,.2f°C", fahrenheit, fahrenheitToCelsius(fahrenheit)));
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	public static void main(String[] args) {
		ConversaoDeTemperatura frame = new ConversaoDeTemperatura();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(330, 80);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
