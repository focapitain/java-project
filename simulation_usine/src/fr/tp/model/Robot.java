package fr.tp.model;

import java.util.ArrayList; 

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;
import fr.tp.inf112.projects.graph.impl.GridGraph;

public class Robot extends Component {
	
	public static final long serialVersionUID = 202505070914L;
	String name;
	ArrayList<Machine> aVisiter;
	int i=0;
	int speed;
	int n;
	private static Factory mon_usine;
	static BasicPathFinder finder;
	
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
	
	public void move(Machine machine, int vitesse) {
	    

	    if (getxCoordinate() == machine.getxCoordinate() && getyCoordinate() == machine.getyCoordinate()) {
	        i=i+1; // Déjà sur la machine
	        return;
	    }
	    Position start = new Position(getxCoordinate(),getyCoordinate());
	    Position end = new Position(machine.getxCoordinate(),machine.getyCoordinate());
	    //Position end = new Position(5,0);
	    BasicPathFinder finder = new BasicPathFinder(mon_usine,new GridGraph());
		finder.addVertex();
		finder.addEdge(mon_usine.getRoom());
	    ArrayList<Position> path= finder.findPath(start,end);
	    
	   // System.out.println(finder.getGridGraph());
	    System.out.println("start :" );
	    start.out();
	    System.out.println("path :" );
	    for (Position pos :path) {
	    	pos.out();
	    }
	    if (path!=null) {
	    Position pos = path.remove(1);
	    pos.out();
	    setxCoordinate(pos.getxCoordinate());
	    setyCoordinate(pos.getyCoordinate());
	    System.out.println("prochain point");
	    System.out.println( pos.getxCoordinate());
	    System.out.println( pos.getyCoordinate());
	    }
	    
	}

	public void setUsine(Factory mon_usine) {
		this.mon_usine=mon_usine;
	}
	
	@Override
	public String toString() {
		return "je m'appelle Robot " + name + ", et j 'avance" + speed + "]";
	}
	
	public void addVisit(Chargement chargement) {
		aVisiter.add(chargement);
	}

}