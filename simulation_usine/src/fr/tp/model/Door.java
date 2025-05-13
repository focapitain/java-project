package fr.tp.model;
import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

public class Door extends Component {

    public Door(String name, Style style, Shape shape, int xCoord, int yCoord) {
        super(name, style, shape, xCoord, yCoord);
    }
    
    public Position getDoor1() {
    	Position pos= new Position(this.getxCoordinate(),this.getyCoordinate());
    	return pos;
    }
    public Position getDoor2() {
    	Position pos2= new Position(this.getxCoordinate(),this.getyCoordinate());
    	return pos2;
    }

    
    public boolean isAtPosition(int x, int y) {
        return this.getxCoordinate() == x && this.getyCoordinate() == y;
    }
    public boolean overlays(Position pos) {
    	return isAtPosition(pos.getxCoordinate(), pos.getyCoordinate());
    }
}
