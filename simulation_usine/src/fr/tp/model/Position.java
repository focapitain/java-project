package fr.tp.model;


public class Position {
	private int xCoord;
	private int yCoord;
	
	public Position(int xCoord,int yCoord) {
		this.xCoord=xCoord;
		this.yCoord=yCoord;
	}
	public int getxCoordinate() {
		return xCoord  ;
	}
	public void setxCoordinate(int xCoord) {
		this.xCoord=xCoord  ;
	}
	
	public int getyCoordinate() {
		return yCoord  ;
	}
	public void setyCoordinate(int yCoord) {
		this.yCoord=yCoord  ;
	}
	public void  out() {
		System.out.println("pos");
		System.out.println("x="+ xCoord);
		System.out.println("y="+ yCoord);
	}
	
}
