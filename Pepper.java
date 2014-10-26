import java.awt.Color;

/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Pepper class extends Cheese
//Pepper is a shallow class and only contains static final values and passes them to the Vegetable super constructor
public class Pepper extends Vegetable{
	public static final int calories = 50;
	public static final Money cost = new Money(0,55);
	public static final String description = "Organic, guilt free, and locally grown in my back yard peppers";
	
	//Constructor calls Cheese constructor with super
	public Pepper(Color color) {
		super(description, cost, calories, color);
	}

}
