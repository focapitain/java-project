package fr.tp.model;
import java.util.ArrayList; 

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

public class Room extends Component{
	
	private ArrayList<Area> areas;
	private Door door;
	
	public Room ( String name,Style style, Shape shape, int xCoord, int yCoord, ArrayList<Area> areas,Door door) {
		super( name,  style, shape, xCoord, yCoord);
		this.areas= areas;
		this.door=door;
	}
	
	public Door getDoor() {
    	return this.door;
    }
	
	public ArrayList<Area> getArea() {
		return areas;
	}
	@Override
	public void behave() {
	}
	public void getInfo() {
		System.out.println("room" + getName() );
		for (Area larea : areas) {
			 larea.getInfo() ;
	}
	}
	
	public boolean overlays(Position pos) {
		return ((Rectangle) getShape()).overlay(pos, this.getxCoordinate(),this.getyCoordinate());
	}
}