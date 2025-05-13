package fr.tp.model;
import fr.tp.inf112.projects.canvas.model.*;
import java.io.Serializable;

public class StrokeC implements Stroke, Serializable {
	
	public static final long serialVersionUID = 202505070954L;
	private Color color;
	private float[] patern;
	private float thickness;
	
	public StrokeC (Color color,float[] patern,float thickness) {
		this.color=color;
		this.patern=patern;
		this.thickness=thickness;
	}
	
	public Color getColor() {
		return color;
	}
	
	public float getThickness() {
		return thickness;
	}
	
	public float[] getDashPattern() {
		return patern;
	}
}
