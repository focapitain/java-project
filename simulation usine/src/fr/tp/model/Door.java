package fr.tp.model;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

public class Door extends Component {

    public Door(String name, Style style, Shape shape, int xCoord, int yCoord) {
        super(name, style, shape, xCoord, yCoord);
    }

    // Tu peux ajouter des méthodes spécifiques à Door ici, par exemple :
    public boolean isAtPosition(int x, int y) {
        return this.getxCoordinate() == x && this.getyCoordinate() == y;
    }
}
