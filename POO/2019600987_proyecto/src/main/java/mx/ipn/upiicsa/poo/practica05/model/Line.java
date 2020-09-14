package mx.ipn.upiicsa.poo.practica05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Figura {

	private static final Color DEFAULT_FILL_COLOR = Color.BLACK;
	private static final String FIGURE_NAME = "linea";
	private Integer x2;
	private Integer y2;

	protected Line(int x, int y) {
		super(x, y);
		this.fillColor = DEFAULT_FILL_COLOR;
		this.x2 = x;
		this.y2 = y;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.fillColor);
		g2d.drawLine(this.x, this.y, x2, this.y2);
		if (selected == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(this.x - 10, this.y - 10, 10, 10);
		}
	}

	public Integer getX2() {
		return x2;
	}

	public void setX2(Integer x2) {
		this.x2 = x2;
	}

	public Integer getY2() {
		return y2;
	}

	public void setY2(Integer y2) {
		this.y2 = y2;
	}

	public static Line getDefault(int x, int y) {
		return new Line(x, y);
	}

	@Override
	public boolean limits(int x, int y) {
		boolean limits = false;
		if (x >= this.x && x <= this.x + 90 && y <= this.y && y >= this.y - 40) {
			limits = true;
		} else {
			limits = false;
		}
		selected = limits;
		return limits;
	}

	public String toString() {
		return FIGURE_NAME;
	}

}
