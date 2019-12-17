/*
 * Objetivo     : 13.28 (Selecionando formas) Escreva um aplicativo que permite ao usuário selecionar uma forma a partir de uma JComboBox 
 * e a desenha 20 vezes com posições e dimensões aleatórias no método paintComponent. O primeiro item na JComboBox deve ser a forma padrão
 * que é exibida na primeira vez que paintComponent é chamado.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 12 de mar de 2019
 */

package ch27.ex27_28;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class SelecionandoFormasFrame extends JFrame {
	private final JComboBox<String> formasComboBox;
	private final String[] namesFormas = { "Círculo", "Retângulo", "Quadrado", "Oval" };

	public SelecionandoFormasFrame() {
		super("Selecionando Formas");

		SelecionandoFormasPanel panel = new SelecionandoFormasPanel();
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
		SelecionandoFormasFrame frame = new SelecionandoFormasFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
