/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Mozzarella class extends Cheese
//Mozzarella is a shallow class and only contains static final values and passes them to the Cheese super constructor
public class Mozzarella extends Cheese{
	public static final int calories = 100;
	public static final Money cost = new Money(0,75);
	public static final String description = "Mozzarella sticks sliced";
	
	//Constructor calls Cheese constructor with super
	public Mozzarella() {
		super(description, cost, calories);
	}

}
