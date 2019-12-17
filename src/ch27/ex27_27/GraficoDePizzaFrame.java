package ch27.ex27_27;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class GraficoDePizzaFrame extends JFrame {
	private GraficoDePizza chart;

	private int counter;

	public GraficoDePizzaFrame() {
		super("Gráfico de Pizza");

		chart = new GraficoDePizza(260, 90, 200, 200);

		for (int i = 0; i < 4; i++)
			chart.addPiece(new Piece(0, Color.BLUE));

		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder("Ajustar Gráfico"));
		controlPanel.setLayout(new GridLayout(4, 1));

		JPanel valuesPanel = new JPanel();
		valuesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		valuesPanel.add(new JLabel("Valores: "));

		JTextField[] valuesJTextFields = new JTextField[4];

		for (; counter < 4; counter++) {
			valuesJTextFields[counter] = new JTextField();
			valuesJTextFields[counter].setHorizontalAlignment(JTextField.CENTER);
			valuesJTextFields[counter].setColumns(5);
			valuesPanel.add(valuesJTextFields[counter]);
		}

		valuesJTextFields[0].addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				chart.setPiece(0, getInput(valuesJTextFields[0]), null);
				chart.repaint();
			}
		});
		valuesJTextFields[1].addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				chart.setPiece(1, getInput(valuesJTextFields[1]), null);
				chart.repaint();
			}
		});
		valuesJTextFields[2].addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				chart.setPiece(2, getInput(valuesJTextFields[2]), null);
				chart.repaint();
			}
		});
		valuesJTextFields[3].addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				chart.setPiece(3, getInput(valuesJTextFields[3]), null);
				chart.repaint();
			}
		});

		JPanel colorsJPanel = new JPanel();
		colorsJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		colorsJPanel.add(new JLabel("Cores: "));

		String[] colorsNames = { "Azul", "Vermelho", "Verde", "Ciano", "Amarelo", "Rosa", "Laranja", "Preto" };
		Color[] colors = { Color.BLUE, Color.RED, Color.GREEN, Color.CYAN, Color.YELLOW, Color.PINK, Color.ORANGE,
				Color.BLACK };

		JComboBox<String>[] colorsComboBoxs = new JComboBox[4];

		for (int i = 0; i < colorsComboBoxs.length; i++) {
			colorsComboBoxs[i] = new JComboBox<>(colorsNames);
			colorsJPanel.add(colorsComboBoxs[i]);
		}

		colorsComboBoxs[0].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					chart.setPiece(0, -1, colors[colorsComboBoxs[0].getSelectedIndex()]);
					chart.repaint();
				}
			}
		});
		colorsComboBoxs[1].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					chart.setPiece(1, -1, colors[colorsComboBoxs[1].getSelectedIndex()]);
					chart.repaint();
				}
			}
		});
		colorsComboBoxs[2].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					chart.setPiece(2, -1, colors[colorsComboBoxs[2].getSelectedIndex()]);
					chart.repaint();
				}
			}
		});
		colorsComboBoxs[3].addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					chart.setPiece(3, -1, colors[colorsComboBoxs[3].getSelectedIndex()]);
					chart.repaint();
				}
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
		controlPanel.add(colorsJPanel);
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

		application.setSize(new Dimension(800, 600));
		application.setLocationRelativeTo(null);
		application.setVisible(true);
	}
}
