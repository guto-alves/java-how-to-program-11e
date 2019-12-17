/*
 * Objetivo     : 13.17 (CÃ­rculos utilizando a classe Ellipse2D.Double) Escreva um aplicativo que solicita que o usuÃ¡rio insira o raio de um cÃ­rculo 
 * como um nÃºmero de ponto flutuante e desenhe o cÃ­rculo, bem como os valores de diÃ¢metro, circunferÃªncia e Ã¡rea do cÃ­rculo. Utilize o valor
 * 3,14159 para PI. [ObservaÃ§Ã£o: vocÃª tambÃ©m pode utilizar a constante Math.PI predefinida para o valor de PI. Essa constante Ã© mais
 * precisa que o valor 3,14159. A classe Math Ã© declarada no pacote java.lang, entÃ£o vocÃª nÃ£o precisa importÃ¡-la.] Utilize as seguintes
 * fÃ³rmulas (r Ã© o raio):
 * 
 * diÃ¢metro = 2 * r
 * circunferÃªncia = 2 *PI * r
 * Ã¡rea = PI * r * 2
 * 
 * TambÃ©m se deve solicitar ao usuÃ¡rio um conjunto de coordenadas alÃ©m do raio. EntÃ£o, desenhe o cÃ­rculo e exiba o diÃ¢metro, circunferÃªncia
 * e Ã¡rea, usando um objeto Ellipse2D.Double para representar o cÃ­rculo e o mÃ©todo draw da classe Graphics2D para exibi-lo.
 *
 * Programador  : Gustavo Alves - gustavo.almeida13@fatec.sp.gov.br
 * Data CriaÃ§Ã£o : 7 de mar de 2019
 */

package ch27.ex27_17;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Circles extends JPanel {
	private double raio;
	private double x;
	private double y;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		double diametro = 2 * raio;
		g2d.draw(new Ellipse2D.Double(x, y, diametro, diametro));

		g.setFont(new Font("SansSerif", Font.BOLD, 16));
		g.drawString(String.format("DiÃ¢metro %,.1f%n cmÂ²  - CircunferÃªncia %,.1f%n cmÂ²  - Ã�rea %,.1f cmÂ²",
				diametro, 2 * Math.PI * raio, Math.PI * Math.pow(raio, 2)), 10, getHeight() - 20);
	}

	public void readData() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o raio do cÃ­rculo: ");
		raio = scanner.nextDouble();

		System.out.print("Digite a coordenada X: ");
		x = scanner.nextDouble();

		System.out.print("Digite a coordenada Y: ");
		y = scanner.nextDouble();
		scanner.close();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("CÃ­rculo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Circles draw = new Circles();
		draw.readData(); // solicita os dados pelo console

		draw.setBackground(Color.WHITE);
		frame.add(draw);

		frame.setSize(520, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}