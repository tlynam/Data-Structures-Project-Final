/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Shape is an abstract class that implements cloneable and comparaable
//It sets up child classes with its methods
public abstract class Shape implements Cloneable, Comparable {
	//Shape has an x value that can be either a side of a square or radius of a circle
	private int x;
	//Area double for area
	private double area;
	//String that will hold the shape type
	private String shapeType;
	
	//Constructor that takes two arguments, the x value for a side or radius, and the type of shape
	public Shape(int nx, String shape) {
		setX(nx);
		setShapeType(shape);
	}
	
	//Copy constructor
	public Shape(Shape other){
		this(other.x, other.shapeType);
	}
	
	//Setter for setting the shape type
	public void setShapeType(String shape){
		shapeType = shape;
	}
	
	//Getter for thet shape type
	public String getShapeType(){
		return shapeType;
	}
	
	//Overridding the clone method
	//Implementing as an abstract method for the child classes to implement
	@Override
	abstract public Shape clone();
	
	//Setter for x value, which can be a side or radius
	public void setX(int nx){
		if(nx>0) this.x = nx;
	}
	
	//Getter for x value, which can be a side or radius
	public int getX() {
		return this.x;
	}
	
	//Get area method that will be implemented in child classes
	public double getArea(){
		return -1;
	}
	
	//Setter for area
	public void setArea(double a){
		area = a;
	}
	
	//Override toString to return shape type and area
	@Override
	//I actually like printf LOL
	public String toString() {
		return String.format("Shape %d area: %.1f",  getX(), getArea() );
	}

	//Override compareTo
	//This compares Shapes based on area
	@Override
	public int compareTo(Object o) {
		//Check for value chape input
		if(o == null || !(o instanceof Shape)){
			throw new PizzaException("Invalid Square");
		}
		Shape that = (Shape) o;
		double temp = this.area - that.area;
		if(temp > 0){
			return 1;
		}
		else if(temp < 0){
			return -1;
		}
		else{
			return 0;
		}
	}

}