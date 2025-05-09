package fr.tp.model;
import fr.tp.inf112.projects.canvas.model.*;

public class Rectangle extends ShapeC implements RectangleShape {
	private int height;
	private int width;
	public static final long serialVersionUID = 202505070924L;
	
	public Rectangle (int width, int height) {
		super();
		this.width=width;
		this.height=height;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
