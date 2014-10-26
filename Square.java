/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Square class that inherits from shape
//Square has a static final side of 32 and shapeType of Square
public class Square extends Shape{
	public static final int side = 32;
	private double area;
	public final static String shapeType = "Square";
	
	//Constructor that calls Shape constructor and sets the area
	public Square(){
		super(side, shapeType);
		setArea();
	}
	
	//Copy Constructor that accepts Circle object
	public Square(Square newCopy){
		super(newCopy.side, newCopy.shapeType);
		setArea();
	}
	
	//Set area method that calculates and sets area
	public void setArea(){
		this.area = this.getX() * this.getX();
	}
	
	//Set area method that takes a double as input
	public void setArea(double a){
		area = a;
	}
	
	//Get area method that returns area
	public double getArea(){
		return area;
	}
	
	//Clone method for Square that implements the Clone method from Shape
	@Override
	public Shape clone() {
		return new Square(this);
	}

}