package fr.tp.test;

import fr.tp.model.Factory;
import fr.tp.model.Robot;
import fr.tp.model.Room;
import fr.tp.model.Machine;
import fr.tp.model.Component;

import java.util.ArrayList;

import fr.tp.inf112.projects.canvas.view.CanvasViewer;
import fr.tp.model.Area;

public class test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Machine myMachine1 = new Machine("Machine 1", 0.0 ,0.0);
		Machine myMachine2 = new Machine("Machine 2", 1.0 ,0.0);
		
		ArrayList<Machine> listMachine1 = new ArrayList();
		listMachine1.add(myMachine1);
		
		Area myArea1 = new Area("Machine 1",0.0 ,0.0, listMachine1);
		ArrayList<Area> arealist1 = new ArrayList();
		arealist1.add(myArea1);
		
		Room myRoom = new Room("salle 1",0.0, 0.0, arealist1);
		ArrayList<Room> roomlist1 = new ArrayList();
		roomlist1.add(myRoom);
		
		Factory myFactory = new Factory("usine", roomlist1);
		myFactory.printToConsole();
	}

}
System.out.println("room" + myFactory.getFigures() );
CanvasViewer canevas= new CanvasViewer( myFactory);