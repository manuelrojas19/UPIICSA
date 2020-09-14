package mx.ipn.upiicsa.poo.practica05.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Poligono extends Figura {
	private static final int DEFAULT_SIDE = 50;
	private static final int DEFAULT_APOTHEM = 44;
	private static final Color DEFAULT_BORDER_COLOR = new Color(0, 0, 0);
	private static final Color DEFAULT_FILL_COLOR = Color.LIGHT_GRAY;
	private static final String FIGURE_NAME = "poligono";
	private static final int DEFAULT_STROKE = 1;

	private int side;
	private int apothem;

	protected Poligono(int x, int y) {
		super(x, y);
		this.side = DEFAULT_SIDE;
		this.apothem = DEFAULT_APOTHEM;
		this.borderColor = DEFAULT_BORDER_COLOR;
		this.fillColor = DEFAULT_FILL_COLOR;
		this.stroke = DEFAULT_STROKE;
	}

	@Override
	public void setSize(int size) {
		setSide(size);
		setApothem((int) (size * .88));
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public int getApothem() {
		return apothem;
	}

	public void setApothem(int apothem) {
		this.apothem = apothem;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.borderColor);
		g2d.setStroke(new BasicStroke(stroke));
		int xDraw[] = { this.x, this.x + (side / 2), this.x + side + (side / 2), this.x + (side * 2),
				this.x + side + (side / 2), this.x + (side / 2) };
		int yDraw[] = { this.y, this.y - apothem, this.y - apothem, this.y, this.y + apothem, this.y + apothem };
		g2d.drawPolygon(xDraw, yDraw, 6);
		g2d.setColor(fillColor);
		int xFill[] = { this.x + 1, this.x + (side / 2), this.x + side + (side / 2), this.x + (side * 2) - 1,
				this.x + side + (side / 2), this.x + (side / 2) + 1 };
		int yFill[] = { this.y, this.y - apothem + 1, this.y - apothem + 1, this.y, this.y + apothem - 1,
				this.y + apothem };
		g2d.fillPolygon(xFill, yFill, 6);
		if (selected == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(this.x - 10, this.y - 10 - side, 10, 10);
			g2d.fillRect(this.x + (2 * side), this.y - 10 - side, 10, 10);
			g2d.fillRect(this.x + (2 * side), this.y + (side), 10, 10);
			g2d.fillRect(this.x - 10, this.y + (side), 10, 10);
		}
	}

	public static Poligono getDefault(int x, int y) {
		return new Poligono(x, y);
	}

	@Override
	public boolean limits(int x, int y) {
		boolean limits;
		if (x >= this.x && x <= this.x + (2 * side) && y >= this.y - side && y <= this.y + (side)) {
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
