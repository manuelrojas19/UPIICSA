package mx.ipn.upiicsa.poo.practica05.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Text extends Figura {
	private static final Color DEFAULT_TEXT_COLOR = Color.RED;
	private static final String FIGURE_NAME = "texto";
	private static String DEFAULT_TEXT = "default text";
	private static final int DEFAULT_FONT_SIZE = 12;
	private String value;
	private int longGraphicText;
	private int fontSize;

	protected Text(int x, int y) {
		super(x, y);
		this.fillColor = DEFAULT_TEXT_COLOR;
		this.value = DEFAULT_TEXT;
		this.longGraphicText = value.length() * 7;
		this.fontSize = DEFAULT_FONT_SIZE;
	}

	protected Text(int x, int y, String texto) {
		super(x, y);
		this.fillColor = DEFAULT_TEXT_COLOR;
		this.value = texto;
		this.longGraphicText = value.length() * 7;
		this.fontSize = DEFAULT_FONT_SIZE;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.fillColor);
		g2d.setFont(new Font("Ariel", Font.PLAIN, fontSize));
		g2d.drawString(this.value, this.x, this.y);
		if (selected == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(this.x - 20, this.y - 10, 10, 10);
		}
	}

	public static Text getDefault(int x, int y) {
		return new Text(x, y);
	}

	public static Text getDefault(int x, int y, String texto) {
		return new Text(x, y, texto);
	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub
		setFontSize(size);
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getLongGraphicText() {
		return longGraphicText;
	}

	public void setLongGraphicText(int longGraphicText) {
		this.longGraphicText = longGraphicText;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

}
