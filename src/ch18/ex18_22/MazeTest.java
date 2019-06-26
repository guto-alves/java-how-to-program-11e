package ch18.ex18_22;

public class MazeTest {

	public static void main(String[] args) {
		MazeGenerator mazeGenerator = new MazeGenerator(25, 20);

		System.out.println(mazeGenerator);

		MazeSolver solver = new MazeSolver(mazeGenerator);

		if (solver.isExit()) {
			for (char[] cs : solver.getMazeSolved()) {
				for (char i : cs)
					System.out.print(i + " ");

				System.out.println();
			}

		} else
			System.out.println("It have not a exit!");
	}
}
