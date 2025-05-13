package fr.tp.model;
import fr.tp.inf112.projects.canvas.model.*;

public class Rond extends ShapeC  implements OvalShape {
	
	private int height;
	private int width; 
	
	public Rond(int heigh,int width) {
		super();
		this.height=heigh;
		this.width=width;
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}

}
