package mx.ipn.upiicsa.poo.practica05.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Cuadrado extends Figura {
	private static final int DEFAULT_SIDE = 100;
	private static final Color DEFAULT_BORDER_COLOR = new Color(0, 0, 0);
	private static final Color DEFAULT_FILL_COLOR = Color.GREEN;
	private static final String FIGURE_NAME = "cuadrado";
	private static final int DEFAULT_STROKE = 1;

	private int side;

	protected Cuadrado(int x, int y) {
		super(x, y);
		this.fillColor = DEFAULT_FILL_COLOR;
		this.borderColor = DEFAULT_BORDER_COLOR;
		this.side = DEFAULT_SIDE;
		this.stroke = DEFAULT_STROKE;
	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub
		setSide(size);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.borderColor);
		g2d.setStroke(new BasicStroke(stroke));
		g2d.drawRect(this.x, this.y, this.side, this.side);
		g2d.setColor(this.fillColor);
		g2d.fillRect(this.x + 1, this.y + 1, this.side - 1, this.side - 1);
		if (selected == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(this.x - 10 - stroke / 2, this.y - 10 - stroke / 2, 10, 10);
			g2d.fillRect(this.x + side + stroke / 2, this.y - 10 - stroke / 2, 10, 10);
			g2d.fillRect(this.x + side + stroke / 2, this.y + side + stroke / 2, 10, 10);
			g2d.fillRect(this.x - 10 - stroke / 2, this.y + side + stroke / 2, 10, 10);
		}
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public static Cuadrado getDefault(int x, int y) {
		return new Cuadrado(x, y);
	}

	@Override
	public boolean limits(int x, int y) {
		boolean limits;
		if (x >= this.x && x <= this.x + side && y >= this.y && y <= this.y + side) {
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
