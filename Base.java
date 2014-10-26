/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//Base class for pizzas.  This can hold sauces.
public class Base extends Ingredient {
	
	//Base constructor calling super class Ingredient constructor
	public Base(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

}
