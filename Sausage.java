/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Sausage class extends Cheese
//Sausage is a shallow class and only contains static final values and passes them to the Meat super constructor
public class Sausage extends Meat {
	public static final int calories = 300;
	public static final Money cost = new Money(1,05);
	public static final String description = "Premium sausage";

	//Constructor calls Meat constructor with super
	public Sausage() {
		super(description, cost, calories);
	}

}