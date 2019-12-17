/*
 * Objetivo     : 12.8 Crie a seguinte GUI. Você não precisa fornecer funcionalidades.
 * 
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data Criação: 28 de fev de 2019
 */

package ch26.ex26_08;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Align extends JFrame {
	private final JCheckBox snapGrid;
	private final JCheckBox showGrid;

	private final JLabel xLabel;
	private final JLabel yLabel;

	private final JTextField xTextField;
	private final JTextField yTextField;

	private final JButton ok;
	private final JButton cancel;
	private final JButton help;

	private final JPanel panel1;
	private final JPanel panel2;
	private final JPanel panel3;

	public Align() {
		super("Align");
		setLayout(new FlowLayout());

		// inicializa componentes
		snapGrid = new JCheckBox("Snap to Grid");
		showGrid = new JCheckBox("Show Grid");

		xLabel = new JLabel("X:");
		yLabel = new JLabel("Y:");

		xTextField = new JTextField(3);
		yTextField = new JTextField(3);

		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		help = new JButton("Help");

		// adiciona componentes aos JPanels
		panel1 = new JPanel(new GridLayout(2, 1, 5, 5));
		panel1.add(snapGrid);
		panel1.add(showGrid);
		add(panel1);

		panel2 = new JPanel(new GridLayout(2, 2, 0, 25));
		panel2.add(xLabel);
		panel2.add(xTextField);
		panel2.add(yLabel);
		panel2.add(yTextField);
		add(panel2);

		panel3 = new JPanel(new GridLayout(3, 1, 10, 10));
		panel3.add(ok);
		panel3.add(cancel);
		panel3.add(help);
		add(panel3);
	}

	public static void main(String[] args) {
		Align alignFrame = new Align();
		alignFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		alignFrame.setSize(300, 150);
		alignFrame.setLocationRelativeTo(null);
		alignFrame.setVisible(true);
	}

}