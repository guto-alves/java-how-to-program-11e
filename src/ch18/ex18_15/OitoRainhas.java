/*
 * Objetivo: 18.15 (Oito Rainhas) Um quebra-cabeças para os fãs de xadrez é o problema
 * das Oito Rainhas, que pergunta: é possível colocar oito rainhas em um tabuleiro
 * de xadrez vazio, de modo que nenhuma delas esteja “atacando” qualquer outra
 * (isto é, sem que duas rainhas estejam na mesma linha, na mesma coluna ou
 * na mesma diagonal)? Por exemplo, se uma rainha for colocada no canto
 * superior esquerdo do tabuleiro, nenhuma outra rainha pode ser colocada em
 * qualquer um dos quadrados marcados na Figura 18.20. Resolva o problema 
 * recursivamente. [Dica: sua solução deve começar com a primeira coluna e
 * procurar uma localização nela em que uma rainha possa ser colocada — inicialmente,
 * coloque a rainha na primeira linha. A solução precisa, então, pesquisar recursivamente
 * as colunas restantes. Nas primeiras poucas, há várias localizações onde uma rainha
 * pode ser colocada. Utilize a primeira localização disponível. Se uma coluna for
 * alcançada sem nenhuma possível localização para uma rainha, o programa deve retornar
 * à coluna anterior e mover essa rainha para uma nova linha. Esse contínuo procedimento
 * de voltar e tentar novas alternativas é um exemplo de retorno recursivo.]
 * 
 * Autor: Gustavo Alves
 */

package ch18.ex18_15;

public class OitoRainhas {
	private static final int N = 8;
	private static int[][] chess = new int[N][N];

	public static void main(String[] args) {
		solveNQueens(1, 0);
		printChess(chess);
	}

	public static boolean solveNQueens(int queen, int column) {
		if (column >= N)
			return true;

		for (int i = 0; i < N; i++) {
			if (isAttacking(chess, i, column)) {
				chess[i][column] = queen;

				if (solveNQueens(queen + 1, column + 1) == true)
					return true;

				chess[i][column] = 0;
			}
		}

		return false;
	}

	public static boolean isAttacking(int[][] chess, int row, int column) {
		int i, j;

		// check the rows
		for (i = 0; i < N; i++) {
			if (chess[row][i] != 0)
				return false;
		}

		// check the columns
		for (i = 0; i < N; i++) {
			if (chess[i][column] != 0)
				return false;
		}

		// check the diagonals
		// /
		j = column + 1;
		for (i = row - 1; (i >= 0 && j < N); i--, j++) {
			if (chess[i][j] != 0)
				return false;
		}

		j = column - 1;
		for (i = row + 1; (i < N && j >= 0); i++, j--) {
			if (chess[i][j] != 0)
				return false;
		}

		// \
		j = column - 1;
		for (i = row - 1; (i >= 0 && j >= 0); i--, j--) {
			if (chess[i][j] != 0)
				return false;
		}

		j = column + 1;
		for (i = row + 1; (i < N && j < N); i++, j++) {
			if (chess[i][j] != 0)
				return false;
		}

		return true;
	}

	public static void printChess(int[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++)
				System.out.print(" " + chess[i][j] + " ");

			System.out.println();
		}
	}
}
