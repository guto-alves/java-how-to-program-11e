/*
 * Objetivo: 18.19 (Fractais) Repita o padrão fractal da Seção 18.9 para formar uma
 * estrela. Inicie com cinco linhas (veja a Figura 18.21) em vez de uma, e cada linha
 * é uma ponta diferente da estrela. Aplique o padrão “fractal de Lo Feather” a cada
 * ponta da estrela.
 * 
 * Autor: Gustavo Alves
 */

// Fractal user interface.

package ch18.ex18_19;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fractal extends JFrame {
	private final int WIDTH = 400;
	private final int HEIGHT = 480;
	private final int MIN_LEVEL = 0;
	private final int MAX_LEVEL = 15;

	public Fractal() {
		super("Fractal");

		final JLabel levelJLabel = new JLabel("Level: 0");

		final FractalJPanel drawSpace = new FractalJPanel(0);

		final JPanel controlJPanel = new JPanel(new FlowLayout());

		final JButton decreaseLevelJButton = new JButton("Decrease Level");
		controlJPanel.add(decreaseLevelJButton);
		decreaseLevelJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int level = drawSpace.getLevel();
				--level;

				if ((level >= MIN_LEVEL) && (level <= MAX_LEVEL)) {
					levelJLabel.setText("Level: " + level);
					drawSpace.setLevel(level);
					repaint();
				}
			}
		});

		final JButton increaseLevelJButton = new JButton("Increase Level");
		controlJPanel.add(increaseLevelJButton);
		increaseLevelJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int level = drawSpace.getLevel();
				++level;

				if ((level >= MIN_LEVEL) && (level <= MAX_LEVEL)) {
					levelJLabel.setText("Level: " + level);
					drawSpace.setLevel(level);
					repaint();
				}
			}
		});

		controlJPanel.add(levelJLabel);

		final JPanel mainPainel = new JPanel();
		mainPainel.add(controlJPanel);
		mainPainel.add(drawSpace);

		add(mainPainel);

		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		Fractal fractal = new Fractal();
		fractal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
