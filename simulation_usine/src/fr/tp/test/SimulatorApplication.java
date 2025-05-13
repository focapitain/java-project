package fr.tp.test;
import fr.tp.inf112.projects.canvas.model.*;
import fr.tp.inf112.projects.canvas.view.*;
import fr.tp.inf112.projects.canvas.controller.*;

import java.util.ArrayList;

import fr.tp.model.Area;
import fr.tp.model.Factory;
import fr.tp.model.ShapeC;
import fr.tp.model.Rond;
import fr.tp.model.Robot;
import fr.tp.model.Room;
import fr.tp.model.Rectangle;
import fr.tp.model.ColorC;
import fr.tp.model.Door;
import fr.tp.model.StrokeC;
import fr.tp.model.StyleC;
import fr.tp.model.Machine;
import fr.tp.model.CanvasPersistManager;
import fr.tp.model.Chargement;


public class SimulatorApplication {
	

	public static void main(String[] args) {
		Rond rond= new Rond(1,1);
		Rectangle rectangle= new Rectangle(6,7);
		Rectangle rectangle4= new Rectangle(1,1);
		Rectangle rectangle2= new Rectangle(2,2);
		Rectangle rectangle3= new Rectangle(8,10);
		Color color1 = new ColorC(0,200,200);
		Color color2 = new ColorC(100,150,50);
		Color color3 = new ColorC(10,15,5);
		Color color4 = new ColorC(0,0,0);
		Color colorRobot = new ColorC(200,0,0);
		float[] patern = {0.5f , 0.5f };
		Stroke stroke1 = new StrokeC(color3,patern, 1.8f );
		Style style1 = new StyleC(color1,stroke1);
		Style style3 = new StyleC(color4,stroke1);
		Style style2 = new StyleC(color2,stroke1);
		Style styleRobot = new StyleC(colorRobot,stroke1);
		Machine myMachine11 = new Machine("Machine 1", style2 ,rectangle2 , 3 ,3);
		Machine myMachine12 = new Machine("Machine 2",style2 ,rectangle2 , 6 ,3);
		Machine myMachine21 = new Machine("Machine 1", style2 ,rectangle2 ,12 ,3);
		Machine myMachine22 = new Machine("Machine 2",style2 ,rectangle2 , 12 ,6);
		Door door1 = new Door("Door 1", style3, rectangle4, 1, 3);
		Door door2 = new Door("Door 2", style3, rectangle4, 10, 3);
		
		Chargement chargement = new Chargement("Base de recharge", style2 ,rectangle2 , 6 ,14);
		
		ArrayList<Machine> listMachine1 = new ArrayList<Machine>();
		listMachine1.add(myMachine11);
		listMachine1.add(myMachine12);
		
		ArrayList<Machine> listMachine2 = new ArrayList<Machine>();
		listMachine2.add(myMachine21);
		listMachine2.add(myMachine22);
		
		
		
		Robot myRobot1 = new Robot ("robot1", styleRobot, rond ,0 , 1, 2, listMachine1);
		Robot myRobot2 = new Robot ("robot2", styleRobot, rond ,0 , 8, 2, listMachine2);
		ArrayList<Robot> listRobot	= new ArrayList<Robot>();
		listRobot.add(myRobot1);
		listRobot.add(myRobot2);
		
		
		Area myArea1 = new Area("Area 1", style1, rectangle,2 ,2 ,listMachine1);
		ArrayList<Area> arealist1 = new ArrayList<Area>();
		arealist1.add(myArea1);
		
		Area myArea2 = new Area("Area 2", style1, rectangle,11 ,2 ,listMachine2);
		ArrayList<Area> arealist2 = new ArrayList<Area>();
		arealist1.add(myArea2);
		
		
		Room myRoom = new Room("salle 1", style2, rectangle3 ,1 ,1 ,arealist1,door1);
		Room myRoom2 = new Room("salle 2", style2, rectangle3 ,10 ,1 ,arealist2,door2);
		ArrayList<Room> roomlist1 = new ArrayList<Room>();
		roomlist1.add(myRoom);
		roomlist1.add(myRoom2);
		
		Factory myFactory = new Factory("usine","usd", roomlist1,listRobot,20,20,style1,chargement);
		myRobot1.setUsine(myFactory);
		myRobot2.setUsine(myFactory);

		
		CanvasPersistManager persitenceManager = new CanvasPersistManager(new FileCanvasChooser("txt", "txt"));
		SimulatorController controller= new SimulatorController(myFactory, persitenceManager);
		CanvasViewer canevas= new CanvasViewer(controller);
		myFactory.addObserver(canevas);

	}
	
	
}
