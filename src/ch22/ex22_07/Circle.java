/*
 * Objetivo: 22.7 (Exiba um círculo e seus atributos) Escreva um programa que exibe um 
 * círculo de tamanho aleatório e calcula e exibe área, raio, diâmetro e circunferência. 
 * Utilize as seguintes equações: diâmetro = 2 × raio, área = 􀁓 × raio2, 
 * circunferência = 2 × PI × raio. Utilize a constante Math.PI para pi (PI. 
 * Todos os desenhos devem ser feitos em uma subclasse de JPanel e os resultados dos 
 * cálculos, exibidos em um JTextArea de leitura.
 */

package ch22.ex22_07;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Circle extends JFrame {

	public Circle() {
		super("Circle");

		CirclePanel circlePanel = new CirclePanel();
		circlePanel.setBackground(Color.DARK_GRAY);

		JPanel displayPanel = new JPanel();
		displayPanel.setBackground(Color.WHITE);

		JTextArea textArea = new JTextArea(circlePanel.toString());
		textArea.setFont(new Font("Arial", Font.PLAIN, 15));
		textArea.setEditable(false);
		displayPanel.add(textArea);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);

		mainPanel.add(circlePanel);
		mainPanel.add(displayPanel);

		add(mainPanel);
	}

	public static void main(String[] args) {
		Circle frame = new Circle();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(420, 480);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
