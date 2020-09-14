package mx.ipn.upiicsa.poo.practica05.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Triangulo extends Figura {
	private static final int DEFAULT_BASE = 100;
	private static final int DEFAULT_HEIGTH = 100;
	private static final Color DEFAULT_BORDER_COLOR = new Color(0, 0, 0);
	private static final Color DEFAULT_FILL_COLOR = Color.CYAN;
	private static final String FIGURE_NAME = "triangulo";
	private static final int DEFAULT_STROKE = 1;

	private int base;
	private int heigth;

	protected Triangulo(int x, int y) {
		super(x, y);
		this.base = DEFAULT_BASE;
		this.heigth = DEFAULT_HEIGTH;
		this.borderColor = DEFAULT_BORDER_COLOR;
		this.fillColor = DEFAULT_FILL_COLOR;
		this.stroke = DEFAULT_STROKE;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	@Override
	public void setSize(int size) {
		setBase(size);
		setHeigth(size);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.borderColor);
		g2d.setStroke(new BasicStroke(stroke));
		int xDraw[] = { this.x, this.x + (base / 2), this.x + base };
		int yDraw[] = { this.y, this.y - heigth, this.y };
		g2d.drawPolygon(xDraw, yDraw, 3);
		g2d.setColor(this.fillColor);
		int xFill[] = { this.x + 1, this.x + (base / 2), this.x + base };
		int yFill[] = { this.y, this.y - heigth + 1, this.y };
		g2d.fillPolygon(xFill, yFill, 3);
		if (selected == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(this.x - 10 - stroke + 2, this.y - 10 + stroke, 10, 10);
			g2d.fillRect(this.x + base + stroke - 2, this.y - 10 + stroke, 10, 10);
			g2d.fillRect(this.x + base / 2 - 4, this.y - heigth - 10 - stroke, 10, 10);
		}
	}

	public static Triangulo getDefault(int x, int y) {
		return new Triangulo(x, y);
	}

	@Override
	public boolean limits(int x, int y) {
		boolean limits;
		if (x >= this.x && x <= this.x + base && y <= this.y && y >= this.y - heigth) {
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
