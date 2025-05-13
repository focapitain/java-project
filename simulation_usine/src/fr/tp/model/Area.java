package fr.tp.model;
import java.util.ArrayList; 

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;


public class Area extends Component {
	private ArrayList<Machine> machines;
	public Area ( String name, Style style, Shape shape, int xCoord, int yCoord, ArrayList<Machine> machines) {
		super(name, style, shape,xCoord, yCoord);
		this.machines= machines;
	}
	
	public ArrayList<Machine> getMachine() {
		return machines;
	}
	@Override
	public void behave() {
	}
	public void getInfo() {
		System.out.println("area" + getName() );
		for (Machine lmachine : machines) {
			System.out.println(lmachine.getName());
	}
		}	
}
