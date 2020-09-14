package mx.ipn.upiicsa.poo.practica05.model;

//import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Imagen extends Figura {

	private static final String FIGURE_NAME = "imagen";
	private Image image;
	private Image scaleImage;
	BufferedImage bufferedImageSize;
	Integer withImage;
	Integer heightImage;

	protected Imagen(int x, int y, Image image) {
		super(x, y);
		this.image = image;
		this.scaleImage = image;
		this.bufferedImageSize = (BufferedImage) this.image;
		this.withImage = bufferedImageSize.getWidth();
		this.heightImage = bufferedImageSize.getHeight();
	}

	@Override
	public void setSize(int size) {
		;
		Double with = withImage * size / 350.0;
		Double height = heightImage * size / 350.0;
		scaleImage = this.image.getScaledInstance(with.intValue(), height.intValue(), Image.SCALE_FAST);
		setScaleImage(scaleImage);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(scaleImage, this.x, this.y, null);
	}

	@Override
	public boolean limits(int x, int y) {
		boolean limits = false;
		BufferedImage bufferedImage = (BufferedImage) this.image;
		if (x >= this.x && x <= this.x + bufferedImage.getWidth() && y >= this.y
				&& y <= this.y + bufferedImage.getHeight()) {
			limits = true;
		}
		return limits;
	}

	public static Imagen getDefault(int x, int y, Image image) {
		return new Imagen(x, y, image);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setScaleImage(Image image) {
		this.scaleImage = image;
	}

	public String toString() {
		return FIGURE_NAME;
	}

}
