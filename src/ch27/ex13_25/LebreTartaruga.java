/*
 * Objetivo: 13.25 (Lebre e a tartaruga) Produza uma versão gráfica da simulação da lebre e tartaruga (Questão 7.28). Simule a montanha desenhando
 * um arco que se estende do canto inferior esquerdo da janela ao canto superior direito. A lebre e a tartaruga devem correr subindo a montanha.
 * Implemente a saída gráfica para imprimir a tartaruga e a lebre no arco a cada movimento. [Dica: estenda o percurso da corrida de
 * 70 para 300 a fim de permitir uma área gráfica maior.]
 * 
 * 7.28 (Simulação: a tartaruga e a lebre) Neste problema, você recriará a clássica corrida da tartaruga e da lebre. Você utilizará geração de
 * números aleatórios para desenvolver uma simulação desse evento memorável.
 * Nossos competidores começam a corrida no quadrado 1 de 70 quadrados. Cada um representa uma possível posição ao longo do percurso
 * da competição. A linha de chegada está no quadrado 70. O primeiro competidor a alcançar ou passar o quadrado 70 é recompensado
 * com um cesto de cenouras frescas e alface. O percurso envolve subir uma montanha escorregadia, por isso, ocasionalmente os competidores
 * perdem terreno.
 * Um relógio emite um tique por segundo. A cada tique-taque do relógio, seu aplicativo deve ajustar a posição dos animais de acordo com
 * as regras na Figura 7.32. Use variáveis para monitorar as posições dos animais (isto é, os números de posição são 1 a 70). Inicie cada animal
 * na posição 1 (a "largada"). Se um animal escorregar para a esquerda do quadrado 1, mova-o novamente para o quadrado 1.
 * 
 * 		Animal 				  Tipo de movimento 		Porcentagem do tempo		Movimento real
 * 	Tartaruga 			    	Caminhada rápida 			50%						 3	 quadrados à direita
 * 								Escorregão 					20% 					 6	 quadrados à esquerda
 *							    Caminhada lenta				30%						 1   quadrado à direita
 *
 *  Lebre					    Dormir 						20% 					 0   Sem nenhum movimento
 * 								Salto grande 				20% 				   	 9 	 quadrados à direita
 * 								Escorregão grande 			10%  					 12  quadrados à esquerda
 * 								Salto pequeno 				30%					     1   quadrado à direita
 * 								scorregão pequeno 			20% 			     	 2   quadrados à esquerda
 * 
 * Gere as porcentagens na Figura 7.32 produzindo um inteiro aleatório i no intervalo 1 􀁤 i 􀁤 10. Para a tartaruga, realize uma “caminhada
 * rápida” quando 1 <= i <= 5, um “escorregão” quando 6 <= i <= 7 ou uma “caminhada lenta” quando 8 <= i <= 10. Utilize uma técnica semelhante
 * para mover a lebre.
 * Comece a corrida exibindo
 * BANG !!!!!
 * E  LÁ VÃO ELES !!!!!
 * Então, para cada tique do relógio (isto é, para cada repetição de um loop), exiba uma linha de 70 posições mostrando a letra T na posição
 * da tartaruga e a letra H na posição da lebre. Ocasionalmente, os competidores ocuparão o mesmo quadrado. Nesse caso, a tartaruga
 * morde a lebre e seu aplicativo deve exibir AI!!! começando nessa posição. Todas as outras posições da saída diferentes de T, H ou AI!!!
 * ( no caso de um empate) devem estar em branco.
 * Depois de cada linha ser exibida, teste se o animal alcançou ou passou o quadrado 70. Se tiver alcançado, exiba o Status e termine a
 * simulação. Se a tartaruga ganhar, exiba A TARTARUGA VENCEU!!! ÊH!!! Se a lebre ganhar, exiba A LEBRE GANHOU. OH. Se os dois
 * ganharem na mesma hora, você pode querer favorecer a tartaruga (a "coitadinha") ou exibir OCORREU UM EMPATE. Se nenhum animal
 * ganhar, realize o loop novamente para simular o próximo tique do relógio. Quando você estiver pronto para executar seu aplicativo, monte
 * um grupo de fãs para observar a corrida. Você se surpreenderá com a empolgação da sua audiência!
 * Mais adiante no livro, introduziremos várias capacidades do Java, como gráficos, imagens, animação, som e multithreading. À medida
 * que estudar esses recursos, você pode se divertir aprimorando sua simulação da competição entre a lebre e a tartaruga.
 * 
 * Autor: Gustavo Alves
 * Data: 18/03/2019
 */

package ch13.ex13_25;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LebreTartaruga extends JPanel implements ActionListener {
	private int xTartaruga = 40;
	private int yTartaruga = 100;
	private int xLebre = 40;
	private int yLebre = 40;

	private int movimentoTartaruga;
	private int movimentoLebre;

	private enum Status {
		TARTARUGA, LEBRE, EMPATE, CONTINUA,
	};

	private Status statusCorrida = Status.CONTINUA;

	private BufferedImage tartarugaImg = null;
	private BufferedImage lebreImg = null;
	private BufferedImage bandeiraImg = null;
	private BufferedImage cestoImg = null;

	private final SecureRandom random = new SecureRandom();

	private Timer time;

	private String statusTarturaga = "";
	private String statusLebre = "";

	public LebreTartaruga() {
		setBackground(Color.WHITE);

		try {
			tartarugaImg = ImageIO.read(new File("./src/ch13/ex13_25/images/Tartaruga25.png"));
			lebreImg = ImageIO.read(new File("./src/ch13/ex13_25/images/Lebre25.png"));
			bandeiraImg = ImageIO.read(new File("./src/ch13/ex13_25/images/Bandeira25.png"));
			cestoImg = ImageIO.read(new File("./src/ch13/ex13_25/images/cesto25.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		time = new Timer(500, this);
		time.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g.setFont(new Font("SansSerif", Font.PLAIN, 16));
		g.drawString("Tartaruga: " + statusTarturaga, 10, 50);
		g.drawString("Lebre: " + statusLebre, 10, 80);

		// desenha a montanha (isto é, a pista para a corrida)
		g.setColor(new Color(189, 121, 66));
		g2d.setStroke(new BasicStroke(3.0f));
		g.drawLine(0, getHeight() - 70, getWidth() - 70, 0);
		g.drawLine(90, getHeight(), getWidth(), 90);

		if (statusCorrida == Status.EMPATE) {
			g.drawImage(tartarugaImg, 585, getHeight() - 650, this);
			g.drawImage(lebreImg, 585, getHeight() - 590, this);
		} else if (statusCorrida == Status.TARTARUGA) {
			g.drawImage(tartarugaImg, 585, getHeight() - 650, this);
			g.drawImage(lebreImg, xLebre, getHeight() - yLebre, this);
		} else if (statusCorrida == Status.LEBRE) {
			g.drawImage(lebreImg, 585, getHeight() - 590, this);
			g.drawImage(tartarugaImg, xTartaruga, getHeight() - yTartaruga, this);
		} else {
			g.drawImage(tartarugaImg, xTartaruga, getHeight() - yTartaruga, this);
			g.drawImage(lebreImg, xLebre, getHeight() - yLebre, this);
		}

		g.drawImage(bandeiraImg, 530, getHeight() - 690, this);
		g.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(5.0f));
		g.drawLine(580, getHeight() - 660, 580, 190);
		g.drawImage(cestoImg, 630, getHeight() - 660, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (statusCorrida == Status.CONTINUA)
			geraMovimento();
		else if (statusCorrida == Status.TARTARUGA) {
			time.stop();
			JOptionPane.showMessageDialog(LebreTartaruga.this, "A TARTARUGA VENCEU!!! ÊH!!!", "Tartaruga Ganhou '-'",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (statusCorrida == Status.LEBRE) {
			time.stop();
			JOptionPane.showMessageDialog(LebreTartaruga.this, "LEBRE GANHOU. OH ;-;", "Infelismente a Lebre ganhou",
					JOptionPane.INFORMATION_MESSAGE);
		} else { // Status.EMPATE
			time.stop();
			JOptionPane.showMessageDialog(LebreTartaruga.this, "OCORREU UM EMPATE.", "Os dois ganharam na mesma hora",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void geraMovimento() {
		int tartarugaRandom = 1 + random.nextInt(10);
		if (tartarugaRandom >= 1 && tartarugaRandom <= 5) {// “caminhada rápida” = 3 quadrados à direita
			movimentoTartaruga = 3;
			statusTarturaga = "Caminhada rápida";
		} else if (tartarugaRandom >= 6 && tartarugaRandom <= 7) { // “escorregão” = 6 quadrados à esquerda
			movimentoTartaruga = -6;
			statusTarturaga = "Escorregão";
		} else if (tartarugaRandom >= 8 && tartarugaRandom <= 10) { // “caminhada lenta” = 1 quadrado à direita
			movimentoTartaruga = 1;
			statusTarturaga = "Caminhada lenta";
		}

		int lebreRandom = 1 + random.nextInt(10);
		if (lebreRandom == 1 || lebreRandom == 2) {// Dormir = Sem nenhum movimento
			movimentoLebre = 0;
			statusLebre = "Dormir";
		} else if (lebreRandom == 3 || lebreRandom == 4) { // Salto grande = 9 quadrados à direita
			movimentoLebre = 9;
			statusLebre = "Salto grande";
		} else if (lebreRandom == 6 || lebreRandom == 7 || lebreRandom == 8) { // Salto pequeno = 1 quadrado à direita
			movimentoLebre = 1;
			statusLebre = "Salto pequeno";
		} else if (lebreRandom == 9 || lebreRandom == 10) { // Escorregão pequeno = 2 quadrados à esquerda
			movimentoLebre = -2;
			statusLebre = "Escorregão pequeno";
		} else if (lebreRandom == 5) { // Escorregão grande = 12 quadrados à esquerda
			movimentoLebre = -12;
			statusLebre = "Escorregão grande";
		}

		setCoordenadas();
	}

	public void setCoordenadas() {
		// configura a posição da tartaruga
		if (movimentoTartaruga > 0) { // verifica se movimento é negativo, ou seja, a tartaruga "anda para trás"
			for (int i = 0; i < movimentoTartaruga; i++) {
				xTartaruga += 10;
				yTartaruga += 10;
			}
		} else if (movimentoTartaruga == -6 && xTartaruga - 60 < 40) { // se, volta do ínicio
			xTartaruga = 40;
			yTartaruga = 100;
		} else {
			for (int i = 0; i < Math.abs(movimentoTartaruga); i++) {
				xTartaruga -= 10;
				yTartaruga -= 10;
			}
		}

		// configura a posição da lebre
		if (movimentoLebre >= 0) { // verifica se movimento é positivo, ou seja, a lebre "anda para frente"
			for (int i = 0; i < movimentoLebre; i++) {
				xLebre += 10;
				yLebre += 10;
			}
		} else if ((movimentoLebre == -12 && xLebre - 120 < 40) || (movimentoLebre == -2 && xLebre - 20 < 40)) {
			xLebre = 40;
			yLebre = 40;
		} else {
			for (int i = 0; i < Math.abs(movimentoLebre); i++) {
				xLebre -= 10;
				yLebre -= 10;
			}
		}

		setStatus();
	}

	public void setStatus() {
		if (xTartaruga > 580 && xLebre > 580)
			statusCorrida = Status.EMPATE;
		else if (xTartaruga > 580)
			statusCorrida = Status.TARTARUGA;
		else if (xLebre > 580)
			statusCorrida = Status.LEBRE;
		else
			statusCorrida = Status.CONTINUA;

		repaint();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Tartaruga e a Lebre");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		LebreTartaruga corrida = new LebreTartaruga();
		frame.add(corrida);

		frame.setSize(685, 720);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
