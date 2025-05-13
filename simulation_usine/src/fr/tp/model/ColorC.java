package fr.tp.model;
import fr.tp.inf112.projects.canvas.model.*;
import java.io.Serializable;

public class ColorC implements Color, Serializable{
	
	public static final long serialVersionUID = 202505070934L;
	private int bleu;
	private int rouge;
	private int vert;
	
	public ColorC(int bleu,int rouge,int vert) {
		this.bleu=bleu;
		this.rouge=rouge;
		this.vert=vert;
	}
	
	public int getRedComponent() {
		return rouge;
		}
	public int getGreenComponent() {
		return vert;
	}
	
	public int getBlueComponent() {
		return bleu;
	}

}
