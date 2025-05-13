package fr.tp.model;
import java.util.ArrayList; 

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
	@Override
	public boolean overlay(Position pos,int xCoord, int yCoord){
		int x = pos.getxCoordinate();
	    int y = pos.getyCoordinate();
	    
	    int left = xCoord;
	    int top = yCoord;
	    int right = left + width - 1;
	    int bottom = top + height - 1;

	    boolean onLeftOrRightEdge = (x == left || x == right) && (y >= top && y <= bottom);
	    boolean onTopOrBottomEdge = (y == top || y == bottom) && (x >= left && x <= right);

	    return onLeftOrRightEdge || onTopOrBottomEdge;
	        
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
