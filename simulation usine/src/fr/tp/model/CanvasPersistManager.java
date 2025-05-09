package fr.tp.model;
import fr.tp.inf112.projects.canvas.model.impl.*;
import fr.tp.inf112.projects.canvas.model.*;
import fr.tp.inf112.projects.canvas.view.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collection;

public class CanvasPersistManager extends AbstractCanvasPersistenceManager implements CanvasPersistenceManager {
	
	public CanvasPersistManager(CanvasChooser canvasChooser) {
		super(canvasChooser);
	}
	
	public Canvas read(String canvasId) throws IOException { 
		FileInputStream fileStream = new FileInputStream("Projet_Java.txt");
		ObjectInputStream objStream = new ObjectInputStream(fileStream);
		Factory factory;
		try {
			factory = (Factory) objStream.readObject();
			objStream.close();
			return factory;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			objStream.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			objStream.close();
			return null;
		}
	}
	
	public void persist(Canvas canvasModel) throws IOException {
		Collection<Figure> components = canvasModel.getFigures();
		OutputStream fileOutStream = new FileOutputStream("Projet_Java.txt");
		OutputStream bufOutStream = new BufferedOutputStream(fileOutStream);
		ObjectOutputStream objOutStream = new ObjectOutputStream(bufOutStream);
		for (Figure component : components) {
			objOutStream.writeObject(component);
		}
		objOutStream.close();
	}
	
	public boolean delete(Canvas canvasModel) {
		File file = new File("Projet_Java.txt");
		file.delete();
		return true;
	}
}
