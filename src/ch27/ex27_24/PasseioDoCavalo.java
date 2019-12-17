/*
 * Objetivo: 13.24 (Passeio do Cavalo) Crie uma versÃ£o grÃ¡fica do problema do Passeio do Cavalo (questÃµes 7.22, 7.23 e 7.26). Ã€ medida que cada 
 * movimento Ã© feito, a cÃ©lula apropriada do tabuleiro deve ser atualizada com o nÃºmero adequado do movimento. Se o resultado do programa Ã©
 * um passeio completo ou um passeio fechado, o programa deve exibir uma mensagem apropriada. Se quiser, utilize a classe Timer (veja
 * a QuestÃ£o 13.19) para ajudar a animar o Passeio do Cavalo.
 * 
 * 7.22 (Passeio do cavalo) Um problema interessante para os fãs de xadrez é o problema do Passeio do Cavalo, originalmente proposto pelo
 * matemático Euler. A peça do cavalo pode mover-se em um tabuleiro vazio e tocar cada um dos 64 quadrados somente uma única vez? Aqui,
 * estudamos esse intrigante problema em profundidade.
 * O cavalo só faz movimentos em forma de L (dois espaços em uma direção e um outro em uma direção perpendicular). Portanto, como
 * mostrado na Figura 7.30, partindo de um quadrado próximo do centro de um tabuleiro de xadrez vazio, o cavalo (rotulado K) pode fazer oito
 * movimentos diferentes (numerados de 0 a 7).
 * a) Desenhe um tabuleiro de xadrez oito por oito em uma folha de papel e tente o Passeio do Cavalo manualmente. Coloque um 1 no quadrado
 * inicial, um 2 no segundo quadrado, um 3 no terceiro e assim por diante. Antes de iniciar o passeio, estime até onde você chegará,
 * lembrando que um passeio completo consiste em 64 movimentos. Até onde você foi? Isso foi próximo de sua estimativa?
 * b) Agora vamos desenvolver um aplicativo que moverá o cavalo pelo tabuleiro. O tabuleiro é representado por um array bidimensional
 * oito por oito board. Cada quadrado é inicializado como zero. Descrevemos cada um dos oito possíveis movimentos em termos de
 * seus componentes vertical e horizontal. Por exemplo, um movimento do tipo 0, como mostrado na Figura 7.30, consiste em mover
 * dois quadrados horizontalmente para a direita e um quadrado verticalmente para cima. Um movimento do tipo 2 consiste em mover
 * um quadrado horizontalmente para a esquerda e dois quadrados verticalmente para cima. Movimentos horizontais para a esquerda e
 * movimentos verticais para cima são indicados com números negativos. Os oitos movimentos podem ser descritos por dois arrays unidimensionais,
 * horizontal e vertical, como segue:
 * 
 * 		horizontal[0] = 2 vertical[0] = -1
 * 		horizontal[1] = 1 vertical[1] = -2
 * 		horizontal[2] = -1 vertical[2] = -2
 *		horizontal[3] = -2 vertical[3] = -1
 *		horizontal[4] = -2 vertical[4] = 1
 *		horizontal[5] = -1 vertical[5] = 2
 * 		horizontal[6] = 1 vertical[6] = 2
 *	    horizontal[7] = 2 vertical[7] = 1
 * 
 * Faça com que as variáveis currentRow e currentColumn indiquem, respectivamente, a linha e a coluna da posição atual
 * do cavalo. Para fazer um movimento do tipo moveNumber, em que moveNumber está entre 0 e 7, seu aplicativo deve utilizar as
 * instruções
 * 
 * 		currentRow += vertical[moveNumber];
 * 		currentColumn += horizontal[moveNumber];
 * 
 * Escreva um aplicativo para mover o cavalo pelo tabuleiro. Mantenha um contador que varia de 1 a 64. Registre a última contagem
 * em cada quadrado para o qual o cavalo se move. Teste cada movimento potencial para ver se o cavalo já visitou esse quadrado. Teste
 * cada movimento potencial para assegurar que o cavalo não saia fora do tabuleiro. Execute o aplicativo. Quantos movimentos o cavalo
 * fez?
 * 
 * Autor: Gustavo Alves
 * Data: 19/03/2019
 */

package ch27.ex27_24;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PasseioDoCavalo extends JFrame implements KeyListener, ActionListener {
	private JButton[][] chessboard = new JButton[8][8];
	private JPanel panelChessboard;

	private Icon iconHorse = new ImageIcon(getClass().getResource("images/24cavalopreto1.png"));
	private Icon iconPossivelMovimento = new ImageIcon(getClass().getResource("images/bolinha24.png"));

	private int currentRow;
	private int currentColumn;

	private int counter = 0; // contador de movimento

	private boolean initialMovement = true;

	private int[] horizontal = new int[8];
	private int[] vertical = new int[8];

	private int errorsCounter = 0;

	private Timer timer = new Timer(1000, this);
	public JLabel timeLabel = new JLabel("02:00");
	private int minutos = 2;
	private int segundos = 0;
	private int minutosPadrao = 2;
	private boolean infinito = false;

	private JButton startTimerButton;

	private JPanel panelSetting;

	private enum Status {
		GANHOU, PERDEU, CONTINUA
	};

	private Status statusPasseio = Status.CONTINUA;

	private Icon[] iconsHorses;
	private JComboBox<Icon> listHorses;

	private JButton configButton;

	private JButton resetButton;

	public PasseioDoCavalo() {
		super("Passeio do Cavalo");

		panelChessboard = new JPanel(new GridLayout(8, 8));

		ChessboardHandler handler = new ChessboardHandler();

		for (int i = 0; i < chessboard.length; i++) {
			for (int j = 0; j < chessboard.length; j++) {
				chessboard[i][j] = new JButton();
				chessboard[i][j].addActionListener(handler);
				chessboard[i][j].addKeyListener(this);
				chessboard[i][j].setBorderPainted(false);
				if (i % 2 == 0)
					if (j % 2 == 1)
						chessboard[i][j].setBackground(new Color(189, 121, 66));
					else
						chessboard[i][j].setBackground(new Color(248, 221, 167));
				else if (j % 2 == 1)
					chessboard[i][j].setBackground(new Color(248, 221, 167));
				else
					chessboard[i][j].setBackground(new Color(189, 121, 66));

				panelChessboard.add(chessboard[i][j]);
			}
		}
		add(panelChessboard, BorderLayout.CENTER);

		// inicializa painel de configuração
		panelSetting = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelSetting.setBackground(Color.ORANGE);

		timeLabel.setFont(new Font("Times", Font.BOLD, 20));
		timeLabel.setForeground(Color.WHITE);
		panelSetting.add(timeLabel);

		startTimerButton = new JButton("Jogar");
		startTimerButton.setBackground(Color.GREEN);
		startTimerButton.setForeground(Color.WHITE);
		startTimerButton.setFont(new Font("Times", Font.BOLD, 14));
		startTimerButton.setToolTipText("Iniciar temporizador do jogo");
		startTimerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timer.start();
				startTimerButton.setVisible(false);
			}
		});
		panelSetting.add(startTimerButton);

		panelSetting.add(new JLabel(" | "));

		resetButton = new JButton("Reset");
		resetButton.setBackground(new Color(255, 215, 0));
		resetButton.setForeground(Color.WHITE);
		resetButton.setFont(new Font("Times", Font.BOLD, 14));
		resetButton.setToolTipText("Resetar jogo");
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();

			}
		});
		panelSetting.add(resetButton);

		panelSetting.add(new JLabel(" | "));

		configButton = new JButton();
		configButton.setBackground(new Color(255, 215, 0));
		configButton.setIcon(new ImageIcon(getClass().getResource("images/config.png")));
		configButton.setToolTipText("Configurar tempo e cavalo");
		configButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("OpÃ§Ãµes");

				JPanel panelconfigButton = new JPanel(new FlowLayout());
				panelconfigButton.setBackground(new Color(248, 190, 94));
				panelconfigButton.add(new JLabel("Jogar com:"));

				iconsHorses = new ImageIcon[12];
				for (int i = 0; i < iconsHorses.length; i++)
					iconsHorses[i] = new ImageIcon();

				iconsHorses[0] = new ImageIcon(getClass().getResource("images/24cavalopreto1.png"));
				iconsHorses[1] = new ImageIcon(getClass().getResource("images/24cavalopreto2.png"));
				iconsHorses[2] = new ImageIcon(getClass().getResource("images/24cavalopreto3.png"));
				iconsHorses[3] = new ImageIcon(getClass().getResource("images/24cavalopreto4.png"));
				iconsHorses[4] = new ImageIcon(getClass().getResource("images/24cavaloamarelo1.png"));
				iconsHorses[5] = new ImageIcon(getClass().getResource("images/24cavaloamarelo2.jpg"));
				iconsHorses[6] = new ImageIcon(getClass().getResource("images/24cavaloamarelo3.png"));
				iconsHorses[7] = new ImageIcon(getClass().getResource("images/24cavaloazul1.png"));
				iconsHorses[8] = new ImageIcon(getClass().getResource("images/24cavaloazul2.png"));
				iconsHorses[9] = new ImageIcon(getClass().getResource("images/24cavalobranco1.png"));
				iconsHorses[10] = new ImageIcon(getClass().getResource("images/24cavaloverde.png"));
				iconsHorses[11] = new ImageIcon(getClass().getResource("images/24cavalovermelho.png"));

				listHorses = new JComboBox<Icon>(iconsHorses);
				listHorses.setMaximumRowCount(3);
				listHorses.addItemListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						iconHorse = iconsHorses[listHorses.getSelectedIndex()];
						if (!initialMovement)
							chessboard[currentRow][currentColumn].setIcon(iconHorse);
					}
				});
				panelconfigButton.add(listHorses);

				panelconfigButton.add(new JLabel("Tempo máximo (mins):"));

				String[] minutoString = { "2", "5", "7", "10", "30", "∞" };
				JComboBox<String> minutosCombo = new JComboBox<String>(minutoString);
				minutosCombo.addItemListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						if (!timer.isRunning() && statusPasseio == Status.CONTINUA) {
							if (minutoString[minutosCombo.getSelectedIndex()].equals("∞")) {
								infinito = true;
								timeLabel.setIcon(new ImageIcon(getClass().getResource("images/24infinito.png")));
								timeLabel.setText(null);
								timeLabel.setToolTipText("Tempo infinito");
							} else {
								infinito = false;
								minutosPadrao = Integer.parseInt(minutoString[minutosCombo.getSelectedIndex()]);
								minutos = minutosPadrao;
								timeLabel.setText(String.format("%02d:%02d", minutos, segundos));
								timeLabel.setIcon(null);
								timeLabel.setToolTipText(null);
							}

						}

					}
				});
				panelconfigButton.add(minutosCombo);

				frame.add(panelconfigButton);
				frame.setSize(225, 130);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		});
		panelSetting.add(configButton);
		add(panelSetting, BorderLayout.NORTH);

		horizontal[0] = 2;
		horizontal[1] = 1;
		horizontal[2] = -1;
		horizontal[3] = -2;
		horizontal[4] = -2;
		horizontal[5] = -1;
		horizontal[6] = 1;
		horizontal[7] = 2;

		vertical[0] = -1;
		vertical[1] = -2;
		vertical[2] = -2;
		vertical[3] = -1;
		vertical[4] = 1;
		vertical[5] = 2;
		vertical[6] = 2;
		vertical[7] = 1;
	}

	private class ChessboardHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < chessboard.length; i++) {
				for (int j = 0; j < chessboard.length; j++) {
					if (e.getSource() == chessboard[i][j]) {
						if (timer.isRunning()) {
							if (initialMovement) {
								initialMovement = false;
								chessboard[i][j].setIcon(iconHorse);
								currentRow = i;
								currentColumn = j;
								counter++;
								displaysMovements();
							} else {
								if (isEmpty(i, j)) {
									if (isValidMovement(i, j)) {
										hidesMovements();
										chessboard[currentRow][currentColumn].setIcon(null);
										chessboard[currentRow][currentColumn].setText("" + counter);
										chessboard[currentRow][currentColumn].setForeground(Color.BLUE);
										currentRow = i;
										currentColumn = j;
										chessboard[currentRow][currentColumn].setIcon(iconHorse);
										counter++;
										setStatusRide();
										displaysMovements();
									} else {
										if (++errorsCounter == 2) { // a cada dois movimentos errados exibe aviso
											errorsCounter = 0;
											JOptionPane.showMessageDialog(null,
													"Ei, o cavalo sÃ³ faz movimentos em forma de L.", "Aviso",
													JOptionPane.INFORMATION_MESSAGE);

										}
									}
								} else {
									if (++errorsCounter == 2) {
										errorsCounter = 0;
										JOptionPane.showMessageDialog(null,
												"O cavalo já passou por essa casa. Tente outra.", "Aviso",
												JOptionPane.INFORMATION_MESSAGE);
									}
								}
							}

						} else {
							JOptionPane.showMessageDialog(null, "Clique no botÃ£o \"Jogar\" para comeÃ§ar o passeio!",
									"Aviso", JOptionPane.INFORMATION_MESSAGE);

						}

					}
				}
			}

		}

	}

	public void displaysMovements() {
		for (int i = 0; i < vertical.length; i++) {
			try {
				if (isEmpty(currentRow + vertical[i], currentColumn + horizontal[i])) {
					chessboard[currentRow + vertical[i]][currentColumn + horizontal[i]].setIcon(iconPossivelMovimento);
				} else
					chessboard[currentRow + vertical[i]][currentColumn + horizontal[i]].setIcon(null);
			} catch (Exception e) {
			}
		}

	}

	public void hidesMovements() {
		for (int i = 0; i < vertical.length; i++) {
			try {
				chessboard[currentRow + vertical[i]][currentColumn + horizontal[i]].setIcon(null);
			} catch (Exception e) {
			}
		}

	}

	public boolean isValidMovement(int rowNext, int columnNext) {
		for (int i = 0; i < vertical.length; i++) {
			if (currentRow + vertical[i] == rowNext && currentColumn + horizontal[i] == columnNext)
				return true;
		}

		return false;

	}

	public boolean isEmpty(int rowNext, int columnNext) {
		try {
			if (chessboard[rowNext][columnNext].getText().equals(""))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	public void setStatusRide() {
		boolean temMovimento = false;

		// verifica se ainda tem algum movimento para fazer
		for (int i = 0; i < vertical.length; i++) {
			if (isEmpty(currentRow + vertical[i], currentColumn + horizontal[i])) {
				temMovimento = true;
				statusPasseio = Status.CONTINUA;
			}
		}

		if (temMovimento == false) {
			if (counter == 64)
				statusPasseio = Status.GANHOU;
			else
				statusPasseio = Status.PERDEU;

			finishRide();
		}

	}

	public void finishRide() {
		if (statusPasseio == Status.GANHOU) {
			timer.stop();
			JOptionPane.showMessageDialog(null,
					"Parabéns, você faz um passeio completo (moveu o cavalo tocando cada um dos \n64 quadrados do tabuleiro somente uma única vez).\n\nOBS: Clique no botão \"Reset\" ou pressione F5 ou R para jogar novamente.",
					"Passeio Completo", JOptionPane.INFORMATION_MESSAGE);

			for (int i = 0; i < chessboard.length; i++) {
				for (int j = 0; j < chessboard.length; j++) {
					chessboard[i][j].setForeground(Color.GREEN);
					removeActionListener(i, j);
				}
			}
		} else if (statusPasseio == Status.PERDEU) {
			timer.stop();
			for (int i = 0; i < chessboard.length; i++) {
				for (int j = 0; j < chessboard.length; j++) {
					chessboard[i][j].setForeground(Color.RED);
					removeActionListener(i, j);
				}

			}
			JOptionPane.showMessageDialog(null, String.format(
					"Passeio Incompleto. Você conseguiu mover o cavalo apenas %d quadrados.\n\nOBS: Clique no botão \"Reset\" ou pressione F5 ou R para jogar novamente.",
					counter), "Passeio Incompleto", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!infinito) {
			if (segundos == 0) {
				segundos = 59;
				minutos--;
			} else
				segundos--;

			timeLabel.setText(String.format("%02d:%02d", minutos, segundos));

			if (minutos == 0 && segundos <= 15) {
				if (segundos % 2 == 0)
					timeLabel.setForeground(Color.RED);
				else
					timeLabel.setForeground(Color.WHITE);

			}

			if (minutos == 0 && segundos == 0) {
				timer.stop();
				statusPasseio = Status.PERDEU;
				hidesMovements();
				JOptionPane.showMessageDialog(null, "OPS: tempo esgotado!");
				finishRide();

			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if ("F5" == KeyEvent.getKeyText(e.getKeyCode()))
			reset();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if ("R".equals(String.valueOf(e.getKeyChar())))
			reset();
	}

	public void reset() {
		timer.stop();
		hidesMovements();

		ChessboardHandler handler = new ChessboardHandler();
		for (int i = 0; i < chessboard.length; i++) {
			for (int j = 0; j < chessboard.length; j++) {
				chessboard[i][j].setText("");
				removeActionListener(i, j);
				chessboard[i][j].addActionListener(handler);
			}

		}
		chessboard[currentRow][currentColumn].setIcon(null);
		startTimerButton.setVisible(true);
		minutos = minutosPadrao;
		segundos = 0;
		if (infinito)
			timeLabel.setText("");
		else
			timeLabel.setText(String.format("%02d:%02d", minutos, segundos));
		timeLabel.setForeground(Color.WHITE);
		counter = 0;
		statusPasseio = Status.CONTINUA;
		initialMovement = true;
		currentRow = 0;
		currentColumn = 0;
	}

	public void removeActionListener(int i, int j) {
		ActionListener[] listeners = chessboard[i][j].getActionListeners();
		for (int k = 0; k < listeners.length; k++)
			chessboard[i][j].removeActionListener(listeners[k]);
	}

	public static void main(String[] args) {
		PasseioDoCavalo frame = new PasseioDoCavalo();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 430);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		JOptionPane.showMessageDialog(null,
				"Um problema interessante para os fãs de xadrez é o problema do \nPasseio do Cavalo, originalmente proposto pelo matemático Euler. \n\nA peça do cavalo pode mover-se em um tabuleiro vazio e \ntocar cada um dos 64 quadrados somente uma única vez?",
				"Sobre o Programa", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null,
				"Clique no botão \"Jogar\" e depois sobre a casa \nque deseja começar o passeio, boa sorte!",
				"Instruções", JOptionPane.INFORMATION_MESSAGE);

	}

}