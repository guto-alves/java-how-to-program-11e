/*
 * Objetivo: 18.21 (Gerar labirintos aleatoriamente) Escreva um método mazeGenerator
 * que recebe como argumento um array bidimensional de 12 × 12 caracteres e que
 * produza aleatoriamente um labirinto. O método também deve fornecer as posições
 * inicial e final desse labirinto. Teste seu método mazeTraversal da Questão 18.20
 * utilizando vários labirintos gerados aleatoriamente.
 * 
 * Autor: Gustavo Alves
 */

package ch18.ex18_21;

import java.awt.Point;
import java.security.SecureRandom;

public class MazeGenerator {
	private static SecureRandom random = new SecureRandom();

	private enum Direction {
		DOWN, RIGHT, UP, LEFT
	};

	public static char[][] mazeGenerator(char[][] maze) {
		maze = fillMaze(maze);

		Point inputPoint = new Point();
		Point outputPoint = new Point();

		while (inputPoint.x == outputPoint.x && inputPoint.y == outputPoint.y) {
			inputPoint = generateInputOrOutput(maze);
			outputPoint = generateInputOrOutput(maze);
		}

		maze[inputPoint.x][inputPoint.y] = '.';
		maze[outputPoint.x][outputPoint.y] = '.';

		return maze;
	}

	// Fills the outside of the maze with '#' and the inside randomly with '.' or
	// '#'.
	private static char[][] fillMaze(char[][] maze) {
		int maxLinha = maze.length - 1;
		int maxColuna = maze[0].length - 1;

		// preenche as bordas do labirinto com #
		for (int i = 0; i <= maxColuna; i++) {
			maze[0][i] = '#';
			maze[maxLinha][i] = '#';
		}

		for (int i = 0; i <= maxLinha; i++) {
			maze[i][0] = '#';
			maze[i][maxColuna] = '#';
		}

		// preenche a parte interna do labirinto de modo aleatório
		for (int i = 1; i < maxLinha; i++) {
			for (int j = 1; j < maze[i].length - 1; j++)
				maze[i][j] = random.nextInt(2) == 0 ? '#' : '.';
		}

		return maze;
	}

	// Generates a coordinate that can be used as the input or output in the maze
	public static Point generateInputOrOutput(char[][] maze) {
		Point point = new Point();

		switch (generateDirection()) {
		case DOWN:
			point.setLocation(maze.length - 1, 1 + random.nextInt(maze.length - 2));
			break;
		case RIGHT:
			point.setLocation(1 + random.nextInt(maze.length - 2), maze.length - 1);
			break;
		case UP:
			point.setLocation(0, 1 + random.nextInt(maze.length - 2));
			break;
		case LEFT:
			point.setLocation(1 + random.nextInt(maze.length - 2), 0);
			break;
		}

		return point;
	}

	public static Direction generateDirection() {
		switch (new SecureRandom().nextInt(4)) {
		case 0:
			return Direction.DOWN;
		case 1:
			return Direction.RIGHT;
		case 2:
			return Direction.UP;
		default: // case 3
			return Direction.LEFT;
		}
	}

	public static void printMaze(char[][] maze) {
		for (int i = 0; i < maze[0].length; i++) {
			for (int j = 0; j < maze.length; j++)
				System.out.print(maze[i][j] + " ");

			System.out.println();
		}
	}

	public static void main(String[] args) {
		char[][] maze = mazeGenerator(new char[12][12]);

		printMaze(maze);
	}
}
