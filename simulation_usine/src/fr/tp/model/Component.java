package fr.tp.model;
import fr.tp.inf112.projects.canvas.model.*;
import java.io.Serializable;


public abstract class Component implements Figure, Serializable {
	private int xCoord ;
	private int yCoord ;
	private final String name;
	private Style style;
	final private Shape shape;
	public static final long serialVersionUID = 202505070944L;
	
	
	public Component( String name,Style style, Shape shape, int xCoord, int yCoord){
		this.name= name;
		this.xCoord= xCoord;
		this.yCoord= yCoord;
		this.style = style;
		this.shape = shape;
	}
	
	public void behave() {
		}
	
	@Override
	public int getxCoordinate() {
		return xCoord  ;
	}
	public void setxCoordinate(int xCoord) {
		this.xCoord=xCoord  ;
	}
	@Override
	public int getyCoordinate() {
		return yCoord  ;
	}
	public void setyCoordinate(int yCoord) {
		this.yCoord=yCoord  ;
	}
	@Override
	public String getName() {
		return  this.name;
	}
	@Override
	public Style getStyle() {
		return style;
	}
	@Override
	public Shape getShape() {
		return shape;
	}

}
