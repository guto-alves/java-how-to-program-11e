/*
 * Objetivo     : 13.30 (Diálogo JColorChooser) Modifique a Questão 13.28 para permitir que o usuário selecione a cor em que formas 
 * devem ser desenhadas a partir de um diálogo JColorChooser
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 13 de mar de 2019
 */

package ch27.ex27_30;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DialogoJColorChooserFrame extends JFrame {
	private final JComboBox<String> formasComboBox;
	private final String[] namesFormas = { "Círculo", "Retângulo", "Quadrado", "Oval" };

	private final JPanel sulPanel;
	private final JButton corMudar;
	public static Color color = Color.BLACK;

	public DialogoJColorChooserFrame() {
		super("Selecionando Formas");

		// instância a classe que estende JPanel para desenhar
		DialogoJColorChooserPanel panel = new DialogoJColorChooserPanel();
		add(panel);

		formasComboBox = new JComboBox<>(namesFormas);
		formasComboBox.setMaximumRowCount(3);
		formasComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				panel.desenharForma(formasComboBox.getSelectedIndex());
			}
		});

		corMudar = new JButton("Mudar Cor");
		corMudar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				color = JColorChooser.showDialog(DialogoJColorChooserFrame.this, "Mudar a Cor", Color.BLACK);

				panel.desenharForma(formasComboBox.getSelectedIndex());

			}
		});

		sulPanel = new JPanel(new FlowLayout());
		sulPanel.add(formasComboBox);
		sulPanel.add(corMudar);
		add(sulPanel, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		DialogoJColorChooserFrame frame = new DialogoJColorChooserFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
