package fr.tp.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import fr.tp.inf112.projects.graph.DijkstraAlgorithm;
import fr.tp.inf112.projects.graph.ShortestPath;
import fr.tp.inf112.projects.graph.Vertex;
import fr.tp.inf112.projects.graph.impl.*;

public class BasicPathFinder implements FactoryPathFinder{
	
	private Factory factory;

    private GridGraph gridGraph;

    public BasicPathFinder(Factory factory, GridGraph gridGraph) {
        this.factory = factory;
        this.gridGraph = gridGraph;
    }

    public GridGraph getGridGraph() {
        return gridGraph;
    }   

    public void addVertex(){
        GridVertex v = null;
        int width = factory.getWidth();
        int height = factory.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                v = new GridVertex(i+ "," + j, i, j);
                gridGraph.addVertex(v);
            }
        }
    }

    public void addEdge(ArrayList<Room> components) {
        int width = factory.getWidth();
        int height = factory.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                GridVertex currentVertex = (GridVertex) gridGraph.getVertex(i + "," + j);
                
                // Vérifiez si le sommet est occupé par un composant
                Position pos = new Position(i, j);
                if(!(factory.isOverlays(pos))) {
                    // Si le sommet n'est occupé, ajouter d'arêtes
                    

                    if (i == 0 && j == 0) {
                        // Coin supérieur gauche
                        if(!(factory.isOverlays(new Position(i,j+1)))){
                            GridVertex v1 = (GridVertex) gridGraph.getVertex(i + "," + (j + 1));
                            GridEdge e1 = new GridEdge(gridGraph, currentVertex, v1, 1);
                            gridGraph.addEdge(e1);
                            currentVertex.addEdge(e1);
                            v1.addEdge(e1);
                        }
                        
                        if(!(factory.isOverlays(new Position(i+1,j)))){
                            GridVertex v2 = (GridVertex) gridGraph.getVertex((i + 1) + "," + j);
                            GridEdge e2 = new GridEdge(gridGraph, currentVertex, v2, 1);
                            gridGraph.addEdge(e2);
                            currentVertex.addEdge(e2);
                            v2.addEdge(e2);
                        }
                    } else if (i == width - 1 && j == height - 1) {
                        // Coin inférieur droit
                        if(!(factory.isOverlays(new Position(i,j-1)))){
                            GridVertex v1 = (GridVertex) gridGraph.getVertex(i + "," + (j - 1));
                            GridEdge e1 = new GridEdge(gridGraph, currentVertex, v1, 1);
                            gridGraph.addEdge(e1);
                            currentVertex.addEdge(e1);
                            v1.addEdge(e1);
                        }
                        
                        if(!(factory.isOverlays(new Position(i-1,j)))){
                            GridVertex v2 = (GridVertex) gridGraph.getVertex((i - 1) + "," + j);
                            GridEdge e2 = new GridEdge(gridGraph, currentVertex, v2, 1);
                            gridGraph.addEdge(e2);
                            currentVertex.addEdge(e2);
                            v2.addEdge(e2);
                        }
                    } else if(i ==0 && j == height -1){
                        // Coin supérieur droit
                        if(!(factory.isOverlays(new Position(i,j-1)))){
                            GridVertex v1 = (GridVertex) gridGraph.getVertex(i + "," + (j - 1));
                            GridEdge e1 = new GridEdge(gridGraph, currentVertex, v1, 1);
                            gridGraph.addEdge(e1);
                            currentVertex.addEdge(e1);
                            v1.addEdge(e1);
                        }
                        
                        if(!(factory.isOverlays(new Position(i+1,j)))){
                            GridVertex v2 = (GridVertex) gridGraph.getVertex((i + 1) + "," + j);
                            GridEdge e2 = new GridEdge(gridGraph, currentVertex, v2, 1);
                            gridGraph.addEdge(e2);
                            currentVertex.addEdge(e2);
                            v2.addEdge(e2);
                        }
                    } else if(i == width - 1 && j == 0){
                        // Coin inférieur gauche
                        if(!(factory.isOverlays(new Position(i,j+1)))){
                            GridVertex v1 = (GridVertex) gridGraph.getVertex(i + "," + (j + 1));
                            GridEdge e1 = new GridEdge(gridGraph, currentVertex, v1, 1);
                            gridGraph.addEdge(e1);
                            currentVertex.addEdge(e1);
                            v1.addEdge(e1);
                        }
                        
                        if(!(factory.isOverlays(new Position(i-1,j)))){
                            GridVertex v2 = (GridVertex) gridGraph.getVertex((i - 1) + "," + j);
                            GridEdge e2 = new GridEdge(gridGraph, currentVertex, v2, 1);
                            gridGraph.addEdge(e2);
                            currentVertex.addEdge(e2);
                            v2.addEdge(e2);
                        }
                    }else if (i == 0) {
                        // Bord supérieur
                        if(!(factory.isOverlays(new Position(i,j+1)))){
                            GridVertex v1 = (GridVertex) gridGraph.getVertex(i + "," + (j + 1));
                            GridEdge e1 = new GridEdge(gridGraph, currentVertex, v1, 1);
                            gridGraph.addEdge(e1);
                            currentVertex.addEdge(e1);
                            v1.addEdge(e1);
                        }
                        
                        if(!(factory.isOverlays(new Position(i+1,j)))){
                            GridVertex v2 = (GridVertex) gridGraph.getVertex((i + 1) + "," + j);
                            GridEdge e2 = new GridEdge(gridGraph, currentVertex, v2, 1);
                            gridGraph.addEdge(e2);
                            currentVertex.addEdge(e2);
                            v2.addEdge(e2);
                        }
                        
                        if(!(factory.isOverlays(new Position(i,j-1)))){
                            GridVertex v3 = (GridVertex) gridGraph.getVertex(i + "," + (j - 1));
                            GridEdge e3 = new GridEdge(gridGraph, currentVertex, v3, 1);
                            gridGraph.addEdge(e3);
                            currentVertex.addEdge(e3);
                            v3.addEdge(e3);
                        }
                    } else if (j == 0) {
                        // Bord gauche
                        if(!(factory.isOverlays(new Position(i,j+1)))){
                            GridVertex v1 = (GridVertex) gridGraph.getVertex(i + "," + (j + 1));
                            GridEdge e1 = new GridEdge(gridGraph, currentVertex, v1, 1);
                            gridGraph.addEdge(e1);
                            currentVertex.addEdge(e1);
                            v1.addEdge(e1);
                        }
                        
                        if(!(factory.isOverlays(new Position(i-1,j)))){
                            GridVertex v2 = (GridVertex) gridGraph.getVertex((i - 1) + "," + j);
                            GridEdge e2 = new GridEdge(gridGraph, currentVertex, v2, 1);
                            gridGraph.addEdge(e2);
                            currentVertex.addEdge(e2);
                            v2.addEdge(e2);
                        }
        
                        if(!(factory.isOverlays(new Position(i+1,j)))){
                            GridVertex v3 = (GridVertex) gridGraph.getVertex((i+1) + "," + j);
                            GridEdge e3 = new GridEdge(gridGraph, currentVertex, v3, 1);
                            gridGraph.addEdge(e3);
                            currentVertex.addEdge(e3);
                            v3.addEdge(e3);
                        }
                    } else if (i == width - 1) {
                        // Bord inférieur
                        if(!(factory.isOverlays(new Position(i,j-1)))){
                            GridVertex v1 = (GridVertex) gridGraph.getVertex(i + "," + (j - 1));
                            GridEdge e1 = new GridEdge(gridGraph, currentVertex, v1, 1);
                            gridGraph.addEdge(e1);
                            currentVertex.addEdge(e1);
                            v1.addEdge(e1);
                        }
        
                        if(!(factory.isOverlays(new Position(i-1,j)))){
                            GridVertex v2 = (GridVertex) gridGraph.getVertex((i - 1) + "," + j);
                            GridEdge e2 = new GridEdge(gridGraph, currentVertex, v2, 1);
                            gridGraph.addEdge(e2);
                            currentVertex.addEdge(e2);
                            v2.addEdge(e2);
                        }
        
                        if(!(factory.isOverlays(new Position(i,j+1)))){
                            GridVertex v3 = (GridVertex) gridGraph.getVertex(i + "," + (j + 1));
                            GridEdge e3 = new GridEdge(gridGraph, currentVertex, v3, 1);
                            gridGraph.addEdge(e3);
                            currentVertex.addEdge(e3);
                            v3.addEdge(e3);
                        }
                    } else if (j == height - 1) {
                        // Bord droit
                        if(!(factory.isOverlays(new Position(i,j-1)))){
                            GridVertex v1 = (GridVertex) gridGraph.getVertex(i + "," + (j - 1));
                            GridEdge e1 = new GridEdge(gridGraph, currentVertex, v1, 1);
                            gridGraph.addEdge(e1);
                            currentVertex.addEdge(e1);
                            v1.addEdge(e1);
                        }
        
                        if(!(factory.isOverlays(new Position(i-1,j)))){
                            GridVertex v2 = (GridVertex) gridGraph.getVertex((i - 1) + "," + j);
                            GridEdge e2 = new GridEdge(gridGraph, currentVertex, v2, 1);
                            gridGraph.addEdge(e2);
                            currentVertex.addEdge(e2);
                            v2.addEdge(e2);
                        }
        
                        if(!(factory.isOverlays(new Position(i+1,j)))){
                            GridVertex v3 = (GridVertex) gridGraph.getVertex((i+1) + "," + j);
                            GridEdge e3 = new GridEdge(gridGraph, currentVertex, v3, 1);
                            gridGraph.addEdge(e3);
                            currentVertex.addEdge(e3);
                            v3.addEdge(e3);
                        }
                    } else {
                        // Sommet intérieur
                        if(!(factory.isOverlays(new Position(i,j-1)))){
                            GridVertex v1 = (GridVertex) gridGraph.getVertex(i + "," + (j - 1));
                            GridEdge e1 = new GridEdge(gridGraph, currentVertex, v1, 1);
                            gridGraph.addEdge(e1);
                            currentVertex.addEdge(e1);
                            v1.addEdge(e1);
                        }
        
                        if(!(factory.isOverlays(new Position(i-1,j)))){
                            GridVertex v2 = (GridVertex) gridGraph.getVertex((i - 1) + "," + j);
                            GridEdge e2 = new GridEdge(gridGraph, currentVertex, v2, 1);
                            gridGraph.addEdge(e2);
                            currentVertex.addEdge(e2);
                            v2.addEdge(e2);
                        }
        
                        if(!(factory.isOverlays(new Position(i,j+1)))){
                            GridVertex v3 = (GridVertex) gridGraph.getVertex(i + "," + (j + 1));
                            GridEdge e3 = new GridEdge(gridGraph, currentVertex, v3, 1);
                            gridGraph.addEdge(e3);
                            currentVertex.addEdge(e3);
                            v3.addEdge(e3);
                        }
        
                        if(!(factory.isOverlays(new Position(i+1,j)))){
                            GridVertex v4 = (GridVertex) gridGraph.getVertex((i + 1) + "," + j);
                            GridEdge e4 = new GridEdge(gridGraph, currentVertex, v4, 1);
                            gridGraph.addEdge(e4);
                            currentVertex.addEdge(e4);
                            v4.addEdge(e4);
                        }
                    }
                }
            }
        }
    }

    @Override
    public ArrayList<Position> findPath(Position start, Position end) {
        // Créez les sommets de départ et d'arrivée
        GridVertex startVertex = (GridVertex) gridGraph.getVertex((int) start.getxCoordinate() + "," + (int) start.getyCoordinate());
        GridVertex endVertex = (GridVertex) gridGraph.getVertex((int) end.getxCoordinate() + "," + (int) end.getyCoordinate());
    
        // Initialisez l'algorithme de Dijkstra
    
        // Trouvez le plus court chemin entre les deux sommets
        List<Vertex> shortestPath = DijkstraAlgorithm.findShortestPath(gridGraph, startVertex, endVertex);
    
        // Convertissez le chemin en une liste de positions
        ArrayList<Position> path = new ArrayList<>();
        for (Vertex vertex : shortestPath) {
            GridVertex gridVertex = (GridVertex) vertex;
            int x = gridVertex.getxCoordinate();
            int y = gridVertex.getyCoordinate();
            path.add(new Position(x, y));
        }
    
        // Retournez le chemin
        return path;
    }

}


