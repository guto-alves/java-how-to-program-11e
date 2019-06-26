/*
 * Objetivo: 18.20 (Percurso para sair de um labirinto utilizando retorno recursivo) 
 * A grade de '#',s e pontos (.) na Figura 18.22 é uma representação bidimensional do
 * array de um labirinto. Os '#',s representam as paredes do labirinto, e os pontos, as
 * localizações nos possíveis caminhos por ele. Um movimento só é permitido nas
 * posições do array que contiverem um ponto.
 * 
 * Escreva um método recursivo (mazeTraversal) para percorrer labirintos como o da
 * Figura 18.22. O método deve receber como argumentos o array de caracteres de 12
 * por 12 representando o labirinto e a localização atual nele (na primeira vez que
 * esse método é chamado, a localização atual deve ser o ponto de entrada no 
 * labirinto). À medida que mazeTraversal tenta localizar a saída, ele deve colocar
 * o caractere x em cada quadrado no caminho. Há um algoritmo simples para percorrer
 * um labirinto que garante a localização da saída (assumindo que existe uma saída).
 * Se não houver nenhuma saída, você chegará à localização inicial novamente.
 * O algoritmo é como segue: a partir da localização atual no labirinto, tente
 * mover-se um espaço em qualquer uma das possíveis direções (para baixo, para a
 * direita, para cima ou para a esquerda). Se for possível ir pelo menos para uma
 * direção, chame mazeTraversal recursivamente, passando o novo local no labirinto
 * como o atual. Caso não consiga caminhar em nenhuma direção, “volte” a um local
 * anterior no labirinto e tente um novo sentido a partir desse local (esse é um
 * exemplo do retorno recursivo). Programe o método para exibir o labirinto depois
 * de cada movimento a fim de que o usuário possa observar enquanto uma solução para
 * ele é procurada. A saída final do labirinto deve exibir somente o caminho necessário
 * para resolvê-lo — na hipótese de que seguir por uma direção resulte em um caminho
 * sem saída, o x para marcar esses passos não deve ser exposto. [Dica: para mostrar
 * apenas o caminho final, pode ser útil marcar os locais que resultam em um caminho
 * sem saída com outro caractere (como ‘0’).]
 * 
 * Autor: Gustavo Alves
 */

package ch18.ex18_20;

public class MazeSolver {

	public boolean mazeTraversal(char[][] maze, int x, int y) {
		maze[x][y] = 'x';

		if (!isWall(maze, x + 1, y)) { // check to down
			maze[x + 1][y] = 'x';

			if (x + 1 == 11) { // test if it is the exit
				printMaze(maze);
				return true;
			}

			if (mazeTraversal(maze, x + 1, y))
				return true;
		}

		if (!isWall(maze, x, y + 1)) { // check to the right
			maze[x][y + 1] = 'x';

			if (y + 1 == 11) { // test if it is the exit
				printMaze(maze);
				return true;
			}

			if (mazeTraversal(maze, x, y + 1))
				return true;
		}

		if (!isWall(maze, x - 1, y)) { // check to up
			maze[x - 1][y] = 'x';

			if (x - 1 == 0) { // test if it is the exit
				printMaze(maze);
				return true;
			}

			if (mazeTraversal(maze, x - 1, y))
				return true;
		}

		if (!isWall(maze, x, y - 1)) { // check to the left
			maze[x][y - 1] = 'x';

			if (y - 1 == 0) { // test if it is the exit
				printMaze(maze);
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

	public void printMaze(char[][] maze) {
		System.out.printf("%n%n");
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++)
				System.out.print(maze[i][j] == '0' ? " ." : " " + maze[i][j]);

			System.out.println();
		}
	}

	public static void main(String[] args) {
		MazeSolver demo = new MazeSolver();

		char[][] maze = { { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#' },
				{ '.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#' },
				{ '#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '.' },
				{ '#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '#' },
				{ '#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#' },
				{ '#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#' },
				{ '#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#' },
				{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#' },
				{ '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#' },
				{ '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };

		if (demo.mazeTraversal(maze, 2, 0))
			System.out.println("It have a exit!");
		else
			System.out.println("It have not a exit!");
	}
}
