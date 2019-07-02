/*
 * Objetivo: 23.10 (Rebatendo a bola) Escreva um programa que faz uma bola 
 * azul rebater dentro de um JPanel. A bola deve começar a se mover com um 
 * evento mousePressed. Quando a bola atingir a borda do JPanel, ela deve 
 * rebater fora da borda e continuar na direção oposta. A bola deve ser 
 * atualizada com uma interface Runnable.
 * 
 * Autor: Gustavo Alves
 */

package ch23.ex23_10;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JPanel;

public class RebatingTheBallJPanel extends JPanel implements Runnable {
	private Point ballPoint;

	private enum Direction {
		DOWN, RIGHT, LEFT, UP, DIAGONAL_LEFT_DOWN, DIAGONAL_LEFT_UP, DIAGONAL_RIGHT_DOWN, DIAGONAL_RIGHT_UP
	};

	private Direction currentDirection;

	public RebatingTheBallJPanel() {
		ballPoint = new Point(320 / 2, 320 / 2);

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent event) {
				startMove();
			}
		});

		setBackground(Color.WHITE);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLUE);
		g.fillOval(ballPoint.x, ballPoint.y, 50, 50);
	}

	public void startMove() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(this);
	}

	@Override
	public void run() {
		try {
			while (true) {
				Direction nextDirection = generateDirection();

				while (nextDirection == currentDirection)
					nextDirection = generateDirection();

				currentDirection = nextDirection;

				do {
					move(currentDirection);
					repaint();

					Thread.sleep(2);

					if (isEdge(currentDirection))
						break;
				} while (true);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	private void move(Direction direction) {
		switch (direction) {
		case DOWN:
			ballPoint.y++;
			break;
		case RIGHT:
			ballPoint.x++;
			break;
		case UP:
			ballPoint.y--;
			break;
		case LEFT:
			ballPoint.x--;
			break;
		case DIAGONAL_LEFT_DOWN:
			ballPoint.x--;
			ballPoint.y++;
			break;
		case DIAGONAL_LEFT_UP:
			ballPoint.x++;
			ballPoint.y--;
			break;
		case DIAGONAL_RIGHT_DOWN:
			ballPoint.x++;
			ballPoint.y++;
			break;
		case DIAGONAL_RIGHT_UP:
			ballPoint.x--;
			ballPoint.y--;
			break;
		}
	}

	private boolean isEdge(Direction direction) {
		switch (direction) {
		case DOWN:
			if (ballPoint.y >= 310)
				return true;
			break;
		case RIGHT:
			if (ballPoint.x >= 330)
				return true;
			break;
		case UP:
			if (ballPoint.y <= 0)
				return true;
			break;
		case LEFT:
			if (ballPoint.x <= 0)
				return true;
			break;
		case DIAGONAL_LEFT_DOWN:
			if (ballPoint.x <= 0 || ballPoint.y >= 310)
				return true;
			break;
		case DIAGONAL_LEFT_UP:
			if (ballPoint.x >= 330 || ballPoint.y <= 0)
				return true;
			break;
		case DIAGONAL_RIGHT_DOWN:
			if (ballPoint.x >= 330 || ballPoint.y >= 310)
				return true;
			break;
		case DIAGONAL_RIGHT_UP:
			if (ballPoint.x <= 0 || ballPoint.y <= 0)
				return true;
			break;
		}

		return false;
	}

	private Direction generateDirection() {
		switch (new SecureRandom().nextInt(8)) {
		case 0:
			return Direction.DOWN;
		case 1:
			return Direction.RIGHT;
		case 2:
			return Direction.UP;
		case 3:
			return Direction.LEFT;
		case 4:
			return Direction.DIAGONAL_LEFT_DOWN;
		case 5:
			return Direction.DIAGONAL_LEFT_UP;
		case 6:
			return Direction.DIAGONAL_RIGHT_DOWN;
		default:
			return Direction.DIAGONAL_RIGHT_UP;
		}
	}
}
