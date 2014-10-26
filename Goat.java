/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Goat class extends Cheese
//Goat is a shallow class and only contains static final values and passes them to the Cheese super constructor
public class Goat extends Cheese{
	public static final int calories = 120;
	public static final Money cost = new Money(1,0);
	public static final String description = "Goat cheese made from finest goats";
	
	//Constructor calls Cheese constructor with super
	public Goat() {
		super(description, cost, calories);
	}

}