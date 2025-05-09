package fr.tp.model;
import fr.tp.inf112.projects.canvas.model.*;
import java.io.Serializable;

public class StyleC implements Style,Serializable{
	
	public static final long serialVersionUID = 202505070964L;
	private Color color;
	private Stroke stroke;
	
	public StyleC (Color color,Stroke stroke) {
		this.color=color;
		this.stroke=stroke;
	}
	
	@Override
	public Color getBackgroundColor() {
		return color;
	}
	public Stroke getStroke() {
		return stroke;
	}
}
