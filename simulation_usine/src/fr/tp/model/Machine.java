package fr.tp.model;

import fr.tp.inf112.projects.canvas.model.Shape; 
import fr.tp.inf112.projects.canvas.model.Style;

public class Machine extends Component{
	
	public Machine(String name,Style style, Shape shape, final int xCoord, final int yCoord) {
		super (name, style, shape, xCoord, yCoord);
	}
	@Override
	public void behave() {
	}
}
