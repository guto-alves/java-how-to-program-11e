/*
 * Objetivo     : 13.29 (Cores aleatórias) Modifique a Questão 13.28 para desenhar cada uma das 20 formas com dimensões aleatórias 
 * em uma cor selecionada aleatoriamente. Utilize todos os 13 objetos Color predefinidos em um array de Colors.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 13 de mar de 2019
 */

package ch27.ex27_29;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class CoresAleatoriasFrame extends JFrame {
	private final JComboBox<String> formasComboBox;
	private final String[] namesFormas = { "Círculo", "Retângulo", "Quadrado", "Oval" };

	public CoresAleatoriasFrame() {
		super("Selecionando Formas");

		// instância a classe que estende JPanel para desenhar com usar o método
		// paintComponent
		CoresAleatoriasPanel panel = new CoresAleatoriasPanel();
		add(panel);

		formasComboBox = new JComboBox<>(namesFormas);
		formasComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				panel.desenharForma(formasComboBox.getSelectedIndex());
			}
		});
		add(new JScrollPane(formasComboBox), BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		CoresAleatoriasFrame frame = new CoresAleatoriasFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
