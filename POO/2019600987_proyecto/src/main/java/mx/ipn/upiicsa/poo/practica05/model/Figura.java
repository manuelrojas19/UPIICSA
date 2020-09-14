package mx.ipn.upiicsa.poo.practica05.model;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura  {	
	protected int x;
	protected int y;
	protected int stroke;
	protected int size;
	protected Color borderColor;
	protected Color fillColor;
	protected Boolean selected;

	
	protected Figura(int x, int y) {
		this.x = x;
		this.y = y;
		this.selected = false;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getStroke() {
		return stroke;
	}
	
	public void setStroke(int stroke) {
		this.stroke = stroke;
	}
	
	public Color getBorderColor() {
		return borderColor;
	}
	
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	public Color getFillColor() {
		return fillColor;
	}
	
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}	

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public abstract void paint(Graphics g);
	
	public abstract boolean limits(int x, int y);
}
