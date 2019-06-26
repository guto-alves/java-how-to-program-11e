/*
 * Objetivo: 18.22 (Labirintos de qualquer tamanho) Generalize os métodos
 * mazeTraversal e mazeGenerator da Questão 18.20 e da Questão 18.21 para
 * processar labirintos de qualquer largura e altura.
 * 
 * Autor: Gustavo Alves
 */

package ch18.ex18_22;

public class MazeSolver {
	private char[][] mazeSolved;
	private char[][] mazeCopy;
	private boolean withExit;

	public MazeSolver(char[][] maze, int x, int y) {
		copyMaze(maze);

		withExit = mazeTraversal(maze, x, y);
	}

	public MazeSolver(MazeGenerator mazeGenerator) {
		copyMaze(mazeGenerator.getMaze());

		withExit = mazeTraversal(mazeCopy, mazeGenerator.getInputPoint().x, mazeGenerator.getInputPoint().y);
	}

	private void copyMaze(char[][] mazeOriginal) {
		mazeCopy = new char[mazeOriginal.length][mazeOriginal[0].length];

		for (int i = 0; i < mazeOriginal.length; i++) {
			for (int j = 0; j < mazeOriginal[0].length; j++)
				mazeCopy[i][j] = mazeOriginal[i][j];
		}
	}

	private boolean mazeTraversal(char[][] maze, int x, int y) {
		maze[x][y] = 'x';

		if (!isWall(maze, x + 1, y)) { // check to down
			maze[x + 1][y] = 'x';

			if (x + 1 == maze.length - 1) { // test if it is the exit
				saveSolution(maze);
				return true;
			}

			if (mazeTraversal(maze, x + 1, y))
				return true;
		}

		if (!isWall(maze, x, y + 1)) { // check to the right
			maze[x][y + 1] = 'x';

			if (y + 1 == maze[0].length - 1) { // test if it is the exit
				saveSolution(maze);
				return true;
			}

			if (mazeTraversal(maze, x, y + 1))
				return true;
		}

		if (!isWall(maze, x - 1, y)) { // check to up
			maze[x - 1][y] = 'x';

			if (x - 1 == 0) { // test if it is the exit
				saveSolution(maze);
				return true;
			}

			if (mazeTraversal(maze, x - 1, y))
				return true;
		}

		if (!isWall(maze, x, y - 1)) { // check to the left
			maze[x][y - 1] = 'x';

			if (y - 1 == 0) { // test if it is the exit
				saveSolution(maze);
				return true;
			}

			if (mazeTraversal(maze, x, y - 1))
				return true;
		}

		maze[x][y] = '0';
		return false;
	}

	private boolean isWall(char[][] maze, int x, int y) {
		try {
			if (maze[x][y] == '#' || maze[x][y] == 'x' || maze[x][y] == '0')
				return true;
		} catch (Exception e) {
			return true;
		}

		return false;
	}

	private void saveSolution(char[][] maze) {
		mazeSolved = new char[maze.length][maze[0].length];

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) 
				mazeSolved[i][j] = maze[i][j] == '0' ? '.' : maze[i][j];
		}
	}

	public boolean isExit() {
		return withExit;
	}

	public char[][] getMazeSolved() {
		return mazeSolved;
	}
}
