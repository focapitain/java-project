package fr.tp.test;
import java.util.ArrayList;

import fr.tp.inf112.projects.canvas.controller.*;
import fr.tp.inf112.projects.canvas.model.*;
import fr.tp.inf112.projects.canvas.view.*;
import fr.tp.model.Factory;


public class SimulatorController implements CanvasViewerController{
	
	private Factory factoryModel;
	private ArrayList<Observer> observers;
	private transient CanvasPersistenceManager persistenceManager;
	
	public SimulatorController(Factory factoryModel, CanvasPersistenceManager persistenceManager) {
		this.factoryModel=factoryModel;
		this.persistenceManager=persistenceManager;
	}
	
	public Canvas getCanvas() {
		return factoryModel;
	}

	public CanvasPersistenceManager getPersistenceManager() {
		return persistenceManager;
	}

	public void setCanvas(Canvas canvasModel) {
		this.factoryModel=(Factory)canvasModel;
	}

	public void startAnimation() {
		factoryModel.startSimulation();
		while (isAnimationRunning()) {
			factoryModel.behave();
			    try {
			        Thread.sleep(200);
			    }
			    catch (InterruptedException ex) {
			        ex.printStackTrace();
			    }
			}
	}

	public void stopAnimation() {
		factoryModel.stopSimulation();
		
	}
	
	public boolean isAnimationRunning() {
		return factoryModel.isSimulationRunning();
	}
	public boolean addObserver(Observer observer) {
		if (observers == null) {	//lazy initialization strategy
			observers = new ArrayList<Observer>();
		}
		return observers.add(observer);
	}
	
	public boolean removeObserver(Observer observer) {
		if (observers == null) {	//lazy initialization strategy
			observers = new ArrayList<Observer>();
		}
		return observers.remove(observer);
	}

}
