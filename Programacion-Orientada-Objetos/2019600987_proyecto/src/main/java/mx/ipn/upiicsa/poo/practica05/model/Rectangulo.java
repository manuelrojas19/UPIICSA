package mx.ipn.upiicsa.poo.practica05.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangulo extends Figura {
	private static final int DEFAULT_WIDTH = 100;
	private static final int DEFAULT_HEIGTH = 200;
	private static final Color DEFAULT_BORDER_COLOR = new Color(0, 0, 0);
	private static final Color DEFAULT_FILL_COLOR = Color.BLUE;
	private static final String FIGURE_NAME = "rectangulo";
	private static final int DEFAULT_STROKE = 1;

	private int width;
	private int heigth;

	protected Rectangulo(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.width = DEFAULT_WIDTH;
		this.heigth = DEFAULT_HEIGTH;
		this.borderColor = DEFAULT_BORDER_COLOR;
		this.fillColor = DEFAULT_FILL_COLOR;
		this.stroke = DEFAULT_STROKE;
	}

	@Override
	public void setSize(int size) {
		setHeigth(size + size);
		setWidth(size);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.borderColor);
		g2d.setStroke(new BasicStroke(stroke));
		g2d.drawRect(this.x, this.y, this.heigth, this.width);
		g2d.setColor(this.fillColor);
		g2d.fillRect(this.x + 1, this.y + 1, this.heigth - 1, this.width - 1);
		if (selected == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(this.x - 10 - stroke / 2, this.y - 10 - stroke / 2, 10, 10);
			g2d.fillRect(this.x + heigth + stroke / 2, this.y - 10 - stroke / 2, 10, 10);
			g2d.fillRect(this.x + heigth + stroke / 2, this.y + width + stroke / 2, 10, 10);
			g2d.fillRect(this.x - 10 - stroke / 2, this.y + width + stroke / 2, 10, 10);
		}
	}

	public static Rectangulo getDefault(int x, int y) {
		return new Rectangulo(x, y);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	@Override
	public boolean limits(int x, int y) {
		boolean limits;
		if (x >= this.x && x <= this.x + heigth && y >= this.y && y <= this.y + width) {
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
