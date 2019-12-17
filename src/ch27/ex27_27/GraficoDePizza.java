/*
 * Objetivo: 13.27 (Gráfico de pizza) Escreva um programa que insere quatro números e mostra-os como um gráfico de pizza. 
 * Use a classe Arc2D.Double e o método fill da classe Graphics2D para realizar o desenho. Desenhe cada pedaço da torta 
 * em uma cor separada.
 * 
 * Autor: Gustavo Alves
 * Data: 17/03/2019
 */

package ch27.ex27_27;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GraficoDePizza extends JPanel {
	private int gX;
	private int gY;
	private int gWidth;
	private int gHeight;

	private List<Piece> pieces;

	private double sum = 0;

	public GraficoDePizza() {
		this(new ArrayList<>(), 0, 0, 200, 200, Color.WHITE);
	}

	public GraficoDePizza(int gX, int gY, int gWidth, int gHeight) {
		this(new ArrayList<>(), gX, gY, gWidth, gHeight, Color.WHITE);
	}

	public GraficoDePizza(List<Piece> pieces, int gX, int gY, int gWidth, int gHeight, Color backgroundColor) {
		this.pieces = pieces;
		this.gX = gX;
		this.gY = gY;
		this.gWidth = gWidth;
		this.gHeight = gHeight;
		setBackground(backgroundColor);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		double start = 0;
		double extent = 0;

		for (Piece piece : pieces)
			sum += piece.getValue();

		for (int i = 0; i < pieces.size(); i++) {
			double percentage = pieces.get(i).getValue() / sum * 360;

			pieces.get(i).setPercentage(percentage);
			extent = percentage;

			g2d.setPaint(pieces.get(i).getColor());

			g2d.fill(new Arc2D.Double(gX, gY, gWidth, gHeight, start, extent, Arc2D.PIE));

			start += extent;
		}

		sum = 0;
	}

	public void setPiece(int index, double value, Color color) {
		if (index < 0 || index >= pieces.size())
			throw new IllegalArgumentException("Length = " + pieces.size() + ", Index = " + index);

		Piece oldPiece = pieces.get(index);
		Piece newPiece = new Piece();

		if (value >= 0)
			newPiece.setValue(value);
		else
			newPiece.setValue(oldPiece.getValue());

		if (color != null)
			newPiece.setColor(color);
		else
			newPiece.setColor(oldPiece.getColor());

		pieces.set(index, newPiece);
	}

	public void addPiece(Piece piece) {
		pieces.add(piece);
	}

	public void clearValues() {
		pieces.clear();
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void setValues(List<Piece> pieces) {
		this.pieces = pieces;
	}

	public int getgX() {
		return gX;
	}

	public void setgX(int gX) {
		this.gX = gX;
	}

	public int getgY() {
		return gY;
	}

	public void setgY(int gY) {
		this.gY = gY;
	}

	public int getgWidth() {
		return gWidth;
	}

	public void setgWidth(int gWidth) {
		this.gWidth = gWidth;
	}

	public int getgHeight() {
		return gHeight;
	}

	public void setgHeight(int gHeight) {
		this.gHeight = gHeight;
	}
}
