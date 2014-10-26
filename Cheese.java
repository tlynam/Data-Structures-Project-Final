/* 
 *  PizzaManager Pizza Class
 *  CSS 162, Final Project
 *  Summer 2014
 *  Author: Rob Nash
 *  Student: Todd Lynam 
 */

//CHeese class that inherits from Ingredient.  This can hold different cheeses.
public class Cheese extends Ingredient{
	
	//Base constructor calling super class Ingredient constructor
	public Cheese(String description, Money cost, int calories) {
		super(description, cost, calories);
	}

}
