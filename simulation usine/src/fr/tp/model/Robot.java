package fr.tp.model;

import java.util.ArrayList;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

public class Robot extends Component {
	
	public static final long serialVersionUID = 202505070914L;
	String name;
	ArrayList<Machine> aVisiter;
	int i=0;
	int speed;
	int n;
	
	public Robot(String name,Style style, Shape shape, int xCoord, int yCoord,  int speed,ArrayList<Machine> aVisiter) {
		
		super(name, style, shape, xCoord, yCoord);
		this.speed = speed;
		this.aVisiter=aVisiter;
		
	}
	@Override
	public void behave() {
		n = aVisiter.size();
		Machine machine = aVisiter.get(i%n);
		move(machine, speed);
		
	}
	int targetX;
	int targetY;
	int xCoord;
	int yCoord;
	int dx, dy;
	
	public void move(Machine machine, int vitesse) {
	    targetX = machine.getxCoordinate();
	    targetY = machine.getyCoordinate();
	    xCoord = getxCoordinate();
	    yCoord = getyCoordinate();

	    if (xCoord == targetX && yCoord == targetY) {
	        i=i+1; // Déjà sur la machine
	        return;
	    }
	    
	    dx = targetX - xCoord;
	    dy = targetY - yCoord;
	 
	    // Avancer en X (maximum "vitesse" unités)
	    if (dx != 0) {
	    	setxCoordinate(getxCoordinate() + (int)Math.signum(dx));
	    	//(int)Math.signum(dx) * Math.min(Math.abs(dx), vitesse)
	    }

	    // Avancer en Y (maximum "vitesse" unités)
	    if (dy != 0) {
	    	setyCoordinate(getyCoordinate() + (int)Math.signum(dy) );
	    }
	}

	
	@Override
	public String toString() {
		return "je m'appelle Robot " + name + ", et j 'avance" + speed + "]";
	}
	

}