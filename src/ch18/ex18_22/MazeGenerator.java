/*
 * Objetivo: 18.22 (Labirintos de qualquer tamanho) Generalize os métodos
 * mazeTraversal e mazeGenerator da Questão 18.20 e da Questão 18.21 para
 * processar labirintos de qualquer largura e altura.
 * 
 * Autor: Gustavo Alves
 */

package ch18.ex18_22;

import java.awt.Point;
import java.security.SecureRandom;

public class MazeGenerator {
	private char[][] maze;
	private Point inputPoint;
	private Point outputPoint;
	private final SecureRandom random = new SecureRandom();
	private int width;
	private int height;

	private enum Direction {
		DOWN, RIGHT, UP, LEFT
	};

	public MazeGenerator() {
		this(12, 12);
	}

	public MazeGenerator(int width, int height) {
		this.width = width;
		this.height = height;
		maze = new char[width][height];
		inputPoint = new Point();
		outputPoint = new Point();
		buildMaze();
	}

	private void buildMaze() {
		boolean withoutExit = true;

		while (withoutExit) {
			mazeGenerator();

			// copies the maze contents for mazeCopy
			char[][] mazeCopy = new char[width][height];

			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++)
					mazeCopy[i][j] = maze[i][j];
			}

			if (new MazeSolver(mazeCopy, inputPoint.x, inputPoint.y).isExit())
				withoutExit = false;
		}
	}

	private void mazeGenerator() {
		fillMaze();

		while (inputPoint.x == outputPoint.x && inputPoint.y == outputPoint.y) {
			inputPoint = generateInputOrOutput(maze);
			outputPoint = generateInputOrOutput(maze);
		}

		maze[inputPoint.x][inputPoint.y] = '.';
		maze[outputPoint.x][outputPoint.y] = '.';
	}

	// Fills the outside of the maze with '#' and the inside randomly with '.' or
	// '#'.
	private void fillMaze() {
		for (int i = 0; i < height; i++) {
			maze[0][i] = '#';
			maze[width - 1][i] = '#';
		}

		for (int i = 0; i < width; i++) {
			maze[i][0] = '#';
			maze[i][height - 1] = '#';
		}

		for (int i = 1; i < width - 1; i++) {
			for (int j = 1; j < height - 1; j++)
				maze[i][j] = random.nextInt(2) == 0 ? '#' : '.';
		}
	}

	// Generates a coordinate to be used as the input or output in the maze
	private Point generateInputOrOutput(char[][] maze) {
		Point point = new Point();

		switch (generateDirection()) {
		case DOWN:
			point.setLocation(width - 1, 1 + random.nextInt(height - 2));
			break;
		case RIGHT:
			point.setLocation(1 + random.nextInt(width - 2), height - 1);
			break;
		case UP:
			point.setLocation(0, 1 + random.nextInt(height - 2));
			break;
		case LEFT:
			point.setLocation(1 + random.nextInt(width - 2), 0);
			break;
		}

		return point;
	}

	private Direction generateDirection() {
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

	public char[][] getMaze() {
		return maze;
	}

	public Point getInputPoint() {
		return inputPoint;
	}

	public Point getOutputPoint() {
		return outputPoint;
	}

	@Override
	public String toString() {
		String string = "";

		for (char[] row : maze) {
			for (char c : row)
				string += c + " ";
			string += "\n";
		}
		return string;
	}
}
