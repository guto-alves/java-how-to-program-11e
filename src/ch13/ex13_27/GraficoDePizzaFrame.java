package ch13.ex13_27;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraficoDePizzaFrame extends JFrame {
	private GraficoDePizza chart;

	private int counter;

	public GraficoDePizzaFrame() {
		super("Gráfico de Pizza");

		chart = new GraficoDePizza();

		for (int i = 0; i < 4; i++)
			chart.addPiece(new Piece(1));

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3, 1));

		JPanel valuesPanel = new JPanel();
		valuesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		valuesPanel.add(new JLabel("Valores: "));

		JTextField[] valuesJTextFields = new JTextField[4];

		for (; counter < 4; counter++) {
			valuesJTextFields[counter] = new JTextField("1");
			valuesJTextFields[counter].setHorizontalAlignment(JTextField.CENTER);
			valuesJTextFields[counter].setColumns(5);
			valuesPanel.add(valuesJTextFields[counter]);
		}

		valuesJTextFields[0].addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Piece piece = chart.getPieces().get(0);
				piece.setValue(getInput(valuesJTextFields[0]));

				chart.getPieces().set(0, piece);
				chart.repaint();
			}
		});
		valuesJTextFields[1].addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Piece piece = chart.getPieces().get(1);
				piece.setValue(getInput(valuesJTextFields[1]));

				chart.getPieces().set(1, piece);
				chart.repaint();
			}
		});
		valuesJTextFields[2].addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Piece piece = chart.getPieces().get(2);
				piece.setValue(getInput(valuesJTextFields[2]));

				chart.getPieces().set(2, piece);
				chart.repaint();
			}
		});
		valuesJTextFields[3].addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Piece piece = chart.getPieces().get(3);
				piece.setValue(getInput(valuesJTextFields[3]));

				chart.getPieces().set(3, piece);
				chart.repaint();
			}
		});

		JPanel widthAndHeightPanel = new JPanel();
		widthAndHeightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		widthAndHeightPanel.add(new JLabel("Largura e Altura: "));

		JTextField widthJTextField = new JTextField(5);
		widthJTextField.setHorizontalAlignment(JTextField.CENTER);
		widthJTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				chart.setgWidth((int) getInput(widthJTextField));
				chart.repaint();
			}
		});
		widthAndHeightPanel.add(widthJTextField);

		JTextField heightJTextField = new JTextField(5);
		heightJTextField.setHorizontalAlignment(JTextField.CENTER);
		heightJTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				chart.setgHeight((int) getInput(heightJTextField));
				chart.repaint();
			}
		});
		widthAndHeightPanel.add(heightJTextField);

		JPanel xAndYPanel = new JPanel();
		xAndYPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		xAndYPanel.add(new JLabel("Pontos X e Y: "));

		JTextField xJTextField = new JTextField(5);
		xJTextField.setHorizontalAlignment(JTextField.CENTER);
		xJTextField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				chart.setgX((int) getInput(xJTextField));
				chart.repaint();
			}
		});
		xAndYPanel.add(xJTextField);

		JTextField yJTextField = new JTextField(5);
		yJTextField.setHorizontalAlignment(JTextField.CENTER);
		yJTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				chart.setgY((int) getInput(yJTextField));
				chart.repaint();
			}
		});
		xAndYPanel.add(yJTextField);

		controlPanel.add(valuesPanel);
		controlPanel.add(xAndYPanel);
		controlPanel.add(widthAndHeightPanel);

		add(chart);
		add(controlPanel, BorderLayout.SOUTH);
	}

	private double getInput(JTextField inputField) {
		String input = inputField.getText();
		return input.matches("\\d+") ? Double.parseDouble(input) : 0;
	}

	public static void main(String[] args) {
		GraficoDePizzaFrame application = new GraficoDePizzaFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		application.setSize(new Dimension(600, 600));
		application.setLocationRelativeTo(null);
		application.setVisible(true);
	}
}
