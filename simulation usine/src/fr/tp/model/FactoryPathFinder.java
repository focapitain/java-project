package fr.tp.model;


import java.util.List;



public interface FactoryPathFinder {
	
	List<Position> findPath(Component sourceComponent , Component targetComponent );
	
}