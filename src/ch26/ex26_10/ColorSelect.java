/*
 * Objetivo     : 12.10 Crie a seguinte GUI. Você não precisa fornecer funcionalidades.
 * 
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação : 28 de fev de 2019
 */

package ch26.ex26_10;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorSelect extends JFrame {
	private final JComboBox<String> listComboBox;

	private final String[] names = { "RED", "BLUE", "GREEN", "YELLOW", "GRAY", "BLACK", "WHITE", "PINK", "ORANGE",
			"CYAN" };

	private final JCheckBox background;
	private final JCheckBox foreground;

	private final JButton ok;
	private final JButton cancel;

	private final JPanel centerPanel;

	public ColorSelect() {
		super("Color Select");

		listComboBox = new JComboBox<String>(names);
		listComboBox.setMaximumRowCount(3);
		add(listComboBox, BorderLayout.NORTH);

		background = new JCheckBox("Background");
		foreground = new JCheckBox("Foreground");
		centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		centerPanel.add(background);
		centerPanel.add(foreground);
		add(centerPanel);

		cancel = new JButton("Cancel");
		ok = new JButton("Ok");
		JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelSouth.add(ok);
		panelSouth.add(cancel);
		add(panelSouth, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		ColorSelect frame = new ColorSelect();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(350, 130);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
