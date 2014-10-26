/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Alfredo class that inherits from Base class
//Alfredo is a shallow class and only contains static final values and passes them to the Base super constructor
public class Alfredo extends Base{
	public static final int calories = 150;
	public static final Money cost = new Money(0,50);
	public static final String description = "Alredo from can";
	
	//Constructor calls Base constructor with super
	public Alfredo() {
		super(description, cost, calories);
	}

}
