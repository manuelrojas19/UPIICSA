package mx.ipn.upiicsa.poo.practica05.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Figura {
	
	private static final int DEFAULT_DIAMETER = 100;
	private static final Color DEFAULT_BORDER_COLOR = new Color(0,0,0);
	private static final Color DEFAULT_FILL_COLOR = Color.YELLOW;
	private static final String FIGURE_NAME = "circulo";
	private static final int DEFAULT_STROKE = 1;
	
	private int diameter;
	
	protected Circle(int x, int y) {
		super(x, y);
		this.fillColor = DEFAULT_FILL_COLOR;
		this.borderColor = DEFAULT_BORDER_COLOR;
		this.diameter = DEFAULT_DIAMETER;
		this.stroke = DEFAULT_STROKE;
	}
	
	@Override
	public void setSize(int size) {
		this.setDiameter(size);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.borderColor);
		g2d.setStroke(new BasicStroke(stroke));
		g2d.drawOval(this.x, this.y, this.diameter, this.diameter);
		g2d.setColor(this.fillColor);
		g2d.fillOval(this.x+1, this.y+1, this.diameter-2, this.diameter-2);
		if (selected == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(this.x - 10, this.y - 10, 10, 10);
			g2d.fillRect(this.x + diameter, this.y - 10, 10, 10);
			g2d.fillRect(this.x + diameter, this.y + diameter, 10, 10);
			g2d.fillRect(this.x-10, this.y + diameter, 10, 10);
		}
	}
	
	public static Circle getDefault(int x, int y) {
		return new Circle(x, y);
	}
	

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	@Override
	public boolean limits(int x, int y) {
		boolean limits;
		if (x >=  this.x &&  x <= this.x + diameter && y >= this.y && y <= this.y + diameter ) {
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
