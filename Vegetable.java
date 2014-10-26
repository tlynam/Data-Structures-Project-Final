import java.awt.Color;

/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Vegetable class extends Ingredient
//Vegetable is an intermediate class that passes values from types of meat to the ingredient super class
//Vegetables are different than meats as they have a color attribute
public class Vegetable extends Ingredient {
	Color myColor;
	
	//Constructor that passes values from child class to super class
	public Vegetable(String description, Money cost, int calories, Color color) {
		super(description, cost, calories, color);
	}
	
	//Getter for color
	public Color getColor() {
		return myColor;
	}
	
	//Setter for color
	public void setColor(Object o){
		//Validate color input
		if(o == null || !(o instanceof Color)){
			throw new PizzaException("Invalid color");
		}
		Color that = (Color) o;
		myColor = that;
	}
	
	//Override equals method
	//Equals will return true if vegetable colors are equal
	//otherwise will return false
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Vegetable)){
			throw new PizzaException("Invalid color");
		}
		Vegetable that = (Vegetable) o;
		if(this.myColor == that.myColor){
			return true;
		}
		else{
			return false;
		}
	}


}
