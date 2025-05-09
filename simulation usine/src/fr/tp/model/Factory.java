package fr.tp.model;
import fr.tp.inf112.projects.canvas.model.*;
import fr.tp.inf112.projects.canvas.controller.*;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Factory implements Canvas, Observable, Serializable {
	
	private transient HashSet<Observer> observers = new HashSet();
	public static final long serialVersionUID = 202505070949L;
	private String id;
	private String nameFactory;
	private ArrayList<Robot> robots;
	private ArrayList<Room> rooms;
	private ArrayList<Component> allComponents;
	private int width;
	private int height;
	private Style style;
	private transient boolean active;
	
	public Factory (String name, String id, ArrayList<Room> rooms,ArrayList<Robot> robots,int width,int height, Style style) {
		this.nameFactory=name;
		this.allComponents = new ArrayList<Component>();
		this.rooms = rooms;
		this.robots= robots;
		this.width=width;
		this.height=height;
		this.style = style;
		allComponents.addAll(rooms);
		for (Room  room :rooms) {
			ArrayList<Area> areas=room.getArea();
			allComponents.addAll(areas);
			allComponents.add(room.getDoor());
			for (Area area : areas) {
				ArrayList<Machine> machines=area.getMachine();
				allComponents.addAll(machines);
				}
			}
		allComponents.addAll(robots);
		
	}
	
	private boolean checkComponentName(Component myComponent) {
		String myname = myComponent.getName();
		for (Component lcompo :allComponents) {
			if (myname.equals(lcompo.getName())) {
				return false;
			}
		}
		return true;
	}
	public boolean addObserver(Observer observer) {
		if (observers == null) {	//lazy initialization strategy
			observers = new HashSet<Observer>();
		}
		return observers.add(observer);
	}
	
	public boolean removeObserver(Observer observer) {
		if (observers == null) {	//lazy initialization strategy
			observers = new HashSet<Observer>();
		}
		return observers.remove(observer);
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.modelChanged();
		}
	}
	public boolean addComponent(Component myComponent) {
		
		if (checkComponentName( myComponent)) { 
			allComponents.add(myComponent);	
			return true;
			}
		return false;
	}
	
	public Collection<Figure> getFigures() { 
		return (Collection) allComponents;
	}
	
	public void behave() {
		for (Component component : allComponents) {
			component.behave();
		}
		notifyObservers();
	}
			
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public String getName() {
		return  this.nameFactory;
	}
	
	public Style getStyle() {
		return style ;
	}
	
	public void printToConsole() {
		System.out.println(nameFactory);
		for (Room lcompo : rooms) {
			lcompo.getInfo();
		}
	}
	
	public void startSimulation() {
		active=true;
		notifyObservers();
		
	}
	public void stopSimulation() {
		active=false;
		notifyObservers();
		
	}
	public boolean isSimulationRunning() {
		return active;
		
	}

}
