/*
 * Objetivo: 12.13 (Modificação de conversão de temperatura) Aprimore o aplicativo de conversão de temperatura da Questão 12.12 adicionando a escala
 * de temperatura Kelvin. O aplicativo também deve permitir ao usuário fazer conversões entre quaisquer duas escalas. Utilize a seguinte
 * fórmula para a conversão entre Kelvin e Celsius (além da fórmula na Questão 12.12) :
 * Kelvin = Celsius + 273,15
 * 
 * Autor: Gustavo Alves
 * Data: 24/03/2019
 */

package ch26.ex26_13;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ModificacaoConversaoDeTemperatura extends JFrame {
	private final JComboBox<String> comboBox1;
	private final JComboBox<String> comboBox2;

	private final String[] names = { "Celsius", "Fahrenheit", "Kelvin" };

	private final JTextField textField1;
	private final JTextField textField2;

	private final JButton ok;

	public ModificacaoConversaoDeTemperatura() {
		super("Conversão Temperatura");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().setBackground(Color.CYAN);

		comboBox1 = new JComboBox<String>(names);
		add(comboBox1);

		add(new JLabel("="));

		comboBox2 = new JComboBox<String>(names);
		comboBox2.setSelectedIndex(1);
		add(comboBox2);

		textField1 = new JTextField("0", 7);
		add(textField1);

		add(new JLabel("="));

		textField2 = new JTextField(7);
		textField2.setEnabled(false);
		textField2.setDisabledTextColor(Color.BLACK);
		add(textField2);

		ok = new JButton("Calcular");
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calculate();
			}
		});
		add(ok);

	}

	public void calculate() {
		try {
			double temperature = Double.parseDouble(textField1.getText());

			int box1 = comboBox1.getSelectedIndex();
			int box2 = comboBox2.getSelectedIndex();

			String result = "";

			// determina quais escalas termométricas estão selecionadadas e chama os métodos
			// correspondentes para calculate a conversão.
			if (box1 == box2)
				result = textField1.getText();
			else if (box1 == 0 && box2 == 1)
				result = String.format("%,.2f", celsiusToFahrenheit(temperature));
			else if (box1 == 0 && box2 == 2)
				result = String.format("%,.2f", celsiusToKelvin(temperature));
			else if (box1 == 1 && box2 == 0)
				result = String.format("%,.2f", fahrenheitToCelsius(temperature));
			else if (box1 == 1 && box2 == 2)
				result = String.format("%,.2f", fahrenheitToKelvin(temperature));
			else if (box1 == 2 && box2 == 0)
				result = String.format("%,.2f", kelvinToCelsius(temperature));
			else
				result = String.format("%,.2f", kelvinToFahrenheit(temperature));

			textField2.setText(result);

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(ModificacaoConversaoDeTemperatura.this,
					"Exceção: entrada inválida, tente novamente!", "Exceção", JOptionPane.ERROR_MESSAGE);
		}
	}

	public double celsiusToFahrenheit(double celsius) {
		return celsius * 1.8 + 32;
	}

	public double celsiusToKelvin(double celsius) {
		return celsius + 273.15;
	}

	public double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}

	public double fahrenheitToKelvin(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9 + 273.15;
	}

	public double kelvinToCelsius(double kelvin) {
		return kelvin - 273.15;
	}

	public double kelvinToFahrenheit(double kelvin) {
		return (kelvin - 273.15) * 9 / 5 + 32;
	}

	public static void main(String[] args) {
		ModificacaoConversaoDeTemperatura frame = new ModificacaoConversaoDeTemperatura();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(250, 130);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
