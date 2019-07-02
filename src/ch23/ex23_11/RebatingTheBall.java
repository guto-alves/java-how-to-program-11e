
package ch23.ex23_11;

import javax.swing.JFrame;

public class RebatingTheBall {

	public static void main(String[] args) {
		JFrame application = new JFrame("Rebating the Ball");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		RebatingTheBallJPanel ballsJPanel = new RebatingTheBallJPanel(20);
		application.add(ballsJPanel);

		application.setSize(400, 400);
		application.setLocationRelativeTo(null);
		application.setVisible(true);
	}
}
