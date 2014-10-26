/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Circle class that inherits from shape
//Circle has a static final radius of 16 and shapeType of Circle
public class Circle extends Shape{
	public static final int radius = 16;
	public double area;
	public final static String shapeType = "Circle";
	
	//Constructor that calls Shape constructor and sets the area
	public Circle() {
		super(radius, shapeType);
		setArea();
	}
	
	//Copy Constructor that accepts Circle object
	public Circle(Circle newCopy){
		super(newCopy.radius, newCopy.shapeType);
		setArea();
	}
	
	//Set area method that calculates and sets area
	public void setArea(){
		this.area = Math.PI * this.getX() * this.getX();
	}
	
	//Set area method that takes a double as input
	public void setArea(double a){
		area = a;
	}
	
	//Get area method that returns area
	public double getArea(){
		return area;
	}

	//Clone method for Circle that implements the Clone method from Shape
	@Override
	public Shape clone() {
		return new Circle(this);
	}

}
